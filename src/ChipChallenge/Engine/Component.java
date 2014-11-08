/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChipChallenge.Engine;

import java.awt.Color;

/**
 * Kelas yang merepresentasikan objek yang ada dalam game Chip Challenge
 * @author Adrian Reynaldi(2013730058)
 * @author Enricofindley  (2013730008)
 * @author Yohanes Ediwan (2013730044)
 */
public class Component 
{
    /**
     * Posisi absis objek 
     */
    private int x;
    
    /**
     * Posisi ordinat objek
     */
    private int y;
    
    /**
     * Warna objek
     */
    private Color warna;

    /**
     * Constructor yang menginisialisasi semua atribut kelas ini
     * @param x posisi absis objek 
     * @param y posisi ordinat objek
     * @param warna warna objek
     */
    public Component(int x, int y, Color warna) {
        this.x = x;
        this.y = y;
        this.warna = warna;
    }

    /**
     * Getter method untuk mendapatkan nilai x dari koordinat objek
     * @return  nilai x
     */
    public int getX() {
        return x;
    }

    /**
     * Setter method untuk mengeset nilai x ke koordinat objek
     * @param x nilai x
     */
    public void setX(int x) {
        this.x = x;
    }

     /**
     * Getter method untuk mendapatkan nilai y dari koordinat objek
     * @return  nilai y
     */
    public int getY() {
        return y;
    }

    /**
     * Setter method untuk mengeset nilai x ke koordinat objek
     * @param y nilai y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Getter method untuk mendapatkan warna dari objek
     * @return warna dari objek
     */
    public Color getWarna() {
        return warna;
    }

    /**
     * Setter method untuk mengeset warna suatu objek
     * @param warna warna objek
     */
    public void setWarna(Color warna) {
        this.warna = warna;
    }
}
