package Personal.Projects.Benchmark.learnJava;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;


public class slider implements ChangeListener
{
    JFrame frame;
    JPanel panel;
    JLabel label;
    JSlider controls;

    slider()
    {
        frame = new JFrame("controls");
        panel = new JPanel();
        label = new JLabel();
        controls = new JSlider(0, 100, 50);

        controls.setPreferredSize(new Dimension(400, 200));
        controls.setPaintTicks(true);
        controls.setMinorTickSpacing(10);
        controls.setPaintTrack(true);
        controls.setMajorTickSpacing(25);
        controls.setPaintLabels(true);
        controls.setOrientation(SwingConstants.VERTICAL); //or horizontal
        label.setText("C = " + controls.getValue());
        controls.addChangeListener(this);
        panel.add(controls);
        panel.add(label);
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
    @Override
    public void stateChanged(ChangeEvent e)
    {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'stateChanged'");
        label.setText("C = " + controls.getValue());
    }
    
}
