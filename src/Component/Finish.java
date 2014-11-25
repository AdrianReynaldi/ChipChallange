/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Component;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Jalan keluar dalam permainan chip challenge
 * @author Adrian Reynaldi(2013730058)
 * @author Enricofindley  (2013730008)
 * @author Yohanes Ediwan (2013730044)
 */
public class Finish extends Component{

    protected ImageIcon image;
    public Finish(int x, int y) {
        super(x, y);
        this.image=new ImageIcon("Finish.png");
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
