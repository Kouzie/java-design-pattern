package command;

import java.awt.*;

public class DrawCanvas extends Canvas implements Drawable {

    private Color color = Color.red;
    private int radius = 6;
    private MacroCommand history; //canvas 에 적영해두었던 Command 모음집

    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
    }

    public void print(Graphics g) {
        history.execute();
    }


    @Override
    public void draw(int x, int y) {
        // x,y 위치에 2 by 2 크기의 점을 찍음.
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
