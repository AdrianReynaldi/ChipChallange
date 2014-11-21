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
 * Pembunuh chip jika chip menginjak fire
 * @author Adrian Reynaldi(2013730058)
 * @author Enricofindley  (2013730008)
 * @author Yohanes Ediwan (2013730044)
 */
public class Fire extends Component {

    protected ImageIcon image;
    public Fire(int x, int y) {
        super(x, y);
        this.image=new ImageIcon("C:\\Users\\Adrian\\Documents\\Tugas\\ADBO\\ChipChallange\\gambar\\IC.png");
    }
    
    public boolean chk(Chip player)
    {
        boolean lose  = false;
        if((player.getX()==this.getX())&&(player.getY()== this.getY()))
        {
            lose = true;
        }
        return lose;
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
