package com.mystudio.gamename;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.game.BasicGame;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.Sprite;
import static com.mystudio.gamename.Variable.*;
import java.awt.*;


public class DonkeyKongGame extends BasicGame  {
	public static final String GAME_IDENTIFIER = "com.mystudio.gamename";

	private Texture texture;
	private Sprite kongSprite, manSprite, groundSprite;
	private Texture kongGraphic, manGraphic, groundGraphic;
	private Monkey Kong;
	private Man man;
	private Floor ground;
	private CollisionBox[] gameObjCollisionBox;
	private GameObject[] gameObj;

	@Override
    public void initialise() {
        kongGraphic = new Texture("Monkey.png");
        kongSprite = new Sprite(kongGraphic);
        Kong = new Monkey(kongSprite);
        manGraphic = new Texture("man_run_right_ wiht_ham_down.png");
        manSprite = new Sprite(manGraphic);
        man = new Man(manSprite);
        groundGraphic = new Texture("Ground2.png");
        groundSprite = new Sprite(groundGraphic);
        ground = new Floor(groundSprite,50,700, 1000, 200);
        gameObjCollisionBox = new CollisionBox[MAX_OBJ];
        gameObj = new GameObject[MAX_OBJ];
        gameObjCollisionBox[0] = ground.getCollisionBox();
        gameObj[0] = ground;


        MyInputProcessor inputProcessor = new MyInputProcessor(Kong, man);
        Gdx.input.setInputProcessor(inputProcessor);


    }
    
    @Override
    public void update(float delta) {
        Kong.update();
        man.update();
        Kong.monkeyMove();
        man.manMove();
//        for(int i = 0; i< MAX_OBJ ; i++) {
//            if (checkCollision(Kong.getMonkeyBox(),gameObjCollisionBox[i])){
//                GameObject temp = gameObj[i];
//                if(temp.getObjectIndex() == 1){
//                    Kong.setOnFloor(true);
//                    Kong.monkeyMove();
//                }
//            }else{
//                Kong.monkeyMove();
//            }
//
//        }

    }
    
    @Override
    public void interpolate(float alpha) {
        Kong.interpolate(alpha);
        man.interpolate(alpha);
    }

    @Override
    public void render(Graphics g) {
        g.setBackgroundColor(Color.WHITE);
        Kong.render(g);
        man.render(g);
        ground.render(g);

    }

    public boolean checkCollision (CollisionBox a,CollisionBox b){
	    if(a.getPolygon().intersects(b.getPolygon())){ return true; }
        else return false;
    }
}
