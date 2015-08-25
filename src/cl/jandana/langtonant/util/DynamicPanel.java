package cl.jandana.langtonant.util;

import cl.jandana.langtonant.logic.Board;
import cl.jandana.langtonant.logic.Node;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Javier
 */
public class DynamicPanel extends JPanel {

    private BufferedImage img = null;
    Font arialFont = new Font("Arial", Font.BOLD, 12);
    Board matriz;

    public DynamicPanel() {

    }

    @Override
    public void paint(Graphics g) {
        if (img == null) {
            super.paint(g);
        } else {
            g.drawImage(img, 0, 0, this);
        }
    }

    public void render(Board matriz, int x, int y) {
        float columnas = (float) getWidth() / (float) matriz.getColumnas();
        float filas = (float) getHeight() / (float) matriz.getFilas();
        float r, g, b;
        Graphics2D g2 = img.createGraphics();
        r = (float) ((Double) matriz.getNodo(x, y).getVector().elementAt(0)).doubleValue();
        g = (float) ((Double) matriz.getNodo(x, y).getVector().elementAt(1)).doubleValue();
        b = (float) ((Double) matriz.getNodo(x, y).getVector().elementAt(2)).doubleValue();
        g2.setColor(new Color(r, g, b));
        g2.fillRect((int) (x * columnas), (int) (y * filas),
                (int) columnas, (int) filas);
        //borde negro
        g2.setColor(Color.black);
        g2.drawRect((int) (x * columnas), (int) (y * filas),
                (int) columnas, (int) filas);
        repaint();
    }

    public BufferedImage getImagen() {
        if (img == null) {
            img = (BufferedImage) createImage(getWidth(), getHeight());
        }
        return img;
    }

    public void init(Board board) {
        float columnas = (float) getWidth() / (float) board.getColumnas();
        float filas = (float) getHeight() / (float) board.getFilas();
        float r, g, b;
        Graphics2D g2 = img.createGraphics();
        for (int x = 0; x < board.getColumnas(); x++) {
            for (int y = 0; y < board.getFilas(); y++) {
                r = (float) ((Double) board.getNodo(x, y).getVector().elementAt(0)).doubleValue();
                g = (float) ((Double) board.getNodo(x, y).getVector().elementAt(1)).doubleValue();
                b = (float) ((Double) board.getNodo(x, y).getVector().elementAt(2)).doubleValue();
                g2.setColor(new Color(r, g, b));
                g2.fillRect((int) (x * columnas), (int) (y * filas),
                        (int) columnas, (int) filas);
                //borde negro
                g2.setColor(Color.black);
                g2.drawRect((int) (x * columnas), (int) (y * filas),
                        (int) columnas, (int) filas);
            }
        }
        repaint();
    }

}
