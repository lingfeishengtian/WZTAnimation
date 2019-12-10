import java.awt.*;
import java.awt.geom.GeneralPath;

public class WZT {
    public static void drawWZT(Graphics g, int iterations, int speed)
    {
        int xpoints [];
        int ypoints [];
        int npoints;
        //color
        Color skin = new Color (255, 244, 203);
        Color jacket = new Color (201,31,55);
        Color black = new Color (0,0,0);
        Color shirt = new Color (255,179,167);
        Color white = new Color (255,255,255);
        Color line = new Color (240,86,84);

        //head
        g.setColor(skin);
        g.fillOval(400,200,200,175);  //head size: 8grid*7grid

        //body + jacket
        g.setColor(jacket);
        //g.fillRect(325,375,350,125);
        Graphics2D graphics2D = (Graphics2D)g;
        GeneralPath sleeve = new GeneralPath();
        sleeve.moveTo(325, 375);
        sleeve.curveTo(325, 375, 332, 450, 350, 500);
        sleeve.curveTo(350, 500, 382, 495, 425, 475);  //bottom
        sleeve.lineTo(350, 650);
        sleeve.curveTo(350, 650, 500, 675, 650, 650);
        sleeve.lineTo(575, 475);
        sleeve.curveTo(575, 475, 618, 495, 650, 500);  //bottom
        sleeve.curveTo(650, 500, 668, 450, 675, 375);
        sleeve.lineTo(325, 375);
        sleeve.closePath();
        graphics2D.setColor(jacket);
        graphics2D.fill(sleeve);


        //inside
        g.setColor(line);  //lining
        g.fillRect(450,375,100,285);
        g.setColor(skin);   //neck
        xpoints = new int[] {463, 500, 537};
        ypoints = new int[]{375, 425, 375};
        npoints = 3;
        g.fillPolygon(xpoints, ypoints, npoints);
        g.setColor(black);  //dress
        g.fillRect(463,500,74,161);
        g.setColor(shirt);  //shirt
        xpoints = new int[] {463, 500, 537, 537, 463};
        ypoints = new int[]{375, 425, 375, 475, 475};
        npoints = 5;
        g.fillPolygon(xpoints, ypoints, npoints);
        g.setColor(line);
        g.drawPolygon(xpoints, ypoints, npoints);
        g.drawLine(500,425,463,475);
        g.setColor(white);
        g.fillRect(463, 475, 74, 25);

        //ribbon
        //Graphics2D graphics2D = (Graphics2D)g;
        int shouldAddOrSub = (int) (50 * Math.sin((Math.PI / speed) * iterations));

        GeneralPath ribbonl = new GeneralPath();  //ribbon left
        ribbonl.moveTo(375, 375);
        ribbonl.lineTo(375, 500);
        ribbonl.curveTo(375, 500, 363, 563, 325 + shouldAddOrSub, 625 + shouldAddOrSub);
//        ribbonl.curveTo(375, 500, 350 + shouldAddOrSub, 530, 363, 563);
//        ribbonl.curveTo(363, 563, 380 + shouldAddOrSub, 590, 325, 625);

        ribbonl.lineTo(338 + shouldAddOrSub, 650 + shouldAddOrSub);
        ribbonl.curveTo(338 + shouldAddOrSub, 650 + shouldAddOrSub, 388, 563 + shouldAddOrSub, 400, 500);
//        ribbonl.curveTo(338, 650, 400 + shouldAddOrSub, 563, 388, 563);
//        ribbonl.curveTo(388, 563, 350 + shouldAddOrSub, 563, 400, 500);

        ribbonl.lineTo(400, 375);
        ribbonl.lineTo(375, 375);
        ribbonl.closePath();
        graphics2D.setColor(line);
        graphics2D.fill(ribbonl);

        GeneralPath ribbonr = new GeneralPath();  //ribbon right
        ribbonr.moveTo(625, 375);
        ribbonr.lineTo(625, 500);
        ribbonr.curveTo(625, 500, 638 + shouldAddOrSub, 563, 675 + shouldAddOrSub, 625);
        ribbonr.lineTo(662 + shouldAddOrSub, 650);
        ribbonr.curveTo(662 + shouldAddOrSub, 650 , 612 + shouldAddOrSub, 563, 600, 500);
        ribbonr.lineTo(600, 375);
        ribbonr.lineTo(625, 375);
        ribbonr.closePath();
        graphics2D.setColor(line);
        graphics2D.fill(ribbonr);
    }

}
