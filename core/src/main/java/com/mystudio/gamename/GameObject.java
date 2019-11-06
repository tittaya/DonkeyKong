package com.mystudio.gamename;

import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.graphics.Sprite;

import java.awt.*;

public class GameObject extends Rectangle {
    private CollisionBox collisionBox;
    private Sprite sprite;
    private int objectIndex;

    public CollisionBox getCollisionBox() {
        return collisionBox;
    }
    public int getObjectIndex() {
        return objectIndex;
    }
    public Sprite getSprite() {
        return sprite;
    }

}
