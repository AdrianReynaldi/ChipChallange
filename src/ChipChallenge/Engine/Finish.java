/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChipChallenge.Engine;

import java.awt.Color;

/**
 * Jalan keluar dalam permainan chip challenge
 * @author Adrian Reynaldi(2013730058)
 * @author Enricofindley  (2013730008)
 * @author Yohanes Ediwan (2013730044)
 */
public class Finish extends Component{

    public Finish(int x, int y, Color warna) {
        super(x, y, warna);
    }
    
    public boolean chk(Chip player)
    {
        boolean win  = false;
        if((player.getX()==this.getX())&&(player.getY()== this.getY()))
        {
            win = true;
        }
        return win;
    }
}
