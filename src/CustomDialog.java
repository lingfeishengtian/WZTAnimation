import java.awt.*;

public class CustomDialog {
    String title, body;

    public CustomDialog(String title, String body) {
        this.title = title;
        this.body = body;
    }

    //Dialog will always be in the center
    public void drawDialog(Graphics g, int widOfScreen, int heiOfScreen){
        g.setColor(Color.white);
        int widthOfDialog = 200;
        int heightOfDialog = 500;
        g.fillRoundRect(widOfScreen / 2 - widOfScreen / 2, heightOfDialog / 2 - heightOfDialog / 2, widthOfDialog, heightOfDialog, 20, 20);
        g.setColor(Color.black);
    }
}
