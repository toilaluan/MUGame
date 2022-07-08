package graphic;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class SpriteSheet {

    public BufferedImage image; // creating another Buffered Image
    GamePanel gp;

    public SpriteSheet(GamePanel gp, String spritePath) {
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(spritePath)));
        }catch(Exception e){
            e.printStackTrace();
        }
        this.gp = gp;
    }

    public BufferedImage grabImage(int col, int row, int width, int height) {

        return image.getSubimage(col, row, width, height);
        //Selecting the rows and columns of the spritesheet in folder res. 
        //This determines what image from the sprite sheet to display, in this case the player.
    }
}