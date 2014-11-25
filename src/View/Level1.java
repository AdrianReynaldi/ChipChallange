/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Board;
import Model.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * GUI permainan chip challenge
 * @author Adrian Reynaldi(2013730058)
 * @author Enricofindley  (2013730008)
 * @author Yohanes Ediwan (2013730044)
 */
public class Level1 extends javax.swing.JFrame implements Level {

    private Board b;
    public Fire[] fire = new Fire[7];
    public Water[] water = new Water[7];
    public Wall[] wall = new Wall[26];
    public JFrame conditionFrame;
    public Chip player;
    public Finish finish;
    public FireBoot fireBoots;
    public WaterBoot waterBoots;
    public Hint Hint;
    public Barrier barrier;;
    public boolean[] emerge = {true, true, true, true, true};
    public IC[] IC;
    public boolean finished = true;

    /**
     * Creates new form ChipGUI
     */
    public Level1() {
        initComponents();
        setBoard();
        this.repaint();
        this.player=new Chip(4, 4, b, this);
        addKeyListener(player);
        this.setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.setVisible(false);
    }
    /**
    * Override method paint milik JFrame
    * @param g graphic program
    */
    @Override
    public void paint(Graphics g) {
        b.paint(g);
    }

    /**
     * Method untuk memunculkan bantuan untuk menyelesaikan permainan
     * @param show penanda apakah hint harus muncul atau tidak
     */
    public void showHint(boolean show)
    {
        if(show == true)
        {
            JOptionPane.showMessageDialog(rootPane, "1.Take the fire boots to go through to the flames \n2.Take the water boots to go through to the water \n3.Collect all the IC to break the barrier ", "Hint", 0);
        }
        else
        {
            
        }

    }
    
    /**
     * Setter method untuk papan permainan pada GUI
     */
    @Override
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
        this.setIC(emerge);
        this.setWall();
        this.add(b);
        this.setSize(720, 600);
    }

    /**
     * Setter method untuk jalan keluar dalam permainan di GUI
     */
    @Override
    public void setFinish() {
        finish = new Finish(4, 0);
        b.setFinish(finish);
    }

    /**
     * Setter method untuk bantuan menyelesaikan permainan di GUI
     */
    @Override
    public void setHint() {
        Hint = new Hint(0, 5);
        b.setHint(Hint);
    }

    /**
     * Setter method untuk penghalang permainan di GUI
     * @param appears
     */
    @Override
    public void setBarrier(boolean appears) {
        if (appears == true) {
            barrier = new Barrier(4, 1);
        } else {
            barrier = new Barrier(-2, -2);
        }
        b.setBarrier(barrier);
    }

    /**
     * Setter method untuk sepatu yang membuat pemain dapat melintasi air di GUI
     * @param emerge
     * @param die
     */
    @Override
    public void setWaterBoots(boolean emerge,boolean die) {
        if (emerge == true) {
            waterBoots = new WaterBoot(0, 3);
        } else {
            waterBoots = new WaterBoot(-5, -5);
            die = false;
        }
        b.setWaterBoots(waterBoots);
    }

    /**
     * Setter method untuk sepatu yang membuat pemain dapat melintasi api di GUI
     * @param emerge
     * @param die
     */
    public void setFireBoots(boolean emerge, boolean die) {
        if (emerge == true) {
            fireBoots = new FireBoot(3, 8);
        } else {
            fireBoots = new FireBoot(-3, -3);
            die = false;
        }
        b.setFireBoots(fireBoots);
    }

    /**
     * Setter method untuk ic dalam permainan di GUI
     * @param emerge
     */
    @Override
    public void setIC(boolean[] emerge) {
        IC = new IC[5];
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

    /**
     * Setter method untuk api dalam permainan pada GUI
     */
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

    /**
     * Setter method untuk air dalam permainan pada GUI
     */
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

    /**
     * Setter method untuk penghalang pemain di permainan pada GUI
     */
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 749, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String[] args)
    {
        new Level1().setVisible(true);
    }
    /**
     * Method untuk membuat popup window jika game selesai
     * @param isWin penanda apakah player menang atau kalah
     */
    public void createConditionFrame(boolean isWin) {
        if(isWin == true)
        {
            if (JOptionPane.showOptionDialog(rootPane, "Congratulations !! You Won!! \n Wanna Play Again ?", "Game Over", 0, 2, null, null, null) == 1) {
                this.dispose();
            } 
            else 
            {
                this.dispose();
                new Level1().setVisible(true);
            }
        }
        else
        {
            if (JOptionPane.showOptionDialog(rootPane, "Try Again?", "Game Over", 0, 2, null, null, null) == 1) {
                this.dispose();
            } 
            else {
                this.dispose();
                new Level1().setVisible(true);
            }
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
   

}
