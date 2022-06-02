package main;

import entity.Entity;

public class ColissionChecker {
    GamePanel gp;
    public ColissionChecker(GamePanel gp){
        this.gp = gp;
    }

    public void checkTile(Entity entity){
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY  = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int tileNum1, tileNum2;
        switch (entity.direction){
            case "up":
                entityTopRow = (entityTopWorldY-entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTile[entityTopRow][entityLeftCol];
                tileNum2 = gp.tileM.mapTile[entityTopRow][entityRightCol];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision){
                    entity.colissionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY+entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTile[entityBottomRow][entityLeftCol];
                tileNum2 = gp.tileM.mapTile[entityBottomRow][entityRightCol];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision){
                    entity.colissionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX-entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTile[entityTopRow][entityLeftCol];
                tileNum2 = gp.tileM.mapTile[entityBottomRow][entityLeftCol];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision){
                    entity.colissionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX-entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTile[entityTopRow][entityRightCol];
                tileNum2 = gp.tileM.mapTile[entityBottomRow][entityRightCol];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision){
                    entity.colissionOn = true;
                }
                break;

        }
    }
}
