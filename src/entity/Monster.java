package entity;

import main.GamePanel;

public class Monster extends  Entity{

    public Monster(GamePanel gp, int worldX, int worldY, int speed) {
        super(gp);
        this.worldX = worldX;
        this.worldY = worldY;
        this.speed = speed;
    }
    public void update(){
        this.screenX = worldX - (gp.player.worldX - gp.player.screenX);
        this.screenY = worldY - (gp.player.worldY - gp.player.screenY);
    }
    public void attack(){

    }
}
