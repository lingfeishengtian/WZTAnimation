import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.TimerTask;

class Main {
    static final long programStartTime = System.currentTimeMillis();

    public static void main(String[] args) {
        JFrame frame = new FrameDrawing();
        frame.setSize(1000, 700);
        frame.setVisible(true);
        AudioManager.playBGM();
        AudioManager.playBreeze();
    }
}

class FrameDrawing extends JFrame {
    FrameDrawing() {
        WZTCanvas cd = new WZTCanvas();
        cd.setSize(1000, 700);
        cd.setBackground(new Color(113, 170, 230));
        add(cd);

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(e -> {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                cd.keyPressed(e);
            }
            return false;
        });

        cd.addMouseListener(new MouseAdapter() {
            java.util.Timer timer = new java.util.Timer();

            @Override
            public void mousePressed(MouseEvent e) {
                timer = new java.util.Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        cd.mousePressed(e);
                    }
                }, 0, 10);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                timer.cancel();
                cd.mouseReleased(e);
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                System.exit(0);
            }
        });

        ActionListener action = e -> cd.repaint();

        Timer t = new Timer(5, action);
        t.setRepeats(true);
        t.setInitialDelay(0);
        t.start();
        cd.t = t;
    }
}

class WZTCanvas extends Canvas {
    Timer t;
    private BufferedImage bf = new BufferedImage(1000, 700,
            BufferedImage.TYPE_INT_RGB);
    private long frameNum = 0;
    private int speedIntensity = 100;
    private int raise = 0;
    private boolean renderDialogue = false;
    private CustomDialog customDialog = new CustomDialog("Information", "To get started, you must know the basics.\n\nTo add more leaves, press + on your keyboard\n(without shift) and to subtract leaves, press -.\n\nTo stop music, press 's', and to continue, press 'a'.\n\n'q' and 'w' does sp00ciel stuff.\n\nClick and hold on the mouse to move the empress'\nsleeves.\n\nPress i to close and open this menu.");

    WZTCanvas() {
        setGraphicsProperties((Graphics2D) bf.getGraphics());
    }

    void mouseReleased(MouseEvent e) {
        slowyPullDown();
    }

    private void slowyPullDown() {
        t.stop();
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (raise > 0) raise -= 1;
                else timer.cancel();
            }
        }, 0, 10);
        t.start();
    }

    void mousePressed(MouseEvent e) {
        if (raise < 20) raise += 1;
    }

    void keyPressed(KeyEvent e) {
        ArrayList<Petal> petals = BackgroundControl.petals;
        if (e.getKeyChar() == '=') {
            petals.add(new Petal((int) (Math.random() * 800 + 100), (int) (Math.random() * 200 + 0)));
        } else if (e.getKeyChar() == '-') {
            if (!petals.isEmpty())
                petals.remove(BackgroundControl.petals.size() - 1);
        } else if (e.getKeyChar() == 'w') {
            speedIntensity += 1;
            if (speedIntensity > 1000) speedIntensity = 1000;
        } else if (e.getKeyChar() == 'q') {
            speedIntensity -= 1;
            if (speedIntensity < 1) speedIntensity = 1;
        } else if (e.getKeyChar() == 'i') {
            renderDialogue = !renderDialogue;
        } else if (e.getKeyChar() == 'a') {
            if (!AudioManager.isBGMOn()) AudioManager.continueBGM();
        } else if (e.getKeyChar() == 's') {
            AudioManager.stopBGM();
        }
    }

    private void animate(Graphics g) {
        frameNum++;
        ((Graphics2D) g).scale(getWidth() / 1000.0, getHeight() / 700.0);
        reset(g);
        BackgroundControl.drawBackground(g);
        BackgroundControl.showFPS(frameNum, 10, 10, g);
        ParticleManager.drawFrame(g);
        WZT.drawWZT(g, frameNum, speedIntensity, raise);
        if (renderDialogue) {
            customDialog.drawDialog(g, 1000, 700);
        }
    }

    private void setGraphicsProperties(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
    }

    private void reset(Graphics g) {
        g.setColor(new Color(113, 170, 230));
        g.fillRect(0, 0, 1000, 700);
    }

    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        bf = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        animate(bf.getGraphics());
        g.drawImage(bf, 0, 0, null);
    }
}