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
 * @author Adrian
 */
public class Water extends Component {
    
    protected ImageIcon image;
    public Water(int x, int y) {
        super(x, y,Color.black);
        this.image=new ImageIcon("Water.jpg");
//        this.image=new ImageIcon("C:\\Users\\Adrian\\Documents\\Tugas\\ADBO\\ChipChallange\\gambar\\IC.png");
    }
    
    @Override
    public Image getGambar() {
        Image img=this.image.getImage();
        return img;
    }

    @Override
    public void setGambar(ImageIcon gambar) {
        this.image=gambar;
    }
}