import greenfoot.*;

/**
 * The Coin class represents a collectible coin in the game.
 * 
 * Coins are scattered throughout the level and can be collected by the player.
 * Each coin increases the player's coin count when collected.
 * The class supports scaling to adjust the coin size for different placements.
 * 
 * @author (Theodora Nouni, Anastasia Pourliaka)
 * @version (v1)
 */
public class Coin extends Actor {
    public Coin() {
        setImage("coin.png");
    }

    public void scaleImage(int size) {
        GreenfootImage img = getImage();
        img.scale(size, size);
        setImage(img);
    }
}
