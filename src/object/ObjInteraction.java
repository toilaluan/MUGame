package object;

import main.GamePanel;

public class ObjInteraction {
    public void objInteraction(GamePanel gp, OBJ obj){
        switch (obj.name){
            case "Key":
//                System.out.println("a Key");

                gp.player.item.add(obj);
                gp.obj.remove(obj);
                break;
            case "Door":
                for (int i = 0; i < gp.player.item.size(); i++){
                    if ( gp.player.item.get(i) != null && gp.player.item.get(i).name == "Key"){
                        System.out.println("Move to next map");
                        gp.player.item.remove(i);
                    }
                }
                break;

        }
    }
}
