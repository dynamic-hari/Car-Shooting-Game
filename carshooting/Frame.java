package carshooting;

import javax.swing.*;

public class Frame {

    public Frame(){
        JFrame frame = new JFrame();
        frame.add(new Board());
        frame.setTitle("Car Shooting Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    public static void main(String[] args){
        new Frame();
    }
}