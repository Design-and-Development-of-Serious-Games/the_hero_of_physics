import greenfoot.*;
import java.util.*;

public class QuizSign extends Actor {
    private int level;

    public QuizSign(int level) {
        this.level = level;        
        GreenfootImage base = new GreenfootImage("mystery_block.png");
        base.scale(50, 50);
        
        setImage(base);
    }
    
    public void act() {
        if (isTouching(Player.class)) {
            List<QuizQuestion> questions = QuizRepository.getQuestionsForLevel(level);
            Greenfoot.setWorld(new QuizWorld(questions, level));
        }
    }
}