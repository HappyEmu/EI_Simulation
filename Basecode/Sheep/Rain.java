import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rain extends Actor
{
    /**
     * Act - do whatever the Rain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private static final int MAX_LIFETIME=7;
    
    private int life;
    
    public Rain()
    {
        this.life = MAX_LIFETIME;
    }
    
    public void act() 
    {
        if (--life <= 0)
        {
            this.kill();
            return;
        }
    }    
    
    public void kill()
    {
        getWorld().removeObject(this);
    }
}
