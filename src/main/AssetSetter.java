package main;

import object.OBJ;
import object.OBJ_key;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(OBJ[] obj){
        obj[0] = new OBJ_key();
        obj[0].worldX = gp.tileSize * 19;
        obj[0].worldY = gp.tileSize * 5;
    }
}
