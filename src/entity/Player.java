package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	
	GamePanel gp;
	KeyHandler keyH;
	public int heroCounter;
	public int heroNum; 
	public Player(GamePanel gp, KeyHandler KeyH) {
		this.gp = gp;
		this.keyH = KeyH;
		
		setDefaultValue();
		getPlayerImage();
	}
	void setDefaultValue() {
		x = 100;
		y = 100;
		speed = 4;
		direction = "down";
		heroCounter = 0;
		heroNum = 1;
	}
	public void getPlayerImage(){
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/up2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/down1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		if (keyH.upPressed) {
			direction = "up";
			if (y == 0) {
				y = gp.screenHeight;
			}
			else {
			y -= speed;
			}
			
		}
		if (keyH.downPressed) {
			direction = "down";
			if (y == gp.screenHeight) {
				y = 0;
			}
			else {
				y += speed;
			}
		}
		if (keyH.rightPressed) {
			direction = "right";
			if (x == gp.screenWidth) {
				x = 0;
			}
			else {
			x += speed;
			}
		}
		if (keyH.leftPressed) {
			direction = "left";
			if (x == 0) {
				x = gp.screenWidth;
			}
			else {
			x -= speed;
			}
		}
		heroCounter += 1;
		if (heroCounter > 10) {
			if (heroNum == 1) {
				heroNum = 2;
			}
			else if (heroNum == 2) {
				heroNum = 1;
			}
			heroCounter = 0;
		}
		
	}
	public void draw(Graphics2D g2) {
		BufferedImage image = null; 
//		g2.setColor(Color.white);
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		switch(direction) {
		case "up":
			if (heroNum==1) {
				image = up1;				
			}
			else {
				image = up2;
			}
			break;
		case "down":
			if (heroNum==1) {
				image = down1;				
			}
			else {
				image = down2;
			}
			break;
		case "right":
			if (heroNum==1) {
				image = right1;				
			}
			else {
				image = right2;
			}
			break;
		case "left":
			if (heroNum==1) {				
				image = left1;
			}
			else {
				image = left2;
			}
			break;
		}
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	}
}
