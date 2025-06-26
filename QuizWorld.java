import greenfoot.*;
import java.util.*;

/**
 * QuizWorld handles the quiz mini-game for each level.
 * 
 * It presents a series of physics-related multiple choice questions to the player,
 * tracks progress, lives, and coins, and provides interactive help options like
 * 50:50 elimination, revealing the answer, and skipping a question.
 * 
 * Features:
 * - Supports different sets of questions per level.
 * - Shows a progress indicator (e.g., "2/5").
 * - Displays animated answer feedback (green for correct, red for wrong).
 * - Deducts a life on incorrect answers and ends the quiz on zero lives.
 * - Offers 3 types of help actions, each usable once per quiz session:
 *   • 50:50 — Removes two incorrect answers (cost: 1 coin)
 *   • Reveal — Highlights the correct answer (cost: 1 coin)
 *   • Skip — Skips the question without penalty (cost: 2 coins)
 * 
 * Transitions to:
 * - Next level after successful completion
 * - GameOverWorld if all lives are lost
 * - WinWorld if final level is completed
 * 
 * Visual elements include a quiz box, answer options, help indicators, and feedback flashes.
 * 
 * @author (Theodora Nouni, Anastasia Pourliaka)
 * @version (v1)
 */
public class QuizWorld extends World
{
    private List<QuizQuestion> questions;
    private int currentLevel;
    private int currentIndex = 0;
    private boolean keyHandled = false;
    private int delayTimer = 0;
    private List<AnswerBox> answerBoxes = new ArrayList<>();
    private boolean gameOverPending = false;
    
    // Help buttons
    private boolean fiftyFiftyUsed = false;
    private boolean revealUsed = false;
    private boolean skipUsed = false;
    
    private List<HelpIndicator> helpIndicators = new ArrayList<>();
    
    public QuizWorld(List<QuizQuestion> questions, int currentLevel)
    {    
        super(1024, 576, 1);
        this.questions = questions;
        this.currentLevel = currentLevel;
        
        setBackground(new GreenfootImage("quiz-bg.jpg"));
        
        LifeCounter lifeCounter = LifeCounter.getInstance();
        addObject(lifeCounter, 0, 0);
        
        CoinsCounter coinsCounter = CoinsCounter.getInstance();
        addObject(coinsCounter, 35, 70);
        
        addObject(new HelpButton(), 100, getHeight() - 40); // bottom-left corner
        
        showCurrentQuestion();
    }
    
    private void showCurrentQuestion() {
        removeObjects(getObjects(QuizBox.class));
        removeObjects(getObjects(AnswerBox.class));
        answerBoxes.clear();

        if (currentIndex >= questions.size()) {
            switch (currentLevel) {
                case GameLevels.LEVEL_1:
                    Greenfoot.setWorld(new Level2World());
                    break;
                case GameLevels.LEVEL_2:
                    Greenfoot.setWorld(new Level3World());
                    break;
                case GameLevels.LEVEL_3:
                    Greenfoot.setWorld(new WinWorld());
                    break;
                default:
                    Greenfoot.setWorld(new Level1World());
            }
            
            return;
        }
        
        showProgressIndicator();
        
        QuizQuestion q = questions.get(currentIndex);

        QuizBox box = new QuizBox(q.getQuestion(), new String[0]); // no options in the box now
        addObject(box, getWidth() / 2, 280);
    
        int quizBoxCenterX = getWidth() / 2;
        int quizBoxTopY = 120; // wherever the top of your box starts
        int spacing = 50;
        
        for (int i = 0; i < q.getOptions().length; i++) {
            String text = q.getOptions()[i];
            int answerY = quizBoxTopY + 100 + (i * spacing); // offset from top of box
            AnswerBox answerBox = new AnswerBox(text, i, this);
            answerBoxes.add(answerBox);
            addObject(answerBox, quizBoxCenterX, answerY);
        }
        
        if (currentIndex == 0 && helpIndicators.isEmpty()) {
            HelpIndicator fifty = new HelpIndicator("50:50 (-1 coin)", "f");
            HelpIndicator reveal = new HelpIndicator("Reveal (-1 coin)", "r");
            HelpIndicator skip = new HelpIndicator("Skip (-2 coin)", "s");
            
            int startX = getWidth() - 80; // Right margin
            int startY = getHeight() - 110; // Bottom corner
            int helpButtonsSpacing = 35;
    
            addObject(fifty, startX, startY);
            addObject(reveal, startX, startY + helpButtonsSpacing);
            addObject(skip, startX, startY + helpButtonsSpacing * 2);
        
            helpIndicators.add(fifty);
            helpIndicators.add(reveal);
            helpIndicators.add(skip);
        }
    }
    
    public void act() {
        if (delayTimer > 0) {
            delayTimer--;
            if (delayTimer == 0) {
                if (gameOverPending) {
                    Greenfoot.setWorld(new GameOverWorld());
                } else {
                    currentIndex++;
                    keyHandled = false;
                    showCurrentQuestion();
                }
            }
            return; // Prevent input during delay
        }
        
        if (!keyHandled) {
            if (Greenfoot.isKeyDown("1")) {
                checkAnswer(0);
                keyHandled = true;
            }
            
            if (Greenfoot.isKeyDown("2")) {
                checkAnswer(1);
                keyHandled = true;
            }
            
            if (Greenfoot.isKeyDown("3")) {
                checkAnswer(2);
                keyHandled = true;
            }
            
            if (Greenfoot.isKeyDown("4")) {
                checkAnswer(3);
                keyHandled = true;
            }
        }
        
        if (
            !Greenfoot.isKeyDown("1") &&
            !Greenfoot.isKeyDown("2") &&
            !Greenfoot.isKeyDown("3") &&
            !Greenfoot.isKeyDown("4")
        ) {
            keyHandled = false;
        }
        
        if (Greenfoot.isKeyDown("f") && !fiftyFiftyUsed) {
            if (CoinsCounter.getInstance().getCoins() >= 1) {
                CoinsCounter.getInstance().addCoins(-1);
                useFiftyFiftyHelp();
            } else {
                addObject(new FlashMessage("Not enough coins!"), getWidth() / 2, getHeight() - 100);
            }
        }
        
        if (Greenfoot.isKeyDown("r") && !revealUsed) {
            if (CoinsCounter.getInstance().getCoins() >= 1) {
                CoinsCounter.getInstance().addCoins(-1);
                useRevealAnswerHelp();
                revealUsed = true;
            } else {
                addObject(new FlashMessage("Not enough coins!"), getWidth() / 2, getHeight() - 100);
            }
        }

        if (Greenfoot.isKeyDown("s") && !skipUsed) {
            if (CoinsCounter.getInstance().getCoins() >= 2) {
                CoinsCounter.getInstance().addCoins(-2);
                useSkipHelp();
                skipUsed = true;
            } else {
                addObject(new FlashMessage("Not enough coins!"), getWidth() / 2, getHeight() - 100);
            }
        }
    }
    
    public void checkAnswer(int selectedIndex) {
        keyHandled = true;
        
        QuizQuestion q = questions.get(currentIndex);
        
         for (AnswerBox ab : answerBoxes) {
            if (ab.getIndex() == q.getCorrectIndex()) {
                ab.showAsCorrect();
            } else if (ab.getIndex() == selectedIndex) {
                ab.showAsIncorrect();
            }
        }
        
        if (selectedIndex == q.getCorrectIndex()) {
            Greenfoot.playSound("correct.wav");
        } else {
            Greenfoot.playSound("wrong.mp3");
            
            LifeCounter lifeCounter = LifeCounter.getInstance();
            lifeCounter.loseLife();

            if (lifeCounter.getLives() <= 0) {
                gameOverPending = true;
                delayTimer = 60;
                return;
            }
        }
        
        delayTimer = 60;
    }
    
    public void useFiftyFiftyHelp() {
        if (fiftyFiftyUsed) return;
    
        QuizQuestion q = questions.get(currentIndex);
        int correctIndex = q.getCorrectIndex();
        List<AnswerBox> wrongAnswers = new ArrayList<>();
    
        for (AnswerBox ab : answerBoxes) {
            if (ab.getIndex() != correctIndex) {
                wrongAnswers.add(ab);
            }
        }
    
        // Randomly remove 2 wrong answers
        Collections.shuffle(wrongAnswers);
        for (int i = 0; i < Math.min(2, wrongAnswers.size()); i++) {
            AnswerBox wrong = wrongAnswers.get(i);
            removeObject(wrong);
        }
    
        fiftyFiftyUsed = true;
        removeHelpIndicator("f");
    }
    
    private void useRevealAnswerHelp() {
        QuizQuestion q = questions.get(currentIndex);
    
        for (AnswerBox ab : answerBoxes) {
            if (ab.getIndex() == q.getCorrectIndex()) {
                ab.showAsCorrect();
            }
        }
    
        delayTimer = 60;
        removeHelpIndicator("r");
    }
    
    private void useSkipHelp() {
        currentIndex++;
        showCurrentQuestion();
        removeHelpIndicator("s");
    }
    
    private void removeHelpIndicator(String key) {
        HelpIndicator toRemove = null;
        for (HelpIndicator hi : helpIndicators) {
            if (hi.getKey().equals(key)) {
                toRemove = hi;
                break;
            }
        }
        if (toRemove != null) {
            removeObject(toRemove);
            helpIndicators.remove(toRemove);
        }
    }
    
    private void showProgressIndicator() {
        String progressText = (currentIndex + 1) + " / " + questions.size();
        showText(progressText, getWidth() / 2, 40);
    }
}