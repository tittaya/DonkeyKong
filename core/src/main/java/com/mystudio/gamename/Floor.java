package com.mystudio.gamename;

import org.mini2Dx.core.engine.geom.CollisionPoint;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.Sprite;

import java.awt.*;


public class Floor extends Rectangle {
    private CollisionPoint point;
    private  Sprite sprite;


    public Floor(Sprite sprite,float x,float y){
        point = new CollisionPoint();
        this.sprite = sprite;
        point.set(x,y);

    }

    public void update() {
        point.preUpdate();
    }

    public void interpolate(float alpha) {
        point.interpolate(null, alpha);

    }
    public void render(Graphics g){
        g.drawSprite(sprite,point.getX(),point.getY());
    }
}
