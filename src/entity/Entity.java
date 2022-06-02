package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
	public int worldX = 100;
	public int worldY = 100;
	public int speed = 4;
	public int mp = 100;
	public int hp = 100;
	public int Attack;
	public int Defense;
	public BufferedImage up1, up2, down1, down2, right1, right2, left1, left2;
	public String direction;

	public Rectangle solidArea;

	public boolean colissionOn = false;

}
