/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChipChallenge.Engine;

import java.awt.Color;

/**
 * Penghalang chip sebelum masuk ke finish
 * @author Adrian Reynaldi(2013730058)
 * @author Enricofindley  (2013730008)
 * @author Yohanes Ediwan (2013730044)
 */
public class Barrier extends Component {

    public Barrier(int x, int y, Color warna) {
        super(x, y, warna);
    }
    
    public boolean breakBarrier(Component[] ic)
    {
        boolean breakBarrier = false;
        if(ic.length == 0)
        {
            breakBarrier = true;
        }
        return breakBarrier;
    }
}
