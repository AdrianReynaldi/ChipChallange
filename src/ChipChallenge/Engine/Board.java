/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChipChallenge.Engine;

/**
 *
 * @author Win8
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Board extends JPanel {

    public int panjang;
    public int lebar;
    public Component finish;
    public Component barrier;
    public Component hint;
    public Component player;
    public Component[] IC;
    public Component[] fire;
    public Component[] wall;

    public Board(int panjang, int lebar, Component finish, Component barrier, Component hint, Component player, Component[] IC, Component[] fire, Component[] wall) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.finish = finish;
        this.barrier = barrier;
        this.hint = hint;
        this.player = player;
        this.IC = IC;
        this.fire = fire;
        this.wall = wall;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < panjang; i++) {
            for (int j = 0; j < lebar; j++) {
                g2d.drawRoundRect(i * 50, j * 50, 50, 50, 10, 10);
            }
        }
        this.draw(g, finish);
        this.draw(g, barrier);
        this.draw(g, hint);
        this.draw(g, player);
        for (int i = 0; i < IC.length; i++) {
            this.draw(g, IC[i]);
        }
        for (int i = 0; i < fire.length; i++) {
            this.draw(g, fire[i]);
        }
        for (int i = 0; i < wall.length; i++) {
            this.draw(g, wall[i]);
        }
    }

    public void draw(Graphics g, Component component) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(component.getWarna());
        g2d.fillRect(component.getX() * 50, component.getY() * 50, 50, 50);
    }
}
