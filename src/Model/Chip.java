/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Engine.Board;
import GUI.ChipGUI;
import java.awt.Color;
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
    
    public Chip(int x, int y, Color warna,Board b,ChipGUI gui) {
        super(x, y, warna);
        this.imageIcon=new ImageIcon("bawah.png");
        this.b=b;
        this.gui=gui;
        this.player=player;
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
            System.out.println(inventory.get(i) + " " + selectedItem);
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
        this.imageIcon=new ImageIcon("atas.png");
        if (scanFire(this.getX(), this.getY() - 1) == true) {
            if (this.hasSelectedItem("Fire Boot") == true) {
                this.setY(-1);
                gui.repaint();
            } else if (this.hasSelectedItem("Fire Boot") == false) {
                this.setY(this.getY()-1);
                gui.repaint();
                gui.createConditionFrame();
            }

        } else if (scanWater(this.getX(), this.getY() - 1) == true) {
            if (this.hasSelectedItem("Water Boot") == true) {
                setPlayer(this.getX(), this.getY() - 1);
                gui.repaint();
            } else if (this.hasSelectedItem("Water Boot") == false) {
                setPlayer(this.getX(), this.getY() - 1);
                gui.repaint();
                gui.createConditionFrame();
            }
        } else if (scanWall(this.getX(), this.getY() - 1) == true) {
             gui.repaint();
        } else if ((this.getX() == gui.waterBoots.getX()) && (this.getY() == gui.waterBoots.getY())) {
            gui.setWaterBoots(false, true);
            this.addItem("Water Boot");
            gui.repaint();
        } else if ((this.getX() == gui.fireBoots.getX()) && (this.getY() == gui.fireBoots.getY())) {
            gui.setFireBoots(false, true);
            this.addItem("Fire Boot");
            gui.repaint();
        } else {
            setPlayer(this.getX(), this.getY() - 1);
            gui.repaint();
        }
        gui.setBarrier(false);

    }

    /**
     * Method untuk menggerakkan chip ke bawah
     */
    public void moveDown() {
        this.imageIcon=new ImageIcon("bawah.png");
        if (scanFire(this.getX(), this.getY() + 1) == true) {
            if (this.hasSelectedItem("Fire Boot") == false) {
                this.setY(this.getY()+1);
                gui.repaint();
                gui.createConditionFrame();
            } else if (this.hasSelectedItem("Fire Boot") == true) {
                gui.repaint();
            }

        } else if (scanWater(this.getX(), this.getY() + 1) == true) {
            if (this.hasSelectedItem("Water Boot") == true) {
                setPlayer(this.getX(), this.getY() + 1);
                gui.repaint();
            } else if (this.hasSelectedItem("Water Boot") == false) {
                setPlayer(this.getX(), this.getY() + 1);
                gui.repaint();
                gui.createConditionFrame();
            }
        } else if (scanWall(this.getX(), this.getY() + 1) == true) {
            gui.repaint();
        } else if ((this.getX() == gui.waterBoots.getX()) && (this.getY() == gui.waterBoots.getY())) {
            gui.setWaterBoots(false, true);
            this.addItem("Water Boot");
            gui.repaint();
        } else if ((this.getX() == gui.fireBoots.getX()) && (this.getY() == gui.fireBoots.getY())) {
            gui.setFireBoots(false, true);
            this.addItem("Fire Boot");
            gui.repaint();
        } else {
            setPlayer(this.getX(), this.getY() + 1);
            gui.repaint();
        }
        gui.setBarrier(false);

    }

    /**
     * Method untuk menggerakkan chip ke kiri
     */
    public void moveLeft() {
        this.imageIcon=new ImageIcon("kiri.png");
        if (scanFire(this.getX() - 1, this.getY()) == true) {
            if (this.hasSelectedItem("Fire Boot") == false) {
                setPlayer(this.getX() - 1, this.getY());
                gui.repaint();               
                gui.createConditionFrame();
            } else if (this.hasSelectedItem("Fire Boot") == true) {
                gui.repaint();
            }

        } else if (scanWater(this.getX() - 1, this.getY()) == true) {
            if (this.hasSelectedItem("Water Boot") == true) {
                setPlayer(this.getX() - 1, this.getY());
                gui.repaint();
            } else if (this.hasSelectedItem("Water Boot") == false) {
                setPlayer(this.getX() - 1, this.getY());
                gui.repaint();
                gui.createConditionFrame();
            }
        } else if (scanWall(this.getX() - 1, this.getY()) == true) {
            gui.repaint();
        } else if ((this.getX() == gui.waterBoots.getX()) && (this.getY() == gui.waterBoots.getY())) {
            gui.setWaterBoots(false, true);
            this.addItem("Water Boot");
            gui.repaint();
        } else if ((this.getX() == gui.fireBoots.getX()) && (this.getY() == gui.fireBoots.getY())) {
            gui.setFireBoots(false, true);
            this.addItem("Fire Boot");
            gui.repaint();
        } else {
            setPlayer(this.getX() - 1, this.getY());
            gui.repaint();
        }
        gui.setBarrier(false);
    }

    /**
     * Method untuk menggerakkan chip ke bawah
     */
    public void moveRight() {
        this.imageIcon=new ImageIcon("kanan.png");
        if (scanFire(this.getX() + 1, this.getY()) == true) {
            if (this.hasSelectedItem("Fire Boot") == false) {
                setPlayer(this.getX() + 1, this.getY());
                gui.repaint();
                gui.createConditionFrame();
            } else if (this.hasSelectedItem("Fire Boot") == true) {
                gui.repaint();
            }

        } else if (scanWater(this.getX() + 1, this.getY()) == true) {
            if (this.hasSelectedItem("Water Boot") == true) {
                setPlayer(this.getX() + 1, this.getY());
                gui.repaint();
            } else if (this.hasSelectedItem("Water Boot") == false) {
                setPlayer(this.getX() + 1, this.getY());
                gui.repaint();
                gui.createConditionFrame();
            }
        } else if (scanWall(this.getX() + 1, this.getY()) == true) {
            gui.repaint();
        } else if ((this.getX() == gui.waterBoots.getX()) && (this.getY() == gui.waterBoots.getY())) {
            gui.setWaterBoots(false, true);
            this.addItem("Water Boot");
            gui.repaint();
        } else if ((this.getX() == gui.fireBoots.getX()) && (this.getY() == gui.fireBoots.getY())) {
            gui.setFireBoots(false, true);
            this.addItem("Fire Boot");
            gui.repaint();
        } else {
            setPlayer(this.getX() + 1, this.getY());
            gui.repaint();
        }
        gui.setBarrier(false);
    }

    public boolean scanFire(int x, int y) {
        boolean result = false;
        for (int i = 0; i < gui.fire.length; i++) {
            if ((gui.fire[i].getX() == x) && (gui.fire[i].getY() == y)) {
                if (gui.fireBoots.getX() > 0) {
                    result = true;
                }
                break;
            }
        }
        return result;
    }

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

    public boolean scanWater(int x, int y) {
        boolean result = false;
        for (int i = 0; i < gui.water.length; i++) {
            if ((gui.water[i].getX() == x) && (gui.water[i].getY() == y)) {
                if (gui.waterBoots.getX() > 0) 
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
    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}
