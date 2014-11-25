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
 * @author Adrian
 */
public class FireBoot extends Component {

    private ImageIcon image;
    public FireBoot(int x, int y) {
        super(x, y);
        image=new ImageIcon("fireBoots.png");
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
