import lang.stride.*;
import greenfoot.*;

/**
 * 
 */
public class MyWorld extends World
{
    private int spawnCounter = 0;

    /* Timer untuk mengontrol kemunculan kentang*/

    /**
     * 
     */
    public MyWorld()
    {
        super(600, 400, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        /* Tambahkan objek orang (player) ke dunia*/
        orang orang =  new  orang();
        addObject(orang, 298, 324);
        orang.setLocation(301, 348);
        /* Tambahkan objek score ke dunia*/
        Score score =  new  Score();
        addObject(score, 50, 10);
        /* Tambahkan beberapa kentang awal ke dunia*/
        for (int i = 0;i <= 4;i++) {
            addRandomKentang();
        }
    }

    /**
     * 
     */
    public void act()
    {
        /* Increment timer setiap frame*/
        if (spawnCounter > 100) {
            spawnCounter=0;
            addRandomKentang();
        }
        spawnCounter = spawnCounter + 1;
    }

    /**
     * 
     */
    private void addRandomKentang()
    {
        kentang kentang =  new  kentang();
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        addObject(kentang, x, y);
    }
}
