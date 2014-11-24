/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Win8
 */
public class Component 
{
    protected int x;
    protected int y;
    private Color warna;

    public Component(int x, int y, Color warna) {
        this.x = x;
        this.y = y;
        this.warna = warna;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getWarna() {
        return warna;
    }

    public void setWarna(Color warna) {
        this.warna = warna;
    }
    
    /**
     * mengganti gambar pada kelas yang memiliki gambar, dengan gambar img
     * @param img gambar baru yang akan menggantikan gambar yang lama
     */
    public void setGambar(ImageIcon img){
        
    }
    
    /**
     * mengembalikan gambar pada kelas yang memiliki gambar
     * @return gambar bertipe Image 
     */
    public Image getGambar() {
        return new ImageIcon("FireSprite.png").getImage();
    }
}
