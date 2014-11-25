/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Controller.Board;
import View.ChipGUI;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Chip adalah player dari permainan Chip Challenge 
 * @author Adrian Reynaldi(2013730058)
 * @author Enricofindley  (2013730008)
 * @author Yohanes Ediwan (2013730044)
 */
public class Chip extends Component implements ActionListener, KeyListener{
    // Atribut untuk menyatakan inventory pada permainan Chip Challenge
    // Inventory di representasikan dalam bentuk ArrayList
    // dimana banyaknya component-component dalam permainan Chip Challenge tidak diketahui panjangnya
    private ArrayList<String> inventory;
    // Atribut untuk menyatakan player pada permainan Chip Challenge
    protected Component player;
    // Atribut untuk menyatakan papan permainan.
    protected Board b;
    // Atribut yang merupakan Objek gui dari kelas Chip GUI
    protected ChipGUI gui;
    // Atribut yang merupakan objek Icon Image dari kelas Image Icon 
    protected ImageIcon imageIcon;
    // Atribut yang merupakan objek finish dari kelas Finish
    protected Finish finish;
    
    /**
     * Konstruktor dari kelas Chip, sekaligus memanggil konstruktor Chip yang ada di Component
     * @param x
     * @param y
     * @param warna
     * @param b
     * @param gui 
     */
    public Chip(int x, int y,Board b,ChipGUI gui) {
        super(x, y);
        this.imageIcon=new ImageIcon("bawah.png");
        this.b=b;
        this.gui=gui;
        inventory = new ArrayList<String>();
        this.setPlayer(x,y);
    }
    /**
     * Method yang berfungsi untuk menambahkan Item baru ke dalam inventory pada permainan Chip Challenge.
     * @param item baru yang ingin diambil
     */
    public void addItem(String item)
    {
        inventory.add(item);
    }
    /**
     * Method yang berguna untuk mengecek apakah player dalam permainan Chip Challenge ini sudah mempunyai item yang udah diambil atau belom
     * @param selectedItem Item yang dipilih
     * @return true jika item dalam permainan Chip Challenge sudah diambil oleh player nya.
     * @return false jika item dalam permainan Chip Challenge belom diambil oleh player nya.
     * Contoh nya : Player dalam permainan Chip Challenge ini jika sudah mengambil sepatu tahan air, player dapat berjalan di atas air.
     *              Jika player dalam permainan Chip Challenge ini belum mengambil sepatu tahan air, player tidak dapat berjalan di atas air  
     */
    public boolean hasSelectedItem(String selectedItem)
    {
        boolean result = false;
        for (int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).equals(selectedItem))
            {
                result = true;
                break;
            }
            else
            {
                result = false;
            }
        }
        return result;
    }
    /**
     * Method yang meng-override method Gambar yang ada di kelas Component
     * Method component yang di override adalah image player/ image Chip.
     * @return gambar player dalam permainan chip challengeyang diperoleh. 
     * Gambar player akan ditampilkan ke dalam bentuk GUI yang diambil dari folder penyimpanan
     */
    @Override
    public Image getGambar()
    {
        Image img = this.imageIcon.getImage();
        return img;
    }    

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
    /**
     * Method yang berfungsi untuk menggerakan pemain, dengan menggunakan arrow key
     * @param moveKey (W,A,S,D);
     */
    @Override
    public void keyPressed(KeyEvent moveKey) {
        int arrowKey = moveKey.getKeyCode();
        int x = this.getX();
        int y = this.getY();
        if (x == 8 && y == 8) {
            if (arrowKey == KeyEvent.VK_LEFT) {
                moveLeft();
            } else if (arrowKey == KeyEvent.VK_UP) {
                moveUp();
            }

        } else if (x == 0 && y == 8) {
            if (arrowKey == KeyEvent.VK_RIGHT) {
                moveRight();
            } else if (arrowKey == KeyEvent.VK_UP) {
                moveUp();
            }

        } else if (x > 7) {
            if (y <= 0) {
                if (arrowKey == KeyEvent.VK_LEFT) {
                    moveLeft();
                } else if (arrowKey == KeyEvent.VK_DOWN) {
                    moveDown();
                }
            } else {
                if (arrowKey == KeyEvent.VK_UP) {
                    moveUp();
                } else if (arrowKey == KeyEvent.VK_DOWN) {
                    moveDown();
                } else if (arrowKey == KeyEvent.VK_LEFT) {
                    moveLeft();
                }
            }

        } else if (x <= 0) {
            if (y <= 0) {
                if (arrowKey == KeyEvent.VK_RIGHT) {
                    moveRight();
                } else if (arrowKey == KeyEvent.VK_DOWN) {
                    moveDown();
                }
            } else {
                if (arrowKey == KeyEvent.VK_UP) {
                    moveUp();
                } else if (arrowKey == KeyEvent.VK_DOWN) {
                    moveDown();
                } else if (arrowKey == KeyEvent.VK_RIGHT) {
                    moveRight();
                }
            }

        } else if (y > 7) {
            if (arrowKey == KeyEvent.VK_UP) {
                moveUp();
            } else if (arrowKey == KeyEvent.VK_RIGHT) {
                moveRight();
            } else if (arrowKey == KeyEvent.VK_LEFT) {
                moveLeft();
            }
        } else if (y <= 0) {
            if (arrowKey == KeyEvent.VK_DOWN) {
                moveDown();
            } else if (arrowKey == KeyEvent.VK_RIGHT) {
                moveRight();
            } else if (arrowKey == KeyEvent.VK_LEFT) {
                moveLeft();
            }
        } else {
            if (arrowKey == KeyEvent.VK_UP) {
                moveUp();
            } else if (arrowKey == KeyEvent.VK_RIGHT) {
                moveRight();
            } else if (arrowKey == KeyEvent.VK_LEFT) {
                moveLeft();
            } else if (arrowKey == KeyEvent.VK_DOWN) {
                moveDown();
            }
        }

    }
    /**
     * Method supaya player bisa berjalan ke atas menggunakan arrow keys 
     */
    public void moveUp() {
        this.imageIcon=new ImageIcon("atas.png");
        if (scanFire(this.getX(), this.getY() - 1) == true) {
            if (this.hasSelectedItem("Fire Boot") == true) {
                this.setPlayer(this.getX(),this.getY()-1);
                gui.repaint();
            } else if (this.hasSelectedItem("Fire Boot") == false) {
                this.setPlayer(this.getX(),this.getY()-1);
                gui.repaint();
                gui.createConditionFrame(false);
            }
        }
        else if((this.getX()==gui.finish.getX())&&(this.getY()-1==gui.finish.getY()))
        {
            this.setPlayer(this.getX(),this.getY()-1);
            gui.repaint();
            gui.createConditionFrame(true);
        }
        else if((this.getX()==gui.Hint.getX())&&(this.getY()-1==gui.Hint.getY()))
        {
            this.setPlayer(this.getX(),this.getY()-1);
            gui.repaint();
            gui.showHint(true);
        }
        else if (scanWater(this.getX(), this.getY() - 1) == true) {
            if (this.hasSelectedItem("Water Boot") == true) {
                setPlayer(this.getX(), this.getY() - 1);
                gui.repaint();
            } else if (this.hasSelectedItem("Water Boot") == false) {
                setPlayer(this.getX(), this.getY() - 1);
                gui.repaint();
                gui.createConditionFrame(false);
            }
        }
        else if (scanWall(this.getX(), this.getY() - 1) == true) {
            gui.repaint();
        } else if ((this.getX() == gui.waterBoots.getX()) && (this.getY() == gui.waterBoots.getY())) {
            gui.setWaterBoots(false, true);
            this.addItem("Water Boot");
        } else if ((this.getX() == gui.fireBoots.getX()) && (this.getY() == gui.fireBoots.getY())) {
            gui.setFireBoots(false, true);
            this.addItem("Fire Boot");
        } else {
            setPlayer(this.getX(), this.getY() - 1);
            gui.repaint();
        }
        gui.setBarrier(false);

    }

    /**
     * Method supaya player bisa berjalan ke bawah menggunakan arrow keys 
     */
    public void moveDown() {
         this.imageIcon=new ImageIcon("bawah.png");
        if (scanFire(this.getX(), this.getY() + 1) == true) {
            if (this.hasSelectedItem("Fire Boot") == true) {
                this.setPlayer(this.getX(),this.getY()+1);
                gui.repaint();
            } else if (this.hasSelectedItem("Fire Boot") == false) {
                this.setPlayer(this.getX(),this.getY()+1);
                gui.repaint();
                gui.createConditionFrame(false);
            }
        } 
        else if((this.getX()==gui.finish.getX())&&(this.getY()+1==gui.finish.getY()))
        {
            this.setPlayer(this.getX(),this.getY()+1);
            gui.repaint();
            gui.createConditionFrame(true);
        }
        else if((this.getX()==gui.Hint.getX())&&(this.getY()+1==gui.Hint.getY()))
        {
            this.setPlayer(this.getX(),this.getY()+1);
            gui.repaint();
            gui.showHint(true);
        }
        else if (scanWater(this.getX(), this.getY() + 1) == true) {
            if (this.hasSelectedItem("Water Boot") == true) {
                setPlayer(this.getX(), this.getY() + 1);
                gui.repaint();
            } else if (this.hasSelectedItem("Water Boot") == false) {
                setPlayer(this.getX(), this.getY() + 1);
                gui.repaint();
                gui.createConditionFrame(false);
            }
        }
        else if (scanWall(this.getX(), this.getY() + 1) == true) {
            gui.repaint();
        } else if ((this.getX() == gui.waterBoots.getX()) && (this.getY() == gui.waterBoots.getY())) {
            gui.setWaterBoots(false, true);
            this.addItem("Water Boot");
        } else if ((this.getX() == gui.fireBoots.getX()) && (this.getY() == gui.fireBoots.getY())) {
            gui.setFireBoots(false, true);
            this.addItem("Fire Boot");
        } else {
            setPlayer(this.getX(), this.getY() + 1);
            gui.repaint();
        }
        gui.setBarrier(false);

    }

    /**
     * Method supaya player bisa berjalan ke kiri menggunakan arrow keys 
     */
    public void moveLeft() {
         this.imageIcon=new ImageIcon("kiri.png");
         if (scanFire(this.getX()-1, this.getY() ) == true) {
            if (this.hasSelectedItem("Fire Boot") == true) {
                this.setPlayer(this.getX()-1,this.getY());
                gui.repaint();
            } else if (this.hasSelectedItem("Fire Boot") == false) {
                this.setPlayer(this.getX()-1,this.getY());
                gui.repaint();
                gui.createConditionFrame(false);
            }
        } 
        else if((this.getX()-1==gui.finish.getX())&&(this.getY()==gui.finish.getY()))
        {
            this.setPlayer(this.getX()-1,this.getY());
            gui.repaint();
            gui.createConditionFrame(true);
        }
        else if((this.getX()-1==gui.Hint.getX())&&(this.getY()==gui.Hint.getY()))
        {
            this.setPlayer(this.getX()-1,this.getY());
            gui.repaint();
            gui.showHint(true);
        }
        else if (scanWater(this.getX()-1, this.getY()) == true) {
            if (this.hasSelectedItem("Water Boot") == true) {
                setPlayer(this.getX()-1, this.getY());
                gui.repaint();
            } else if (this.hasSelectedItem("Water Boot") == false) {
                setPlayer(this.getX()-1, this.getY());
                gui.repaint();
                gui.createConditionFrame(false);
            }
        }
        else if (scanWall(this.getX()-1, this.getY()) == true) {
            gui.repaint();
        } else if ((this.getX() == gui.waterBoots.getX()) && (this.getY() == gui.waterBoots.getY())) {
            gui.setWaterBoots(false, true);
            this.addItem("Water Boot");
        } else if ((this.getX() == gui.fireBoots.getX()) && (this.getY() == gui.fireBoots.getY())) {
            gui.setFireBoots(false, true);
            this.addItem("Fire Boot");
        } else {
            setPlayer(this.getX()-1, this.getY());
            gui.repaint();
        }
        gui.setBarrier(false);

    }

    /**
     * Method supaya player bisa berjalan ke kanan menggunakan arrow keys 
     */
    public void moveRight() {
        this.imageIcon=new ImageIcon("kanan.png");
        if (scanFire(this.getX()+1, this.getY() ) == true) {
            if (this.hasSelectedItem("Fire Boot") == true) {
                this.setPlayer(this.getX()+1,this.getY());
                gui.repaint();
            } else if (this.hasSelectedItem("Fire Boot") == false) {
                this.setPlayer(this.getX()+1,this.getY());
                gui.repaint();
                gui.createConditionFrame(false);
            }
        } 
        else if((this.getX()+1==gui.finish.getX())&&(this.getY()==gui.finish.getY()))
        {
            this.setPlayer(this.getX()+1,this.getY());
            gui.repaint();
            gui.createConditionFrame(true);
        }
        else if((this.getX()+1==gui.Hint.getX())&&(this.getY()==gui.Hint.getY()))
        {
            this.setPlayer(this.getX()+1,this.getY());
            gui.repaint();
            gui.showHint(true);
        }
        else if (scanWater(this.getX()+1, this.getY()) == true) {
            if (this.hasSelectedItem("Water Boot") == true) {
                setPlayer(this.getX()+1, this.getY());
                gui.repaint();
            } else if (this.hasSelectedItem("Water Boot") == false) {
                setPlayer(this.getX()+1, this.getY());
                gui.repaint();
                gui.createConditionFrame(false);
            }
        }
        else if (scanWall(this.getX()+1, this.getY()) == true) {
            gui.repaint();
        } else if ((this.getX() == gui.waterBoots.getX()) && (this.getY() == gui.waterBoots.getY())) {
            gui.setWaterBoots(false, true);
            this.addItem("Water Boot");
        } else if ((this.getX() == gui.fireBoots.getX()) && (this.getY() == gui.fireBoots.getY())) {
            gui.setFireBoots(false, true);
            this.addItem("Fire Boot");
        } else {
            setPlayer(this.getX()+1, this.getY());
            gui.repaint();
        }
        gui.setBarrier(false);

    }
    /**
     * Method yang berfungsi untuk mengidentifikasikan apakah ada api atau tidak di sekeliling player dalam chip challenge
     * @param x koordinat x
     * @param y koordinat y
     * @return true player akan mati jika menyentuh api, atau menginjak api
     * @return false player aman jika di sekelilingnya tidak ada api
     */
    public boolean scanFire(int x, int y) {
        boolean result = false;
        for (int i = 0; i < gui.fire.length; i++) {
            if ((gui.fire[i].getX() == x) && (gui.fire[i].getY() == y)) {
                if(gui.fire[i].getX()>0)
                {
                    result = true;
                }
                
                break;
            }
        }
        return result;
    }
    /**
     * Method yang berfungsi untuk mengidentifikasikan apakah ada dinding atau tidak di sekeliling player dalam chip challenge
     * @param x koordinat x
     * @param y koordinat y
     * @return true jika di sekeliling player ada dinding, dan player tidak bisa menembus dinding.
     */
    public boolean scanWall(int x, int y) {
        boolean result = false;
        for (int i = 0; i < gui.wall.length; i++) {
            if ((gui.wall[i].getX() == x) && (gui.wall[i].getY() == y)) {
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * Method yang berfungsi untuk mengidentifikasikan apakah ada air atau tidak di sekeliling player dalam chip challenge
     * @param x koordinat x
     * @param y koordinat y
     * @return true player akan mati jika menyentuh air, atau menginjak air
     * @return false player aman jika di sekelilingnya tidak ada air
     */
    public boolean scanWater(int x, int y) {
        boolean result = false;
        for (int i = 0; i < gui.water.length; i++) {
           if ((gui.water[i].getX() == x) && (gui.water[i].getY() == y)) {
                if(gui.water[i].getX()>0)
                {
                    result = true;
                }
                
                break;
            }
            }
        return result;
}
    /**
     * Method untuk menyimpan player ke dalam koordinat di papan permainan challenge
     * @param x koordinat x
     * @param y koordinat y
     */
    public void setPlayer(int x, int y) {
        this.x=x;
        this.y=y;
        b.setPlayer(this);
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
