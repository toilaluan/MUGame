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
    boolean colission = false;
    public void draw(Graphics2D g2, GamePanel gp){
        int screenX = worldX - (gp.player.worldX - gp.player.screenX);
        int screenY = worldY - (gp.player.worldY - gp.player.screenY);
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
