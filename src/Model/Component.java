/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Kelas yang beisi koordinat, dan warna dari keseluruhan komponen-komponen yang ada dalam permainan Chip Challenge.
 * @author Adrian Reynaldi(2013730058)
 * @author Enricofindley  (2013730008)
 * @author Yohanes Ediwan (2013730044)
 */
public class Component 
{
    //atribut yang menyatakan koordinat sumbu x
    protected int x;
    //atribut yang menyatakan koordinat sumbu y
    protected int y;
    /**
     * Konstruktor dari kelas Component
     * @param x sebagai koordinat sumbu x
     * @param y sebagai koordinat sumbu y
     */
    public Component(int x, int y) 
    {
        this.x = x;
        this.y = y;
    }
    /**
     * Method yang bertugas sebagai getter dari nilai X
     * @return kordinat sumbu x
     */
    public int getX() 
    {
        return x;
    }
    /**
     * Setter untuk sumbu X
     * @param x sebagai koordinat sumbu X
     */
    public void setX(int x) 
    {
        this.x = x;
    }
    /**
     * Method yang bertugas sebagai getter dari nilai y
     * @return kordinat sumbu y
     */
    public int getY() 
    {
        return y;
    }
    /**
     * Setter untuk sumbu y
     * @param y sebagai koordinat sumbu Y
     */
    public void setY(int y) 
    {
        this.y = y;
    }
    /**
     * Method untuk mengeset gambar
     * @param img 
     */
    public void setGambar(ImageIcon img)
    {
        
    }
    /**
     * Getter dari Gambar 
     * @return gambar yang ditampilkan
     */
    public Image getGambar() 
    {
        return new ImageIcon("FireSprite.png").getImage();
    }
}
