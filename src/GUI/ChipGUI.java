/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Engine.Barrier;
import Engine.Board;
import Engine.Chip;
import Engine.Component;
import Engine.Finish;
import Engine.Fire;
import Engine.IC;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Win8
 */
public class ChipGUI extends javax.swing.JFrame implements ActionListener, KeyListener {

    private Board b;

    /**
     * Creates new form ChipGUI
     */
    public ChipGUI() {
        initComponents();
        setBoard();
        this.repaint();
        addKeyListener(this);
        this.setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void paint(Graphics g) {
        b.paint(g);
    }

    public void setBoard() {
        this.setTitle("Chip Challenge");
        b = (new Board(9, 9));
        this.setBarrier(true);
        this.setFinish();
        this.setWaterBoots(true, true);
        this.setFireBoots(true, true);
        this.setFire();
        this.setWater();
        boolean[] emerge = {true, true, true, true, true};
        this.setIC(emerge);
        this.setPlayer(4, 4);
        this.setWall();
        this.add(b);
        this.setSize(720, 600);
        this.setVisible(true);
    }

    public void setFinish() {
        Finish finish = new Finish(4, 0, Color.BLACK);
        b.setFinish(finish);
    }

    public void setBarrier(boolean appears) {
        Barrier barrier;
        if (appears == true) {
            barrier = new Barrier(4, 1, Color.MAGENTA);
        } else {
            barrier = new Barrier(-2, -2, Color.MAGENTA);
        }
        b.setBarrier(barrier);
    }

    public void setPlayer(int x, int y) {
        Chip player = new Chip(x, y, Color.GREEN);
        b.setPlayer(player);
    }

    public void setWaterBoots(boolean emerge, boolean die) {
        Component waterBoots;
        if (emerge == true) {
            waterBoots = new Component(0, 0, Color.blue);
        } else {
            waterBoots = new Component(-5, -5, Color.blue);
            die = false;
        }
        b.setWaterBoots(waterBoots);
    }

    public void setFireBoots(boolean emerge, boolean die) {
        Component fireBoots;
        if (emerge == true) {
            fireBoots = new Component(3, 8, Color.red);
        } else {
            fireBoots = new Component(-3, -3, Color.red);
            die = false;
        }
        b.setFireBoots(fireBoots);
    }

    public void setIC(boolean[] emerge) {
        IC[] IC = new IC[5];
        if (emerge[0] == true) {
            IC[0] = new IC(1, 0, Color.GRAY);
        } else {
            IC[0] = new IC(-2, -2, Color.MAGENTA);
        }
        if (emerge[1] == true) {
            IC[1] = new IC(7, 0, Color.GRAY);

        } else {
            IC[1] = new IC(-2, -2, Color.MAGENTA);
        }
        if (emerge[2] == true) {
            IC[2] = new IC(2, 4, Color.GRAY);
        } else {
            IC[2] = new IC(-2, -2, Color.MAGENTA);
        }
        if (emerge[3] == true) {
            IC[3] = new IC(4, 6, Color.GRAY);
        } else {
            IC[3] = new IC(-2, -2, Color.MAGENTA);
        }
        if (emerge[4] == true) {
            IC[4] = new IC(6, 4, Color.GRAY);
        } else {
            IC[4] = new IC(-2, -2, Color.MAGENTA);
        }
        b.setIC(IC);
    }

    public void setFire() {
        Fire[] fire = new Fire[7];
        fire[0] = new Fire(3, 2, Color.RED);
        fire[1] = new Fire(4, 2, Color.RED);
        fire[2] = new Fire(2, 2, Color.RED);
        fire[3] = new Fire(1, 2, Color.RED);
        fire[4] = new Fire(0, 2, Color.RED);
        fire[5] = new Fire(2, 1, Color.RED);
        fire[6] = new Fire(2, 0, Color.RED);
        b.setFire(fire);
    }

    public void setWater() {
        Component[] water = new Component[7];
        water[0] = new Component(6, 0, Color.BLUE);
        water[1] = new Component(6, 1, Color.BLUE);
        water[2] = new Component(6, 2, Color.BLUE);
        water[3] = new Component(7, 2, Color.BLUE);
        water[4] = new Component(8, 2, Color.BLUE);
        water[5] = new Component(8, 3, Color.BLUE);
        water[6] = new Component(5, 2, Color.BLUE);
        b.setWater(water);
    }

    public void setWall() {
        Component[] wall = new Component[26];
        wall[0] = new Component(3, 0, Color.DARK_GRAY);
        wall[1] = new Component(5, 0, Color.DARK_GRAY);
        wall[2] = new Component(0, 1, Color.DARK_GRAY);
        wall[3] = new Component(0, 4, Color.DARK_GRAY);
        wall[4] = new Component(0, 7, Color.DARK_GRAY);
        wall[5] = new Component(1, 1, Color.DARK_GRAY);
        wall[6] = new Component(3, 1, Color.DARK_GRAY);
        wall[7] = new Component(5, 1, Color.DARK_GRAY);
        wall[8] = new Component(7, 1, Color.DARK_GRAY);
        wall[9] = new Component(8, 1, Color.DARK_GRAY);
        wall[10] = new Component(1, 3, Color.DARK_GRAY);
        wall[11] = new Component(7, 3, Color.DARK_GRAY);
        wall[12] = new Component(1, 4, Color.DARK_GRAY);
        wall[13] = new Component(7, 4, Color.DARK_GRAY);
        wall[14] = new Component(8, 4, Color.DARK_GRAY);
        wall[15] = new Component(1, 5, Color.DARK_GRAY);
        wall[16] = new Component(7, 5, Color.DARK_GRAY);
        wall[17] = new Component(1, 7, Color.DARK_GRAY);
        wall[18] = new Component(2, 7, Color.DARK_GRAY);
        wall[19] = new Component(4, 7, Color.DARK_GRAY);
        wall[20] = new Component(5, 7, Color.DARK_GRAY);
        wall[21] = new Component(7, 7, Color.DARK_GRAY);
        wall[22] = new Component(8, 7, Color.DARK_GRAY);
        wall[23] = new Component(1, 8, Color.DARK_GRAY);
        wall[24] = new Component(4, 8, Color.DARK_GRAY);
        wall[25] = new Component(7, 8, Color.DARK_GRAY);
        b.setWall(wall);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Method untuk menggerakkan chip
     *
     * @param moveKey
     */
    @Override
    public void keyPressed(KeyEvent moveKey) {
        int arrowKey = moveKey.getKeyCode();
        int x = b.player.getX();
        int y = b.player.getY();
        if(x==8 && y==8)
        {
                if (arrowKey == KeyEvent.VK_LEFT) {
                    moveLeft();
                }
                else if (arrowKey == KeyEvent.VK_UP) {
                    moveUp();
                }
       
        }else if(x==0 && y==8)
        {
                if (arrowKey == KeyEvent.VK_RIGHT) {
                    moveRight();
                }
                else if (arrowKey == KeyEvent.VK_UP) {
                    moveUp();
                }
       
        }
        else if(x>7)
        {
            if(y<=0)
            {
                if (arrowKey == KeyEvent.VK_LEFT) {
                    moveLeft();
                }
                else if (arrowKey == KeyEvent.VK_DOWN) {
                    moveDown();
                } 
            }
            else
            {
                 if (arrowKey == KeyEvent.VK_UP) {
                    moveUp();
            } else if (arrowKey == KeyEvent.VK_DOWN) {
                moveDown();
            } 
            else if (arrowKey == KeyEvent.VK_LEFT) {
                moveLeft();
            }
            }
           
        }
        else if(x<=0)
        {
            if(y<=0)
            {
                if (arrowKey == KeyEvent.VK_RIGHT) {
                    moveRight();
                }
                else if (arrowKey == KeyEvent.VK_DOWN) {
                    moveDown();
                } 
            }
            else
            {
                if (arrowKey == KeyEvent.VK_UP) {
                moveUp();
            } else if (arrowKey == KeyEvent.VK_DOWN) {
                moveDown();
            } 
            else if (arrowKey == KeyEvent.VK_RIGHT) {
                moveRight();
            }
            }
            
        }
        else if(y>7)
        {
            if (arrowKey == KeyEvent.VK_UP) {
                moveUp();
            }  else if (arrowKey == KeyEvent.VK_RIGHT) {
                moveRight();
            } else if (arrowKey == KeyEvent.VK_LEFT) {
                moveLeft();
            }
        }
        else if(y<=0)
        {
            if (arrowKey == KeyEvent.VK_DOWN) {
                moveDown();
            } else if (arrowKey == KeyEvent.VK_RIGHT) {
                moveRight();
            } else if (arrowKey == KeyEvent.VK_LEFT) {
                moveLeft();
            }
        }
        else
        {
            if (arrowKey == KeyEvent.VK_UP) {
                moveUp();
            }  else if (arrowKey == KeyEvent.VK_RIGHT) {
                moveRight();
            } else if (arrowKey == KeyEvent.VK_LEFT) {
                moveLeft();
            }
             else if (arrowKey == KeyEvent.VK_DOWN) {
                moveDown();
            } 
        }

    }

    /**
     * Method untuk menggerakkan chip ke atas
     */
    public void moveUp() {
        int x = b.player.getX();
        int y = b.player.getY();
        this.setPlayer(x, y - 1);
        this.setBarrier(false);
        this.repaint();
    }

    /**
     * Method untuk menggerakkan chip ke bawah
     */
    public void moveDown() {
        int x = b.player.getX();
        int y = b.player.getY();
        this.setPlayer(x, y + 1);
        this.setBarrier(false);
        this.repaint();
    }

    /**
     * Method untuk menggerakkan chip ke kiri
     */
    public void moveLeft() {
        int x = b.player.getX();
        int y = b.player.getY();
        this.setPlayer(x-1, y);
        this.setBarrier(false);
        this.repaint();
    }

    /**
     * Method untuk menggerakkan chip ke bawah
     */
    public void moveRight() {
        int x = b.player.getX();
        int y = b.player.getY();
        this.setPlayer(x + 1, y);
        this.setBarrier(false);
        this.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChipGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChipGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChipGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChipGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChipGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
