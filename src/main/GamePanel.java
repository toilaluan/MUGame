package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import entity.Player;
import graphic.PlayerGraphic;
import object.OBJ;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	
	double FPS = 60;
	public final int originalTileSize = 16; // Kich thuoc cua nhan vat
	public final int scale = 3; // tang kich thuoc nhan vat theo scale
	public final int tileSize = scale * originalTileSize;
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 16; //ti le 16:9
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;
	public final int maxWorldRow = 32;
	public final int maxWorldCol = 32;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;

	Thread gameThread;
	KeyHandler keyH = new KeyHandler();
	public Player player = new Player(this, keyH, 1, 1);
	public TileManager tileM = new TileManager(this);
	//	set Player's default position
	public ArrayList<OBJ> obj = new ArrayList<>();
	PlayerGraphic pg = new PlayerGraphic(player, this, keyH);

	public AssetSetter aSetter = new AssetSetter(this);
	public CollisionChecker cChecker = new CollisionChecker(this);
	public void setupGame(){
		aSetter.setObject(obj);
	}
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
		player.update();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
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
		g2.dispose();
	}
}
