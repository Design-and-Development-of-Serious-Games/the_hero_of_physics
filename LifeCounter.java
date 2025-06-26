import greenfoot.*;

/**
 * LifeCounter manages and displays the player's remaining lives.
 * 
 * It adds Heart objects on the screen at the start of the game,
 * and updates them when the player loses a life. 
 * Each Heart visually changes from a full heart to an empty heart
 * as lives are lost.
 * 
 * This class works together with the Heart class to visually represent
 * the player's health status during the game.
 * 
 * @authors (Anastasia Pourliaka, Theodora Nouni) 
 * @version: v1
 */
public class LifeCounter extends Actor
{
    private static LifeCounter instance;
    private Heart[] hearts = new Heart[3];

    private LifeCounter() {
        // private constructor
    }

    public static LifeCounter getInstance() {
        if (instance == null) {
            instance = new LifeCounter();
        }
        return instance;
    }

    public static void resetInstance() {
        instance = new LifeCounter();
    }

    public void addedToWorld(World world) {
        for (int i = 0; i < hearts.length; i++) {
            if (hearts[i] == null) {
                hearts[i] = new Heart();
            }
            world.addObject(hearts[i], 30 + i * 40, 30);
        }
    }

    public void loseLife() {
        for (int i = hearts.length - 1; i >= 0; i--) {
            if (hearts[i] != null && hearts[i].isFull()) {
                hearts[i].lose();
                break;
            }
        }
    }

    public int getLives() {
        int count = 0;
        for (Heart h : hearts) {
            if (h != null && h.isFull()) {
                count++;
            }
        }
        return count;
    }

    public void gainLife() {
        for (int i = 0; i < hearts.length; i++) {
            if (hearts[i] != null && !hearts[i].isFull()) {
                hearts[i].fill();
                break;
            }
        }
    }
}
