package carshooting;

import java.awt.*;

public class Obstacle {

    private Integer xPos;
    private Integer yPos = -20;
    private Integer l = 30;
    private boolean visible;

    public Obstacle(Integer xPos) {
        super();
        this.xPos = xPos;
        visible=true;
    }

    public void die() {

        visible = false;
    }
    public boolean isVisible() {

        return visible;
    }

    public void move_down() {
        yPos = yPos + l;
    }

    public Rectangle getBounds()
    {
        return new Rectangle(xPos,yPos, 30, 30);
    }

    public void draw_obstacle(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(xPos, yPos, l, l);
    }

}
