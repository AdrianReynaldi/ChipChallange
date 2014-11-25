/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Component yang dapat membantu player/chip berjalan di atas api dalam permainan Chip Challenge. 
 * @author Adrian Reynaldi(2013730058)
 * @author Enricofindley  (2013730008)
 * @author Yohanes Ediwan (2013730044)
 */
public class FireBoot extends Component 
{
    // Atribut yang menyatakan objek gambar dari Kelas Image Icon
    private ImageIcon image;
    /**
     * Konstruktor dari kelas FireBoot, dan juga memanggil konstruktor koordinat yang ada di kelas Component 
     * Membuat objek image yang berupa gambar FireBoot.
     * @param x sebagai koordinat sumbu X
     * @param y sebagai koordinat sumbu Y
     */
    public FireBoot(int x, int y) 
    {
        super(x, y);
        image=new ImageIcon("fireBoots.png");
    }
    /**
     * Method yang meng-override method Gambar yang ada di kelas Component
     * @return gambar yang diperoleh. Gambar akan ditampilkan ke dalam bentuk GUI yang diambil dari folder penyimpanan
     */
    @Override
    public Image getGambar() 
    {
        Image img=this.image.getImage();
        return img;
    }
    /**
     * Method yang meng-override method Gambar yang ada di kelas Component
     * @param gambar yang akan diambil dari folder penyimpanan
     */
    @Override
    public void setGambar(ImageIcon gambar)
    {
        this.image=gambar;
    }
    
}
