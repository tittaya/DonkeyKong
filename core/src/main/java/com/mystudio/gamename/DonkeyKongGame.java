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

    //-----------------------------------
	private Texture texture;
	private Sprite kongSprite, manSprite, groundSprite, floor1Sprite;
	private Texture kongGraphic, manGraphic, groundGraphic, floor1Graphic;
	private Monkey Kong;
	private Man man;
	private Floor ground, floor1;
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

        groundGraphic = new Texture("Ground3.png");
        groundSprite = new Sprite(groundGraphic);
        ground = new Floor(groundSprite,0,800, 1500, 200);

        floor1Graphic = new Texture("floor2.png");
        floor1Sprite = new Sprite(floor1Graphic);
        floor1 = new Floor(floor1Sprite,0,300,800,100);

        gameObjCollisionBox = new CollisionBox[MAX_OBJ];
        gameObj = new GameObject[MAX_OBJ];
        gameObjCollisionBox[0] = ground.getCollisionBox();
//        gameObjCollisionBox[1] = floor1.getCollisionBox();
        gameObj[0] = ground;
//        gameObj[1] = floor1;


        MyInputProcessor inputProcessor = new MyInputProcessor(Kong, man);
        Gdx.input.setInputProcessor(inputProcessor);


    }
    
    @Override
    public void update(float delta) {
        Kong.update();
        man.update();
        Kong.monkeyMove();
        man.manMove();
        for(int i=0; i<MAX_OBJ ; i++) {
            if(gameObj[i]!= null) {
                GameObject temp = gameObj[i];
                if (checkCollision(Kong.getMonkeyBox(), temp.getCollisionBox())) {
                    Kong.setOnFloor(true);
                    Kong.monkeyMove();
                }
                if (!checkCollision(Kong.getMonkeyBox(), temp.getCollisionBox())) {
                    Kong.setOnFloor(false);
                    Kong.monkeyMove();
                }
                if(checkCollision(man.getManBox(), temp.getCollisionBox())){
                    man.setOnFloor(true);
                    man.manMove();
                }
                if(!checkCollision(man.getManBox(), temp.getCollisionBox())){
                    man.setOnFloor(false);
                    man.manMove();
                }
            }
        }

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
        floor1.render(g);

    }

    public boolean checkCollision (CollisionBox a,CollisionBox b){
	    if(a.getPolygon().intersects(b.getPolygon())){ return true; }
        else return false;
    }
//    public boolean checkFloor(CollisionBox a,CollisionBox b){
//	    if((a.getY()+a.getHeight()) >= b.getY()){ return true; }
//	    else return false;
//    }
}
