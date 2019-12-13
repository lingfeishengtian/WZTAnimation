import java.awt.*;

class ParticleManager {
    static void drawFrame(Graphics g) {
        petalCallPerFrame(g);
    }

    private static void petalCallPerFrame(Graphics g) {
        for (Petal x :
                BackgroundControl.petals) {
            if (x.isInRange())
                x.move(g);
            else
                x.setRandPos();
        }
    }
}
