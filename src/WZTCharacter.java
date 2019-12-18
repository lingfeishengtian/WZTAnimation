import java.awt.*;
import java.awt.geom.GeneralPath;

class WZTCharacter {
    /**
     * The whole character of WuZeTian the one and only empress
     * @param g Graphics
     * @param iterations frames
     * @param speed velocity
     * @param raise how high did the user mouse click
     */
    static void drawWZT(Graphics g, long iterations, int speed, int raise) {
        //colors used
        Color skin = new Color(255, 244, 203);
        Color jacket = new Color(201, 31, 55);
        Color black = new Color(0, 0, 0);
        Color shirt = new Color(255, 179, 167);
        Color white = new Color(255, 255, 255);
        Color line = new Color(240, 86, 84);

        Graphics2D graphics2D = (Graphics2D) g;
        int shouldAddOrSub = (int) (50 * Math.sin((Math.PI / speed) * iterations));

        drawJacket(g, raise, skin, jacket, black, shirt, white, line, graphics2D, shouldAddOrSub);
        drawHead(g, skin, jacket, black, shirt, graphics2D, iterations);
    }

    private static void drawJacket(Graphics g, int raise, Color skin, Color jacket, Color black, Color shirt, Color white, Color line, Graphics2D graphics2D, int shouldAddOrSub) {
        drawBodyAndJacket(g, raise, jacket, graphics2D);
        drawJacketDesign(g, raise, skin, black, shirt, white, line);
        drawRibbons(raise, line, graphics2D, shouldAddOrSub);
    }

    private static void drawHead(Graphics g, Color skin, Color jacket, Color black, Color shirt, Graphics2D graphics2D, long frameNum) {
        drawHead(g, skin);
        drawHair(black, graphics2D);
        drawEyes(g, frameNum);
        drawMouth(jacket, graphics2D);
        drawBlush(g, shirt);
        drawForehead(graphics2D, jacket);
    }

    private static void drawBlush(Graphics g, Color shirt) {
        g.setColor(new Color(255, 96, 106));
        g.fillOval(455, 300, 25, 15);
        g.fillOval(575, 300, 25, 15);
    }

    private static void drawForehead(Graphics2D graphics2D, Color jacket){
        GeneralPath f1 = new GeneralPath();
        f1.moveTo(515, 250);
        f1.curveTo(515, 250, 520, 245, 525, 250);
        f1.lineTo(520, 265);
        f1.lineTo(515, 250);
        f1.closePath();
        graphics2D.setColor(jacket);
        graphics2D.fill(f1);

        GeneralPath f2 = new GeneralPath();
        f2.moveTo(520, 265);
        f2.lineTo(510, 255);
        f2.curveTo(510, 255, 500, 260, 505, 265);
        f2.lineTo(520, 265);
        f2.closePath();
        graphics2D.setColor(jacket);
        graphics2D.fill(f2);

        GeneralPath f3 = new GeneralPath();
        f3.moveTo(520, 265);
        f3.lineTo(530, 255);
        f3.curveTo(530, 255, 540, 260, 535, 265);
        f3.lineTo(520, 265);
        f3.closePath();
        graphics2D.setColor(jacket);
        graphics2D.fill(f3);
    }

    private static void drawMouth(Color jacket, Graphics2D graphics2D) {
        GeneralPath mouth = new GeneralPath();
        mouth.moveTo(508, 300);
        mouth.curveTo(508, 300, 523, 350, 533, 300);
        mouth.lineTo(508, 300);
        mouth.closePath();
        graphics2D.setColor(jacket);
        graphics2D.fill(mouth);
    }

    private static void drawEyes(Graphics g, long frameNum) {
        int y = 275 + (int)(Math.pow(frameNum, 2.0));
        g.fillOval(475, 275, 15, 25);
        g.fillOval(550, 275, 15, 25);
    }

    private static void drawHair(Color black, Graphics2D graphics2D) {
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
    }

    private static void drawRibbons(int raise, Color line, Graphics2D graphics2D, int shouldAddOrSub) {
        GeneralPath ribbonl = new GeneralPath();  //ribbon left
        ribbonl.moveTo(375, 375);
        ribbonl.lineTo(375, 500);
        ribbonl.curveTo(375, 500, 363, 563, 325 + shouldAddOrSub, 625 + shouldAddOrSub);
        ribbonl.lineTo(338 + shouldAddOrSub, 650 + shouldAddOrSub);
        ribbonl.curveTo(338 + shouldAddOrSub, 650 + shouldAddOrSub, 388, 563 + shouldAddOrSub, 400, 500);
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
    }

    private static void drawJacketDesign(Graphics g, int raise, Color skin, Color black, Color shirt, Color white, Color line) {
        int[] xpoints;
        int[] ypoints;
        int npoints;
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
    }

    private static void drawHead(Graphics g, Color skin) {
        g.setColor(skin);
        g.fillOval(400, 200, 200, 175);  //head size: 8grid*7grid
    }

    private static void drawBodyAndJacket(Graphics g, int raise, Color jacket, Graphics2D graphics2D) {
        g.setColor(jacket);
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
    }

}
