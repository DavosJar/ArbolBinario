package GUI;


import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class Line extends JPanel {
    private int x1, y1, x2, y2;

    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        setOpaque(false); // Hacer que el fondo sea transparente
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawLine(x1, y1, x2, y2);
    }
}