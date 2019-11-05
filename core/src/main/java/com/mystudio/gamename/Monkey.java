package com.mystudio.gamename;

import org.mini2Dx.core.engine.geom.CollisionPoint;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.Sprite;

import java.awt.*;

import static com.mystudio.gamename.Variable.GRAVITY;

/**
 * Kong (Player)
 */
public  class Monkey extends Rectangle {
    private boolean onLadder;
    private boolean onFloor;
    private boolean A_Pressed;
    private boolean D_Pressed;
    private boolean W_Pressed;
    private boolean S_Pressed;
    private int monkeySpeed_X = 10;
    private int monkeySpeed_Y = 3;
    private CollisionPoint point;
    private  Sprite sprite;

    /**
     *
     * @param sprite
     */
    public Monkey(Sprite sprite){
        point = new CollisionPoint();
        this.sprite = sprite;
        point.set(0,0);
    }

    /**
     *
     * @param t the element to be insert
     */
    public void setA_Pressed(boolean t) {
        A_Pressed = t;
    }

    public void setD_Pressed(boolean t) {
        D_Pressed = t;
    }

    public void setW_Pressed(boolean t) {
        W_Pressed = t;
    }

    public void setS_Pressed(boolean t) {
        S_Pressed = t;
    }

    public void setOnFloor(boolean t){
        onFloor = t;
    }

    public void setOnLadder(boolean t) {
        onLadder = t;
    }

    /**
     * Control Player's movement.
     * if player doesn't stand on floor, player will fall down to the ground.
     */
    public void monkeyMove(){
//        point.set(point.getX(),point.getY() + GRAVITY *1f);
        if(A_Pressed){
            point.set(point.getX() - monkeySpeed_X *1f, point.getY());
        }
        if(!A_Pressed) {
            point.set(point.getX() , point.getY());
        }
        if(D_Pressed){
            point.set(point.getX() + monkeySpeed_X *1f, point.getY());
        }
        if(!D_Pressed){
            point.set(point.getX() , point.getY());
        }
        if(W_Pressed && D_Pressed){
            point.set(point.getX() + monkeySpeed_X *0.5f, point.getY() - monkeySpeed_Y *1f);
        }
        if(W_Pressed && A_Pressed){
            point.set(point.getX() - monkeySpeed_X *0.5f, point.getY() - monkeySpeed_Y *1f);
        }
        if(!W_Pressed){
            point.set(point.getX() , point.getY());
        }
        if(S_Pressed){
            point.set(point.getX() , point.getY() + monkeySpeed_Y *1f);
        }
        if(!S_Pressed){
            point.set(point.getX() , point.getY());
        }
    }


    public void update() {
        point.preUpdate();
    }

    public void interpolate(float alpha) {
        point.interpolate(null, alpha);

    }

    public void render(Graphics g) {
        g.drawSprite(sprite, point.getRenderX(), point.getRenderY());
    }


}
