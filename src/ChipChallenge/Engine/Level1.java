/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChipChallenge.Engine;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Win8
 */
public class Level1 {

    public static void main(String args[]) {
        JFrame frame = new JFrame("Board");
        Component finish = new Component(4, 0, Color.blue);
        Component barrier = new Component(4, 1, Color.MAGENTA);
        Component hint = new Component(4, 3, Color.YELLOW);
        Component player = new Component(4, 4, Color.GREEN);
        Component[] IC = new Component[5];
        Component[] fire = new Component[2];
        Component[] wall = new Component[26];
        IC[0] = new Component(1, 0, Color.GRAY);
        IC[1] = new Component(7, 0, Color.GRAY);
        IC[2] = new Component(2, 4, Color.GRAY);
        IC[3] = new Component(4, 6, Color.GRAY);
        IC[4] = new Component(6, 4, Color.GRAY);
        fire[0] = new Component(3, 2, Color.RED);
        fire[1] = new Component(5, 2, Color.RED);
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
        frame.add(new Board(9, 9, finish, barrier, hint, player, IC, fire, wall));
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
