import greenfoot.*;

/**
 * Heart represents one life of the player.
 * 
 * @authors (Anastasia Pourliaka, Theodora Nouni) 
 * @version (v1)
 */
public class Heart extends Actor
{
    private GreenfootImage fullHeart = new GreenfootImage("heart_full.png");
    private GreenfootImage emptyHeart = new GreenfootImage("heart_empty.png");
    
    private boolean isFull = true;

    public Heart()
    {
        setImage(fullHeart);
        resize();
    }

    private void resize()
    {
        getImage().scale(30, 20);
    }
    
    public void lose()
    {
        if (isFull)
        {
            setImage(emptyHeart);
            resize();
            isFull = false;
        }
    }
    
    public boolean isFull()
    {
        return isFull;
    }
    
    public void fill()
    {
        isFull = true;
        setImage(new GreenfootImage("heart_full.png"));
        resize();
    }
}