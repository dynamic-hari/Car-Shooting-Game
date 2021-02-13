package carshooting;

import java.awt.*;

import javax.swing.ImageIcon;

public class Bullet {

    int x,y;
    Image img;
    boolean visible;

    public Bullet(int startX, int startY)
    {
        x = startX;
        y = startY;
        ImageIcon newBullet = new ImageIcon("src/carshooting/Bullet.png");
        img = newBullet.getImage();
        visible = true;
    }

    public Rectangle getBounds()
    {
        return new Rectangle(x,y, 40, 20);
    }

    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public void die() {

        visible = false;
    }
    public boolean getVisible()
    {
        return visible;
    }
    public Image getImage()
    {
        return img;
    }

    public void move()
    {
        y = y-30;
        if ( y < 0)
            visible = false;
    }

}