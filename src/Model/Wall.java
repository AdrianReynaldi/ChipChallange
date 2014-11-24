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
 * Penghalang chip berjalan
 * @author Adrian Reynaldi(2013730058)
 * @author Enricofindley  (2013730008)
 * @author Yohanes Ediwan (2013730044)
 */
public class Wall extends Component {
    protected ImageIcon image;

    public Wall(int x, int y) {
        super(x, y,Color.black);
        this.image=new ImageIcon("Wall.jpg");
//        this.image=new ImageIcon("C:\\Users\\Adrian\\Documents\\Tugas\\ADBO\\ChipChallange\\gambar\\Wall.jpg");
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
