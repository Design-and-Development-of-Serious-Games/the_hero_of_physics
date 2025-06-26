import greenfoot.*;

/**
 * The GameOverWorld class represents the screen shown when the player loses all lives.
 * 
 * It displays a "Game Over" message along with instructions to restart the game.
 * Pressing ENTER resets the LifeCounter and CoinsCounter and returns the player
 * to Level 1, effectively restarting the game.
 * 
 * This class provides a clean transition point after the game ends.
 * 
 * @author (Theodora Nouni, Anastasia Pourliaka)
 * @version (v1)
 */
public class GameOverWorld extends World {
    public GameOverWorld() {
        super(1024, 576, 1);
        
        GreenfootImage bg = new GreenfootImage(1024, 576);
        bg.setColor(Color.BLACK);
        bg.fill();
        setBackground(bg);

        showText("Game Over!", getWidth() / 2, getHeight() / 2 - 20);
        showText("Press ENTER to restart", getWidth() / 2, getHeight() / 2 + 20);
        
        SoundManager.stopBackgroundMusic();
        Greenfoot.playSound("game-over.mp3");
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("enter")) {
            LifeCounter.resetInstance();
            CoinsCounter.resetInstance();
            Greenfoot.setWorld(new Level1World());
        }
    }
}
