import greenfoot.*;
import java.util.*;

/**
 * Level2World sets up the second level of the game.
 * 
 * This world includes a new background, platforms, collectible coins, and a quiz sign
 * for Level 2 questions. It continues from Level 1 while increasing difficulty slightly
 * in both platform layout and quiz content. The player retains their life and coin status
 * from the previous level.
 * 
 * Additional player speech is used to guide and motivate the player. Help options for
 * the quiz are refreshed in this level, regardless of previous usage.
 * 
 * @author (Theodora Nouni, Anastasia Pourliaka)
 * @version (v1)
 */
public class Level2World extends World
{
    public Level2World() {
        super(1024, 576, 1);
        
        GreenfootImage bg = new GreenfootImage("background2.jpg");
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

        addObject(new Platform(), 200, 450);
        addObject(new Platform(), 400, 350);
        addObject(new Platform(), 500, 250);
        addObject(new Platform(), 700, 150);
        addObject(new Platform(), 750, 150);
        addObject(new Platform(), 780, 150);
        
        addCoin(320, 400);
        addCoin(620, 300);
        addCoin(520, 200);

        addObject(new QuizSign(GameLevels.LEVEL_2), 900, 100);
        
        Player hero = new Player();
        addObject(hero, 100, groundY - hero.getImage().getHeight() / 2);
        hero.speak(
            "Be carefull now ..",
            "The questions might be harder ..",
            "But I know you can make it!",
            "Don't worry though ..",
            " You have extra help in each level,",
            "even if you used them before."
        );
    }

    private void addCoin(int x, int y) {
        Coin coin = new Coin();
        coin.scaleImage(30);
        addObject(coin, x, y);
    }    
}
