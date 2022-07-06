package main;

import entity.Entity;
import entity.Player;
import object.ObjInteraction;

public class ColissionChecker {
    GamePanel gp;
    public static ObjInteraction interactor = new ObjInteraction();
    public ColissionChecker(GamePanel gp){
        this.gp = gp;
    }
    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;
        int tileNum1, tileNum2;
        if (Player.checkDown||Player.checkLeft||Player.checkRight) {
            switch (entity.direction) {
                case "up":
                    entityTopRow = (entityTopWorldY - entity.speeds()) / gp.tileSize;
                    tileNum1 = gp.tileM.mapTile[entityTopRow][entityLeftCol];
                    tileNum2 = gp.tileM.mapTile[entityTopRow][entityRightCol];
                    System.out.println(tileNum1);
                    System.out.println("And");
                    System.out.println(tileNum2);
                    if (gp.tileM.tile[tileNum1].collision) {
                        entity.colissionOnCol = true;
                    } else entity.colissionOnCol = false;
                    if (gp.tileM.tile[tileNum2].collision) {
                        entity.colissionOnRoW = true;
                    } else entity.colissionOnRoW = false;
                    break;
                case "down":
                    entityBottomRow = (entityBottomWorldY + entity.speeds()) / gp.tileSize;
                    tileNum1 = gp.tileM.mapTile[entityBottomRow][entityLeftCol];
                    tileNum2 = gp.tileM.mapTile[entityBottomRow][entityRightCol];
                    System.out.println(tileNum1);
                    System.out.println("And");
                    System.out.println(tileNum2);
                    if (gp.tileM.tile[tileNum1].collision) {
                        entity.colissionOnCol = true;
                    } else entity.colissionOnCol = false;
                    if (gp.tileM.tile[tileNum2].collision) {
                        entity.colissionOnRoW = true;
                    } else entity.colissionOnRoW = false;
                    break;
                case "left":
                    entityLeftCol = (entityLeftWorldX - entity.speeds()) / gp.tileSize;
                    tileNum1 = gp.tileM.mapTile[entityTopRow][entityLeftCol];
                    tileNum2 = gp.tileM.mapTile[entityBottomRow][entityLeftCol];
                    System.out.println(tileNum1);
                    System.out.println("And");
                    System.out.println(tileNum2);
                    if (gp.tileM.tile[tileNum1].collision) {
                        entity.colissionOnRoW = true;
                    } else entity.colissionOnRoW = false;
                    if (gp.tileM.tile[tileNum2].collision) {
                        entity.colissionOnCol = true;
                    } else entity.colissionOnCol = false;
                    break;
                case "right":
                    entityRightCol = (entityRightWorldX - entity.speeds()) / gp.tileSize;
                    tileNum1 = gp.tileM.mapTile[entityTopRow][entityRightCol];
                    tileNum2 = gp.tileM.mapTile[entityBottomRow][entityRightCol];
                    System.out.println(tileNum1);
                    System.out.println("And");
                    System.out.println(tileNum2);
                    if (gp.tileM.tile[tileNum1].collision) {
                        entity.colissionOnRoW = true;
                    } else entity.colissionOnRoW = false;
                    if (gp.tileM.tile[tileNum2].collision) {
                        entity.colissionOnCol = true;
                    } else entity.colissionOnCol = false;
                    break;
            }
        }
        if (Player.checkUp) {
            switch (entity.direction) {
                case "up":
                    entityTopRow = (entityTopWorldY - entity.speeds()) / gp.tileSize;
                    tileNum1 = gp.tileM.mapTile[entityTopRow][entityLeftCol];
                    tileNum2 = gp.tileM.mapTile[entityTopRow][entityRightCol];
                    System.out.println(tileNum1);
                    System.out.println("And");
                    System.out.println(tileNum2);
                    if (gp.tileM.tile[tileNum1].collision) {
                        entity.colissionOnCol = true;
                    } else entity.colissionOnCol = false;
                    if (gp.tileM.tile[tileNum2].collision) {
                        entity.colissionOnRoW = true;
                    } else entity.colissionOnRoW = false;
                    break;
                case "down":
                    entityBottomRow = (entityBottomWorldY + entity.speeds()) / gp.tileSize;
                    tileNum1 = gp.tileM.mapTile[entityBottomRow][entityLeftCol];
                    tileNum2 = gp.tileM.mapTile[entityBottomRow][entityRightCol];
                    System.out.println(tileNum1);
                    System.out.println("And");
                    System.out.println(tileNum2);
                    if (gp.tileM.tile[tileNum1].collision) {
                        entity.colissionOnCol = true;
                    } else entity.colissionOnCol = false;
                    if (gp.tileM.tile[tileNum2].collision) {
                        entity.colissionOnRoW = true;
                    } else entity.colissionOnRoW = false;
                    break;
                case "left":
                    entityLeftCol = (entityLeftWorldX - entity.speeds()) / gp.tileSize;
                    tileNum1 = gp.tileM.mapTile[entityTopRow][entityLeftCol];
                    tileNum2 = gp.tileM.mapTile[entityBottomRow][entityLeftCol];
                    System.out.println(tileNum1);
                    System.out.println("And");
                    System.out.println(tileNum2);
                    if (gp.tileM.tile[tileNum1].collision) {
                        entity.colissionOnCol = true;
                    } else entity.colissionOnCol = false;
                    if (gp.tileM.tile[tileNum2].collision) {
                        entity.colissionOnRoW = true;
                    } else entity.colissionOnRoW = false;
                    break;
                case "right":
                    entityRightCol = (entityRightWorldX - entity.speeds()) / gp.tileSize;
                    tileNum1 = gp.tileM.mapTile[entityTopRow][entityRightCol];
                    tileNum2 = gp.tileM.mapTile[entityBottomRow][entityRightCol];
                    System.out.println(tileNum1);
                    System.out.println("And");
                    System.out.println(tileNum2);
                    if (gp.tileM.tile[tileNum1].collision) {
                        entity.colissionOnCol = true;
                    } else entity.colissionOnCol = false;
                    if (gp.tileM.tile[tileNum2].collision) {
                        entity.colissionOnRoW = true;
                    } else entity.colissionOnRoW = false;
                    break;
            }
        }
    }
    public int checkObject(Entity entity, boolean player){
        int index = 999;
        for (int i = 0; i < gp.obj.size(); i++){
//            System.out.println(i);
            if (gp.obj.get(i) != null){
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;
                gp.obj.get(i).solidArea.x = gp.obj.get(i).worldX + gp.obj.get(i).solidArea.x;
                gp.obj.get(i).solidArea.y = gp.obj.get(i).worldY + gp.obj.get(i).solidArea.y;

                switch(entity.direction){
                    case "up":
                        entity.solidArea.x -= Entity.speeds();
                        if (entity.solidArea.intersects(gp.obj.get(i).solidArea)){
                            if(gp.obj.get(i).colission == true){
                                entity.colissionOnRoW = true;
                                entity.colissionOnCol = true;
                            }
                            if(player == true) index = i;
                        }
                        break;
                    case "down":
                        entity.solidArea.x += Entity.speeds();
                        if (entity.solidArea.intersects(gp.obj.get(i).solidArea)){

                            if(gp.obj.get(i).colission == true){
                                entity.colissionOnRoW = true;
                                entity.colissionOnCol = true;
                            }
                            if(player == true) index = i;
                        }
                        break;
                    case "right":
                        entity.solidArea.y += Entity.speeds();
                        if (entity.solidArea.intersects(gp.obj.get(i).solidArea)){

                            if(gp.obj.get(i).colission == true){
                                entity.colissionOnRoW = true;
                                entity.colissionOnCol = true;
                            }
                            if(player == true) index = i;
                        }
                        break;
                    case "left":
                        entity.solidArea.y -= Entity.speeds();
                        if (entity.solidArea.intersects(gp.obj.get(i).solidArea)){

                            if(gp.obj.get(i).colission == true){
                                entity.colissionOnRoW = true;
                                entity.colissionOnCol = true;
                            }
                            if(player == true) index = i;
                        }
                        break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.obj.get(i).solidArea.x = gp.obj.get(i).solidAreaDefaultX;
                gp.obj.get(i).solidArea.y = gp.obj.get(i).solidAreaDefaultY;
            }
        }
        return index;
    }
}