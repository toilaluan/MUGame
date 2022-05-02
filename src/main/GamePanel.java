package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;

public class GamePanel extends JPanel implements Runnable{
	
	double FPS = 60;
	final int originalTileSize = 16; // Kich thuoc cua nhan vat
	final int scale = 3; // tang kich thuoc nhan vat theo scale
	public final int tileSize = scale * originalTileSize; 
	final int maxScreenCol = 16;
	final int maxScreenRow = 9; //ti le 16:9
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;
	Thread gameThread;
	KeyHandler keyH = new KeyHandler();
//	set Player's default position 
	Player player = new Player(this, keyH);
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.blue);
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
		player.draw(g2);
		g2.dispose();
	}
}
