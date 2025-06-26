import greenfoot.*;

/**
 * The HelpIndicator class displays a small UI element that shows
 * the label and key binding for a help option in the quiz.
 * 
 * Each HelpIndicator shows a label (e.g., "50:50 (-1 coin)") and
 * the corresponding keyboard key (e.g., "f") used to activate it.
 * 
 * This helps guide the player on how to use available help tools during a quiz.
 * 
 * @author (Theodora Nouni, Anastasia Pourliaka)
 * @version (v1)
 */
public class HelpIndicator extends Actor {
    private String label;
    private String key;

    public HelpIndicator(String label, String key) {
        this.label = label;
        this.key = key;

        updateImage();
    }

    private void updateImage() {
        GreenfootImage img = new GreenfootImage(120, 30); // box size
        img.setColor(Color.WHITE);
        img.fillRect(0, 0, img.getWidth(), img.getHeight());
        img.setColor(Color.BLACK);
        img.drawRect(0, 0, img.getWidth() - 1, img.getHeight() - 1);
        img.setFont(new Font("Arial", false, false, 14));
        img.drawString(label, 10, 20); // padding inside box
        setImage(img);
    }

    public String getKey() {
        return key;
    }
}