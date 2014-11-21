/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChipChallenge.GUI;

import ChipChallenge.Engine.*;
import ChipChallenge.Engine.Board;
import ChipChallenge.Engine.Component;
import ChipChallenge.Engine.Finish;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author Win8
 */
public class ChipGUI extends javax.swing.JFrame implements ActionListener, KeyListener{

    Board b;

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
        //this.setWaterBoots(true, true);
        //this.setFireBoots(true, true);
        this.setFire();
        this.setWater();
       // this.setHint();
        boolean[] emerge = {true, true, true, true, true};
        this.setIC(emerge);
        this.setPlayer(4, 4);
        this.setWall();
        this.add(b);
        this.setSize(720, 600);
        this.setVisible(true);
    }

    public void setFinish() {
        Component finish = new Finish(4, 0);
        b.setFinish(finish);
    }

    public void setBarrier(boolean appears) {
        Component barrier;
        if (appears == true) {
            barrier = new Barrier(4, 1);
        } else {
            barrier = new Barrier(-2, -2);
        }
        b.setBarrier(barrier);
    }

   // public void setHint() {
      //  Component hint = new Component(4, 3, Color.YELLOW);
      //  b.setHint(hint);
   // }

    public void setPlayer(int x, int y) {
        Component player = new Chip(x, y);
        b.setPlayer(player);
    }

    /**public void setWaterBoots(boolean emerge, boolean die)
    {
        //Component waterBoots;
        //if(emerge == true)
        //{
        //    waterBoots = new Component(0, 0, Color.blue);
        //}
        //else
        //{
        //    waterBoots = new Component(-5, -5, Color.blue);
        //    die = false;
        //}
        //b.setWaterBoots(waterBoots);
    }
    */
    /**public void setFireBoots(boolean emerge, boolean die)
    {
        Component fireBoots;
        //if(emerge == true)
        //{
        //    fireBoots = new Component(3, 8, Color.red);
        //}
        //else
        //{
        //    fireBoots = new Component(-3, -3, Color.red);
        //    die = false;
        //}
        //b.setFireBoots(fireBoots);
    }
    * */
    
    public void setIC(boolean[] emerge) {
        IC[] IC = new IC[5];
        if (emerge[0] == true) {
            IC[0] = new IC(1, 0);
        } else {
            IC[0] = new IC(-2, -2);
        }
        if (emerge[1] == true) {
            IC[1] = new IC(7, 0);

        } else {
            IC[1] = new IC(-2, -2);
        }
        if (emerge[2] == true) {
            IC[2] = new IC(2, 4);
        } else {
            IC[2] = new IC(-2, -2);
        }
        if (emerge[3] == true) {
            IC[3] = new IC(4, 6);
        } else {
            IC[3] = new IC(-2, -2);
        }
        if (emerge[4] == true) {
            IC[4] = new IC(6, 4);
        } else {
            IC[4] = new IC(-2, -2);
        }
        b.setIC(IC);
    }

    public void setFire() {
        Fire[] fire = new Fire[7];
        fire[0] = new Fire(3, 2);
        fire[1] = new Fire(4, 2);
        fire[2] = new Fire(2, 2);
        fire[3] = new Fire(1, 2);
        fire[4] = new Fire(0, 2);
        fire[5] = new Fire(2, 1);
        fire[6] = new Fire(2, 0);
        b.setFire(fire);
    }

    public void setWater()
    {
        Water[] water = new Water[7];
        water[0] = new Water(6, 0);
        water[1] = new Water(6, 1);
        water[2] = new Water(6, 2);
        water[3] = new Water(7, 2);
        water[4] = new Water(8, 2);
        water[5] = new Water(8, 3);
        water[6] = new Water(5, 2);
        b.setWater(water);
    }
    public void setWall() {
        Wall[] wall = new Wall[26];
        wall[0] = new Wall(3, 0);
        wall[1] = new Wall(5, 0);
        wall[2] = new Wall(0, 1);
        wall[3] = new Wall(0, 4);
        wall[4] = new Wall(0, 7);
        wall[5] = new Wall(1, 1);
        wall[6] = new Wall(3, 1);
        wall[7] = new Wall(5, 1);
        wall[8] = new Wall(7, 1);
        wall[9] = new Wall(8, 1);
        wall[10] = new Wall(1, 3);
        wall[11] = new Wall(7, 3);
        wall[12] = new Wall(1, 4);
        wall[13] = new Wall(7, 4);
        wall[14] = new Wall(8, 4);
        wall[15] = new Wall(1, 5);
        wall[16] = new Wall(7, 5);
        wall[17] = new Wall(1, 7);
        wall[18] = new Wall(2, 7);
        wall[19] = new Wall(4, 7);
        wall[20] = new Wall(5, 7);
        wall[21] = new Wall(7, 7);
        wall[22] = new Wall(8, 7);
        wall[23] = new Wall(1, 8);
        wall[24] = new Wall(4, 8);
        wall[25] = new Wall(7, 8);
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

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(601, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jButton1)
                .addContainerGap(465, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int x = b.player.getX();
        int y = b.player.getY();
        this.setPlayer(x + 1, y);
        this.setBarrier(false);
        this.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

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
@Override
    public void actionPerformed(ActionEvent e) {

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
