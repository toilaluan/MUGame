package entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javax.imageio.ImageIO;

import main.ColissionChecker;
import main.GamePanel;
import main.KeyHandler;
import object.OBJ;
import object.ObjInteraction;

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

	public Player(GamePanel gp, KeyHandler KeyH, int attack, int defense) {
		super(gp);
		solidArea = new Rectangle();
		solidArea.x = 13;
		solidArea.y = 35;
		solidArea.width = 20;
		solidArea.height = 8;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		this.gp = gp;
		this.keyH = KeyH;
		this.Attack = attack;
		this.Defense = defense;
		setDefaultValue();
		item = new ArrayList<OBJ>();
	}
	void setDefaultValue() {
		screenX = gp.screenWidth/2-gp.tileSize/2;
		screenY = gp.screenHeight/2-gp.tileSize/2;
		worldX = gp.tileSize * 8;
		worldY = gp.tileSize * 8;
		direction = "down";
		heroCounter = 0;
		heroNum = 0;
	}

	public void update() {
		if (keyH.upPressed || keyH.downPressed || keyH.rightPressed || keyH.leftPressed){

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
				heroNum = heroNum%5;
//			System.out.println(heroNum);
				heroCounter = 0;
			}
		}
		colissionOnRoW = false;
		colissionOnCol = false;
		gp.cChecker.checkTile(this);
		int objIndex = gp.cChecker.checkObject(this, true);
		ColissionChecker.interactor.ObjInteraction(gp,objIndex);
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
				gp.cChecker.checkTile(this);
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

}