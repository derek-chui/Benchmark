import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.awt.*;
import javax.swing.*;
// import javax.swing.event.*;

public class myFrame extends JFrame implements ActionListener, KeyListener, MouseListener
{
    JButton button;
    JTextField textField;
    JCheckBox checkBox;
    JRadioButton button1;
    JRadioButton button2;
    JComboBox comboBox;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu editMenu;
    JMenuItem saveItem;
    JMenuItem exitItem;
    JButton select;
    JButton choose;
    JLabel label;
    JLabel box;
    dragPanel dragPanel = new dragPanel();
    myPanel panel;

    myFrame()
    {
        // this.setTitle("JFrame Title");
        // this.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE)); //can also hide or do nothing on close
        // this.setResizable(false);
        // this.setSize(420,420);
        // this.setVisible(true);
        // ImageIcon image = new ImageIcon("mike.jpg");
        // this.setIconImage(image.getImage());
        // this.getContentPane().setBackground(new Color(111,52,230)); //or hex 0x123456
        // ImageIcon icon = new ImageIcon("mike.jpg");
        
        // button = new JButton();
        // button.setBounds(200, 100, 250, 100);
        // button.setText("boo");
        // button.setFocusable(false);
        // button.addActionListener(e -> System.out.println("boo")); //actionPerform not needed after this
        // // button.setIcon(icon); //can also set icon position, font, gap, color, etc.
        // button.setForeground(Color.lightGray);
        // button.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        // // button.setEnabled(false);

        // this.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        // this.setLayout(null);
        // this.setSize(500,500);
        // this.setVisible(true);
        // this.add(button);
        
        // this.add(dragPanel);
        panel = new myPanel();

        //textfield
        // this.setTitle("drag and drop");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setSize(500,500);
        // this.setLocationRelativeTo(null);
        // this.setLayout(null);
        // this.setLayout(new FlowLayout());

        button = new JButton("Submit");
        button.addActionListener(this);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250,40));

        //checkbox
        checkBox = new JCheckBox();
        checkBox.setText("checkbox");
        checkBox.setFocusable(false);
        //can also change box with image

        button1 = new JRadioButton("button 1");
        button2 = new JRadioButton("button 2");
        //add buttons to group so only one button selectable at a time
        ButtonGroup group = new ButtonGroup();
        group.add(button1);
        group.add(button2);
        button1.addActionListener(this);
        button2.addActionListener(this);
        //can also change button with image

        //must pass reference data types
        String[] options = {"option 1", "option 2"};
        comboBox = new JComboBox(options);
        comboBox.addActionListener(this);
        comboBox.setEditable(true);
        //getItemCount(), addItem("text"), insertItemAt("text", 2)
        //setSelectedIndex(0), .removeItem("text"), .removeItemAt(0), .removeAllItems()

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);
        fileMenu.setMnemonic(KeyEvent.VK_F); //ctrl+opt+f
        editMenu.setMnemonic(KeyEvent.VK_E); //ctrl+opt+e
        saveItem.setMnemonic(KeyEvent.VK_S); //s
        exitItem.setMnemonic(KeyEvent.VK_E); //e
        // fileMenu.add(saveItem);
        // fileMenu.add(exitItem);
        // menuBar.add(fileMenu);
        // menuBar.add(editMenu);
        // this.setJMenuBar(menuBar); //can also add icons to menu

        select = new JButton("select");
        select.addActionListener(this);

        choose = new JButton("pick color");
        choose.addActionListener(this);
        label = new JLabel();
        label.setBackground(Color.white);
        label.setText("text");
        label.setFont(new Font("MV Boli", Font.PLAIN, 100));
        label.setOpaque(true);
        //can replace label with image

        this.addKeyListener(this);
        box = new JLabel();
        box.setBounds(0,0,100,100);
        box.setBackground(Color.red);
        box.setOpaque(true);
        box.addMouseListener(this); //if it's this. then applies to entire frame

        // this.add(button);
        // this.add(textField);
        // this.add(checkBox);
        // this.add(button1);
        // this.add(button2);
        // this.add(comboBox);
        // this.add(select);
        // this.add(choose);
        // this.add(label);
        // this.add(label);
        // this.add(box);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        //can also customize as shown before
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // if(e.getSource()==button)
        // {
        //     // System.out.println("boo");
        //     // button.setEnabled(false); //add here to enable button once
        //     // //or set a label to be visible after one click by label.setVisible(true);
        //     // System.out.println("Hello " + textField.getText());
        //     System.out.println(checkBox.isSelected());
        // }
        // if(e.getSource()==button1)
        // {
        //     System.out.println("button 1 pressed");
        // }
        // else if(e.getSource()==button2)
        // {
        //     System.out.println("button 2 pressed");
        // }
        // if(e.getSource()==comboBox)
        // {
        //     System.out.println(comboBox.getSelectedItem()); //can be index as well
        // }
        // if(e.getSource()==saveItem)
        // {
        //     System.out.println("file saved"); //can be index as well
        // }
        // if(e.getSource()==exitItem)
        // {
        //     System.exit(0);
        // }
        // if(e.getSource()==select)
        // {
        //     JFileChooser fileChooser = new JFileChooser();
        //     fileChooser.setCurrentDirectory(new File(/*add file path */"."));
        //     // int response = fileChooser.showOpenDialog(null);
        //     int response = fileChooser.showSaveDialog(null); 
        //     if (response == JFileChooser.APPROVE_OPTION)
        //     {
        //         File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
        //         System.out.println(file);
        //     }
        // }
        // if(e.getSource()==choose)
        // {
        //     JColorChooser colorChooser = new JColorChooser();
        //     Color color = JColorChooser.showDialog(null, "pick color", Color.black);
        //     label.setForeground(color);
        // }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        switch(e.getKeyChar())
        {
            case 'w':
                box.setLocation(box.getX(), box.getY() - 10);
                break;
            case 'a':
                box.setLocation(box.getX() - 10, box.getY());
                break;
            case 's':
                box.setLocation(box.getX(), box.getY() + 10);
                break;
            case 'd':
                box.setLocation(box.getX() + 10, box.getY());
                break;
        }
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case 37:
                box.setLocation(box.getX() - 10, box.getY());
                break;
            case 38:
                box.setLocation(box.getX(), box.getY() - 10);
                break;
            case 39:
                box.setLocation(box.getX() + 10, box.getY());
                break;
            case 40:
                box.setLocation(box.getX(), box.getY() + 10);
                break;
        }
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        // System.out.println("key released: " + e.getKeyChar()); //or getKeyCode
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        System.out.println("mouse clicked");
        box.setBackground(Color.yellow);
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }
}
