import greenfoot.*;

/**
 * The Platform class represents a solid block on which the player
 * can walk or jump. It is a core component of each level’s terrain.
 * 
 * Each platform is rendered using the "platform3.png" image and scaled
 * to a standard size of 50x50 pixels.
 * 
 * Platforms are used to build walkable areas and platforms at different heights.
 * 
 * @author (Theodora Nouni, Anastasia Pourliaka)
 * @version (v1)
 */
public class Platform extends Actor {
    public Platform() {
        GreenfootImage img = new GreenfootImage("platform3.png");
        img.scale(50, 50);
        setImage(img);
    }
}
