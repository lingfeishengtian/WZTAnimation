import java.awt.*;

class CustomDialog {
    private String title, body;

    CustomDialog(String title, String body) {
        this.title = title;
        this.body = body;
    }

    //Dialog will always be in the center
    void drawDialog(Graphics g, int widOfScreen, int heiOfScreen) {
        g.setColor(Color.white);
        int widthOfDialog = 500;
        int heightOfDialog = 500;
        int xPos = widOfScreen / 2 - widthOfDialog / 2;
        int yPos = heiOfScreen / 2 - heightOfDialog / 2;
        g.fillRoundRect(xPos, yPos, widthOfDialog, heightOfDialog, 20, 20);
        g.setColor(Color.black);
        g.drawRoundRect(widOfScreen / 2 - widthOfDialog / 2, heiOfScreen / 2 - heightOfDialog / 2, widthOfDialog, heightOfDialog, 20, 20);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 50));

        int stringWid = g.getFontMetrics().stringWidth(title);
        g.drawString(title, xPos + stringWid / 2, yPos + stringWid / 3);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        String[] splitByNewLines = body.split("\n");
        for (int i = 0; i < splitByNewLines.length; i++) {
            g.drawString(splitByNewLines[i], xPos + 20, yPos + stringWid / 3 + 70 + i * 25);
        }
    }
}
