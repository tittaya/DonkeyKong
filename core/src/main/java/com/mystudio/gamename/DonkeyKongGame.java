package com.mystudio.gamename;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.game.BasicGame;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.Sprite;
import static com.mystudio.gamename.Variable.*;
import static com.mystudio.gamename.GameObjectList.*;


public class DonkeyKongGame extends BasicGame {
    public static final String GAME_IDENTIFIER = "com.mystudio.gamename";

    private Sprite kongSprite, manSprite;
//    private Sprite groundSprite, floor1Sprite;
    private Texture kongGraphic, manGraphic;
//    private Texture  groundGraphic, floor1Graphic, bgTexture;
    private Monkey Kong;
    private Man man;
//    private Floor ground, floor1;
    private GameObject[] gameObj;

    @Override
    public void initialise() {
        bgTexture = new Texture("bg2.png");


        kongGraphic = new Texture("Kong1.png");
        kongSprite = new Sprite(kongGraphic);
        Kong = new Monkey(kongSprite);

        manGraphic = new Texture("man_run_right_ wiht_ham_down.png");
        manSprite = new Sprite(manGraphic);
        man = new Man(manSprite);


        gameObj = new GameObject[MAX_OBJ];

        gameObj[0] = ground;
        gameObj[1] = floor1;

        MyInputProcessor inputProcessor = new MyInputProcessor(Kong, man);
        Gdx.input.setInputProcessor(inputProcessor);


    }

    @Override
    public void update(float delta) {
//        Kong.update();
//        man.update();
        if(Kong.jump) {
            if (checkCollision(Kong.getMonkeyBox(), gameObj)) {

                Kong.setOnFloor(true);
                Kong.setCanJump(true);
            } else {
                Kong.setOnFloor(false);
            }
        }
        Kong.monkeyMove(delta);
        Kong.update();
        man.update();




    }

    @Override
    public void interpolate(float alpha) {
        Kong.interpolate(alpha);
        man.interpolate(alpha);
    }

    @Override
    public void render(Graphics g) {
        g.drawTexture(bgTexture, 0, 0);
        Kong.render(g);
        man.render(g);
        ground.render(g);
        floor1.render(g);


    }

    public boolean checkCollision(CollisionBox a, GameObject[] b) {
        for (int i = 0; i < b.length; i++) {
            GameObject x = b[i];
            if (x != null) {
                if(a.intersects(x.getCollisionBox())){
                    return true;
                }else{
                    return false;
                }
            }

        }
        return false;
    }
}

//	    if(a.getPolygon().intersects(b.getPolygon())){ return true; }
//        else return false;
//    }
//    public boolean checkFloor(CollisionBox a,CollisionBox b){
//	    if((a.getY()+a.getHeight()) >= b.getY()){ return true; }
//	    else return false;
//    }

