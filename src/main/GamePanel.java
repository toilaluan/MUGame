package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import entity.Monster;
import entity.Player;
import graphic.EntityGraphic;
import object.OBJ;
import render.TileManager;
//import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	
	double FPS = 60;
	public final int originalTileSize = 16; // Kich thuoc cua nhan vat
	public final int scale = 3; // tang kich thuoc nhan vat theo scale
	public final int tileSize = scale * originalTileSize;
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12; //ti le 16:9
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;
	public final int maxWorldRow = 50;
	public final int maxWorldCol = 50;

	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;


	public int gameState;
	public final int titleState=0;
	public final int playState =1;
	public final int pauseState =2;
	Sound sound= new Sound();

	Thread gameThread;
	public KeyHandler keyH = new KeyHandler(this);
	public Player player = new Player(this, keyH, 1, 1);
	public Monster monster1 = new Monster(this, tileSize * 10, tileSize * 10, 1);
	public TileManager tileM = new TileManager(this);
	//	set Player's default position
	public ArrayList<OBJ> obj = new ArrayList<>();
	EntityGraphic pg = new EntityGraphic(player, this, "BlueNinja", "Lance");
	EntityGraphic mg = new EntityGraphic(monster1, this, "Cyclope");
	public AssetSetter aSetter = new AssetSetter(this);
	public CollisionChecker cChecker = new CollisionChecker(this);
	public void setupGame(){
		aSetter.setObject(obj);
		gameState=titleState;
		playMusic(0);

	}
	public UI ui=new UI(this);
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(false);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
//	@Override

	public void run() {
		double drawTimeInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		while (gameThread != null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime)/drawTimeInterval;
			lastTime = currentTime;
			while (delta >= 1) {
				update();
				repaint();
				delta -= 1;
			}
		}
	}
	public void update() {
			if (gameState == playState) {
				// update player\
				monster1.update();
				player.update();}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		//title screen
		if(gameState==titleState){
			ui.draw(g2);
		}
		else{
			tileM.draw(g2);
//		Object
			for (OBJ value : obj) {
				if (value == null) {
					break;
				}
				value.draw(g2, this);
//			System.out.println(1);
			}
			pg.draw(g2);
			mg.draw(g2);
			ui.draw(g2);
		}

		g2.dispose();

	}
	public void playMusic(int i){
		sound.setFile(i);
		sound.play();
		sound.loop();
	}

	public void stopMusic(){
		sound.stop();
	}
	public void playSE(int i){
		sound.setFile(i);
		sound.play();
	}
}
