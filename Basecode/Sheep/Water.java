import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Water here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Water extends Actor
{
    private static final int MAX_LIFETIME = 150;
    /**
     * Act - do whatever the Water wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int life = MAX_LIFETIME;
    
    public void act() 
    {
        if (--life <= 0) this.kill();
    }
    
    public void kill()
    {
        Field field = (Field)getWorld();
        field.seedGrass(this.getX(),this.getY());
        getWorld().removeObject(this);
    }
}
