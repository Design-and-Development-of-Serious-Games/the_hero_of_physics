import greenfoot.*;

public class QuizHelpPopup extends Actor {
    public QuizHelpPopup() {
        int popupWidth = 700;
        int popupHeight = 300;
    
        GreenfootImage popup = new GreenfootImage(popupWidth, popupHeight);
        popup.setColor(new Color(255, 255, 255, 240)); // semi-transparent white background
        popup.fillRect(0, 0, popupWidth, popupHeight);
        popup.setColor(Color.BLACK);
        popup.drawRect(0, 0, popupWidth - 1, popupHeight - 1); // border
        popup.setFont(new Font("Arial", true, false, 18));
    
        popup.drawString("Available Help Options:", 30, 40);
        popup.drawString("1. Press [F] (50:50) - Eliminates two incorrect answers", 30, 80);
        popup.drawString("2. Press [R] (Reveal Answer) - Shows the correct answer instantly", 30, 120);
        popup.drawString("3. Press [S] (Skip Question) - Skip without losing lives or coins", 30, 160);
        popup.drawString("Be careful: Each wrong answer costs 1 life!", 30, 200);
        popup.drawString("Press [H] again to close this popup", 30, 240);
    
        setImage(popup);
    }

    public void act() {
        if (Greenfoot.mouseClicked(null)) {
            getWorld().removeObject(this);
        }
    }
}