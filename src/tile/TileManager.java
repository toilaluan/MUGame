package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.nio.Buffer;
import java.util.Objects;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTile;
    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[10];
        this.mapTile = new int[gp.maxWorldRow][gp.maxWorldCol];
        setImage();
        getMap("/maps/map1.txt");
    }

    public void setImage(){
        try {
            tile[0] = new Tile();
            tile[1] = new Tile();
            tile[2] = new Tile();
            tile[3] = new Tile();
            tile[4] = new Tile();
            tile[5] = new Tile();
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/road00.png")));
            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/water00.png")));
            tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/grass00.png")));
            tile[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/wall.png")));
            tile[1].collision = true;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void getMap(String path){
        try{

//            File f = new File(path);
//            BufferedReader br = new BufferedReader(new FileReader(f));
//            int row = 0, col = 0;
//            for (row=0; row <gp.maxWorldRow; row++){
//                String line = br.readLine();
//                String[] numbers = line.split(" ");
//                for (col = 0; col<gp.maxWorldCol; col++){
//                    int num = Integer.parseInt(numbers[col]);
//                    mapTile[row][col] = num;
//                }
//            }
            InputStream is = getClass().getResourceAsStream(path);
            assert is != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int row = 0;
            int col = 0;
            while (row < gp.maxWorldRow && col < gp.maxWorldCol){
                String line = br.readLine();
                String[] numbers = line.split(" ");
                while (col < gp.maxWorldCol){
                    int num = Integer.parseInt(numbers[col]);
                    mapTile[row][col] = num;
                    col++;
                }
                if (col == gp.maxWorldCol){
                    col = 0;
                    row += 1;
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
        int col = 0, row = 0;
        while (col < gp.maxWorldCol && row < gp.maxScreenRow){
            int tileNum = mapTile[row][col];
//            System.out.println(tileNum);
            int worldX = col*gp.tileSize;
            int worldY = row*gp.tileSize;
            int screenX = worldX - (gp.player.worldX - gp.player.screenX);
            int screenY = worldY - (gp.player.worldY - gp.player.screenY);

            g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            col += 1;
            if (col == gp.maxWorldCol){
                col = 0;
                row += 1;
            }
        }

    }
}
