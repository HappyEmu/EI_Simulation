import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class WeatherController here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WeatherController extends Actor
{
    /**
     * Act - do whatever the WeatherController wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public static final int AMOUNT = 2;
    private static final int LOCAL_DURATION = 300;
    private static final int MIN_SIZE = 8;
    private static final int MAX_SIZE = 14;
    private static final int DIFF = MAX_SIZE - MIN_SIZE;
    private static int size = 12;
    private static final int PROBABILITY=3;
    private static final float LIGHTNING_PROB = 0.01f;
    
    private boolean raining;
    private int xStart;
    private int yStart;
    private int duration;
    
    public WeatherController()    
    {
        this.duration = 0;
        this.xStart = 0;
        this.yStart = 0;
        this.raining = false;
    }
    
    public void act() 
    {
        
        Random rand = new Random();
        Field world = (Field)getWorld();
        
        if (--this.duration <= 0)
        {
            xStart =  2+rand.nextInt(Field.FLD_WID-size-4);
            yStart =  4+rand.nextInt(Field.FLD_HGH-size-6);
            this.duration = LOCAL_DURATION;
            size = MIN_SIZE+ rand.nextInt(DIFF);
            raining = (rand.nextInt(10)>PROBABILITY) ? false : true; 
            
        }   
        if(!raining) return;
        for (int i = 0; i < AMOUNT; i++)
        {
            int x = xStart + rand.nextInt(size);
            int y = yStart + rand.nextInt(size);
            
            if (world.hasWaterAt(x,y))
                continue;
            if (world.hasRainAt(x,y))
                world.turnRainToWater(x,y);
            else
                world.spawnRainAt(x,y);
        }
        
        if (rand.nextInt(100) < (int)(LIGHTNING_PROB*100.0f))
        {
            int x =  2+rand.nextInt(Field.FLD_WID-4);
            int y =  4+rand.nextInt(Field.FLD_HGH-6);
            
            world.spawnLightningAt(x,y);
        }
    }    
}
