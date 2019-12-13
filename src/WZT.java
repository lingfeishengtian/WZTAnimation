import java.awt.*;
import java.awt.geom.GeneralPath;

class WZT {
    static void drawWZT(Graphics g, long iterations, int speed, int raise) {
        int[] xpoints;
        int[] ypoints;
        int npoints;

        //color
        Color skin = new Color(255, 244, 203);
        Color jacket = new Color(201, 31, 55);
        Color black = new Color(0, 0, 0);
        Color shirt = new Color(255, 179, 167);
        Color white = new Color(255, 255, 255);
        Color line = new Color(240, 86, 84);

        //body + jacket
        g.setColor(jacket);
        //g.fillRect(325,375,350,125);
        Graphics2D graphics2D = (Graphics2D) g;
        GeneralPath sleeve = new GeneralPath();
        sleeve.moveTo(325 + raise, 375 - raise);
        sleeve.curveTo(325 + raise, 375 - raise, 332, 450, 350 + raise, 500 - raise);
        sleeve.curveTo(350 + raise, 500 - raise, 382 + raise, 495, 425, 475);  //bottom
        sleeve.lineTo(350 + raise / 3.0, 650 - raise / 3.0);
        sleeve.curveTo(350 + raise / 3.0, 650 - raise / 3.0, 500, 675, 650 - raise / 3.0, 650 - raise / 3.0);
        sleeve.lineTo(575, 475);
        sleeve.curveTo(575, 475, 618, 495, 650 - raise, 500 - raise);  //bottom
        sleeve.curveTo(650 - raise, 500 - raise, 668, 450, 675 - raise, 375 - raise);
        sleeve.lineTo(500, 375);
        sleeve.lineTo(325 + raise, 375 - raise);
        sleeve.closePath();
        graphics2D.setColor(jacket);
        graphics2D.fill(sleeve);

        //head
        g.setColor(skin);
        g.fillOval(400, 200, 200, 175);  //head size: 8grid*7grid

        //inside
        g.setColor(line);  //lining
        g.fillRect(450, 375 - raise / 3, 100, 285 + raise / 3);
        g.setColor(skin);   //neck
        xpoints = new int[]{463, 500, 537};
        ypoints = new int[]{375 - raise / 3, 425, 375 - raise / 3};
        npoints = 3;
        g.fillPolygon(xpoints, ypoints, npoints);
        g.setColor(black);  //dress
        g.fillRect(463, 500, 74, 161);
        g.setColor(shirt);  //shirt
        xpoints = new int[]{463, 500, 537, 537, 463};
        ypoints = new int[]{375 - raise / 3, 425, 375 - raise / 3, 475, 475};
        npoints = 5;
        g.fillPolygon(xpoints, ypoints, npoints);
        g.setColor(line);
        g.drawPolygon(xpoints, ypoints, npoints);
        g.drawLine(500, 425, 463, 475);
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

        ribbonl.lineTo(400, 375 - raise * 4.0 / 6);
        ribbonl.lineTo(375, 375 - raise * 5.0 / 6);
        ribbonl.closePath();
        graphics2D.setColor(line);
        graphics2D.fill(ribbonl);

        GeneralPath ribbonr = new GeneralPath();  //ribbon right
        ribbonr.moveTo(625, 375);
        ribbonr.lineTo(625, 500);
        ribbonr.curveTo(625, 500, 638 + shouldAddOrSub, 563, 675 + shouldAddOrSub, 625);
        ribbonr.lineTo(662 + shouldAddOrSub, 650);
        ribbonr.curveTo(662 + shouldAddOrSub, 650, 612 + shouldAddOrSub, 563, 600, 500);
        ribbonr.lineTo(600, 375 - raise * 4.0 / 6);
        ribbonr.lineTo(625, 375 - raise * 5.0 / 6);
        ribbonr.closePath();
        graphics2D.setColor(line);
        graphics2D.fill(ribbonr);

        //hair
        GeneralPath hair = new GeneralPath();  //ribbon right
        hair.moveTo(538, 237);
        hair.curveTo(538, 237, 560, 275, 588, 287);
        hair.curveTo(588, 287, 583, 308, 575, 313);
        hair.curveTo(575, 313, 600, 310, 613, 287);
        hair.curveTo(613, 287, 600, 155, 500, 200);
        hair.curveTo(500, 200, 400, 150, 400, 300);
        //	hair.curveTo(613, 287, 500, 0, 400, 300);  //
        hair.curveTo(400, 300, 387, 325, 400, 350);
        hair.curveTo(400, 350, 383, 363, 400, 375);
        hair.curveTo(400, 375, 413, 380, 425, 375);
        hair.curveTo(425, 375, 450, 378, 475, 337);
        hair.curveTo(475, 337, 463, 350, 450, 337);
        hair.curveTo(450, 337, 460, 332, 463, 328);
        hair.curveTo(463, 328, 475, 312, 463, 300);
        hair.curveTo(463, 300, 450, 287, 517, 235);
        hair.curveTo(517, 235, 525, 240, 538, 237);
        hair.closePath();
        graphics2D.setColor(black);
        graphics2D.fill(hair);

        //eyes
        g.fillOval(475, 275, 15, 25);
        g.fillOval(550, 275, 15, 25);

        //mouth
        GeneralPath mouth = new GeneralPath();
        mouth.moveTo(508, 300);
        mouth.curveTo(508, 300, 523, 350, 533, 300);
        mouth.lineTo(508, 300);
        mouth.closePath();
        graphics2D.setColor(jacket);
        graphics2D.fill(mouth);

        //blush
        g.setColor(shirt);
        g.fillOval(455, 300, 25, 15);
        g.fillOval(575, 300, 25, 15);
    }

}
