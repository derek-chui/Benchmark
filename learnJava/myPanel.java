import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class myPanel extends JPanel implements ActionListener
{
    Image image;
    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    Image mike;
    Timer timer;
    int xVel = 2;
    int yVel = 1;
    int x = 0;
    int y = 0;

    myPanel()
    {
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setBackground(Color.black);
        mike = new ImageIcon("mike.jpg").getImage();
        timer = new Timer(10, this);
        timer.start();
        // image = new ImageIcon("mike.jpg").getImage();
        // this.setPreferredSize(new Dimension(500,500));
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        // g2D.setPaint(Color.blue);
        // g2D.setStroke(new BasicStroke(5));
        // g2D.drawLine(0,0,500,500);
        // g2D.drawRect(0,0,100,200);
        // g2D.fillRect(0,0,100,200);
        // g2D.drawOval(0,0,100,100); //or fillOval
        // g2D.setPaint(Color.red);
        // g2D.fillArc(0,0,100,100,0,180);
        // g2D.setPaint(Color.green);
        // g2D.fillArc(0,0,100,100,180,180);
        // int[] xPoints = {150,250,350};
        // int[] yPoints = {300,150,300};
        // g2D.drawPolygon(xPoints, yPoints, 3);
        // g2D.setPaint(Color.darkGray);
        // g2D.drawString("string", 50, 50);
        // g2D.drawImage(image,0,0,null);
        g2D.drawImage(mike,x,y,null); 
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // if(x >= PANEL_WIDTH - mike.getWidth(null) || x < 0)
        // {
        //     xVel = xVel * -1;
        // }
        x = x + xVel;
        // if(y >= PANEL_HEIGHT - mike.getHeight(null) || y < 0)
        // {
        //     yVel = yVel * -1;
        // }
        // y = y + yVel;
        repaint();
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
