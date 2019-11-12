package com.mystudio.gamename;

import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.Sprite;

import java.awt.*;


public class Floor extends GameObject {
    private CollisionBox collisionBox;
    private  Sprite sprite;
    private int objectIndex = 1; //floor = 1 , ladder = 2

    /**
     * @param sprite
     * @param x
     * @param y
     * @param width
     * @param height
     * create floors
     * set sprite's size, collisionBox's size and position.
     */
    public Floor(Sprite sprite, float x, float y, float width, float height){
        collisionBox = new CollisionBox(x,y,width,height);
        this.sprite = sprite;
        this.sprite.setSize(width,height);
    }

    /**
     * getter
     */
    public CollisionBox getCollisionBox() { return collisionBox; }
    public int getObjectIndex() { return objectIndex; }


    public void update() {
        collisionBox.preUpdate();
    }
    public void interpolate(float alpha) {
        collisionBox.interpolate(null, alpha);
    }
    public void render(Graphics g){
        g.drawSprite(sprite, collisionBox.getX(), collisionBox.getY());
    }
}
