/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChipChallenge.Engine;

/**
 * Kelas yang merepresentasikan papan permainan pada permainan Chip Challenge
 * @author Adrian Reynaldi(2013730058)
 * @author Enricofindley  (2013730008)
 * @author Yohanes Ediwan (2013730044)
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
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
     * Kotak finish
     */
    public Finish finish;
    
    /**
     * Penghalang chip sebelum masuk ke finish
     */
    public Barrier barrier;
    
    /**
     * Pemain permainan
     */
    public Chip player;
    
    /**
     * IC sebagai syarat pembuka barrier
     */
    public Component[] ic;
    
    /**
     * Api yang membuat permainan berakhir
     */
    public Fire[] fire;
    
    /**
     * dinding penghlang chip berjalan 
     */
    public Wall[] wall;

    /**
     * Constructor yang menginisialisasi atribut
     * @param panjang panjang papan permainan
     * @param lebar lebar papan permainan
     * @param finish kotak finish
     * @param barrier penghalang chip sebelum masuk ke finish
     * @param player pemain permainan
     * @param IC ic sebagai syarat pembuka barrier
     * @param fire api yang membuat permainan berakhir
     * @param wall dinding penghalang chip berjalan 
     */
    public Board(int panjang, int lebar, Finish finish, Barrier barrier, Chip player, Component[] ic, Fire[] fire, Wall[] wall) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.finish = finish;
        this.barrier = barrier;
        this.player = player;
        this.ic = ic;
        this.fire = fire;
        this.wall = wall;
        
    }

    /**
     * Method untuk menggambar komponen-komponen dalam permainan
     * @param g grafik
     */
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < panjang; i++) {
            for (int j = 0; j < lebar; j++) {
                g2d.drawRoundRect(i * 50, j * 50, 50, 50, 10, 10);
            }
        }
        this.draw(g, finish);
        this.draw(g, barrier);
        this.draw(g, player);
        for (int i = 0; i < ic.length; i++) {
            this.draw(g, ic[i]);
        }
        for (int i = 0; i < fire.length; i++) {
            this.draw(g, fire[i]);
        }
        for (int i = 0; i < wall.length; i++) {
            this.draw(g, wall[i]);
        }
    }

    /**
     * Menampilkan semua hasil dari method paint
     * @param g grafik
     * @param component komponen dalam permainan  
     */
    public void draw(Graphics g, Component component) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(component.getWarna());//replace ama image
        g2d.fillRect(component.getX() * 50, component.getY() * 50, 50, 50);//replace ama image
    }
    
    
}
