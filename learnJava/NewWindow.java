package Personal.Projects.Benchmark.learnJava;
import java.awt.*;
import javax.swing.*;

public class NewWindow
{
    JFrame frame = new JFrame();
    JLabel label = new JLabel("text");

    NewWindow()
    {
        label.setBounds(0,0,100,50);
        label.setFont(new Font(null, Font.PLAIN, 25));

        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);  
    }
}
