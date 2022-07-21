package controller;

import entity.Monster;
import main.GamePanel;

public class MonsterController extends EntityController{
    GamePanel gp;
    Monster monster;
    public MonsterController(GamePanel gp, Monster monster){
        this.gp = gp;
        this.monster = monster;
        setDefaultValue();
    }
    private void setDefaultValue(){
        monster.worldX = gp.tileSize * 8;
        monster.worldY = gp.tileSize * 8;
        heroCounter = 0;
        heroNum = 0;
    }
    @Override
    public void update() {
        screenX = monster.worldX - (gp.player.worldX - gp.playerController.screenX);
        screenY = monster.worldY - (gp.player.worldY - gp.playerController.screenY);
    }

    @Override
    public void attacking() {

    }
}
