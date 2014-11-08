/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChipChallenge.Engine;

import java.awt.Color;

/**
 * Pembunuh chip jika chip menginjak fire
 * @author Adrian Reynaldi(2013730058)
 * @author Enricofindley  (2013730008)
 * @author Yohanes Ediwan (2013730044)
 */
public class Fire extends Component {

    public Fire(int x, int y, Color warna) {
        super(x, y, warna);
    }
    
    public boolean chk(Chip player)
    {
        boolean lose  = false;
        if((player.getX()==this.getX())&&(player.getY()== this.getY()))
        {
            lose = true;
        }
        return lose;
    }
}
