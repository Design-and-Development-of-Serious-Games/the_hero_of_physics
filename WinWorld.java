import greenfoot.*;

/**
 * WinWorld is displayed when the player successfully completes all levels.
 * 
 * It shows a celebratory background, a congratulatory message, and the player
 * character speaking a final line. It also includes a restart button that allows 
 * the player to return to the beginning of the game and replay it.
 * 
 * The ground is created using platform tiles, and the scene maintains visual
 * consistency with previous levels.
 * 
 * @author (Theodora Nouni, Anastasia Pourliaka)
 * @version (v1)
 */
public class WinWorld extends World 
{    
    public WinWorld()
    {
        super(1024, 576, 1);
        GreenfootImage bg = new GreenfootImage("win_background.jpg");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        showVictoryMessage();
        
        SoundManager.stopBackgroundMusic();
        Greenfoot.playSound("win-world.mp3");
        
        int tileWidth = 50;
        int groundY = getHeight() - tileWidth / 2;
        
        for (int x = 0; x < getWidth(); x += tileWidth) {
            Platform tile = new Platform();
            addObject(tile, x + tileWidth / 2, groundY);
        }
        
        Player hero = new Player();
        addObject(hero, 100, groundY - hero.getImage().getHeight() / 2);
        hero.speak("I made it!");
        
        RestartButton restartButton = new RestartButton();
        addObject(restartButton, getWidth() / 2, getHeight() - 250);
    }

    private void showVictoryMessage() {
        GreenfootImage titleImg = new GreenfootImage("Congratulations!", 40, Color.WHITE, new Color(0, 0, 0, 128));
        Actor title = new Actor() {
            { setImage(titleImg); }
        };
        addObject(title, getWidth()/2, getHeight()/2 - 70);

        GreenfootImage subtitleImg = new GreenfootImage("You have completed all levels! You are The Hero of Physics!", 30, Color.WHITE, new Color(0, 0, 0, 128));
        Actor subtitle = new Actor() {
            { setImage(subtitleImg); }
        };
        addObject(subtitle, getWidth()/2, getHeight()/2 - 30);
    } 
}
