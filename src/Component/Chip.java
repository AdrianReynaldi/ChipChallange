/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Component;

import LevelDesigner.Board;
import GUI.ChipGUI;
import LevelDesigner.Level1;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Kelas yang merepresentasikan objek chip
 * @author microsoft
 */
public class Chip extends Component implements ActionListener, KeyListener{
    private ArrayList<String> inventory;
    protected Component player;
    protected Board b;
    protected ChipGUI gui;
    protected ImageIcon imageIcon;
    protected Finish finish;
    
    public Chip(int x, int y,Board b,ChipGUI gui) {
        super(x, y);
        this.imageIcon=new ImageIcon("bawah.png");
        this.b=b;
        this.gui=gui;
        inventory = new ArrayList<String>();
        this.setPlayer(x,y);
    }
    
    public void addItem(String item)
    {
        inventory.add(item);
    }
   
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
    
    @Override
    public Image getGambar()
    {
        Image img = this.imageIcon.getImage();
        return img;
    }    

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

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
    
    public void moveUp() {
        this.scanIC();
        for (int i = 0; i < b.IC.length; i++) {
            if ((this.getX() == b.IC[i].getX()) && (this.getY() - 1 == b.IC[i].getY())) {
                b.emerge[i] = false;
                this.setPlayer(this.getX(), this.getY());
                b.setIC(b.emerge);
                gui.repaint();
                break;
            }
        }
        this.imageIcon = new ImageIcon("atas.png");
        if (scanFire(this.getX(), this.getY() - 1) == true) {
            if (this.hasSelectedItem("Fire Boot") == true) {
                this.setPlayer(this.getX(), this.getY() - 1);
                gui.repaint();
            } else if (this.hasSelectedItem("Fire Boot") == false) {
                this.setPlayer(this.getX(), this.getY() - 1);
                gui.repaint();
                gui.createConditionFrame(false);
            }
        } else if ((this.getX() == b.barrier.getX()) && (this.getY() - 1 == b.barrier.getY())) {

        } else if ((this.getX() == b.finish.getX()) && (this.getY() - 1 == b.finish.getY())) {
            this.setPlayer(this.getX(), this.getY() - 1);
            gui.repaint();
            gui.finished = true;
            gui.createConditionFrame(true);
        } else if ((this.getX() == b.hint.getX()) && (this.getY() - 1 == b.hint.getY())) {
            this.setPlayer(this.getX(), this.getY() - 1);
            gui.repaint();
            gui.showHint(true);
        } else if (scanWater(this.getX(), this.getY() - 1) == true) {
            if (this.hasSelectedItem("Water Boot") == true) {
                setPlayer(this.getX(), this.getY() - 1);
                gui.repaint();
            } else if (this.hasSelectedItem("Water Boot") == false) {
                setPlayer(this.getX(), this.getY() - 1);
                gui.repaint();
                gui.createConditionFrame(false);
            }
        } else if (scanWall(this.getX(), this.getY() - 1) == true) {
            gui.repaint();
        } else if ((this.getX() == b.waterBoots.getX()) && (this.getY() - 1 == b.waterBoots.getY())) {
            setPlayer(this.getX(), this.getY() - 1);
            b.setWaterBoots(false, true);
            gui.repaint();
            this.addItem("Water Boot");
        } else if ((this.getX() == b.fireBoots.getX()) && (this.getY() - 1 == b.fireBoots.getY())) {
            setPlayer(this.getX(), this.getY() - 1);
            b.setFireBoots(false, true);
            gui.repaint();
            this.addItem("Fire Boot");
        } else {
            setPlayer(this.getX(), this.getY() - 1);
            gui.repaint();
        }

    }

    /**
     * Method untuk menggerakkan chip ke bawah
     */
   public void moveDown() {
        this.scanIC();
        for (int i = 0; i < b.IC.length; i++) {
            if ((this.getX() == b.IC[i].getX()) && (this.getY() + 1 == b.IC[i].getY())) {
                b.emerge[i] = false;
                this.setPlayer(this.getX(), this.getY() );
                b.setIC(b.emerge);
                gui.repaint();
                break;
            }

        }
        this.imageIcon = new ImageIcon("bawah.png");
        if (scanFire(this.getX(), this.getY() + 1) == true) {
            if (this.hasSelectedItem("Fire Boot") == true) {
                this.setPlayer(this.getX(), this.getY() + 1);
                gui.repaint();
            } else if (this.hasSelectedItem("Fire Boot") == false) {
                this.setPlayer(this.getX(), this.getY() + 1);
                gui.repaint();
                gui.createConditionFrame(false);
            }
        } else if ((this.getX() == b.barrier.getX()) && (this.getY() + 1 == b.barrier.getY())) {

        } else if ((this.getX() == b.finish.getX()) && (this.getY() + 1 == b.finish.getY())) {
            this.setPlayer(this.getX(), this.getY() + 1);
            gui.repaint();
            gui.createConditionFrame(true);
        } else if ((this.getX() == b.hint.getX()) && (this.getY() + 1 == b.hint.getY())) {
            this.setPlayer(this.getX(), this.getY() + 1);
            gui.repaint();
            gui.showHint(true);
        } else if (scanWater(this.getX(), this.getY() + 1) == true) {
            if (this.hasSelectedItem("Water Boot") == true) {
                setPlayer(this.getX(), this.getY() + 1);
                gui.repaint();
            } else if (this.hasSelectedItem("Water Boot") == false) {
                setPlayer(this.getX(), this.getY() + 1);
                gui.repaint();
                gui.createConditionFrame(false);
            }
        } else if (scanWall(this.getX(), this.getY() + 1) == true) {
            gui.repaint();
        } else if ((this.getX() == b.waterBoots.getX()) && (this.getY() + 1 == b.waterBoots.getY())) {
            setPlayer(this.getX(), this.getY() + 1);
            b.setWaterBoots(false, true);
            gui.repaint();
            this.addItem("Water Boot");
        } else if ((this.getX() == b.fireBoots.getX()) && (this.getY() + 1 == b.fireBoots.getY())) {
            setPlayer(this.getX(), this.getY() + 1);
            b.setFireBoots(false, true);
            gui.repaint();
            this.addItem("Fire Boot");
        } else {
            setPlayer(this.getX(), this.getY() + 1);
            gui.repaint();
        }

    }

    /**
     * Method untuk menggerakkan chip ke kiri
     */
    public void moveLeft() {
        this.scanIC();
        for (int i = 0; i < b.IC.length; i++) {
            if ((this.getX() - 1 == b.IC[i].getX()) && (this.getY() == b.IC[i].getY())) {
                b.emerge[i] = false;
                this.setPlayer(this.getX() , this.getY());
                b.setIC(b.emerge);
                gui.repaint();
                break;
            }

        }
        this.imageIcon = new ImageIcon("kiri.png");
        if (scanFire(this.getX() - 1, this.getY()) == true) {
            if (this.hasSelectedItem("Fire Boot") == true) {
                this.setPlayer(this.getX() - 1, this.getY());
                gui.repaint();
            } else if (this.hasSelectedItem("Fire Boot") == false) {
                this.setPlayer(this.getX() - 1, this.getY());
                gui.repaint();
                gui.createConditionFrame(false);
            }
        } else if ((this.getX() - 1 == b.barrier.getX()) && (this.getY() == b.barrier.getY())) {

        } else if ((this.getX() - 1 == b.finish.getX()) && (this.getY() == b.finish.getY())) {
            this.setPlayer(this.getX() - 1, this.getY());
            gui.repaint();
            gui.createConditionFrame(true);
        } else if ((this.getX() - 1 == b.hint.getX()) && (this.getY() == b.hint.getY())) {
            this.setPlayer(this.getX() - 1, this.getY());
            gui.repaint();
            gui.showHint(true);
        } else if (scanWater(this.getX() - 1, this.getY()) == true) {
            if (this.hasSelectedItem("Water Boot") == true) {
                setPlayer(this.getX() - 1, this.getY());
                gui.repaint();
            } else if (this.hasSelectedItem("Water Boot") == false) {
                setPlayer(this.getX() - 1, this.getY());
                gui.repaint();
                gui.createConditionFrame(false);
            }
        } else if (scanWall(this.getX() - 1, this.getY()) == true) {
            gui.repaint();
        } else if ((this.getX() - 1 == b.waterBoots.getX()) && (this.getY() == b.waterBoots.getY())) {
            setPlayer(this.getX() - 1, this.getY());
            b.setWaterBoots(false, true);
            gui.repaint();
            this.addItem("Water Boot");
        } else if ((this.getX() - 1 == b.fireBoots.getX()) && (this.getY() == b.fireBoots.getY())) {
            setPlayer(this.getX() - 1, this.getY());
            b.setFireBoots(false, true);
            gui.repaint();
            this.addItem("Fire Boot");
        } else {
            setPlayer(this.getX() - 1, this.getY());
            gui.repaint();
        }

    }

    /**
     * Method untuk menggerakkan chip ke bawah
     */
    public void moveRight() {
        this.scanIC();
        for (int i = 0; i < b.IC.length; i++) {
            if ((this.getX() + 1 == b.IC[i].getX()) && (this.getY() == b.IC[i].getY())) {
                b.emerge[i] = false;
                this.setPlayer(this.getX(), this.getY());
                b.setIC(b.emerge);
                gui.repaint();
                break;
            }
        }
        this.imageIcon = new ImageIcon("kanan.png");
        if (scanFire(this.getX() + 1, this.getY()) == true) {
            if (this.hasSelectedItem("Fire Boot") == true) {
                this.setPlayer(this.getX() + 1, this.getY());
                gui.repaint();
            } else if (this.hasSelectedItem("Fire Boot") == false) {
                this.setPlayer(this.getX() + 1, this.getY());
                gui.repaint();
                gui.createConditionFrame(false);
            }
        } else if ((this.getX() + 1 == b.barrier.getX()) && (this.getY() == b.barrier.getY())) {

        } else if ((this.getX() + 1 == b.finish.getX()) && (this.getY() == b.finish.getY())) {
            this.setPlayer(this.getX() + 1, this.getY());
            gui.repaint();
            gui.createConditionFrame(true);
        } else if ((this.getX() + 1 == b.hint.getX()) && (this.getY() == b.hint.getY())) {
            this.setPlayer(this.getX() + 1, this.getY());
            gui.repaint();
            gui.showHint(true);
        } else if (scanWater(this.getX() + 1, this.getY()) == true) {
            if (this.hasSelectedItem("Water Boot") == true) {
                setPlayer(this.getX() + 1, this.getY());
                gui.repaint();
            } else if (this.hasSelectedItem("Water Boot") == false) {
                setPlayer(this.getX() + 1, this.getY());
                gui.repaint();
                gui.createConditionFrame(false);
            }
        } else if (scanWall(this.getX() + 1, this.getY()) == true) {
            gui.repaint();
        } else if ((this.getX() + 1 == b.waterBoots.getX()) && (this.getY() == b.waterBoots.getY())) {
            setPlayer(this.getX() + 1, this.getY());
            b.setWaterBoots(false, true);
            gui.repaint();
            this.addItem("Water Boot");
        } else if ((this.getX() + 1 == b.fireBoots.getX()) && (this.getY() == b.fireBoots.getY())) {
            setPlayer(this.getX() + 1, this.getY());
            b.setFireBoots(false, true);
            gui.repaint();
            this.addItem("Fire Boot");
        } else {
            setPlayer(this.getX() + 1, this.getY());
            gui.repaint();
        }

    }

    public boolean scanFire(int x, int y) {
        boolean result = false;
        for (int i = 0; i < b.fire.length; i++) {
            if ((b.fire[i].getX() == x) && (b.fire[i].getY() == y)) {
                if(b.fire[i].getX()>0)
                {
                    result = true;
                }
                
                break;
            }
        }
        return result;
    }

    public boolean scanWall(int x, int y) {
        boolean result = false;
        for (int i = 0; i < b.wall.length; i++) {
            if ((b.wall[i].getX() == x) && (b.wall[i].getY() == y)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean scanWater(int x, int y) {
        boolean result = false;
        for (int i = 0; i < b.water.length; i++) {
           if ((b.water[i].getX() == x) && (b.water[i].getY() == y)) {
                if(b.water[i].getX()>0)
                {
                    result = true;
                }
                
                break;
            }
            }
        return result;
}
    

    
    public void setPlayer(int x, int y) {
        this.x=x;
        this.y=y;
        b.setPlayer(this);
    }
    
     public void scanIC() {
        int ct = 0;
        for (int i = 0; i < b.emerge.length; i++) {
            if (b.emerge[i] == false) {
                ct++;
            }
        }
        if (ct == b.emerge.length) {
            b.setBarrier(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}
