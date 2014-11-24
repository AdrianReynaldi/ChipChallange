/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Adrian
 */
public class WaterBoot extends Component{

    protected ImageIcon image;
    public WaterBoot(int x, int y) {
        super(x, y);
        this.image=new ImageIcon("waterBoots.png");
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
