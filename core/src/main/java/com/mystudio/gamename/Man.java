package com.mystudio.gamename;

import org.mini2Dx.core.engine.geom.CollisionPoint;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.Sprite;

import java.awt.*;

public class Man extends Rectangle {
    private boolean Left_Pressed;
    private boolean Right_Pressed;
    private boolean Up_Pressed;
    private boolean Down_Pressed;
    private CollisionPoint point;
    private  Sprite sprite;

    public Man(Sprite sprite){
        point = new CollisionPoint();
        this.sprite = sprite;
        point.set(500,0);
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

    public void manMove(){
        if(Left_Pressed){
            point.set(point.getX() - 5f, point.getY());
        }
        if(!Left_Pressed) {
            point.set(point.getX() , point.getY());
        }
        if(Right_Pressed){
            point.set(point.getX() + 5f, point.getY());
        }
        if(!Right_Pressed){
            point.set(point.getX() , point.getY());
        }
        if(Up_Pressed){
            point.set(point.getX() , point.getY() - 5f);
        }
        if(!Up_Pressed){
            point.set(point.getX() , point.getY());
        }
        if(Down_Pressed){
            point.set(point.getX() , point.getY() + 5f);
        }
        if(!Down_Pressed){
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
