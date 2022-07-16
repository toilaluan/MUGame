package entity;

import main.GamePanel;
import object.OBJ;
import object.OBJ_SpeedPotion;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Entity {
	public GamePanel gp;
	public int worldX = 100;
	public int worldY = 100;
	public int monsterSpeed;
	public int speed = 2;
	public int speeds() {
		if (Player.checkSpeedPT==1) {
			Player.checkSpeedPT = 0;
			speed = speed+ OBJ_SpeedPotion.speedBonus;
			return speed;
		}
		else return speed;
	}

	public int maxlife;
	public int life;
	public int maxmana;
	public int mana;
	public int Attack;
	public boolean attack = false;

	public int screenX;
	public int heroNum;
	public int screenY;
	public int Defense;
	public String direction = "down";
	public Rectangle solidArea = new Rectangle(0,0,48,48);

	public int solidAreaDefaultX, solidAreaDefaultY;
	public static boolean colissionOnCol = false;
	public static boolean colissionOnRoW = false;
	public Entity(GamePanel gp) {
		this.gp=gp;
	}
	public ArrayList<OBJ> item;
}