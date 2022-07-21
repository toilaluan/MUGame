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
        attack();
    }
    public void attack(){
        double distance = Math.sqrt(Math.pow(gp.player.worldX-worldX,2) + Math.pow(gp.player.worldY - worldY,2));
        System.out.println(distance);
        if (distance < gp.tileSize){
            gp.player.life -= 1;
        }
    }
}
