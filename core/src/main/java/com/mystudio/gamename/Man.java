package com.mystudio.gamename;

import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.Sprite;
import java.awt.*;
import static com.mystudio.gamename.Variable.*;

public class Man extends Rectangle {
    private boolean onLadder;
    private boolean onFloor;
    private boolean canJump;
    public boolean jump = true;
    private boolean Left_Pressed;
    private boolean Right_Pressed;
    private boolean Up_Pressed;
    private boolean Down_Pressed;
    private float manSpeed_X = 500;
    private float manSpeed_Y = 250;
    private CollisionBox manBox;
    private  Sprite sprite;

    /**
     *
     * @param sprite
     * create man
     * set sprite's size, collisionBox's size and position.
     */
    public Man(Sprite sprite){
        manBox = new CollisionBox(500,600,80,150);
        this.sprite = sprite;
        this.sprite.setSize(80,150);
    }

    /**
     * Getter
     */
    public CollisionBox getManBox() { return manBox; }

    /**
     * Setter
     */
    public void setLeft_Pressed(boolean t){ Left_Pressed = t; }

    public void setRight_Pressed(boolean t) { Right_Pressed = t; }

    public void setUp_Pressed(boolean t) { Up_Pressed = t; }

    public void setDown_Pressed(boolean t) { Down_Pressed = t; }

    public void setOnFloor(boolean t) { this.onFloor = t; }

    public void setOnLadder(boolean t) { this.onLadder = t; }

    public void setCanJump(boolean t) { canJump = t; }

    /**
     * Control Player's movement.
     * if player doesn't stand on floor, player will fall down to the ground.
     */
    public void manMove(float delta){
        float x_box = manBox.getX();
        float y_box = manBox.getY();
        float oldY = manBox.getY();
        if (onFloor && Left_Pressed) {

            manBox.setX(x_box -= manSpeed_X*delta);
        }
        /*if (onFloor && !A_Pressed) {

            monkeyBox.set(monkeyBox.getX(), monkeyBox.getY());
        }*/
        if (onFloor && Right_Pressed) {

            manBox.setX(x_box += manSpeed_X*delta);
        }
        /*if (onFloor && !D_Pressed) {

            monkeyBox.set(monkeyBox.getX(), monkeyBox.getY());
        }*/
        if (onFloor && Up_Pressed){
            for(int i=0; i<15  ; i++) {
                manBox.set(manBox.getX(), y_box -= manSpeed_Y*delta);
            }
        }

        if (onFloor && Up_Pressed && Right_Pressed){
            System.out.println(oldY);
            jump = false;
            for (int i = 0; i < 10; i++) {
                System.out.println("in loop jump up");
                manBox.set(x_box += manSpeed_X * delta, y_box -= manSpeed_Y * delta);
                System.out.println("jump up" + manBox.getX() + " " + manBox.getY());
            }
            Up_Pressed = false;
            Right_Pressed = false;
            float newX_box = manBox.getX();
            float newY_box = manBox.getY();


            while (newY_box!=oldY) {
                System.out.println("in loop jump down");
                newX_box += manSpeed_X * delta;
                newY_box += manSpeed_Y * delta;
                manBox.set(newX_box,newY_box);
                System.out.println("jump down" + manBox.getX() + " " + manBox.getY());
            }
            jump = true;
        }


        if (Up_Pressed && Left_Pressed){
            jump = false;
            for (int i = 0; i < 10; i++) {
                System.out.println("in loop jump up");
                manBox.set(x_box -= manSpeed_X * delta, y_box -= manSpeed_Y * delta);
                System.out.println("jump up" + manBox.getX() + " " + manBox.getY());
            }
            Up_Pressed = false;
            Right_Pressed = false;
            float newX_box = manBox.getX();
            float newY_box = manBox.getY();


            while (newY_box!=oldY) {
                System.out.println("in loop jump down");
                newX_box -= manSpeed_X * delta;
                newY_box += manSpeed_Y * delta;
                manBox.set(newX_box,newY_box);
                System.out.println("jump down" + manBox.getX() + " " + manBox.getY());
            }
            jump = true;

        }
            /*if(!W_Pressed){
                monkeyBox.set(monkeyBox.getX() , monkeyBox.getY());
            }*/
        if(Down_Pressed){
            manBox.set(manBox.getX() , manBox.getY());
        }
        if(!Down_Pressed){
            manBox.set(manBox.getX() , manBox.getY());
        }

        if(!onFloor){
            manBox.set(manBox.getX(),manBox.getY() + ((manSpeed_Y*delta) + ((5/10)*GRAVITY*(delta*delta))));
            System.out.println(manBox.getX()+" "+manBox.getY());
        }
    }

    public void update() {
        manBox.preUpdate();
    }

    public void interpolate(float alpha) {
        manBox.interpolate(null, alpha);

    }

    public void render(Graphics g) {
        g.drawSprite(sprite, manBox.getRenderX(), manBox.getRenderY());
    }


}
