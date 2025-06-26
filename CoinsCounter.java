import greenfoot.*;

/**
 * The CoinsCounter class displays and manages the number of coins collected by the player.
 * 
 * It follows the Singleton pattern to ensure only one instance exists during gameplay.
 * Coins can be added through the `addCoins()` method, and the visual display updates automatically.
 * The counter shows an icon and a number, and it can be reset when restarting the game.
 * 
 * @author (Theodora Nouni, Anastasia Pourliaka)
 * @version (v1)
 */
public class CoinsCounter extends Actor
{
    private static CoinsCounter instance;
    private GreenfootImage coinIcon = new GreenfootImage("coin.png");

    private int coins = 0;

    private CoinsCounter()
    {
        updateImage();
    }

    public static CoinsCounter getInstance() {
        if (instance == null)
        {
            instance = new CoinsCounter();
        }
        return instance;
    }

    public static void resetInstance() {
        instance = new CoinsCounter();
    }

    private void updateImage() {
        coinIcon.scale(24, 24);

        GreenfootImage textImage = new GreenfootImage(" " + coins, 24, Color.BLACK, new Color(0,0,0,0));
    
        GreenfootImage combined = new GreenfootImage(coinIcon.getWidth() + textImage.getWidth(), 24);
        combined.setColor(Color.BLACK);
        combined.drawImage(coinIcon, 0, 0);
        combined.drawImage(textImage, coinIcon.getWidth(), 0);
    
        setImage(combined);
    }

    public void addCoins(int coins) {
        this.coins += coins;
        updateImage();
    }

    public int getCoins() {
        return coins;
    }
}
