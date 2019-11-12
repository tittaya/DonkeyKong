package com.mystudio.gamename;

import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.graphics.Sprite;

import static com.mystudio.gamename.Variable.MAX_OBJ;

/**
 * create objects in game
 */
public class GameObjectList {
    public static Texture  bgTexture = new Texture("bg2.png");
    public static Texture groundGraphic = new Texture("Ground3.png");
    public static Texture  floor1Graphic = new Texture("floor2.png");

    public static Sprite  groundSprite = new Sprite(groundGraphic);
    public static Sprite floor1Sprite = new Sprite(floor1Graphic);

    public static Floor ground = new Floor(groundSprite, 0, 800, 1300, 200);
    public static Floor floor1 =  new Floor(floor1Sprite, 0, 300, 800, 100);

}