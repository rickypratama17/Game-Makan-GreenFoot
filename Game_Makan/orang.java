import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class orang extends Actor
{
    private int currentScore = 0;
    /**
     * Act - do whatever the orang wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(0);
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - 5);
        }
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + 5);
        }
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - 5, getY());
        }
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + 5, getY());
        }
        if (isTouching(kentang.class)) {
            Score.add(1);
            removeTouching(kentang.class);
        }
        checkScore();  // Tambahkan pemanggilan checkScore di sini
    }

    private void checkScore() {
        int newScore = Score.getScore();
        if (newScore > currentScore && newScore % 10 == 0) {
            increaseSize();
        }
        currentScore = newScore;
    }

    private void increaseSize() {
        GreenfootImage image = getImage();
        int newWidth = (int) (image.getWidth() * 1.2);
        int newHeight = (int) (image.getHeight() * 1.2);
        image.scale(newWidth, newHeight);
        setImage(image);
    }

}
