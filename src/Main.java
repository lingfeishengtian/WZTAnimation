import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
            JFrame frame = new FrameDrawing();
            frame.setSize(1000, 700);
            frame.setVisible(true);
    }
}

class FrameDrawing extends JFrame{
    public FrameDrawing(){
        WZTCanvas cd = new WZTCanvas();
        cd.setSize(1000, 700);
        cd.setBackground(new Color(113, 170, 230));
        add(cd);

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if(e.getID() == KeyEvent.KEY_PRESSED){
                    cd.keyPressed(e);
                }
                return false;
            }
        });
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent arg0) {
                System.exit(0);
            }

        });

        ActionListener action = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cd.repaint();
            }
        };

        Timer t = new Timer(5, action);
        t.setRepeats(true);
        t.setInitialDelay(0);
        t.start();
    }
}

class WZTCanvas extends Canvas{
    BufferedImage bf = new BufferedImage( 1000, 700,
            BufferedImage.TYPE_INT_RGB);

    public void keyPressed(KeyEvent e){
        ArrayList<Petal> petals = BackgroundControl.petals;
        if(e.getKeyChar() == '='){
            petals.add(new Petal((int) (Math.random() * 800 + 100), (int) (Math.random() * 200 + 0)));
        }else if(e.getKeyChar() == '-'){
            if(!petals.isEmpty())
                petals.remove(BackgroundControl.petals.size() - 1);
        }else if(e.getKeyChar() == 'i'){

        }
    }

//    @Override
//    public void repaint() {
//        //update(getGraphics());
//        //paint(getGraphics());
//        super.repaint();
//    }

    public void animate(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g.setColor(new Color(113, 170, 230));
        g.fillRect(0,0,1000,700);
        BackgroundControl.drawBackground(g);
        BackgroundControl.drawShu(g, 30, 500);
        ParticleManager.drawFrame(g);
        WZT.drawWZT(g);
    }

    @Override
    public void paint(Graphics g) {
        animate(bf.getGraphics());
        g.drawImage(bf,0, 0,null);
    }
}