/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Chip;
import Model.Finish;
import Model.Fire;
import Model.Hint;
import Model.WaterBoot;
import Model.Barrier;
import Model.IC;
import Model.Water;
import Model.FireBoot;
import Model.Wall;
import Engine.*;
import Model.Component;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Win8
 */
public class ChipGUI extends javax.swing.JFrame {

    private Board b;
    public Component[] fire = new Component[7];
    public Component[] water = new Component[7];
    public Component[] wall = new Component[26];
    JFrame conditionFrame;
    public Chip player;
    public Component fireBoots, waterBoots;

    /**
     * Creates new form ChipGUI
     */
    public ChipGUI() {
        initComponents();
        nameLabel.setText("Hello, " + JOptionPane.showInputDialog(rootPane, "Enter Your Name", "Start Game", 0));
        setBoard();
        this.repaint();
        this.player=new Chip(4, 4, Color.white, b, this);
        addKeyListener(player);
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
        this.setHint();
        this.setWaterBoots(true, true);
        this.setFireBoots(true, true);
        this.setFire();
        this.setWater();
        boolean[] emerge = {true, true, true, true, true};
        this.setIC(emerge);
        this.setWall();
        this.add(b);
        this.setSize(720, 600);
        this.setVisible(true);
    }

    public void setFinish() {
        Component finish = new Finish(4, 0);
        b.setFinish(finish);
    }

    private void setHint() {
        Component hint = new Hint(4, 3);
        b.setHint(hint);
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

    

    public void setWaterBoots(boolean emerge, boolean die) {
        if (emerge == true) {
            waterBoots = new WaterBoot(0, 0);
        } else {
            waterBoots = new WaterBoot(-5, -5);
            die = false;
        }
        b.setWaterBoots(waterBoots);
    }

    public void setFireBoots(boolean emerge, boolean die) {
        if (emerge == true) {
            fireBoots = new FireBoot(3, 8);
        } else {
            fireBoots = new FireBoot(-3, -3);
            die = false;
        }
        b.setFireBoots(fireBoots);
    }

    public void setIC(boolean[] emerge) {
        Component[] IC = new Component[5];
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
        fire[0] = new Fire(3, 2);
        fire[1] = new Fire(4, 2);
        fire[2] = new Fire(2, 2);
        fire[3] = new Fire(1, 2);
        fire[4] = new Fire(0, 2);
        fire[5] = new Fire(2, 1);
        fire[6] = new Fire(2, 0);
        b.setFire(fire);
    }

    public void setWater() {
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

        nameLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nameLabel.setText("Hello");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(598, Short.MAX_VALUE)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(422, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Method untuk menggerakkan chip
     *
     * @param moveKey
     */
    

    public void createConditionFrame() {
//        conditionFrame = new JFrame("Game Over");
//        conditionFrame.setVisible(true);
//        conditionFrame.setSize(720, 480);
//        conditionFrame.setResizable(false);
//        JLabel labelCondition = new JLabel("You Lose !!");
//        conditionFrame.add(labelCondition);
//        this.setFocusable(false);
//        JButton tryAgain = new JButton("Try Again");
//        conditionFrame.add(tryAgain);
//        tryAgain.setSize(50, 50);
//        this.setVisible(false);
        if (JOptionPane.showOptionDialog(rootPane, "Try Again?", "Game Over", 0, 2, null, null, null) == 1) {
            this.dispose();
        } else {
            this.dispose();
            new ChipGUI().setVisible(true);
        }
    }

    /**
     * Method untuk menggerakkan chip ke atas
     */
    

    

    

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
    private javax.swing.JLabel nameLabel;
    // End of variables declaration//GEN-END:variables
   

}
