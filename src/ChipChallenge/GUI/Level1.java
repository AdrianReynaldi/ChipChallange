/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChipChallenge.GUI;

import ChipChallenge.Engine.*;
import java.awt.Color;
import javax.swing.JFrame;

/**
 * Kelas yang menggambarkan Level 1 pada permainan Chip Challenge
 * @author Adrian Reynaldi(2013730058)
 * @author Enricofindley  (2013730008)
 * @author Yohanes Ediwan (2013730044)
 */
public class Level1 {

    /**
     * Method untuk memasukkan objek ke dalam board 
     */
    public void executeLv1() {
        JFrame frame = new JFrame("Board");
        Finish finish = new Finish(4, 0, Color.blue);
        Barrier barrier = new Barrier(4, 1, Color.MAGENTA);
        Chip player = new Chip(4, 4, Color.GREEN);
        Component[] ic = new Component[5];
        Fire[] fire = new Fire[2];
        Wall[] wall = new Wall[26];
        ic[0] = new Component(1, 0, Color.GRAY);
        ic[1] = new Component(7, 0, Color.GRAY);
        ic[2] = new Component(2, 4, Color.GRAY);
        ic[3] = new Component(4, 6, Color.GRAY);
        ic[4] = new Component(6, 4, Color.GRAY);
        fire[0] = new Fire(3, 2, Color.RED);
        fire[1] = new Fire(5, 2, Color.RED);
        wall[0] = new Wall(3, 0, Color.DARK_GRAY);
        wall[1] = new Wall(5, 0, Color.DARK_GRAY);
        wall[2] = new Wall(0, 1, Color.DARK_GRAY);
        wall[3] = new Wall(0, 4, Color.DARK_GRAY);
        wall[4] = new Wall(0, 7, Color.DARK_GRAY);
        wall[5] = new Wall(1, 1, Color.DARK_GRAY);
        wall[6] = new Wall(3, 1, Color.DARK_GRAY);
        wall[7] = new Wall(5, 1, Color.DARK_GRAY);
        wall[8] = new Wall(7, 1, Color.DARK_GRAY);
        wall[9] = new Wall(8, 1, Color.DARK_GRAY);
        wall[10] = new Wall(1, 3, Color.DARK_GRAY);
        wall[11] = new Wall(7, 3, Color.DARK_GRAY);
        wall[12] = new Wall(1, 4, Color.DARK_GRAY);
        wall[13] = new Wall(7, 4, Color.DARK_GRAY);
        wall[14] = new Wall(8, 4, Color.DARK_GRAY);
        wall[15] = new Wall(1, 5, Color.DARK_GRAY);
        wall[16] = new Wall(7, 5, Color.DARK_GRAY);
        wall[17] = new Wall(1, 7, Color.DARK_GRAY);
        wall[18] = new Wall(2, 7, Color.DARK_GRAY);
        wall[19] = new Wall(4, 7, Color.DARK_GRAY);
        wall[20] = new Wall(5, 7, Color.DARK_GRAY);
        wall[21] = new Wall(7, 7, Color.DARK_GRAY);
        wall[22] = new Wall(8, 7, Color.DARK_GRAY);
        wall[23] = new Wall(1, 8, Color.DARK_GRAY);
        wall[24] = new Wall(4, 8, Color.DARK_GRAY);
        wall[25] = new Wall(7, 8, Color.DARK_GRAY);
        frame.add(new Board(9, 9, finish, barrier, player, ic, fire, wall));
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
