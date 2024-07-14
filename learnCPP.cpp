#include <iostream>
#include <vector>
#include <cmath>
#include <ctime>
#include <iomanip>

using namespace std;

enum Day {sunday, monday};

template <typename T, typename U>

T funtion (T x, U y)
{
    return x;
}

class Human
{
    private:
        int ssn;

    public:
        string name;
        int age;

        int height;
        int weight;

        void walk()
        {
            cout << "walk\n";
        }
    
    //constructor
    Human(string name, int age)
    {
        this->name = name;
        this->age = age;
    }
    //overloaded constructor
    Human(int x, int y)
    {
        height = x;
        weight = y;
    }
    Human()
    {
        
    }

    //if private, need getters and setters
    int getSsn()
    {
        return ssn;
    }
    void setSsn(int ssn)
    {
        this->ssn = ssn;
    }

    Human(int ssn)
    {
        setSsn(ssn);
    }
};

class Child : public Human
{
    public:
        void speak()
        {
            cout << "hello\n";
        }
};

int main()
{
    Day today = sunday;
    switch(today)
    {
        case sunday: 
            cout << "sunday\n";
            break;
        case monday:
            cout << "monday\n";
            break;
    }

    Human human1("John", 69);
    human1.walk();
    cout << human1.name << '\n';
    cout << human1.age << '\n';

    Human human2(180, 200);
    cout << human2.height << '\n';
    cout << human2.weight << '\n';

    Human human3;

    cout << human1.getSsn() << '\n';
    human1.setSsn(1000000);
    cout << human1.getSsn() << '\n';

    Human human(69420);
    human.setSsn(69);
    cout << human.getSsn() << '\n';

    Child child1;
    cout << child1.getSsn() << '\n';
    child1.speak();

    return 0;
}