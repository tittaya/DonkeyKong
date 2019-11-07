package com.mystudio.gamename;

import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.Sprite;
import java.awt.*;
import static com.mystudio.gamename.Variable.*;

public class Man extends Rectangle {
    private boolean onLadder;
    private boolean onFloor;
    private boolean Left_Pressed;
    private boolean Right_Pressed;
    private boolean Up_Pressed;
    private boolean Down_Pressed;
    private float manSpeed_X = 10;
    private float manSpeed_Y = 3;
    private CollisionBox manBox;
    private  Sprite sprite;

    public Man(Sprite sprite){
        manBox = new CollisionBox(500,600,80,150);
        this.sprite = sprite;
        this.sprite.setSize(80,150);
    }

    public CollisionBox getManBox() {
        return manBox;
    }

    public void setLeft_Pressed(boolean t){
        Left_Pressed = t;
    }

    public void setRight_Pressed(boolean t) {
        Right_Pressed = t;
    }

    public void setUp_Pressed(boolean t) {
        Up_Pressed = t;
    }

    public void setDown_Pressed(boolean t) {
        Down_Pressed = t;
    }

    public void setOnFloor(boolean t) {
        this.onFloor = t;
    }

    public void setOnLadder(boolean t) {
        this.onLadder = t;
    }

    public void manMove(){
        if(onFloor) {
            if (Left_Pressed) {
                manBox.set(manBox.getX() - manSpeed_X*1f, manBox.getY());
            }
            if (!Left_Pressed) {
                manBox.set(manBox.getX(), manBox.getY());
            }
            if (Right_Pressed) {
                manBox.set(manBox.getX() + manSpeed_X*1f, manBox.getY());
            }
            if (!Right_Pressed) {
                manBox.set(manBox.getX(), manBox.getY());
            }
        }
        if(!onFloor){
            manBox.set(manBox.getX(), manBox.getY()+ GRAVITY *1f);
        }
//        if(Up_Pressed){
//            manBox.set(manBox.getX() , manBox.getY() - 5f);
//        }
//        if(!Up_Pressed){
//            manBox.set(manBox.getX() , manBox.getY());
//        }
//        if(Down_Pressed){
//            manBox.set(manBox.getX() , manBox.getY() + 5f);
//        }
//        if(!Down_Pressed){
//            manBox.set(manBox.getX() , manBox.getY());
//        }
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
