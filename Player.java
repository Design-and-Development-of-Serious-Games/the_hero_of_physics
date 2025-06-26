import greenfoot.*;

/**
 * The Player class represents the main character controlled by the user.
 * 
 * The player can move left and right, jump, land on platforms, and collect coins.
 * The class includes sprite-based animation, collision detection with platforms,
 * gravity simulation, and speech bubble interactions at specific points in the game.
 * 
 * Features:
 * - Animated walking in both directions using a sprite sheet.
 * - Platform collision and gravity-based jumping/falling.
 * - Coin collection system that updates the CoinsCounter.
 * - Customizable speech messages shown via SpeechBubble.
 * - Supports external control of speech per level.
 * 
 * Uses:
 * - Interacts with Platform, Coin, SpeechBubble, and CoinsCounter classes.
 * 
 * @author (Theodora Nouni, Anastasia Pourliaka)
 * @version (v1)
 */
public class Player extends Actor {
    private GreenfootImage[] walkRightFrames;
    private GreenfootImage[] walkLeftFrames;
    private GreenfootImage standStillFrame;
    
    private int animationCounter = 0;
    private int frameIndex = 0;
    
    private int yVelocity = 0;
    private final int GRAVITY = 1;
    private final int JUMP_STRENGTH = -18;
    private final int MAX_FALL_SPEED = 100;
    
    private boolean isMoving = false;
    private boolean hasSpoken = false;

    public Player() {
        prepareImages();
        setImage(standStillFrame);
    }
    
    public void act() {
        handleMovement();
        collectCoins();
    }
    
    public void speak(String... lines) {
        if (hasSpoken) return;
    
        getWorld().addObject(
            new SpeechBubble(this, lines),
            getX(), getY() - getImage().getHeight()
        );
    
        hasSpoken = true;
    }
    
    private void handleMovement() {
        checkPlatformCollision();
        handleHorizontalMovement();
        handleJumping();
        applyGravity();
        applyVerticalMovement();
        updateImage();
    }
    
    private void checkPlatformCollision() {
        Actor platform = getOneIntersectingObject(Platform.class);
        if (platform != null && yVelocity >= 0) {
            int platformTop = platform.getY() - platform.getImage().getHeight() / 2;
            setLocation(getX(), platformTop - getImage().getHeight() / 2);
            yVelocity = 0;
        }
    }
    
    private void handleHorizontalMovement() {
        isMoving = false;

        if (Greenfoot.isKeyDown("right")) {
            move(4);
            animate(walkRightFrames);
            isMoving = true;
        } else if (Greenfoot.isKeyDown("left")) {
            move(-4);
            animate(walkLeftFrames);
            isMoving = true;
        }
    }
    
    private void handleJumping() {
        if (Greenfoot.isKeyDown("space") && isOnGround()) {
            yVelocity = JUMP_STRENGTH;
        }
    }
    
    private void applyGravity() {
        yVelocity += GRAVITY;
        if (yVelocity > MAX_FALL_SPEED) {
            yVelocity = MAX_FALL_SPEED;
        }
    }
    
    private void applyVerticalMovement() {
        setLocation(getX(), getY() + yVelocity);

        if (isOnGround() && yVelocity > 0) {
            yVelocity = 0;
        }
    }
    
    private void updateImage() {
        if (!isMoving && isOnGround()) {
            setImage(standStillFrame);
        }
    }
    
    private void animate(GreenfootImage[] frames) {
        animationCounter++;
        if (animationCounter % 6 == 0) {
            frameIndex = (frameIndex + 1) % frames.length;
            setImage(frames[frameIndex]);
        }
    }
    
    private boolean isOnGround() {
        setLocation(getX(), getY() + 1);
        Actor platform = getOneIntersectingObject(Platform.class);
        setLocation(getX(), getY() - 1);
        return platform != null;
    }
    
    private void prepareImages()
    {
        GreenfootImage spriteSheet = new GreenfootImage("scientist_hero.png");
        double scaleFactor = 1.2;
    
        int frameCols = 4;
        int frameRows = 4;
        int frameWidth = spriteSheet.getWidth() / frameCols;
        int frameHeight = spriteSheet.getHeight() / frameRows;
    
        walkRightFrames = new GreenfootImage[4];
        for (int i = 0; i < 4; i++) {
            walkRightFrames[i] = new GreenfootImage(frameWidth, frameHeight);
            walkRightFrames[i].drawImage(spriteSheet, -i * frameWidth, -2 * frameHeight);
            walkRightFrames[i].scale((int)(frameWidth * scaleFactor), (int)(frameHeight * scaleFactor));
        }
    
        walkLeftFrames = new GreenfootImage[4];
        for (int i = 0; i < 4; i++) {
            walkLeftFrames[i] = new GreenfootImage(frameWidth, frameHeight);
            walkLeftFrames[i].drawImage(spriteSheet, -i * frameWidth, -1 * frameHeight);
            walkLeftFrames[i].scale((int)(frameWidth * scaleFactor), (int)(frameHeight * scaleFactor));
        }
    
        standStillFrame = new GreenfootImage(frameWidth, frameHeight);
        standStillFrame.drawImage(spriteSheet, 0, 0);
        standStillFrame.scale((int)(frameWidth * scaleFactor), (int)(frameHeight * scaleFactor));
    }
    
    private void collectCoins() {
        Coin coin = (Coin) getOneIntersectingObject(Coin.class);
        
        if (coin != null) {
            getWorld().removeObject(coin);
            CoinsCounter.getInstance().addCoins(1);
            Greenfoot.playSound("coin.mp3");
        }
    }
}