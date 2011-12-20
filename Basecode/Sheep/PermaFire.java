import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PermaFire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PermaFire extends Fire
{
    private static final int MAX_LIFETIME = 500;
    public PermaFire()
    {
        super();
        this.life = MAX_LIFETIME;
    }
    /**
     * Act - do whatever the PermaFire wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }    
}
