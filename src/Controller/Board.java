/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 * Papan permainan dalam permainan Chip Challenge
 * @author Adrian Reynaldi(2013730058)
 * @author Enricofindley  (2013730008)
 * @author Yohanes Ediwan (2013730044)
 */
import Model.Chip;
import Model.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel {

    /**
     * Panjang papan permainan
     */
    public int panjang;
    
    /**
     * Lebar papan permainan 
     */
    public int lebar;
    
    /**
     * Jalan keluar pada permainan
     */
    public Component finish;
    
    /**
     * penghalang chip sebelum masuk ke finish
     */
    public Component barrier;
    
    /**
     * Bantuan untuk menyelesaikan puzzle permainan
     */
    public Component hint;
    
    /**
     * Player dalam permainan
     */
    public Chip player;
    
    /**
     * Sepatu untuk dapat membuat player melintasi air
     */
    public Component waterBoots;
    
    /**
     * Sepatu untuk dapat membuat player melintasi api
     */
    public Component fireBoots;
    
    /**
     * IC sebagai syarat terbukanya barrier
     */
    public Component[] IC;
    
    /**
     * Api yang dapat membakar pemain
     */
    public Component[] fire;
    
    /**
     * Air yang dapat menenggelamkan pemain
     */
    public Component[] water;
    
    /**
     * Tembok sebagai penghalang jalan pemain
     */
    public Component[] wall;

    /**
     * Constructor untuk menginisialisasi atribut
     * @param panjang panjang papan permainan
     * @param lebar lebar papan permainan
     */
    public Board(int panjang, int lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    /**
     * Override method paint dari kelas JPanel
     * @param g graphic program
     */
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < panjang; i++) {
            for (int j = 0; j < lebar; j++) {
                g2d.drawImage(new ImageIcon("Floor.png").getImage(),i * 50 + 50, j * 50 + 50, 50, 50, null);
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

    /**
     * Method untuk menggambar permainan ke dalam GUI
     * @param g graphic program
     * @param component komponen dalam papan permainan
     */
    public void draw(Graphics g, Component component) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(component.getGambar(),component.getX() * 50 + 50, component.getY() * 50 + 50, 50, 50,null);
    }

    /**
     * Setter method untuk Jalan keluar pada permainan
     * @param finish jalan keluar dari permainan
     */
    public void setFinish(Component finish) {
        this.finish = finish;
    }

     /**
     * Setter method untuk penghalang jalan pemain menuju finish
     * @param barrier penghalang jalan pemain menuju finish
     */
    public void setBarrier(Component barrier) {
        this.barrier = barrier;
    }
    
     /**
     * Setter method untuk bantuan menyelesaikan permainan
     * @param hint bantuan untuk menyelesaikan permainan
     */
    public void setHint(Component hint) {
        this.hint = hint;
    }

     /**
     * Setter method untuk pemain dalam permainan
     * @param player pemain dalam permainan
     */
    public void setPlayer(Chip player) {
        this.player = player;
    }
    
     /**
     * Setter method untuk sepatu yang dapat membuat pemain berjalan di air
     * @param waterBoots sepatu yang dapat membuat pemain berjalan di air
     */
    public void setWaterBoots(Component waterBoots)
    {
        this.waterBoots = waterBoots;
    }
    
   /**
     * Setter method untuk sepatu yang dapat membuat pemain berjalan di api
     * @param fireBoots sepatu yang dapat membuat pemain berjalan di api
     */
    public void setFireBoots(Component fireBoots) {
        this.fireBoots = fireBoots;
    }
    
     /**
     * Setter method untuk ic yang menjadi syarat terbukanya barrier
     * @param IC ic pada permainan chip challenge
     */
    public void setIC(Component[] IC) {
        this.IC = IC;
    }
    
     /**
     * Setter method untuk api yang dapat membakar pemain
     * @param fire api yang membakar pemain
     */
    public void setFire(Component[] fire) {
        this.fire = fire;
    }
    
    /**
     * Setter method untuk air yang dapat membakar pemain
     * @param water air yang membakar pemain
     */
    public void setWater(Component[] water) {
        this.water = water;
    }
    
     /**
     * Setter method untuk penghalang jalan pemain
     * @param wall penghalang jalan pemain
     */
    public void setWall(Component[] wall) {
        this.wall = wall;
    }
}