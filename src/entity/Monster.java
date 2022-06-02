package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Monster extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public int screenX;
    public int screenY;
    public Monster(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValue();

    }
    public void getMonsterImage(){

    }
    public void setDefaultValue(){
        screenX = 500;
        screenY = 500;
        speed = 1;
        direction = "up";

    }
    public void update(){

    }
    public void draw(Graphics2D g2){

    }
}
