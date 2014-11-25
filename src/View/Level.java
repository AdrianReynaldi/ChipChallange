/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

/**
 * Kelas Sebagai interface untuk level-level pada permainan
 * @author Adrian Reynaldi(2013730058)
 * @author Enricofindley  (2013730008)
 * @author Yohanes Ediwan (2013730044)
 */
public interface Level {
    public abstract void setBoard();
    public abstract void setFinish();
    public abstract void setHint();
    public abstract void setFire();
    public abstract void setWater();
    public abstract void setBarrier(boolean appears);
    public abstract void setWaterBoots(boolean emerge,boolean die);
    public abstract void setFireBoots (boolean emerge, boolean die);
    public abstract void setIC(boolean[] emerge);
    public abstract void setWall();
    
    
}
