package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class OBJ {
    String name;
    BufferedImage image;
    public int worldX;
    public int worldY;
    boolean colission = true;

    public Rectangle solidArea = new Rectangle(0,0,48,48);

    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    public void draw(Graphics2D g2, GamePanel gp){
        int screenX = worldX - (gp.player.worldX - gp.player.screenX);
        int screenY = worldY - (gp.player.worldY - gp.player.screenY);
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
