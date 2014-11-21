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
import java.awt.Image;
import java.awt.Shape;
import javax.swing.ImageIcon;
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
        ImageIcon image=new ImageIcon("C:\\Users\\Adrian\\Documents\\Tugas\\ADBO\\ChipChallange\\gambar\\Floor.jpg");
        Image img=image.getImage();
        for (int i = 0; i < panjang; i++) {
            for (int j = 0; j < lebar; j++) {
                g2d.drawImage(img, i * 50 + 50, j * 50 + 50, 50, 50, null);
            }
        }
        this.draw(g, finish);
        this.draw(g, barrier);
       // this.draw(g, hint);
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
       // this.draw(g, waterBoots);
        //this.draw(g, fireBoots);
    }

    public void draw(Graphics g, Component component) {
        Graphics2D g2d = (Graphics2D) g;
        Image img=component.getGambar();
        g2d.drawImage(img,component.getX() * 50 + 50, component.getY() * 50 + 50, 50, 50,null);
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

    public void setIC(IC[] IC) {
        this.IC = IC;
    }

    public void setFire(Fire[] fire) {
        this.fire = fire;
    }

    public void setWater(Water[] water) {
        this.water = water;
    }
    
    public void setWall(Wall[] wall) {
        this.wall = wall;
    }
}
