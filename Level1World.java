import greenfoot.*;
import java.util.*;

/**
 * The Level1World class sets up the first level of the game.
 * 
 * It includes platforms, coins, the player's starting position,
 * and an introductory speech that guides the player through the mechanics.
 * 
 * Features:
 * - Static platforms for basic platforming challenges.
 * - Coins placed on elevated platforms to teach jumping/collecting.
 * - Introduction to the player character, life and coin counters.
 * - Entry point to the first quiz via the QuizSign.
 * 
 * Interacts with:
 * - Player, Platform, Coin, LifeCounter, CoinsCounter, QuizSign.
 * 
 * @author (Theodora Nouni, Anastasia Pourliaka)
 * @version (v1)
 */
public class Level1World extends World {
    private LifeCounter lifeCounter;

    public Level1World() {
        super(1024, 576, 1);

        setBackground(new GreenfootImage("level1_background.png"));
        
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
        
        addObject(new Platform(), 275, 430);
        addObject(new Platform(), 325, 430);
        
        addObject(new Platform(), 425, 330);
        addObject(new Platform(), 475, 330);
        
        addObject(new Platform(), 575, 230);
        addObject(new Platform(), 625, 230);
        
        addObject(new Platform(), 725, 130);
        addObject(new Platform(), 775, 130);
        addObject(new Platform(), 825, 130);
        addObject(new Platform(), 875, 130);
        
        addCoin(300, 350);
        addCoin(450, 250);
        addCoin(600, 150);
        
        QuizSign quiz = new QuizSign(GameLevels.LEVEL_1);
        addObject(quiz, 800, 50);

        Player hero = new Player();
        addObject(hero, 100, groundY - hero.getImage().getHeight() / 2);
        hero.speak(
            "Hello!",
            "Welcome to my lab!",
            "Find the the golden box ..",
            ".. answer all the questions ..",
            ".. collect coins, to get help ..",
            "and be the Hero of Physics!"
        );
        
        SoundManager.playBackgroundMusic();
    }

    private void addCoin(int x, int y) {
        Coin coin = new Coin();
        coin.scaleImage(30);
        addObject(coin, x, y);
    }
}