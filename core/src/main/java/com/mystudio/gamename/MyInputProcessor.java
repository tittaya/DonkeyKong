package com.mystudio.gamename;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class MyInputProcessor implements InputProcessor {
    private Monkey monkey;
    private Man man;

    public MyInputProcessor(Monkey monkey, Man man) {
        this.monkey = monkey;
        this.man = man;
    }

    /**
     *
     * @param keycode
     * @return
     */
    public boolean keyDown (int keycode) {
        switch (keycode)
        {
            case Input.Keys.D:
                monkey.setD_Pressed(true);
                break;
            case Input.Keys.A:
                monkey.setA_Pressed(true);
                break;
            case Input.Keys.W:
                monkey.setW_Pressed(true);
                break;
            case Input.Keys.S:
                monkey.setS_Pressed(true);
                break;
            case Input.Keys.RIGHT:
                man.setRight_Pressed(true);
                break;
            case Input.Keys.LEFT:
                man.setLeft_Pressed(true);
                break;
            case Input.Keys.UP:
                man.setUp_Pressed(true);
                break;
            case Input.Keys.DOWN:
                man.setDown_Pressed(true);
                break;
        }
        return true;
    }

    public boolean keyUp (int keycode) {
        switch (keycode)
        {
            case Input.Keys.D:
                monkey.setD_Pressed(false);
                break;
            case Input.Keys.A:
                monkey.setA_Pressed(false);
                break;
            case Input.Keys.W:
                monkey.setW_Pressed(false);
                break;
            case Input.Keys.S:
                monkey.setS_Pressed(false);
                break;
            case Input.Keys.RIGHT:
                man.setRight_Pressed(false);
                break;
            case Input.Keys.LEFT:
                man.setLeft_Pressed(false);
                break;
            case Input.Keys.UP:
                man.setUp_Pressed(false);
                break;
            case Input.Keys.DOWN:
                man.setDown_Pressed(false);
                break;
        }
        return true;
    }

    public boolean keyTyped (char character) {
        return false;
    }

    public boolean touchDown (int x, int y, int pointer, int button) {
        return false;
    }

    public boolean touchUp (int x, int y, int pointer, int button) {
        return false;
    }

    public boolean touchDragged (int x, int y, int pointer) {
        return false;
    }

    public boolean mouseMoved (int x, int y) {
        return false;
    }

    public boolean scrolled (int amount) {
        return false;
    }
}

