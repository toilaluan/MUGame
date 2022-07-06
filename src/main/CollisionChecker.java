package main;

import entity.Entity;
import entity.Player;
import object.ObjInteraction;

public class CollisionChecker {
    GamePanel gp;
    public static ObjInteraction interactor = new ObjInteraction();
    public CollisionChecker(GamePanel gp){
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
                    entityTopRow = (entityTopWorldY - Entity.speeds()) / gp.tileSize;
                    tileNum1 = gp.tileM.mapTile[entityTopRow][entityLeftCol];
                    tileNum2 = gp.tileM.mapTile[entityTopRow][entityRightCol];
                    System.out.println(tileNum1);
                    System.out.println("And");
                    System.out.println(tileNum2);
                    Entity.colissionOnCol = gp.tileM.tile[tileNum1].collision;
                    Entity.colissionOnRoW = gp.tileM.tile[tileNum2].collision;
                    break;
                case "down":
                    entityBottomRow = (entityBottomWorldY + Entity.speeds()) / gp.tileSize;
                    tileNum1 = gp.tileM.mapTile[entityBottomRow][entityLeftCol];
                    tileNum2 = gp.tileM.mapTile[entityBottomRow][entityRightCol];
                    System.out.println(tileNum1);
                    System.out.println("And");
                    System.out.println(tileNum2);
                    Entity.colissionOnCol = gp.tileM.tile[tileNum1].collision;
                    Entity.colissionOnRoW = gp.tileM.tile[tileNum2].collision;
                    break;
                case "left":
                    entityLeftCol = (entityLeftWorldX - Entity.speeds()) / gp.tileSize;
                    tileNum1 = gp.tileM.mapTile[entityTopRow][entityLeftCol];
                    tileNum2 = gp.tileM.mapTile[entityBottomRow][entityLeftCol];
                    System.out.println(tileNum1);
                    System.out.println("And");
                    System.out.println(tileNum2);
                    Entity.colissionOnRoW = gp.tileM.tile[tileNum1].collision;
                    Entity.colissionOnCol = gp.tileM.tile[tileNum2].collision;
                    break;
                case "right":
                    entityRightCol = (entityRightWorldX - Entity.speeds()) / gp.tileSize;
                    tileNum1 = gp.tileM.mapTile[entityTopRow][entityRightCol];
                    tileNum2 = gp.tileM.mapTile[entityBottomRow][entityRightCol];
                    System.out.println(tileNum1);
                    System.out.println("And");
                    System.out.println(tileNum2);
                    Entity.colissionOnRoW = gp.tileM.tile[tileNum1].collision;
                    Entity.colissionOnCol = gp.tileM.tile[tileNum2].collision;
                    break;
            }
        }
        if (Player.checkUp) {
            switch (entity.direction) {
                case "up":
                    entityTopRow = (entityTopWorldY - Entity.speeds()) / gp.tileSize;
                    tileNum1 = gp.tileM.mapTile[entityTopRow][entityLeftCol];
                    tileNum2 = gp.tileM.mapTile[entityTopRow][entityRightCol];
                    System.out.println(tileNum1);
                    System.out.println("And");
                    System.out.println(tileNum2);
                    Entity.colissionOnCol = gp.tileM.tile[tileNum1].collision;
                    Entity.colissionOnRoW = gp.tileM.tile[tileNum2].collision;
                    break;
                case "down":
                    entityBottomRow = (entityBottomWorldY + Entity.speeds()) / gp.tileSize;
                    tileNum1 = gp.tileM.mapTile[entityBottomRow][entityLeftCol];
                    tileNum2 = gp.tileM.mapTile[entityBottomRow][entityRightCol];
                    System.out.println(tileNum1);
                    System.out.println("And");
                    System.out.println(tileNum2);
                    Entity.colissionOnCol = gp.tileM.tile[tileNum1].collision;
                    Entity.colissionOnRoW = gp.tileM.tile[tileNum2].collision;
                    break;
                case "left":
                    entityLeftCol = (entityLeftWorldX - Entity.speeds()) / gp.tileSize;
                    tileNum1 = gp.tileM.mapTile[entityTopRow][entityLeftCol];
                    tileNum2 = gp.tileM.mapTile[entityBottomRow][entityLeftCol];
                    System.out.println(tileNum1);
                    System.out.println("And");
                    System.out.println(tileNum2);
                    Entity.colissionOnCol = gp.tileM.tile[tileNum1].collision;
                    Entity.colissionOnRoW = gp.tileM.tile[tileNum2].collision;
                    break;
                case "right":
                    entityRightCol = (entityRightWorldX - Entity.speeds()) / gp.tileSize;
                    tileNum1 = gp.tileM.mapTile[entityTopRow][entityRightCol];
                    tileNum2 = gp.tileM.mapTile[entityBottomRow][entityRightCol];
                    System.out.println(tileNum1);
                    System.out.println("And");
                    System.out.println(tileNum2);
                    Entity.colissionOnCol = gp.tileM.tile[tileNum1].collision;
                    Entity.colissionOnRoW = gp.tileM.tile[tileNum2].collision;
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
                            if(gp.obj.get(i).colission){
                                Entity.colissionOnRoW = true;
                                Entity.colissionOnCol = true;
                            }
                            if(player) index = i;
                        }
                        break;
                    case "down":
                        entity.solidArea.x += Entity.speeds();
                        if (entity.solidArea.intersects(gp.obj.get(i).solidArea)){

                            if(gp.obj.get(i).colission){
                                Entity.colissionOnRoW = true;
                                Entity.colissionOnCol = true;
                            }
                            if(player) index = i;
                        }
                        break;
                    case "right":
                        entity.solidArea.y += Entity.speeds();
                        if (entity.solidArea.intersects(gp.obj.get(i).solidArea)){

                            if(gp.obj.get(i).colission){
                                Entity.colissionOnRoW = true;
                                Entity.colissionOnCol = true;
                            }
                            if(player) index = i;
                        }
                        break;
                    case "left":
                        entity.solidArea.y -= Entity.speeds();
                        if (entity.solidArea.intersects(gp.obj.get(i).solidArea)){

                            if(gp.obj.get(i).colission){
                                Entity.colissionOnRoW = true;
                                Entity.colissionOnCol = true;
                            }
                            if(player) index = i;
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