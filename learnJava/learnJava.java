package Personal.Projects.Benchmark.learnJava;
// import java.util.Scanner;
// import javax.swing.JOptionPane;
import java.util.Random;
import java.util.*;
import java.util.ArrayList;
// import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import javax.sound.sampled.*;

// import javax.swing.*;
// import java.awt.*; 
import java.io.*;

// import tools.toolBox;

public class learnJava
{
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, ClassNotFoundException, InterruptedException
    {
        byte one = 127;
        long two = 123456789L; //f float, d double
        System.out.println("hello " + one + two);
        //swap: temp = x, x = y, y = temp
        // Scanner scanner = new Scanner(System.in);
        // String name = scanner.nextLine();
        // int age = scanner.nextInt();
        // scanner.nextLine(); //need this after nextInt to take \n
        // String country = scanner.nextLine();
        //graphical user interface, parse anything that isn't String
        // String name = JOptionPane.showInputDialog("name: ");
        // int age = Integer.parseInt(JOptionPane.showInputDialog("age: "));
        // JOptionPane.showMessageDialog(null, "Hello " + name + " age " + age);
        Random random = new Random();
        int x = random.nextInt(6)+1;
        System.out.println(x);
        //.isBlank() to check empty responses
        //use .equals() when comparing Strings .equalsIgnoreCase()
        //.length() to traverse for loop
        //charAt return char at given index
        //indexOf returns first index of given char
        //isEmpty, toUpper, toLower, .trim empty spaces, .replace(old char, new char)
        //wrapper class: primitive as reference for methods like ones listed above
        //autoboxing: conversion between prim and ref, unboxing is the opposite
        Double a = 3.14; //Character, Integer, Double, String
        a.toString();
        if (a == 3.14)
        {
            System.out.println("unboxing");
        }

        //user reference
        ArrayList<String> arrList = new ArrayList<String>();
        arrList.add("one");
        arrList.add("two");
        arrList.set(0, "first"); //.remove(1) .clear()
        for(int i = 0; i < arrList.size(); i++) //.size() for ArrayList
        {
            System.out.println(arrList.get(i));
        }
        ArrayList<ArrayList<String>> main = new ArrayList<>();
        ArrayList<String> section1 = new ArrayList<String>();
        section1.add("part 1.1");
        section1.add("part 1.2");
        ArrayList<String> section2 = new ArrayList<String>();
        section2.add("part 2.1");
        section2.add("part 2.2");
        main.add(section1);
        main.add(section2);
        System.out.println(main);
        System.out.println(main.get(0).get(0));
        //printf(): similar to C, %d %b %c %s %f
        //width before ex. %10f (- for after), precision %.2f
        //+ output +/- for numbers (%+f), 0 zero padded (%020f), comma (%,f)
        //% flags precision width type
        double myDouble = -1000;
        System.out.printf("%,+02.2f\n", myDouble);
        // final double pi = 3.14159;
        //basic java oop similar to c++ & c#, can make separate file
        profile user1 = new profile("John", 4, true);
        user1.addFriend();
        System.out.println(user1);
        //same for array of objects and object passing
        //static means class owns member, shared by all instances
        profile.symbol = 'A';
        profile.showSymbol(); // another example: Math.round(a);
        user1.verify();
        settings user1Settings = new settings("John", 4);
        user1Settings.verify();
        //public (all), protected (class, package, subclass), no modifier (class, package), private (class)
        profile user2 = new profile("James", 2, true);
        user2.copyName(user1);
        System.out.println(user2.getName());
        //abstraction: cant be instantiated, framework for subclass
        //any method, any variable, abstract implement interface, "extends" keyword
        //extend to multiple interfaces, cant have multiple extends (diamond problem), can be private, protected, etc.
        //interface & implement: one class as interface, another follows interface instructions
        //abstract method, public static final variables, can't implement abstract, "implements" keyword
        //branch to more interfaces, multiple "inheritance", final by default.
        //polymorphism: use parent or object for more than one type
        Object[] profiles = {user1, user1Settings, user2};
        for (Object objects : profiles)
        {
            System.out.println(objects);
        }
        //dyanimc: profile user3; then choose later

        try{/*divide by zero*/}
        catch(ArithmeticException e){System.out.println("can't divide by zero");}
        catch(InputMismatchException e){System.out.println("enter a number");}
        catch(Exception e){System.out.println("something went wrong");}
        finally{System.out.println("always print");} //or can close scanners -> scanner.close();
        File file = new File("message.txt"); //if elsewhere then show path: "C:/Users/John/Desktop/message.txt"
        System.out.println(file.exists()); //.getPath(); .getAbsolutePath(); .isFile(); .delete();
        try
        {
            FileWriter writer = new FileWriter("message.txt");
            writer.write("new message\n");
            writer.append("\nappended");
            writer.close();
        }
        catch(IOException e){e.printStackTrace();}
        try
        {
            FileReader reader = new FileReader("message.txt");
            int data = reader.read();
            while(data != -1)
            {
                System.out.print((char)data);
                data = reader.read();
            }
            reader.close();
        }
        catch(FileNotFoundException e){e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
        
        // Scanner scanner = new Scanner(System.in);
        File wokeUp = new File("woke up.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(wokeUp);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        // clip.start(); //.stop() .setMicrosecondPosition();
        // String response = scanner.next();

        // JFrame frame = new JFrame();
        // /*if making changes: myFrame frame =*/new myFrame();
        // ImageIcon image = new ImageIcon("mike.jpg");
        // // Border border = BorderFactory.createLineBorder(Color.green,3);
        // JLabel label = new JLabel();
        // label.setText("hello");
        // label.setIcon(image);
        // label.setHorizontalTextPosition(JLabel.CENTER); //LEFT or RIGHT works too
        // label.setVerticalTextPosition(JLabel.TOP); //TOP, CENTER, BOTTOM
        // label.setForeground(new Color(0x00FF00)); //color
        // label.setFont(new Font("MV Boli", Font.PLAIN, 20)); //color
        // label.setIconTextGap(100 ); //text above or below icon
        // label.setBackground(Color.black); //bg color
        // label.setOpaque(true); //show bg color
        // label.setVerticalAlignment(JLabel.CENTER);
        // label.setHorizontalAlignment(JLabel.CENTER);
        // // label.setBounds(100, 100, 250, 250);

        // JPanel redPanel = new JPanel();
        // redPanel.setBackground(Color.red);
        // redPanel.setBounds(0, 0, 250, 250);
        // JPanel bluePanel = new JPanel();
        // bluePanel.setBackground(Color.blue);
        // bluePanel.setBounds(250, 0, 250, 250);
        // bluePanel.setLayout(new BorderLayout()); //can add images within panel
        // //when bounds set for label will be relative to panel

        // //layered
        // JLabel label1 = new JLabel();
        // label1.setOpaque(true);
        // label1.setBackground(Color.RED);
        // label1.setBounds(50,50,200,200);
        // JLabel label2 = new JLabel();
        // label2.setOpaque(true);
        // label2.setBackground(Color.BLUE);
        // label2.setBounds(150,150,200,200);
        // JLayeredPane layeredPane = new JLayeredPane();
        // layeredPane.setBounds(0,0,500,500);
        // layeredPane.add(label1, Integer.valueOf(0)); //JLayeredPane.DEFAULT_LAYER
        // layeredPane.add(label2, Integer.valueOf(1)); //JLayeredPane.DRAG_LAYER
        //layers: Default 0, Palette, Modal, PopUp, Drag

        //to initialize frame
        // JFrame frame = new JFrame();
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(500,500);
        
        //layered pt 2
        // frame.add(layeredPane);
        // frame.setLayout(null);

        // frame.setLayout(null);
        // frame.add(label);
        // bluePanel.add(label); add label to this panel
        // frame.add(redPanel);
        // frame.add(bluePanel);
        // frame.pack();
        // new myFrame(); //for buttons

        //BorderLayout: make frame, new panel, set color, setPreferredSize(new Dimension(x,y))
        //setLayout(new BorderLayout(x,y)), frame.add(panel, BorderLayout.NORTH/SOUTH/EAST/WEST/CENTER)
        //can also add panels within panels
        // frame.setLayout(new BorderLayout(10, 10));
        // JPanel panel1 = new JPanel();
        // panel1.setBackground(Color.red);
        // panel1.setPreferredSize(new Dimension(100, 100));
        // frame.add(panel1,BorderLayout.SOUTH);

        //flow layout
        // frame.setLayout(new FlowLayout(FlowLayout.LEADING,10,10));
        // frame.add(new JButton("1"));
        // frame.add(new JButton("2")); //can also add in a panel by creating and changing frame to panel

        //grid layout
        // frame.setLayout(new GridLayout(2,2, 10, 10));
        // frame.add(new JButton("1"));
        // frame.add(new JButton("2"));

        // frame.setVisible(true);

        //new window
        // new LaunchPage();

        // String[] responses = {"1", "2", "3"};
        // JOptionPane.showMessageDialog(null, "info", "text", JOptionPane.INFORMATION_MESSAGE);
        //theres also plain, question, warning, error, and yes 0/no 1/cancel 2/exit -1 <- # when printing and store in int
        // JOptionPane.showOptionDialog(null, "info", "text", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, responses, 0);
        //change first null to an icon for custom
        //change second null to array for custom messages

        // myFrame frame = new myFrame();
        // slider control = new slider();

        // progressBar loading = new progressBar();
        // new myFrame();

        // game game = new game();

        //generics:
        Integer[] intArr = {1, 2};
        Character[] charArr = {'H', 'I'};
        System.out.println(getFirst(intArr));
        System.out.println(getFirst(charArr));

        //generic class similar to making array list
        // generic<Integer, Integer> myInt = new generic(12, 21);
        // System.out.println(myInt.getVal());

        // HashMap<Integer, String> users = new HashMap<>();

        //serialization: object to byte, saving file
        profile save = new profile("saved", 6);
        FileOutputStream fileOut = new FileOutputStream("profile.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(save);
        out.close();
        fileOut.close();
        System.out.println("profile saved");

        //deserialization: reverse, loading saved file
        profile save2 = null;
        FileInputStream fileIn = new FileInputStream("profile.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        save2 = (profile) in.readObject(); //need to cast
        in.close();
        fileIn.close();
        System.out.println(save2.friends);
        System.out.println(save2.adult);
        //children class serializable, static cant
        //serialVersionUID shows that they match
        long serialVersionUID = ObjectStreamClass.lookup(save.getClass()).getSerialVersionUID();
        long serialVersionUID2 = ObjectStreamClass.lookup(save2.getClass()).getSerialVersionUID();
        System.out.println(serialVersionUID);
        System.out.println(serialVersionUID2);
        //custom serialVersionUID recommended, so changed to 1 in profile class

        //timer and timer task
        // Timer timer = new Timer();
        // TimerTask task = new TimerTask()
        // {
        //     int counter = 10;
        //     @Override
        //     public void run()
        //     {
        //         if (counter > 0)
        //         {
        //             System.out.println(counter + " seconds");
        //             counter--;
        //         }
        //         else
        //         {
        //             System.out.print("done");
        //             timer.cancel();
        //         }
        //         // System.out.print("done");
        //         // throw new UnsupportedOperationException("Unimplemented method 'run'");
        //     }  
        // };
        // timer.schedule(task,2000);
        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, 2024);
        date.set(Calendar.MONTH, Calendar.JULY);
        date.set(Calendar.DAY_OF_MONTH, 23);
        date.set(Calendar.HOUR_OF_DAY, 22);
        date.set(Calendar.MINUTE, 31);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        // timer.schedule(task,date.getTime());
        // timer.scheduleAtFixedRate(task, date.getTime(), 1000);

        //threads
        System.out.println(Thread.activeCount()); //.setName()
        System.out.println(Thread.currentThread().getName());
        //.getPriority() .setPriority(number) 1 low - 10 high .isAlive()

        // for (int i = 3; i > 0; i--)
        // {
        //     System.out.println(i);
        //     Thread.sleep(1000);
        // }
        // System.out.println("done");
        // myThread thread2 = new myThread();
        // thread2.setDaemon(true);
        // thread2.start();
        // System.out.println(thread2.isAlive());
        // System.out.println(thread2.isDaemon());
        //inherits priority so same as Thread
        //daemon thread: low priority, background like garbage collection
        //user thread (non daemon): terminates self when all user threads are done
        // myThread thread1 = new myThread();

        //better option for extends
        // myRunnable runnable1 = new myRunnable();
        // Thread threadR = new Thread(runnable1);

        // thread1.start();
        // thread1.join(3000); //wait x milliseconds before next one starts
        // threadR.start();
        //threads are independent so if one has an exception other still runs, unless they're daemon threads

        //packages
        // toolBox item = new toolBox();

        //can run on terminal by going to file then javac file.java
        //then java file

        //for executable: export to runnable jar file
        //to change executable icon, get image to ICO file
        //launch4j, get .exe file and connect to .ico file, JRE, Bundled JRE and get location to jdk
        //build wrapper (gear icon), name and save launch4j config file, .exe saved to output, previous files no longer needed
    }
    public static <Thing> Thing getFirst(Thing[] arr)
    {
        return arr[0];
    }
} 
