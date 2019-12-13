import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

class BackgroundControl {
    static ArrayList<Petal> petals = new ArrayList<>();

    static void drawBackground(Graphics g) {
        g.setColor(new Color(126, 200, 80));
        g.fillRect(0, 500, 1000, 200);
        g.setColor(Color.black);
        g.drawString("Press i for more information!", 400, 20);
        BackgroundControl.drawShu(g, 30, 500);
        BackgroundControl.drawShu(g, 600, 500);
    }

    static void showFPS(long frameNum, int x, int y, Graphics g) {
        g.setColor(Color.black);
        g.drawString((getFramesPerSecond(frameNum)) + " FPS", x, y);
    }

    private static long timeSinceProgramStarted() {
        return System.currentTimeMillis() - Main.programStartTime;
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
        g.setColor(new Color(180, 79, 27));
        ((Graphics2D) g).fill(tree);

        g.setColor(Color.pink);
        g.fillOval(initialX - 100, initialY - 500, 350, 350);
    }
}

class Petal {
    private int initialX, initialY;
    private int iterations;

    void setRandPos() {
        iterations = 0;
        initialY = 0;
        initialX = (int) (Math.random() * 800 + 100);
    }

    boolean isInRange() {
        return initialY + iterations <= 490;
    }

    Petal(int iX, int iY) {
        initialX = iX;
        initialY = iY;
    }

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