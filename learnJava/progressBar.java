package Personal.Projects.Benchmark.learnJava;
// import java.awt.*;
import javax.swing.*;

public class progressBar
{
    JFrame frame = new JFrame();
    JProgressBar loading = new JProgressBar();

    progressBar()
    {
        loading.setValue(0);
        loading.setBounds(0, 0, 500, 50);
        loading.setStringPainted(true);
        frame.add(loading);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);

        load();
    }

    public void load()
    {
        int counter = 0;
        while (counter <= 100)
        {
            loading.setValue(counter);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            counter += 1;
        }
        loading.setString("complete");
    }
}
