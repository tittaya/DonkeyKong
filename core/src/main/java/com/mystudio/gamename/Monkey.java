package com.mystudio.gamename;

import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.Sprite;
import java.awt.*;
import static com.mystudio.gamename.Variable.*;

/**
 * Kong (Player)
 */
public  class Monkey extends Rectangle  {
    private boolean onLadder;
    private boolean onFloor;
    private boolean canJump;
    private boolean A_Pressed;
    private boolean D_Pressed;
    private boolean W_Pressed;
    private boolean S_Pressed;
    public boolean jump = true;
    private float monkeySpeed_X = 10;
    private float monkeySpeed_Y = 5;
    private CollisionBox monkeyBox;
    private  Sprite sprite;

    /**
     *
     * @param sprite
     * create monkey
     * set sprite's size, collisionBox's size and position.
     */
    public Monkey(Sprite sprite){
        monkeyBox = new CollisionBox(0,0,200,200);
        this.sprite = sprite;
        this.sprite.setSize(200,200);
    }

    /**
     * Getter
     */
    public CollisionBox getMonkeyBox() {
        return monkeyBox;
    }


    /**
     * Setter
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

    public void setCanJump(boolean t) { canJump = t; }

    public void monkeyFall(){
        if(!onFloor){
            monkeyBox.set(monkeyBox.getX(),monkeyBox.getY() + GRAVITY *1f);
        }
    }

    /**
     * Control Player's movement.
     * if player doesn't stand on floor, player will fall down to the ground.
     */
    public void monkeyMove(){
        float x_box = monkeyBox.getX();
        float y_box = monkeyBox.getY();
//        float x_sprite = sprite.getX();
//        float y_sprite = sprite.getY();

        if (onFloor && A_Pressed) {
//            sprite.setPosition(x_sprite -= monkeySpeed_X, sprite.getY());
            monkeyBox.setX(x_box -= monkeySpeed_X);
        }
        if (onFloor && !A_Pressed) {
//            sprite.setPosition(sprite.getX(), sprite.getY());
            monkeyBox.set(monkeyBox.getX(), monkeyBox.getY());
        }
        if (onFloor && D_Pressed) {
//            sprite.setPosition(x_sprite += monkeySpeed_X, sprite.getY());
            monkeyBox.setX(x_box += monkeySpeed_X);
        }
        if (onFloor && !D_Pressed) {
//            sprite.setPosition(sprite.getX() , sprite.getY());
            monkeyBox.set(monkeyBox.getX(), monkeyBox.getY());
        }
        if (onFloor && W_Pressed){
            for(int i=0; i<15 ; i++) {
//                sprite.setPosition(sprite.getX() , y_sprite -= monkeySpeed_Y);
                monkeyBox.set(monkeyBox.getX(), y_box -= monkeySpeed_Y);
            }
        }
        if (onFloor && W_Pressed && D_Pressed){
            jump = false;
            for(int i=0; i<10 ; i++){
                System.out.println("in loop jump up");
//                sprite.setPosition(x_sprite += monkeySpeed_X, y_sprite -= monkeySpeed_Y);
                monkeyBox.set(x_box += monkeySpeed_X, y_box -= monkeySpeed_Y);
                System.out.println(monkeyBox.getX()+" "+monkeyBox.getY());
            }
                W_Pressed = false;
                D_Pressed = false;
                for(int j=0; j<10 ; j++){
                    float newX_box = monkeyBox.getX();
                    float newY_box = monkeyBox.getY();
//                    float newX_sprite = sprite.getX();
//                    float newY_sprite = sprite.getY();
                    System.out.println("in loop jump down");
//                    sprite.setPosition(x_sprite += monkeySpeed_X, y_sprite += monkeySpeed_Y);
                    monkeyBox.set( newX_box += monkeySpeed_X, newY_box += monkeySpeed_Y);
                    System.out.println(monkeyBox.getX()+" "+monkeyBox.getY());
                }

            }




            if (W_Pressed && A_Pressed){
                //for(int i=0; i<10 ; i++) {
                    //monkeyBox.set(x -= monkeySpeed_X, y -= monkeySpeed_Y);
                //}
//                this.setOnFloor(false);

            }
            if(!W_Pressed){
                monkeyBox.set(monkeyBox.getX() , monkeyBox.getY());
            }
            if(S_Pressed){
                monkeyBox.set(monkeyBox.getX() , monkeyBox.getY());
            }
            if(!S_Pressed){
                monkeyBox.set(monkeyBox.getX() , monkeyBox.getY());
            }

        if(!onFloor){
            monkeyBox.set(monkeyBox.getX(),monkeyBox.getY() + GRAVITY *1f);
            System.out.println(monkeyBox.getX()+" "+monkeyBox.getY());
        }

    }


    public void update() {
        monkeyBox.preUpdate();
    }

    public void interpolate(float alpha) {
        monkeyBox.interpolate(null, alpha);

    }

    public void render(Graphics g) {
        g.drawSprite(sprite, monkeyBox.getRenderX(), monkeyBox.getRenderY());
    }


}
