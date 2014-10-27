/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChipChallenge.Engine;

import java.awt.Color;

/**
 *
 * @author Win8
 */
public class Component 
{
    private int x;
    private int y;
    private Color warna;

    public Component(int x, int y, Color warna) {
        this.x = x;
        this.y = y;
        this.warna = warna;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getWarna() {
        return warna;
    }

    public void setWarna(Color warna) {
        this.warna = warna;
    }
}
