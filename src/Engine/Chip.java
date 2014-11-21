/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChipChallenge.Engine;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;

/**
 * Kelas yang menggambarkan Chip yaitu pemain dalam sebuah game Chip Challenge
 * @author Adrian Reynaldi(2013730058)
 * @author Enricofindley  (2013730008)
 * @author Yohanes Ediwan (2013730044)
 */
public class Chip extends Component{

    private ImageIcon image;
    /**
     * Constructor yang menginisialisasi parameter yang dimiliki oleh super class
     * @param x nilai x
     * @param y nilai y
     * @param warna warna dari chip
     */
    public Chip(int x, int y) {
        super(x, y);
        this.image=new ImageIcon("C:\\Users\\Adrian\\Documents\\Tugas\\ADBO\\ChipChallange\\gambar\\Finish.png");
    }
    
   @Override
    public Image getGambar() {
        Image img=this.image.getImage();
        return img;
    }

    @Override
    public void setGambar(ImageIcon gambar) {
        this.gambar=gambar;
    }
}
