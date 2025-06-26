import greenfoot.*;
import java.util.*;

/**
 * Displays a series of messages above the player in a dialog bubble,
 * changing every few seconds until all messages are shown.
 * 
 * @author (Theodora Nouni, Anastasia Pourliaka)
 * @version (v1)
 */
public class SpeechBubble extends Actor
{
    private Player player;
    private List<String> messages;
    private int currentIndex = 0;
    private int displayTime = 100;
    private int timer = 0;

    public SpeechBubble(Player player, String... messages) {
        this.player = player;
        this.messages = new ArrayList<>(Arrays.asList(messages));
        updateImage(messages[0]);
    }

    public void act() {
        if (player != null && player.getWorld() != null) {
            setLocation(player.getX() + 80, player.getY() - player.getImage().getHeight());
        }

        timer++;
        if (timer >= displayTime) {
            timer = 0;
            currentIndex++;

            if (currentIndex < messages.size()) {
                updateImage(messages.get(currentIndex));
            } else {
                getWorld().removeObject(this); // done showing all messages
            }
        }
    }

    private void updateImage(String text) {
        GreenfootImage background = new GreenfootImage("dialog.png");
    
        background.scale(300, 150);

        GreenfootImage bubble = new GreenfootImage(background);
    
        GreenfootImage textImage = new GreenfootImage(text, 15, Color.BLACK, null);
        int x = (bubble.getWidth() - textImage.getWidth()) / 2;
        int y = 45;
    
        bubble.drawImage(textImage, x, y);
    
        setImage(bubble);
    }
}
