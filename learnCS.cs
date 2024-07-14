// See https://aka.ms/new-console-template for more information

using System.Diagnostics.Tracing;
using System.Drawing;
using System.Security.Cryptography;

using System.Threading;

Console.WriteLine();

double a = 3.14;
int b = Convert.ToInt32(a);
//.ToDouble() .ToString() .ToChar() works too

Console.WriteLine("\tHello\bWor\nld! " + b);
Console.WriteLine(b.GetType());

// int age = Convert.ToInt32(Console.ReadLine());

double c = Math.Pow(3, 2); //.Max .Min
double d = Math.Sqrt(4); // .Abs .Round .Ceiling .Floor

Random random = new Random();
int num = random.Next(1, 7); //dice .NextDouble
Console.WriteLine(num);

String name = "John-";
name = name.ToUpper(); //.ToLower()
name = name.Replace("-","/");
name = name.Insert(0,"@");
String name2 = name.Substring(0, 3);
Console.WriteLine(name + name.Length + name2);

String[] cars = { "BMW", "Mustang", "Corvette"};
String[] trucks = new string[4];
foreach (String car in cars)
{
    Console.WriteLine(car);
}

// static double checkOut(params double[] prices)
// {
//     double total = 0;
//     foreach (double price in prices)
//     {
//         total += price;
//     }
//     return total;
// }

// double total = checkOut(4.20, 6.9);
// Console.WriteLine(total);

// double exception;
// try
// {
//     exception = Convert.ToDouble(Console.ReadLine());
// }
// catch (FormatException)
// {
//     Console.WriteLine("Enter numbers only");
// }
// catch (DivideByZeroException)
// {
//     Console.WriteLine("Cannot divide by zero");
// }
// catch (Exception)
// {
//     Console.WriteLine("Something went wrong");
// }
// finally
// {
//     Console.WriteLine("Thanks");
// }

String firstName = "Bro";
Console.WriteLine($"Hello {firstName}.");
Console.WriteLine($"Hello {firstName, 10}.");
Console.WriteLine($"Hello {firstName, -10}.");

String[,] parkingLot = {{"Mustang", "F-150"},
                        {"Corvette", "Camaro"},
                        {"Corolla", "Camry"}};

Console.WriteLine(parkingLot[0,1]);


//static (shared)
//no need for Messages message1 = new Messages();
Messages.Hello();

//non static (independent)
Human human1 = new Human("John", 69);
human1.Hello();

//array of objects
Car[] garage = {new Car("Mustang", "Red"), new Car("Corvette", "Blue")};

foreach (Car car in garage)
{
    Console.WriteLine(car.name);
}

//Objects as arguments
static void ChangeColor (Car car, String color)
{
    car.color = color;
}

ChangeColor(garage[0], "Black");
Console.WriteLine("Changed to " + garage[0].color);

static Car Copy(Car car)
{
    return new Car(car.name, car.color);
}
Console.WriteLine("Before: " + garage[1].name);
garage[1] = Copy(garage[0]);
Console.WriteLine("After: " + garage[1].name);

//override
garage[0].Honk();
Bike bike1 = new Bike(400);
bike1.Honk();
Console.WriteLine(garage[0].ToString());

Vehicle[] vehicles = {garage[0], bike1};

//List (DDS)

List<String> food = new List<String>();
food.Add("sushi");
food.Add("steak");
food.Add("sushi");
food.Remove("steak");
food.Insert(0, "oatmeal");
Console.WriteLine(food.Count);
Console.WriteLine(food.IndexOf("sushi"));
Console.WriteLine(food.LastIndexOf("sushi"));
Console.WriteLine(food.Contains("oatmeal"));
food.Sort(); //.Reverse .Clear
String[] foodArray = food.ToArray();

//List of objects
List<Car> carList = new List<Car>();
// Car mini = new Car("mini", "blue");
// carList.Add(mini);
carList.Add(new Car("mini", "blue"));
foreach (Car car in carList)
{
    Console.WriteLine(car);
}

Bike bike = new Bike(400);
bike.Speed = 1000000;
Console.WriteLine(bike.Speed);

Boat boat = new Boat("yacht");
Console.WriteLine(boat.Model);

//enum set of unchanged values
Console.WriteLine(Planets.Venus + " " + (int)Planets.Venus);

static Planets planetMethod(Planets hello)
{
    return hello;
}
Console.WriteLine(planetMethod(Planets.Mercury));

//generics
int[] ints = {1, 2};
double[] doubles = {1.1, 2.2};

display(ints);
display(doubles);

static void display<Thing>(Thing[] array)
{
    foreach (Thing item in array)
    {
        Console.Write(item + " ");
    }
    Console.WriteLine();
}

//multithreading
Thread mainThread = Thread.CurrentThread;
mainThread.Name = "Main Thread";
Console.WriteLine(mainThread.Name);

Thread thread1 = new Thread(() => CountDown("Timer #1"));
Thread thread2 = new Thread(() => CountUp("Timer #2"));
thread1.Start();
thread2.Start();

Console.WriteLine(mainThread.Name + "done");

static void CountDown(String name)
{
    for (int i = 10; i >= 0; i--)
    {
        Console.WriteLine("Timer 1:" + i);
        Thread.Sleep(1000);
    }
    Console.WriteLine("Timer #1 done");
}

static void CountUp(String name)
{
    for (int i = 0; i <= 10; i++)
    {
        Console.WriteLine("Timer 2:" + i);
        Thread.Sleep(1000);
    }
    Console.WriteLine("Timer #2 done");
}

//************CLASSES************\\
enum Planets{Mercury = 0, Venus = 3}

//static
static class Messages
{
    public static void Hello()
    {
        Console.WriteLine("New Message");
    }
}

//non static
class Human
{
    public String name;
    public int age;

    public Human(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public void Hello()
    {
        Console.WriteLine(name + " is " + age + " years old\n");
    }
}

//abstract
//Can't do Vehicle vehicle1 = new Vehicle();
//but can with Car because car isn't abstract

//virtual and override

//interface, can inherit multiple

interface IMoving
{
    void Warning();
}
interface IRoad
{
    void Stop();
}
abstract class Vehicle : IMoving, IRoad
{
    public virtual void Honk() //can also be abstract but must have no body
    {
        Console.WriteLine("honk");
    }
    public void Warning()
    {
        Console.WriteLine("watch out");
    }
    public void Stop()
    {
        Console.WriteLine("stop");
    }
}
class Car : Vehicle
{
    public String name;
    public String color;
    public Car(String name, String color)
    {
        this.name = name;
        this.color = color;  
    }
    public override void Honk()
    {
        Console.WriteLine("beep");
    }
    public override string ToString()
    {
        return color + name; //set default call to this
    }//so for example Console.WriteLine(car); will be return this
}
class Bike : Vehicle
{
    private int speed;

    public Bike(int speed)
    {
        Speed = speed;
    }
    
    //getters and setters
    public int Speed
    {
        get { return speed; }
        set
        {
            if (value > 500)
            {
                speed = 500;
            }
            else if (value < 0)
            {
                speed = 0;
            }
            else
            {
                speed = value;
            }
        }
    }
}
class Boat : Vehicle
{
    //short form
    public String Model { get; set; }
    public Boat(String model)
    {
        this.Model = model;
    }
}

// Console.ReadKey();