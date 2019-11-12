package com.mystudio.gamename;

import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.Sprite;

import java.awt.*;

public class GameObject extends Rectangle {
    private CollisionBox collisionBox;
    private Sprite sprite;
    private int objectIndex;

    /**
     * getter
     */
    public CollisionBox getCollisionBox() { return collisionBox; }
    public int getObjectIndex() { return objectIndex; }
    public Sprite getSprite() { return sprite; }

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
