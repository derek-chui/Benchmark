import math, random, os, shutil, functools, time, threading, smtplib
from device import Device, Phone
from abc import ABC, abstractmethod
import device
from multiprocessing import Process, cpu_count

print("Hello World")
first_name = "John"
age = 18
age += 1
print(first_name + " is " + str(age))
#float instead of double, bool, str, etc.
username, followers, private = "1234", 420, True
#len(name), name.find("J"), name.capitalize("o")
# .upper() and lower, .isdigit(), .isalpha(), .count("h"), .replace("n", "h")
print(username*4)
#print((int)y) is temp but y = int(y) is perm
# age = float(input("age: "))
# print("you are " + str(age))
#round, .ceil, .floor, abs, pow (x,y), .sqrt, max(x,y,z,....)
#indexing [:3] = [0:3] = [0:3:1], [3:] = [3:last] = [3:last:1], [::2], [first:last:2] every 2nd
reversed_name = first_name[::-1]
print(reversed_name)
#slice = slice(7, -4), website = "http://google.com", website[slice] = "google"
if age == 100: print("very old")
elif age >= 18: print("adult")
elif age < 0:print("not born")
else: print("child")
#instead of && || use and or, None for null
# for i in range(10): print(i + 1)
# for i in range (50,100): print(i) #similar to slice
# for i in range (50,100,4): print(i) #(begin, end, step)
# for i in "hello": print(i)
#pause: time.sleep(1) in seconds, range(10,0,-1) countdown from 10
#break, continue skips to next iteration, pass skips specified seciton of iteration

#lists: list = [...] list[4] .append("") .remove("") .pop() .insert(2,"") .sort() .clear()

#tuple ordered and unchangable lists: .count("") .index("")
contact = ("James", 22) #for x in contact, if "..." in contact

#set unordered unindexed list, if dup will only print once, contact[1]
stationary = {"pen", "pencil", "ruler"} #random order when printed every time
#.add("") .remove("") .clear() set1.update(set2) adds set2 to 1
#set3 = set2.union(set1) joins 1 and 2 to 3, cant do stationary[1]
#set1.difference(set2) set1 has set2 doesnt, intersection common

#dictionary changeable unordered key:value pairs uses hashing
capitals = {'USA':'Washington DC','UK':'London'} #capitals.get('USA') is Washington DC
#.keys() .values() .items() or for key,value in capitals.items() print(key,value)
capitals.update({'Poland':'Warsaw'}) #can also pop("") or clear()
capitals.update({'USA':'San Jose'})

def test(x,y):
    print("testing " + x + " " +  str(y))
test("example", 42)
#positional args order matter, keyword args dont
test(y="first",x="last")
#nested func, scope (LEGB), def func(*args) packs func args into a tuple: args = list(args)
def hello(**kwargs):
    print("hi ",end=" ")
    for key,value in kwargs.items():
        print(value,end=" ")
hello(title="mr.",first="john ",middle="james",last="jack")
print("Player {:>10} has {pts} points".format(123,pts=234)) #: > < ^ .3f , b o x e E
#random .randint(x,y) .random() .choice(list)) .shuffle(list)
#try, except ZeroDivisionError as e: ValueError as e: Exception as e: else: finally:
#os.path.exists(path) .isfile(path) .isdir(path)
text = "this is my text\nthis is more text"
with open("test.txt", "w") as file: file.write(text) #a
with open("test.txt") as file: print(file.read())
#copyfile(from, to) copy() permission mode copy2() metadata
#move: try if exists else .replace(from, to) except
os.remove("test.txt") #rmdir empty file shutil.rmtree with files
#module, import file as f, f.hello() OR from file import func1,func2 can also do import *
#help("modules"), try rock paper sissors and a quiz game?
phone1 = Phone("Apple")
phone1.lock().charge()
#objects as arguments, duck typing (if class contents are the same then can be used)
print(happy := True)
talk = print
talk("talking")
#Higher Order Function
def divisor(x):
    def dividend(y):
        return y / x
    return dividend
divide = divisor(2)
print(divide(10))
#lambda
alg = lambda x,y,z:x%y+z*2
check = lambda age:True if age >= 18 else False
print(alg(5,6,7) + check(18))
#.sort() for list .sort(reverse=True), sorted(x) for iterables like tuples
students = [("John", "C", 34), ("James", "D", 17)]
grade = lambda grades:grades[1]
students.sort(key=grade, reverse=True)
sorted_students = sorted(students, key=grade)
for i in students: print(i)
for i in sorted_students: print(i)
#map applies func to every item in iterable
to_months = lambda data: (data[0], data[1], data[2]*12)
student_months = list(map(to_months, students))
for i in student_months: print(i)
#filter
adult = lambda data:data[2] >=18
student_adults = list(filter(adult, students))
for i in student_adults: print(i)
letters = ["T", "£", "X", "T"]
word = functools.reduce(lambda x,y,:x+y,letters)
print(word)
grades = [97,72,53]
passing = [i for i in grades if i >= 60]
passing2 = [i if i >= 60 else "FAIL" for i in grades]
print(passing2)
#dictionary can also add if at end, if/else beginning, function() beginning, etc
farenheit = {'SF': 50, 'NY': 41}
celcius = {key: ((value-32)*(5/9)) for (key,value) in farenheit.items()}
print(celcius)
temp = list(zip(farenheit,celcius))
for i in temp: print(i)
# print(__name__), print(device.__name__)
# if __name__ == '__main__': function
print(time.ctime(0)), print(time.time()), print(time.ctime(time.time()))
time_object = time.localtime() #gmtime
local_time = time.strftime("%B %d %Y %H:%M:%S", time_object)
print(time_object), print(local_time)
time_string = "22 June, 2017"
time_object = time.strptime(time_string, "%d %B, %Y")
print(time_object)
time_tuple = (2021, 3, 29, 6, 23, 0, 0, 0, 0)
time_string = time.asctime(time_tuple) #mktime
print(time_string)

print(threading.active_count())
print(threading.enumerate())
print(time.perf_counter())
#x = threading.Thread(target=function_name, args=(1))
#x.start, x.join() main waits for x
#daemon=True for daemon, x.setDaemon(True) x.isDaemon()
#multiproccessing ofr heavy cpu, multithreading for waiting
#a = Process(target=counter, args=(num,))
#a.start(), a.join(), slower when # of process > cpu_count()
print(cpu_count())
#GUI, projects: clock
sender = "sender@gmail.com"
reciever = "receiver@gmail.com"
password = "123qwerty"
subject = "email subject"
body = "email body"
message = f"""From: Nigerian Prince{sender}
To: John Smith{reciever}
Subject: {subject}\nonlocal
{body}
"""
server = smtplib.SMTP("smtp.gmail.com",587)
server.starttls()
# try:
#     server.login(sender,password)
#     print("Logged in...")
#     server.sendmail(sender,reciever,message)
#     print("Email sent!")
# except smtplib.SMTPAuthenticationError:
#     print("cant sign in")

#to run with cmd: do to terminal and to folder with file, then type python file_name.py
#pip, --version, list, list --outdated, install wheel/setuptools/etc. --upgrade, pip install pandas/etc.
#python package index for more python packages
#py to exe: pip install pyinstaller, pyinstaller -F -w -i icon.ico learnPython.py, exe is dist file, click on exe
#more projects: calculator, text editor, tic tac toe, snake