package graphic;

import entity.Entity;
import entity.Player;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Objects;

public class PlayerGraphic extends Entity {
    Player player;
    GamePanel gp;
	KeyHandler keyH;
	String walk_SS_path = "/player/blue_ninja/Walk.png";
	String attack_SS_path = "/player/blue_ninja/Attack.png";
	SpriteSheet walkSS;
	SpriteSheet attackSS;
    ArrayList<BufferedImage> walk_images;
	ArrayList<BufferedImage> attack_images;
    public PlayerGraphic(Player p, GamePanel gp, KeyHandler k){
		super(gp);
		this.player = p;
		this.keyH = k;
        this.gp = gp;
		this.walkSS = new SpriteSheet(gp, walk_SS_path);
		this.attackSS = new SpriteSheet(gp, attack_SS_path);
		walk_images = getSpriteImage(4, 4, walkSS);
		attack_images = getSpriteImage(4, 1, attackSS);
    }
    public BufferedImage getImage(String path){
		BufferedImage bImage = null;
        try{
			bImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(path)));
        }catch(Exception e){
            e.printStackTrace();
        }
		return bImage;
    }

	public ArrayList<BufferedImage> getSpriteImage(int numCol, int numRow, SpriteSheet ss){
		ArrayList<BufferedImage> images = new ArrayList<>();
		int w = ss.image.getWidth()/numCol;
		int h = ss.image.getHeight()/numRow;
		for (int i=0; i < numCol; i++){
			for (int j = 0; j < numRow; j++){
				BufferedImage image = ss.grabImage(i*w, j*h, w, h);
				images.add(image);
			}
		}
		return images;
	}
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
//		g2.setColor(Color.white);
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		switch(player.direction) {
		case "right":
			if (player.attack){
				image = attack_images.get(3);
			}
			else{
				image = imageSelector(walk_images.get(12), walk_images.get(13), walk_images.get(14), walk_images.get(15));
			}
			break;
		case "down":
			if (player.attack){
				image = attack_images.get(0);
			}
			else{
				image = imageSelector(walk_images.get(0), walk_images.get(1), walk_images.get(2), walk_images.get(3));
			}
			break;
		case "left":
			if (player.attack){
				image = attack_images.get(2);
			}
			else{
				image = imageSelector(walk_images.get(8), walk_images.get(9), walk_images.get(10), walk_images.get(11));
			}
			break;
		case "up":
			if (player.attack){
				image = attack_images.get(1);
			}
			else{
				image = imageSelector(walk_images.get(4), walk_images.get(5), walk_images.get(6), walk_images.get(7));
			}
			break;
		}
		g2.drawImage(image, player.screenX, player.screenY, gp.tileSize, gp.tileSize, null);
	}

	public BufferedImage imageSelector(BufferedImage run0, BufferedImage run1, BufferedImage run2, BufferedImage run3) {
		BufferedImage image = null;
		switch (player.heroNum){
			case 0: image = run0; break;
			case 1: image = run1; break;
			case 2: image = run2; break;
			case 3: image = run3; break;
		}
		return image;
	}
}
