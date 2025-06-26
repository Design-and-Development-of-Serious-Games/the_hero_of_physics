import greenfoot.*;
import java.util.*;

/**
 * Level3World sets up the third and final level of the game.
 * It includes a custom background, platforms arranged in increasing height,
 * collectible coins, and a quiz trigger for Level 3.
 * The player starts at the bottom and must navigate upward using the platforms.
 * This level is designed to be a final challenge and includes introductory dialogue
 * when the player spawns.
 * 
 * @author (Theodora Nouni, Anastasia Pourliaka) 
 * @version (v1)
 */
public class Level3World extends World
{
    public Level3World()
    {
        super(1024, 576, 1);
        
        GreenfootImage bg = new GreenfootImage("levelbackground3.jpg");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        LifeCounter lifeCounter = LifeCounter.getInstance();
        addObject(lifeCounter, 0, 0);
        
        CoinsCounter coinsCounter = CoinsCounter.getInstance();
        addObject(coinsCounter, 35, 70);

        int tileWidth = 50;
        int groundY = getHeight() - tileWidth / 2;
        
        for (int x = 0; x < getWidth(); x += tileWidth) {
            Platform tile = new Platform();
            addObject(tile, x + tileWidth / 2, groundY);
        }
        
        addObject(new Platform(), 150, 450);
        addObject(new Platform(), 330, 370);
        addObject(new Platform(), 550, 290);
        addObject(new Platform(), 750, 220);
        addObject(new Platform(), 900, 150);

        addCoin(330, 330);
        addCoin(750, 180);
 
        addObject(new QuizSign(GameLevels.LEVEL_3), 900, 100);
        
        Player hero = new Player();
        addObject(hero, 100, groundY - hero.getImage().getHeight() / 2);
        hero.speak(
            "You made it!",
            "Good work!",
            "Are you ready for the last one?"
        );
    }
    
    private void addCoin(int x, int y) {
        Coin coin = new Coin();
        coin.scaleImage(30);
        addObject(coin, x, y);
    }
}
