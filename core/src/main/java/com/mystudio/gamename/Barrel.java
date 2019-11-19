package com.mystudio.gamename;

import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.Sprite;
import org.mini2Dx.core.graphics.Texture;

import java.awt.*;

import static com.mystudio.gamename.Variable.GRAVITY;

public class Barrel extends GameObject {
    private CollisionBox collisionBox;
    private  Sprite sprite;
    private int objectIndex;
    private boolean onFloor;
    private float barrelSpeed_X = 500;
    private float barrelSpeed_Y = 250;


    public Barrel(Sprite sprite, float x, float y, float width, float height){
        collisionBox = new CollisionBox(x,y,width,height);
        this.sprite = sprite;
        this.sprite.setSize(width,height);
    }
    public CollisionBox getCollisionBox() { return collisionBox; }
    public int getObjectIndex() { return objectIndex; }
    public void setOnFloor(boolean t){
        onFloor = t;
    }

    public void barrelMove(float delta){
        float x_box = collisionBox.getX();
        float y_box = collisionBox.getY();
        if (onFloor){
            collisionBox.setX(x_box += barrelSpeed_X*delta);
        }else{
            collisionBox.set(collisionBox.getX(),collisionBox.getY() + ((barrelSpeed_Y*delta) + ((5/10)*GRAVITY*(delta*delta))));
        }
    }

    public void update() {
        collisionBox.preUpdate();
    }
    public void interpolate(float alpha) {
        collisionBox.interpolate(null, alpha);
    }
    public void render(Graphics g){
        g.drawSprite(sprite, collisionBox.getX(), collisionBox.getY());
    }
//    public int getX()
//    {
//        return x;
//    }
//    public int getY()
//    {
//        return y;
//    }
//    public void move() {
//
//    }
//    public Image getImage()
//    {
//        return img;
//    }
//    public Rectangle getBounds() {  //ขอบเขตบักเกต
//        return new Rectangle(x, y, width, height);
//    }
}
