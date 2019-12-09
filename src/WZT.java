import java.awt.*;
import java.awt.geom.GeneralPath;

public class WZT {
    public static void drawWZT(Graphics g)
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
        GeneralPath ribbonl = new GeneralPath();  //ribbon left
        ribbonl.moveTo(375, 375);
        ribbonl.lineTo(375, 500);
        ribbonl.curveTo(375, 500, 363, 563, 325, 625);
        ribbonl.lineTo(338, 650);
        ribbonl.curveTo(338, 650, 388, 563, 400, 500);
        ribbonl.lineTo(400, 375);
        ribbonl.lineTo(375, 375);
        ribbonl.closePath();
        graphics2D.setColor(line);
        graphics2D.fill(ribbonl);

        GeneralPath ribbonr = new GeneralPath();  //ribbon right
        ribbonr.moveTo(625, 375);
        ribbonr.lineTo(625, 500);
        ribbonr.curveTo(625, 500, 638, 563, 675, 625);
        ribbonr.lineTo(662, 650);
        ribbonr.curveTo(662, 650, 612, 563, 600, 500);
        ribbonr.lineTo(600, 375);
        ribbonr.lineTo(625, 375);
        ribbonr.closePath();
        graphics2D.setColor(line);
        graphics2D.fill(ribbonr);

        //hair
//        GeneralPath hair = new GeneralPath();  //ribbon right
//        hair.moveTo(538, 237);
//        hair.curveTo(538, 237, 560, 275, 588, 287);
//        hair.curveTo(588, 287, 583, 308, 575, 313);
//        hair.curveTo(575, 313, 600, 310, 613, 287);
//        hair.curveTo(613, 287, 500, 200, 400, 300);
//        hair.curveTo(400, 300, 387, 325, 400, 350);
//        hair.curveTo(400, 350, 383, 363, 400, 375);
//        hair.curveTo(400, 375, 413, 380, 425, 375);
//
//
//        hair.curveTo(662, 650, 612, 563, 600, 500);
//        hair.curveTo(625, 500, 638, 563, 675, 625);
//        hair.curveTo(662, 650, 612, 563, 600, 500);
//        hair.closePath();
//        graphics2D.setColor(black);
//        graphics2D.fill(hair);

	/*	g.drawOval(325,120,20,20);   //left eyes
		g.fillOval(330,130,10,10);
		g.drawOval(355,120,20,20);   //right eye
		g.fillOval(360,130,10,10);

		g.setColor(Color.RED);		  // mouth
		g.drawArc(335,140,30,40,0,-180);


		//hair
		g.setColor(Color.MAGENTA);
		g.drawLine(350,100,350,50);
		g.drawLine(350,100,340,50);
		g.drawLine(350  ,100,330  ,50);
		g.drawLine(350  ,100,320  ,50);
		g.drawLine(350  ,100,310  ,50);
		g.drawLine(350  ,100,360  ,50);
		g.drawLine(350  ,100,370  ,50);
		g.drawLine(350  ,100,380  ,50);
		g.drawLine(350  ,100,390  ,50);

		//skirt
		//xpoints = new int[] {425, 575, 650, 575, 425, 350,425};
    	//ypoints = new int[]{475, 475, 650, 675, 675, 650, 475};
    	//npoints = 6;
    	//g.fillPolygon(xpoints, ypoints, npoints);

		// neck
		g.setColor(Color.BLACK);
		g.drawRect(340  ,200,20,25);

		//body
		g.setColor(Color.YELLOW);
		g.fillRect(300  ,210,100,180);

		// left arm
		g.setColor(Color.BLUE);
		g.fillRect(250  ,210,50,90);
		g.setColor(Color.WHITE);
		g.fillRect(275  ,230,25,50);

		// right arm
		g.setColor(Color.BLUE);
		g.fillRect(400  ,210,50,90);
		g.setColor(Color.WHITE);
		g.fillRect(400  ,230,25,50);

		//buttons
		g.setColor(Color.RED);
		g.fillOval(345  ,220,10,10);
		g.fillOval(345  ,240,10,10);
		g.fillOval(345  ,260,10,10);

		//legs
		g.setColor(Color.BLACK);
		g.fillRect(320  ,390,30,80);
		g.fillRect(360  ,390,30,80);

		//shoes
		g.setColor(Color.BLUE);
		g.fillRect(300  ,470,50,20);
		g.fillRect(360  ,470,50,20);

		// name
		g.setFont(new Font ("Arial", Font.BOLD, 20));
		g.drawString("WZT", 200  ,100);

		g.setColor(Color.BLACK);

		Polygon s = new Polygon();
    for (int i = 0; i < 360; i++) {
      double t = i / 360.0;
      s.addPoint((int) (150 + 50 * t * Math.cos(8 * t * Math.PI)),
          (int) (150 + 50 * t * Math.sin(8 * t * Math.PI)));
    }
    g.drawPolygon(s);*/
    /* int radius = 40;
    int centerX = 50;
    int centerY = 100;
    int angle = 30;

    int dx = (int) (radius * Math.cos(angle * Math.PI / 180));
    int dy = (int) (radius * Math.sin(angle * Math.PI / 180));

    g.fillArc(centerX - radius, centerY - radius, 2 * radius, 2 * radius, angle, 360 - 2 * angle);

    GeneralPath ribbon = new GeneralPath();  //flapped ribbon
    	ribbon.moveTo(375, 375);
    	ribbon.lineTo(375, 500);
    	ribbon.curveTo(375, 500, 363, 563, 325, 625);
    	ribbon.lineTo(338, 650);
    	ribbon.curveTo(350, 500, 388, 563, 400, 500);  //ribbon
    	ribbon.lineTo(400, 375);
    	ribbon.lineTo(375, 375);
    	ribbon.closePath();
    	graphics2D.setColor(line);
    	graphics2D.fill(ribbon);
    */
    }

}
