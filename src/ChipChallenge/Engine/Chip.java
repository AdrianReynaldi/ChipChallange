/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChipChallenge.Engine;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Kelas yang menggambarkan Chip yaitu pemain dalam sebuah game Chip Challenge
 * @author Adrian Reynaldi(2013730058)
 * @author Enricofindley  (2013730008)
 * @author Yohanes Ediwan (2013730044)
 */
public class Chip extends Component implements ActionListener, KeyListener {

    /**
     * Constructor yang menginisialisasi parameter yang dimiliki oleh super class
     * @param x nilai x
     * @param y nilai y
     * @param warna warna dari chip
     */
    public Chip(int x, int y, Color warna) {
        super(x, y, warna);
    }
    
    /**
     * Method untuk menggerakkan chip
     * @param moveKey 
     */
    @Override
    public void keyPressed(KeyEvent moveKey)
    {
        int arrowKey = moveKey.getKeyCode();
        if(arrowKey == KeyEvent.VK_UP)
        {
            moveUp();
        }
        else if(arrowKey == KeyEvent.VK_DOWN)
        {
            moveDown();
        }
        else if(arrowKey == KeyEvent.VK_RIGHT)
        {
            moveRight();
        }
        else if(arrowKey == KeyEvent.VK_LEFT)
        {
            moveLeft();
        }
    }
    
    /**
     * Method untuk menggerakkan chip ke atas
     */
    public void moveUp()
    {
        this.setY(this.getY()-1);
    }
    
    /**
     * Method untuk menggerakkan chip ke bawah 
     */
    public void moveDown()
    {
        this.setY(this.getY()+1);
    }
    
    /**
     * Method untuk menggerakkan chip ke kiri
     */
    public void moveLeft()
    {
        this.setX(this.getX()-1);
    }
    
    /**
     * Method untuk menggerakkan chip ke bawah 
     */
    public void moveRight()
    {
        this.setX(this.getX()+1);
    }

    @Override
     public void actionPerformed(ActionEvent e){
        
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
