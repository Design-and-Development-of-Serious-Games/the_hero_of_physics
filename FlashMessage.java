import greenfoot.*;

/**
 * The FlashMessage class displays a temporary on-screen message to the player.
 * 
 * It shows a translucent white background with red text and automatically disappears
 * after a short delay (approximately 1 second). It is typically used to notify players
 * of important events such as invalid actions (e.g., not enough coins).
 * 
 * @author (Theodora Nouni, Anastasia Pourliaka)
 * @version (v1)
 */
public class FlashMessage extends Actor
{
    private int timer = 60;

    public FlashMessage(String message) {
        GreenfootImage img = new GreenfootImage(300, 30);
        img.setColor(new Color(255, 255, 255, 220));
        img.fillRect(0, 0, 300, 30);
        img.setColor(Color.RED);
        img.setFont(new Font("Arial", true, false, 18));
        img.drawString(message, 10, 22);
        setImage(img);
    }

    public void act() {
        timer--;
        if (timer <= 0) {
            getWorld().removeObject(this);
        }
    }
}
