package entity;

import java.awt.*;
import java.util.ArrayList;

import main.CollisionChecker;
import main.GamePanel;
import main.KeyHandler;
import object.OBJ;

public class Player extends Entity {

	public static boolean hasKey = false;
	KeyHandler keyH;
	public int heroCounter;
	public int heroNum;
	public int screenX;
	public int screenY;
	public static boolean checkUp;
	public static boolean checkDown;
	public static boolean checkLeft;
	public static boolean checkRight;
	public static int checkSpeedPT = 0;
	public boolean attack = false;
	Rectangle attackArea = new Rectangle(0,0,0,0);
	public Player(GamePanel gp, KeyHandler KeyH, int attack, int defense) {
		super(gp);
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidArea.width = 32;
		solidArea.height = 32;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		this.gp = gp;
		this.keyH = KeyH;
		this.Attack = attack;
		this.Defense = defense;
		setDefaultValue();
		item = new ArrayList<>();
	}
	void setDefaultValue() {
		screenX = gp.screenWidth/2-gp.tileSize/2;
		screenY = gp.screenHeight/2-gp.tileSize/2;
		worldX = gp.tileSize * 8;
		worldY = gp.tileSize * 8;
		direction = "down";
		heroCounter = 0;
		heroNum = 0;
		maxlife = 6;
		life = maxlife;
	}

	public void update() {
		if(attack){
			attacking();
		}
		else if (keyH.upPressed || keyH.downPressed || keyH.rightPressed || keyH.leftPressed || keyH.spacePressed){
			if (keyH.spacePressed){
				attack = true;
			}
			else{
				attack = false;
			}
			if (keyH.upPressed) {
				direction = "up";
				checkUp=true;
			}
			else checkUp = false;
			if (keyH.downPressed) {
				direction = "down";
				checkDown=true;
			}
			else checkDown=false;
			if (keyH.rightPressed) {
				direction = "right";
				checkRight=true;
			}
			else checkRight = false;
			if (keyH.leftPressed) {
				direction = "left";
				checkLeft=true;
			}
			else checkLeft=false;
			heroCounter += 1;
			if (heroCounter > 10) {
				heroNum+=1;
				heroNum = heroNum%4;
//			System.out.println(heroNum);
				heroCounter = 0;
			}
		}
		colissionOnRoW = false;
		colissionOnCol = false;
//		gp.cChecker.checkTile(this);
		int objIndex = gp.cChecker.checkObject(this, true);
		CollisionChecker.interactor.ObjInteraction(gp,objIndex);
		if (!colissionOnRoW|| !colissionOnCol){
			if (keyH.upPressed || keyH.downPressed || keyH.rightPressed || keyH.leftPressed){
				if(!colissionOnCol){
					if (keyH.upPressed) {
						worldY -= Entity.speeds();
					}
					if (keyH.downPressed) {
						worldY += Entity.speeds();
					}
				}
				if(!colissionOnRoW){

					if (keyH.rightPressed) {
						worldX += Entity.speeds();
					}
					if (keyH.leftPressed) {
						worldX -= Entity.speeds();
					}
				}
				colissionOnRoW = false;
				colissionOnCol = false;
//				gp.cChecker.checkTile(this);
				heroCounter += 1;
				if (heroCounter > 10) {
					if (heroNum == 1) {
						heroNum = 2;
					} else if (heroNum == 2) {
						heroNum = 1;
					}
					heroCounter = 0;
				}
			}
		}
	}
	private void attacking() {
		heroCounter++;
		if(heroCounter <= 5){
			heroNum = 1;
		}
		if(heroCounter > 5 && heroCounter < 10){
			heroNum = 2;
			//luu worldX,Y, solidArea
			int currentWorldX = worldX;
			int currentWorldY = worldY;
			int solidAreaWidth = solidArea.width;
			int solidAreaHeight = solidArea.height;

			switch (direction){
				case "up": worldY -= attackArea.height;
				case "down": worldY += attackArea.height;
				case "left": worldX -= attackArea.width;
				case "right": worldX += attackArea.width;
			}

			solidArea.width = attackArea.width;
			solidArea.height = attackArea.height;

//			int monIndex = gp.cChecker.checkEntity(this, gp.monster);
//			damageMonster(monIndex, atk);
			worldX = currentWorldX;
			worldY = currentWorldY;
			solidArea.width = solidAreaWidth;
			solidArea.height = solidAreaHeight;
		}
		if(heroCounter >= 10){
			heroNum = 1;
			heroCounter = 0;
			attack = false;
		}
	}

}