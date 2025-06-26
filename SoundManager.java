import greenfoot.*;

/**
 * Write a description of class SoundManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoundManager  
{
    private static GreenfootSound backgroundMusic;
    
    public static void playBackgroundMusic() {
        if (backgroundMusic == null) {
            backgroundMusic = new GreenfootSound("bg_music.mp3");
            backgroundMusic.setVolume(60);
            backgroundMusic.playLoop();
        } else if (!backgroundMusic.isPlaying()) {
            backgroundMusic.playLoop();
        }
    }

    public static void stopBackgroundMusic() {
        if (backgroundMusic != null) {
            backgroundMusic.stop();
        }
    }

    public static void reset() {
        stopBackgroundMusic();
        backgroundMusic = null;
    }
}
