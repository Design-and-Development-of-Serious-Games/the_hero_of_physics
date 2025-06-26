import greenfoot.*;

/**
 * The AnswerBox class represents one of the clickable answer options in a quiz question.
 * 
 * Each AnswerBox is associated with a specific answer index and text. It detects
 * clicks and informs the QuizWorld to check if the selected answer is correct.
 * Visual feedback is provided by changing the color to green (correct) or red (incorrect).
 * 
 * This class encapsulates the rendering and interactivity for answer choices in the quiz system.
 * 
 * @author (Theodora Nouni, Anastasia Pourliaka)
 * @version (v1)
 */
public class AnswerBox extends Actor
{
    private int answerIndex;
    private QuizWorld quizWorld;
    private String answerText;
    
    public AnswerBox(String answerText, int index, QuizWorld world)
    {
        this.answerIndex = index;
        this.quizWorld = world;
        this.answerText = answerText;

        setImage(makeImage(answerText, Color.WHITE));
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            quizWorld.checkAnswer(answerIndex);
        }
    }
    
    public int getIndex() {
        return answerIndex;
    }
    
    public void showAsCorrect() {
        setImage(makeImage(answerText, new Color(0, 180, 0))); // green
    }

    public void showAsIncorrect() {
        setImage(makeImage(answerText, new Color(200, 0, 0))); // red
        Greenfoot.playSound("wrong.mp3");
    }
    
    private GreenfootImage makeImage(String text, Color bgColor) {
        int width = 600;
        int height = 40;

        GreenfootImage img = new GreenfootImage(width, height);

        img.setColor(bgColor);
        img.fillRect(0, 0, width, height);

        img.setColor(Color.BLACK);
        img.drawRect(0, 0, width - 1, height - 1);

        img.setFont(new Font("Arial", 18));
        img.setColor(Color.BLACK);
        img.drawString((answerIndex + 1) + ". " + text, 15, 28);

        return img;
    }
}