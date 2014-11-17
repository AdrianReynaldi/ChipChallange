/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChipChallenge.Engine;

/**
 *
 * @author Win8
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Board extends JPanel {

    public int panjang;
    public int lebar;
    public Component finish;
    public Component barrier;
    public Component hint;
    public Component player;
    public Component waterBoots;
    public Component fireBoots;
    public Component[] IC;
    public Component[] fire;
    public Component[] water;
    public Component[] wall;

    public Board(int panjang, int lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        for (int i = 0; i < panjang; i++) {
            for (int j = 0; j < lebar; j++) {
                g2d.fill3DRect(i * 50 + 50, j * 50 + 50, 50, 50, true);
            }
        }
        this.draw(g, finish);
        this.draw(g, barrier);
        this.draw(g, hint);
        for (int i = 0; i < IC.length; i++) 
        {
            this.draw(g, IC[i]);
        }
        for (int i = 0; i < fire.length; i++) 
        {
            this.draw(g, fire[i]);
        }
        for (int i = 0; i < water.length; i++) 
        {
            this.draw(g, water[i]);
        }
        for (int i = 0; i < wall.length; i++) 
        {
            this.draw(g, wall[i]);
        }
        this.draw(g, player);
        this.draw(g, waterBoots);
        this.draw(g, fireBoots);
    }

    public void draw(Graphics g, Component component) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(component.getWarna());
        g2d.fillRect(component.getX() * 50 + 50, component.getY() * 50 + 50, 50, 50);
    }

    public void setFinish(Component finish) {
        this.finish = finish;
    }

    public void setBarrier(Component barrier) {
        this.barrier = barrier;
    }

    public void setHint(Component hint) {
        this.hint = hint;
    }

    public void setPlayer(Component player) {
        this.player = player;
    }
    
    public void setWaterBoots(Component waterBoots)
    {
        this.waterBoots = waterBoots;
    }
    
    public void setFireBoots(Component fireBoots) {
        this.fireBoots = fireBoots;
    }

    public void setIC(Component[] IC) {
        this.IC = IC;
    }

    public void setFire(Component[] fire) {
        this.fire = fire;
    }

    public void setWater(Component[] water) {
        this.water = water;
    }
    
    public void setWall(Component[] wall) {
        this.wall = wall;
    }
}
