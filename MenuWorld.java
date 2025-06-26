import greenfoot.*;

/**
 * The MenuWorld class represents the main menu screen of the game.
 * 
 * It sets the background image, adds the Start button, and ensures that 
 * the game state is reset by reinitializing the LifeCounter and CoinsCounter 
 * singletons. This guarantees that every new game starts with default lives 
 * and coins.
 * 
 * This is the player's entry point before starting the first level.
 * 
 * @author (Theodora Nouni, Anastasia Pourliaka)
 * @version (v1)
 */
public class MenuWorld extends World {

    public MenuWorld() {
        super(1024, 576, 1);

        GreenfootImage bg = new GreenfootImage("menu_background.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);

        StartButton start = new StartButton();
        start.getImage().scale(150, 80);
        addObject(start, getWidth()/2, getHeight()/2 + 200);
        
        LifeCounter.resetInstance();
        CoinsCounter.resetInstance();
        SoundManager.playBackgroundMusic();
    }
}