import greenfoot.*;

/**
 * The HelpButton class provides the player with access to a help popup during quizzes.
 * 
 * When the player presses the 'H' key, a help window is toggled on or off,
 * giving hints about how to use the available help options.
 * It displays an icon alongside a hint text ("Hit [H] for help").
 * 
 * The popup appears centered in the screen and disappears when the key is pressed again.
 * 
 * @author (Theodora Nouni, Anastasia Pourliaka)
 * @version (v1)
 */
public class HelpButton extends Actor {
    private boolean popupVisible = false;
    private boolean keyHandled = false;
    private QuizHelpPopup popup;

    public HelpButton() {
        GreenfootImage icon = new GreenfootImage("help_icon.png");
        icon.scale(30, 30);

        GreenfootImage text = new GreenfootImage(" Hit [H] for help", 20, Color.BLACK, new Color(0, 0, 0, 0));

        GreenfootImage combined = new GreenfootImage(icon.getWidth() + text.getWidth(), Math.max(icon.getHeight(), text.getHeight()));
        combined.drawImage(icon, 0, 0);
        combined.drawImage(text, icon.getWidth(), 5);
        
        setImage(combined);
    }

    public void act() {
        if (Greenfoot.isKeyDown("h") && !keyHandled) {
            togglePopup();
            keyHandled = true;
        }

        if (!Greenfoot.isKeyDown("h")) {
            keyHandled = false;
        }
    }
    
    private void togglePopup() {
        World world = getWorld();
        if (!popupVisible) {
            popup = new QuizHelpPopup();
            world.addObject(popup, 512, 288);
        } else {
            if (popup != null) {
                world.removeObject(popup);
            }
        }
        popupVisible = !popupVisible;
    }
}