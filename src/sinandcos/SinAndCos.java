
package sinandcos;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Olcay
 */
public class SinAndCos extends JFrame {
    
    public static final int frameWidth = 440;
    public static final int frameHeight = 440;
    
    public static final int xAxisStartX = 20;
    public static final int xAxisStartY = frameHeight/2;
    
    public static final int xAxisStopX = frameWidth-20;
    public static final int xAxisStopY = frameHeight/2;
    
    public static final int yAxisStartX = frameWidth/2;
    public static final int yAxisStartY = 20;
    
    public static final int yAxisStopX = frameWidth/2;
    public static final int yAxisStopY = frameHeight-20;
    
    class DrawSine extends JPanel {

        double getSinValue(double x) {
            return Math.sin(x);
        }

        double getCosValue(double y) {
            return Math.cos(y);
        }
        
        double getLogValue(double x){
            return Math.log(x);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            g.setColor(Color.black);
            
            // draw x axis
            g.drawLine(xAxisStartX, xAxisStartY, xAxisStopX, xAxisStopY);
            
            // draw y axis
            g.drawLine(yAxisStartX, yAxisStartY, yAxisStopX, yAxisStopY);

            // draw arrow for x axis
            g.drawLine(frameWidth-20, frameHeight/2, frameWidth-30, frameHeight/2-10);
            g.drawLine(frameWidth-20, frameHeight/2, frameWidth-30, frameHeight/2+10);
            
            // draw arrow for y axis
            g.drawLine(frameWidth/2, 20, frameWidth/2-10, 30);
            g.drawLine(frameWidth/2, 20, frameWidth/2+10, 30);

            // draw axis names
            g.drawString("X", frameWidth-40, frameHeight/2+20);
            g.drawString("Y", frameWidth/2+20, 40);

            Polygon sinPol = new Polygon();
            Polygon cosPol = new Polygon();
            Polygon logPol = new Polygon();

            for (int x = -180; x <= 180; x++) {
                sinPol.addPoint(x + frameWidth/2, frameHeight/2 - (int)(50 * getSinValue((x / 100.0) * 2 * Math.PI)));
            }

            for (int x = -180; x <= 180; x++) {
                cosPol.addPoint(x + frameWidth/2, frameHeight/2 - (int)(50 * getCosValue((x / 100.0) * 2 * Math.PI)));
            }
            
            for (int x = 0; x <= 500; x++) {
                logPol.addPoint(x + frameWidth/2, frameHeight/2 - (int)getLogValue(x));
            }

            g.setColor(Color.red);
            g.drawPolyline(sinPol.xpoints, sinPol.ypoints, sinPol.npoints);
            g.drawString("\u03c0",   frameWidth/2-50,  frameHeight/2+15);
            g.drawString("-2\u03c0", frameWidth/2-100, frameHeight/2+15);
            g.drawString("\u03c0",   frameWidth/2+50,  frameHeight/2+15);
            g.drawString("2\u03c0",  frameWidth/2+100, frameHeight/2+15);
            g.drawString("0",        frameWidth/2,     frameHeight/2+15);

            g.setColor(Color.blue);
            g.drawPolyline(cosPol.xpoints, cosPol.ypoints, cosPol.npoints);
            
            g.setColor(Color.BLACK);
            //g.drawPolyline(logPol.xpoints, logPol.ypoints, logPol.npoints);
        }
    }

    /**
     * Constructor.
     */
    public SinAndCos() {
        setLayout(new BorderLayout());
        add(new SinAndCos.DrawSine(), BorderLayout.CENTER);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SinAndCos frame = new SinAndCos();
        
        frame.setSize(frameWidth+20, frameHeight+40);
        frame.setTitle("SinAndCos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
