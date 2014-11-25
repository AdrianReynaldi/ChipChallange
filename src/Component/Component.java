/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Component;

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

    public Component(int x, int y) {
        this.x = x;
        this.y = y;
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
    
    public void setGambar(ImageIcon img){
        
    }
    
    public Image getGambar() {
        return new ImageIcon("FireSprite.png").getImage();
    }
}
