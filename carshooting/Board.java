package carshooting;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Board extends JPanel implements ActionListener
{
    Car car;

    Timer time;

    private ArrayList<Obstacle> list1=new ArrayList<Obstacle>();;

    private Random rand1 = new Random();

    int score=0;

    String message = "Game Over!!!";

    boolean game=true;

    public Board() {
        car = new Car();
        addKeyListener(new AL());
        setFocusable(true);
        time =new Timer(400, new TimerListener());
        time.start();
    }

    @Override
    public void actionPerformed(ActionEvent e){
    }

    public class TimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            checkCollision_car();
            Integer x = rand1.nextInt(800);
            list1.add(new Obstacle(x));
            for (Obstacle obstacle : list1)
            {
                if (obstacle.isVisible())
                {
                    obstacle.move_down();
                    check_Collision();
                }
            }
            ArrayList bullets = Car.getBullets();
            for (int w = 0; w < bullets.size(); w++)
            {
                Bullet m = (Bullet) bullets.get(w);
                if (m.getVisible() == true) {
                    m.move();
                    check_Collision();
                }
                else
                    bullets.remove(w);
            }
            repaint();
        }
    }
    public void check_Collision()
    {
        for (Obstacle obstacle : list1)
        {   Rectangle r1;
            r1 = obstacle.getBounds();
            ArrayList bullets = car.getBullets();
            for (int w = 0; w < bullets.size(); w++) {
                Bullet m = (Bullet) bullets.get(w);
                Rectangle m1 = m.getBounds();
                if (r1.intersects(m1) && obstacle.isVisible()) {
                    obstacle.die();
                    m.die();
                    score=score+1;
                }
            }
        }
    }
    public void checkCollision_car()
    {
        for (Obstacle obstacle : list1)
        {   Rectangle r1;
            r1 = obstacle.getBounds();
            Rectangle d = car.getBounds();
            if (d.intersects(r1)) {
                time.stop();
                game=false;
            }
        }
    }
    /*public void checkCollisions()
    {
        for (Obstacle obstacle : list1)
        {   Rectangle r1;
            r1 = obstacle.getBounds();
            ArrayList bullets = car.getBullets();
            for (int w = 0; w < bullets.size(); w++) {
                Bullet m = (Bullet) bullets.get(w);
                Rectangle m1 = m.getBounds();
                if (r1.intersects(m1) && obstacle.isVisible()) {
                    obstacle.die();
                    m.die();
                    score=score+1;
                }
            }
            Rectangle d = car.getBounds();
            if (d.intersects(r1)) {
                game=false;
                time.stop();
            }
        }
    }
     */
    void gameOver(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 800, 800);
        g.setColor(new Color(0, 32, 48));
        g.fillRect(50, 300, 700, 100);
        g.setColor(Color.white);
        g.drawRect(50, 300, 700, 100);
        var small = new Font("Helvetica", Font.BOLD, 20);
        var fontMetrics = this.getFontMetrics(small);
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(message, (800 - fontMetrics.stringWidth(message)) / 2, 340);
        g.drawString("Score <~~> "+Integer.toString(score), (800 - fontMetrics.stringWidth(message)) / 2, 380);

    }
    public void paint(Graphics g)
    {
        super.paint(g);
        if(game)
        {
            g.drawImage(car.getImage(), car.getX(), car.getY(), this);
            for (Obstacle obstacle : list1)
            {
                if (obstacle.isVisible())
                    obstacle.draw_obstacle(g);
            }
            ArrayList bullets = car.getBullets();
            for (int w = 0; w < bullets.size(); w++)
            {
                Bullet m = (Bullet) bullets.get(w);
                if (m.getVisible())
                    g.drawImage(m.getImage(), m.getX(), m.getY(), null);
            }
            drawScore(g);
        }
        else
        {
            gameOver(g);
        }
    }
    public void drawScore(Graphics g)
    {
        g.setColor(Color.RED);
        g.setFont(new Font("serif", Font.BOLD + Font.ITALIC, 35));
        g.drawString("SCORE", 60, 50);
        g.setFont(new Font("serif", Font.BOLD, 50));
        g.drawString("-------", 60, 70);
        g.drawString(Integer.toString(score), 100, 100);
        g.drawString("-------", 60, 120);
    }
    private class AL extends KeyAdapter
    {
        public void keyPressed(KeyEvent e)
        {
            car.keyPressed(e);
        }
    }
}