package entity;

import main.GamePanel;
import object.OBJ;
import object.OBJ_SpeedPotion;

import java.awt.*;
import java.util.ArrayList;

public abstract class Entity {
	public int worldX;
	public int worldY;
	public int speed;
	public int maxlife;
	public int attack;
	public int defend;
	public boolean attacking;
	public int life;
	public int maxMana;
	public int mana;

	public boolean alive = true;
	public boolean dying = false;

	public String direction;
	public ArrayList<OBJ> item;
	public Rectangle solidArea;
}