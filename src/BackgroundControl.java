import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

class BackgroundControl {
    static ArrayList<Petal> petals = new ArrayList<>();

    /**
     * Draw the background
     * @param g Graphics
     */
    static void drawBackground(Graphics g) {
        g.setColor(new Color(22, 73, 11));
        g.fillRect(0, 500, 1000, 200);
        g.setColor(Color.black);
        g.drawString("Press i for more information!", 400, 20);
        BackgroundControl.drawShu(g, 30, 500);
        BackgroundControl.drawShu(g, 600, 500);
        BackgroundControl.drawDeco(g, -400, -300);
    }

    public static void drawDeco(Graphics g, int x, int y)
    {
        Color flower = new Color (255,128,170);
        Color petal = new Color (255,102,153);
        Color stem = new Color (0,204,0);
        Color leaf = new Color (0,190,0);

        //extra colors
        Color c1 = new Color (248, 139, 148);
        Color c2 = new Color (231, 123, 159);
        Color c3 = new Color (226, 92, 131);
        Color c4 = new Color (247, 199, 191);
        Color c5 = new Color (251, 171, 175);
        Color c6 = new Color (194, 32, 71);
        Color c7 = new Color (235, 99, 104);
        Color c8 = new Color (166, 65, 86);
        Color c9 = new Color (229, 72, 72);
        Color c10 = new Color (206, 49, 61);
        Color c11 = new Color (178, 36, 60);
        Color c12 = new Color (255, 155, 0);
        Color c13 = new Color (125, 203, 204);
        Color c14 = new Color (194, 180, 225);
        Color c15 = new Color (220, 68, 115);

        //flower
        g.setColor(leaf);
        g.fillOval(716 + x,608 + y,20,10);
        g.fillOval(688 + x,608 + y,20,10);
        g.setColor(stem);
        g.fillRect(708 + x,600 + y,8,50);
        g.setColor(petal);
        g.fillOval(695 + x,570 + y,15,15);
        g.fillOval(705 + x,565 + y,15,15);
        g.fillOval(715 + x,570 + y,15,15);
        g.fillOval(718 + x,580 + y,15,15);
        g.fillOval(715 + x,590 + y,15,15);
        g.fillOval(705 + x,595 + y,15,15);
        g.fillOval(695 + x,590 + y,15,15);
        g.fillOval(690 + x,580 + y,15,15);
        g.setColor(flower);
        g.fillOval(700 + x,575 + y,25,25);
    }

    /**
     * Get the frames per second!
     * @param frameNum Number of frames passed
     * @param x Starting position to be shown
     * @param y Starting position to be shown
     * @param g Graphics
     */
    static void showFPS(long frameNum, int x, int y, Graphics g) {
        g.setColor(Color.black);
        g.drawString((getFramesPerSecond(frameNum)) + " FPS", x, y);
    }

    private static long timeSinceProgramStarted() {
        return System.currentTimeMillis() - WuZeTian.programStartTime;
    }

    private static long getFramesPerSecond(long frameNum) {
        if ((timeSinceProgramStarted() / 1000) > 0)
            return (frameNum) / (timeSinceProgramStarted() / 1000);
        else return 0;
    }

    /**
     * 画一个美丽的桃花树！！！！！！！
     * 景色！！！！
     *
     * @param g        Graphics
     * @param initialX Bottom Left corner of bark
     * @param initialY Also bottom left corner of bark
     */
    private static void drawShu(Graphics g, int initialX, int initialY) {
        GeneralPath tree = new GeneralPath();
        tree.moveTo(initialX, initialY);
        tree.curveTo(initialX, initialY, initialX + 20, initialY - 100, initialX, initialY - 200);
        tree.curveTo(initialX, initialY - 200, initialX + 25, initialY - 180, initialX + 100, initialY - 200);
        tree.curveTo(initialX + 100, initialY - 200, initialX + 100 - 20, initialY - 100, initialX + 100, initialY);
        tree.closePath();
        g.setColor(new Color(105, 59, 35));
        ((Graphics2D) g).fill(tree);

        g.setColor(Color.pink);
        g.fillOval(initialX - 100, initialY - 500, 350, 350);
    }
}

/**
 * A leaf that falls from the sky! Activated with + and -.
 * This class helps you store and manage all the petals falling from the sky.
 */
class Petal {
    private int initialX, initialY;
    private int iterations;

    /**
     * Resets the position of the petal to the top and random X position within bounds.
     */
    void setRandPos() {
        iterations = 0;
        initialY = 0;
        initialX = (int) (Math.random() * 800 + 100);
    }

    /**
     * checks to see if petal is in range
     * @return is petal out of the screen????
     */
    boolean isInRange() {
        return initialY + iterations <= 490;
    }

    Petal(int iX, int iY) {
        initialX = iX;
        initialY = iY;
    }

    /**
     * Move the petal to a new location based on a damped Sinusoidal function
     * @param g Graphics
     */
    void move(Graphics g) {
        double newX = 90 * Math.pow(Math.E, -0.01 * iterations) * Math.cos((Math.PI / 50) * iterations) + initialX;
        double newY = initialY + iterations;

        iterations++;
        drawPetal((int) newX, (int) newY, g);
    }

   private void drawPetal(int startX, int startY, Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        GeneralPath petal = new GeneralPath();
        petal.moveTo(startX, startY);

        petal.curveTo(startX, startY, startX + 10, startY - 10, startX + 20, startY);
        petal.curveTo(startX + 20, startY, startX + 10, startY + 10, startX, startY);

        petal.closePath();
        graphics2D.setColor(new Color(244, 121, 131));
        graphics2D.fill(petal);
    }
}