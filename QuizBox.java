import greenfoot.*;

/**
 * The QuizBox class displays a quiz question and its possible answer options
 * inside a styled box image. It is shown at the top of the quiz screen,
 * providing the main quiz prompt to the player.
 * 
 * The box is based on the "quiz-box.png" image, which is scaled to fit the layout,
 * and then the question and its options (if any) are drawn dynamically using a font.
 * 
 * In the current implementation, only the question is used for display since the 
 * options are shown separately in individual AnswerBox objects.
 * 
 * @author (Theodora Nouni, Anastasia Pourliaka)
 * @version (v1)
 */
public class QuizBox extends Actor
{
    public QuizBox(String question, String[] options) {
        GreenfootImage bg = new GreenfootImage("quiz-box.png");
        
        int boxWidth = 1000;
        int boxHeight = 650;
        bg.scale(boxWidth, boxHeight);

        GreenfootImage image = new GreenfootImage(bg);

        image.setFont(new Font("Arial", true, false, 25));
        image.setColor(Color.WHITE);

        int textX = 200;
        int textY = 220;

        image.drawString(question, textX, textY);

        for (int i = 0; i < options.length; i++) {
            image.drawString((i + 1) + ". " + options[i], textX, textY + 40 + i * 40);
        }

        setImage(image);
    }
}
