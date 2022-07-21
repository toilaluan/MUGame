package controller;

import entity.Player;
import main.CollisionChecker;
import main.GamePanel;

import java.awt.*;

public abstract class EntityController {
    GamePanel gp;
    Player player;
    public static boolean hasKey;
    public int heroCounter;

    public static boolean checkUp;
    public static boolean checkDown;
    public static boolean checkLeft;
    public static boolean checkRight;
    public int screenX;
    public int screenY;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public static boolean colissionOnCol;
    public static boolean colissionOnRoW;
    public int heroNum;
    public abstract void update();
    public abstract void attacking();

}
