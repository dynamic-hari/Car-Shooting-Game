package carshooting;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Car {

    int x, y;
    Image car;
    int ammo = 100;

    ImageIcon s = new ImageIcon("src/carshooting/Car.png");


    static ArrayList bullets;

    public Car() {
        x = 350;
        y = 680;
        car = s.getImage();
        bullets = new ArrayList();
    }

    public Rectangle getBounds()
    {
        return new Rectangle(x,y, 40, 70);
    }

    public static ArrayList getBullets()
    {
        return bullets;
    }

    public void fire()
    {
        if (ammo > 1)
        {
            ammo--;
            Bullet z = new Bullet((x+10), (y-5));
            bullets.add(z);
        }
        else if(ammo == 1)
        {
            ammo+=100;
        }
    }

    public void move_right() {
        if (x < 750)
            x = x + 25;
    }

    public void move_left() {
        x = x - 25;
        if (x < 0) {
            x = 0;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return car;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT)
        {
            move_left();

        }

        if (key == KeyEvent.VK_RIGHT)
        {
            move_right();
        }

        if (key == KeyEvent.VK_SPACE)
        {
            fire();
        }

    }
}
