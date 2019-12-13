import java.awt.*;

public class ParticleManager {
    public static void drawFrame(Graphics g){
        petalCallPerFrame(g);
    }

    public static void petalCallPerFrame(Graphics g){
        for (Petal x :
                BackgroundControl.petals) {
            if(x.isInRange())
                x.move(g);
            else
                x.setRandPos();
        }
    }
}
