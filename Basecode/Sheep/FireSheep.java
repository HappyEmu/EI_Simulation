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
    
    private Fire f1,f2,f3,f4;
    public FireSheep(Fire f1, Fire f2, Fire f3, Fire f4)
    {
        super();
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
        this.f4 = f4;
                      
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
            getWorld().removeObject(this.f1);
            getWorld().removeObject(this.f2);
            getWorld().removeObject(this.f3);
            getWorld().removeObject(this.f4);
            getWorld().removeObject(this);
            return;
        }
            
        if(!theField.hasBrickAt(newX, newY))
        {
            if (theField.hasGrassAt(newX, newY))
                theField.turnGrassToFire(newX, newY);
            setLocation(newX, newY);
            if (!theField.hasBrickAt(oldX+1, oldY)) f1.setLocation(newX+1,newY);
            if (!theField.hasBrickAt(oldX-1, oldY)) f2.setLocation(newX-1,newY);
            if (!theField.hasBrickAt(oldX, oldY+1)) f3.setLocation(newX,newY+1);
            if (!theField.hasBrickAt(oldX, oldY-1)) f4.setLocation(newX,newY-1);
        } 
        else 
        {      
            bounceFromSolid(theField, oldX, oldY, newX, newY);
        }
    }    
}
