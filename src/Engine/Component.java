/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChipChallenge.Engine;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Win8
 */
public abstract class  Component 
{
    protected int x;
    protected int y;
    protected ImageIcon gambar;

    public Component(int x, int y) {
        this.x = x;
        this.y = y;
        this.gambar = gambar;
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

    public abstract Image getGambar();

    public abstract void setGambar(ImageIcon gambar) ;
}
