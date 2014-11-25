/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LevelDesigner;

import Component.Barrier;
import Component.Chip;
import Component.Component;
import Component.Finish;
import Component.Fire;
import Component.FireBoot;
import Component.Hint;
import Component.IC;
import Component.Wall;
import Component.Water;
import Component.WaterBoot;

/**
 *
 * @author Adrian
 */
public class Level1 extends Board{
    private Board b;
    
    public Level1(int panjang,int lebar){
        super(panjang,lebar);
        this.fire = new Component[7];
        this.water = new Component[7];
        this.wall = new Component[26];
    }
    
    /**
     * Setter method untuk jalan keluar dalam permainan di GUI
     */
    @Override
    public void setFinish() {
        this.finish = new Finish(4, 0);
    }

    /**
     * Setter method untuk bantuan menyelesaikan permainan di GUI
     */
    @Override
    public void setHint() {
        this.hint = new Hint(0, 5);
    }

    /**
     * Setter method untuk penghalang permainan di GUI
     * @param appears
     */
    @Override
    public void setBarrier(boolean appears) {
       
        if (appears == true) {
            this.barrier = new Barrier(4, 1);
        } else {
            this.barrier = new Barrier(-2, -2);
        }
    }

    /**
     * Setter method untuk sepatu yang membuat pemain dapat melintasi air di GUI
     */
    @Override
    public void setWaterBoots(boolean emerge, boolean die) {
        if (emerge == true) {
            this.waterBoots = new WaterBoot(0, 3);
        } else {
            this.waterBoots = new WaterBoot(-5, -5);
            die = false;
        }
    }

    /**
     * Setter method untuk sepatu yang membuat pemain dapat melintasi api di GUI
     */
    @Override
    public void setFireBoots(boolean emerge, boolean die) {
        if (emerge == true) {
            this.fireBoots = new FireBoot(3, 8);
        } else {
            this.fireBoots = new FireBoot(-3, -3);
            die = false;
        }
    }

    /**
     * Setter method untuk ic dalam permainan di GUI
     */
    @Override
    public void setIC(boolean[] emerge) {
        this.IC = new Component[5];
        if (emerge[0] == true) {
            IC[0] = new IC(1, 0);
        } else {
            IC[0] = new IC(-2, -2);
        }
        if (emerge[1] == true) {
            IC[1] = new IC(7, 0);

        } else {
            IC[1] = new IC(-2, -2);
        }
        if (emerge[2] == true) {
            IC[2] = new IC(2, 4);
        } else {
            IC[2] = new IC(-2, -2);
        }
        if (emerge[3] == true) {
            IC[3] = new IC(4, 6);
        } else {
            IC[3] = new IC(-2, -2);
        }
        if (emerge[4] == true) {
            IC[4] = new IC(6, 4);
        } else {
            IC[4] = new IC(-2, -2);
        }
    }

    /**
     * Setter method untuk api dalam permainan pada GUI
     */
    @Override
    public void setFire() {
        this.fire[0] = new Fire(3, 2);
        this.fire[1] = new Fire(4, 2);
        this.fire[2] = new Fire(2, 2);
        this.fire[3] = new Fire(1, 2);
        this.fire[4] = new Fire(0, 2);
        this.fire[5] = new Fire(2, 1);
        this.fire[6] = new Fire(2, 0);
    }

    /**
     * Setter method untuk air dalam permainan pada GUI
     */
    @Override
    public void setWater() {
        this.water[0] = new Water(6, 0);
        this.water[1] = new Water(6, 1);
        this.water[2] = new Water(6, 2);
        this.water[3] = new Water(7, 2);
        this.water[4] = new Water(8, 2);
        this.water[5] = new Water(8, 3);
        this.water[6] = new Water(5, 2);
    }

    /**
     * Setter method untuk penghalang pemain di permainan pada GUI
     */
    @Override
    public void setWall() {
        wall[0] = new Wall(3, 0);
        wall[1] = new Wall(5, 0);
        wall[2] = new Wall(0, 1);
        wall[3] = new Wall(0, 4);
        wall[4] = new Wall(0, 7);
        wall[5] = new Wall(1, 1);
        wall[6] = new Wall(3, 1);
        wall[7] = new Wall(5, 1);
        wall[8] = new Wall(7, 1);
        wall[9] = new Wall(8, 1);
        wall[10] = new Wall(1, 3);
        wall[11] = new Wall(7, 3);
        wall[12] = new Wall(1, 4);
        wall[13] = new Wall(7, 4);
        wall[14] = new Wall(8, 4);
        wall[15] = new Wall(1, 5);
        wall[16] = new Wall(7, 5);
        wall[17] = new Wall(1, 7);
        wall[18] = new Wall(2, 7);
        wall[19] = new Wall(4, 7);
        wall[20] = new Wall(5, 7);
        wall[21] = new Wall(7, 7);
        wall[22] = new Wall(8, 7);
        wall[23] = new Wall(1, 8);
        wall[24] = new Wall(4, 8);
        wall[25] = new Wall(7, 8);
    }

    @Override
    public void setPlayer(Chip player) {
        this.player=player;
    }
}
