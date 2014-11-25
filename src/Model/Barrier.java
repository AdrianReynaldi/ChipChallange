/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Penghalang chip sebelum masuk ke finish
 * @author Adrian Reynaldi(2013730058)
 * @author Enricofindley  (2013730008)
 * @author Yohanes Ediwan (2013730044)
 */
public class Barrier extends Component 
{
    // Atribut untuk nyimpen image.
    private ImageIcon image;
    /**
     * Memanggil konstruktor barrier dari konstruktor barrier bapanya
     * Dan membuat objek gambar Barrier ke dalam bentuk GUI
     * @param koordinat dari x
     * @param koordinat dari y 
     */
    public Barrier(int x, int y) 
    {
        super(x, y);
        image=new ImageIcon("Barrier.png");
    }
    /**
     * Method yang berfungsi untuk mengambil setiap komponent IC yang ada di permainan Chip Challenge
     * Barrier akan hancur jika semua komponent IC telah terkumpul.
     * @param ic --> komponen-komponen IC
     * @return barrier yang sudah hancur.
     */
    public boolean breakBarrier(Component[] ic)
    {
        boolean breakBarrier = false;
        if(ic.length == 0)
        {
            breakBarrier = true;
        }
        return breakBarrier;
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
