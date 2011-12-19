import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireSheep here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireSheep extends Sheep
{
    private static final int MAX_LIFE = 200;
    private int life;
    public FireSheep()
    {
        super();
        this.life = MAX_LIFE;
    }
    /**
     * Act - do whatever the FireSheep wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Field theField = getWorld();

        int oldX = getX();
        int oldY = getY();
        int newX = oldX + this.dir.rightSteps;
        int newY = oldY + this.dir.upSteps;
        
        if (--life <= 0)
        {
            getWorld().removeObject(this);
            return;
        }
            
        if(!theField.hasBrickAt(newX, newY))
        {
            if (theField.hasGrassAt(newX, newY))
                theField.turnGrassToFire(newX, newY);
            setLocation(newX, newY);
        } 
        else 
        {      
            bounceFromSolid(theField, oldX, oldY, newX, newY);
        }
    }    
}
