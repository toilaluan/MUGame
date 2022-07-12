package main;


import java.awt.*;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_40;
    Font arial_80B;
    int subState = 0;
    public UI(GamePanel gp){
        this.gp=gp;
        arial_40 = new Font("Arial", Font.PLAIN,40);
        arial_80B = new Font("Arial", Font.BOLD,80);

    }
    public void draw(Graphics2D g2){
        this.g2=g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        if(gp.gameState==gp.playState){

        }
        else if(gp.gameState == gp.pauseState){
            drawPauseScreen();
        }
    }
    public int getXforCenteredText(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
    public void drawSubWindow(int x,int y,int width,int height){
        Color c = new Color(0,0,0,200);
        g2.setColor(c);
        g2.fillRoundRect(x,y,width,height,35,35);
        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5,y+5,width-10,height-10,25,25);
    }
    public void drawPauseScreen(){
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;
        final int frameX = gp.screenWidth/2 - 120;
        final int frameY = gp.screenHeight/2 - 60;
        final int frameWidth = gp.tileSize * 5 ;
        final int frameHeight = gp.tileSize * 2;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);
        g2.drawString(text,x,y);
    }
}
