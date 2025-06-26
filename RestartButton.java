import greenfoot.*;

/**
 * The RestartButton class displays a button that allows the player
 * to restart the game after completing all levels or from the end screen.
 * 
 * When clicked:
 * - Resets the CoinCounter and LifeCounter singletons.
 * - Returns the player to the main menu (MenuWorld).
 * 
 * Inherits functionality from GameButton to support consistent button behavior
 * and image scaling.
 * 
 * Appears typically in the WinWorld.
 * 
 * @author (Theodora Nouni, Anastasia Pourliaka)
 * @version (v1)
 */
public class RestartButton extends GameButton
{
    public RestartButton() {
        super("restart_button.png", 150, 40);
    }
    
    @Override
    protected void onClick() {
        CoinsCounter.resetInstance();
        LifeCounter.resetInstance();
        SoundManager.playBackgroundMusic(); 
        Greenfoot.setWorld(new MenuWorld());
    }
}
