/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Engine;

import java.awt.Color;

/**
 * Kelas yang menggambarkan Chip yaitu pemain dalam sebuah game Chip Challenge
 * @author Adrian Reynaldi(2013730058)
 * @author Enricofindley  (2013730008)
 * @author Yohanes Ediwan (2013730044)
 */
public class Chip extends Component {

    /**
     * Constructor yang menginisialisasi parameter yang dimiliki oleh super class
     * @param x nilai x
     * @param y nilai y
     * @param warna warna dari chip
     */
    public Chip(int x, int y, Color warna) {
        super(x, y, warna);
    }
 
}
