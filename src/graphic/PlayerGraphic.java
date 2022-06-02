package graphic;

import entity.Entity;
import entity.Player;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.Objects;

public class PlayerGraphic extends Entity {
    Player player;
    GamePanel gp;
	KeyHandler keyH;
    BufferedImage run0, run1, run2, run3, run4, run5;
	BufferedImage run_back0, run_back1, run_back2, run_back3, run_back4, run_back5;
	BufferedImage step_down, step_up;
    public PlayerGraphic(Player p, GamePanel gp, KeyHandler k){
        this.player = p;
		this.keyH = k;
        this.gp = gp;
		getEntityImage();
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
    public void getEntityImage(){
//        up1 = getImage("/player/up1.png");
//        up2 = getImage("/player/up2.png");
//        down1 = getImage("/player/down1.png");
//        down2 = getImage("/player/down2.png");
//        right1 = getImage("/player/right1.png");
//        right2 = getImage("/player/right2.png");
//        left1 = getImage("/player/left1.png");
//        left2 = getImage("/player/left2.png");
		run0 = getImage("/player/adventurer-run-00.png");
		run1 = getImage("/player/adventurer-run-01.png");
		run2 = getImage("/player/adventurer-run-02.png");
		run3 = getImage("/player/adventurer-run-03.png");
		run4 = getImage("/player/adventurer-run-04.png");
		run5 = getImage("/player/adventurer-run-05.png");

		run_back0 = getImage("/player/adventurer-run-back-00.png");
		run_back1 = getImage("/player/adventurer-run-back-01.png");
		run_back2 = getImage("/player/adventurer-run-back-02.png");
		run_back3 = getImage("/player/adventurer-run-back-03.png");
		run_back4 = getImage("/player/adventurer-run-back-04.png");
		run_back5 = getImage("/player/adventurer-run-back-05.png");

		step_down = getImage("/player/adventurer-idle-00.png");
		step_up = getImage("/player/adventurer-idle-01.png");
    }

	public void draw(Graphics2D g2) {
		BufferedImage image = null;
//		g2.setColor(Color.white);
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		switch(player.direction) {
		case "right":
			image = imageSelector(run0, run1, run2, run3, run4, run5);
			break;
		case "down":
			image = step_down;
			break;
		case "left":
			image = imageSelector(run_back0, run_back1, run_back2, run_back3, run_back4, run_back5);
			break;
		case "up":
			image = step_up;
			break;
		}
		g2.drawImage(image, player.screenX, player.screenY, gp.tileSize, gp.tileSize, null);
	}

	public BufferedImage imageSelector(BufferedImage run0, BufferedImage run1, BufferedImage run2, BufferedImage run3, BufferedImage run4, BufferedImage run5) {
		BufferedImage image = null;
		switch (player.heroNum){
			case 0: image = run0; break;
			case 1: image = run1; break;
			case 2: image = run2; break;
			case 3: image = run3; break;
			case 4: image = run4; break;
			case 5: image = run5; break;
		}
		return image;
	}
}
