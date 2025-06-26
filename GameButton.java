import greenfoot.*;

/**
 * The GameButton class is an abstract base class for all interactive 
 * button-like actors in the game. It provides a consistent structure 
 * for buttons that respond to mouse clicks.
 * 
 * Features:
 * - Loads and scales the button image based on the provided file path and size.
 * - Detects mouse clicks via Greenfoot's built-in mouse support.
 * - Calls the abstract onClick() method when clicked, which must be implemented
 *   by each subclass to define specific behavior.
 * 
 * This class enables reuse and cleaner design for UI components such as
 * Start & Restart.
 * 
 * @author (Theodora Nouni, Anastasia Pourliaka)
 * @version (v1)
 */
public abstract class GameButton extends Actor
{
    protected GreenfootImage defaultImage;

    public GameButton(String imagePath, int width, int height) {
        defaultImage = new GreenfootImage(imagePath);
        defaultImage.scale(width, height);
        setImage(defaultImage);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            onClick();
        }
    }

    protected abstract void onClick();
}
