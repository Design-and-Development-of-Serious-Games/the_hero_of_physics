import greenfoot.*;

/**
 * The StartButton class represents the main button used to start the game
 * from the MenuWorld. It visually blinks to attract the player's attention.
 * 
 * Features:
 * - Inherits from GameButton for consistent appearance and click behavior.
 * - Blinks by alternating visibility every 30 frames.
 * - On click, it transitions the game to the Level1World.
 * 
 * This button is typically placed in the main menu screen.
 * 
 * @author (Theodora Nouni, Anastasia Pourliaka)
 * @version (v1)
 */
public class StartButton extends GameButton {
    private int blinkCounter = 0;
    private boolean visible = true;

    public StartButton() {
        super("start_button.png", 150, 80);
    }

    @Override
    public void act() {
        super.act();
        blink();
    }

    private void blink() {
        blinkCounter++;
        if (blinkCounter % 30 == 0) {
            visible = !visible;
            if (visible) {
                setImage(defaultImage);
            } else {
                setImage(new GreenfootImage(1, 1));
            }
        }
    }

    @Override
    protected void onClick() {
        Greenfoot.setWorld(new Level1World());
    }
}
