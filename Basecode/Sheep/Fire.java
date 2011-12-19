import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fire extends Actor
{
    private static final int MAX_LIFETIME = 5;
    
    private int life;
    
    public Fire() {
        this.life = MAX_LIFETIME;
    }
    
    public void act() 
    {
        Field field = (Field)getWorld();

        int x = getX();
        int y = getY();
        
        if (field.hasGrassAt(x+1,y))
            field.turnGrassToFire(x+1,y);
        if (field.hasGrassAt(x-1,y))
            field.turnGrassToFire(x-1,y);
        if (field.hasGrassAt(x,y+1))
            field.turnGrassToFire(x,y+1);
        if (field.hasGrassAt(x,y-1))
            field.turnGrassToFire(x,y-1);
            
        if (--life <= 0)
            getWorld().removeObject(this);
    }    
}