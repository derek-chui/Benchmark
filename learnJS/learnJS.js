// import {PI, getCircumference, getArea} from "./math.js";
import * as myMath from "./math.js";

//go live, inspect, console to see results
//; not needed
// window.alert("text!");

let cAge = "19";
console.log(cAge);
cAge += 1;
console.log(cAge, typeof cAge);
cAge = Number(cAge);
cAge += 1;
console.log(cAge, typeof cAge);
//converting empty string to bool = false
//convert text to number = NaN

// let username = window.prompt("name?");
// console.log(username);

let username;
document.getElementById("myButton").onclick = function()
{
    username = document.getElementById("myText").value;
    document.getElementById("myLabel").innerHTML = "Hello " + username;
    const myCheckBox = document.getElementById("checkBox");
    if (myCheckBox.checked)
    {
        console.log(username + " is not a robot");
    }
    else
    {
        console.log(username + " is a robot");
    }
}

let full = "John Smith";
let first;
let last;
first = full.slice(0, full.indexOf(" "));
last = full.slice(full.indexOf(" ") + 1);
console.log(first);
console.log(last);

// let i = 5;
// let j = i++; // j is assigned 5, i becomes 6
// let k = i += 1; // k is assigned 7, i becomes 7

for (var i = 1; i <= 4; i++)
{
    //if let i then only local to for loop
    //var i here is only local to a function
}
console.log(i);
//var name = "John"; changes window properties if global, but let won't
console.log(`Hello ${last}, ${first}`);

let myNum = 1234.56;
myNum = myNum.toLocaleString("en-US", {style: "currency", currency: "USD"});
//Hindi: hi-IN, INR, German: de-DE, EUR
// myNum = myNum.toLocaleString(undefined, {style: "percent"});
//style: "unit", unit: "celcius"
console.log(myNum);

let colors = ["red", "blue", "pink"];
let numbers = [2, 6, 4];
let lists = [colors, numbers];
colors = colors.sort().reverse();
numbers = numbers.sort().reverse();
for (let list of lists)
{
    for (let item of list)
    {
        console.log(item);
    }
}
for (let color of colors)
{
    console.log(...color);
}
let max = Math.max(...numbers);
console.log(max);
//needed to push as well, class1.push(...class2)
let a = 3; let b = 5; let c = 7;
console.log(sum(a,b,c));
function sum(...nums)
{
    let total = 0;
    for (let num of nums)
    {
        total += num;
    }
    return total;
}
//callback: passing function to another function
//for example: sum(1, 2, display);
function callbackSum(x, y, callback)
{
    let result = x + y;
    callback(result);
}
//for each does callback per element
let capColors = colors.forEach(caps);
function caps(elt, i, arr)
{
    arr[i] = elt[0].toUpperCase() + elt.substring(1);
}
console.log(colors);
console.log(capColors);
//map does callback per element and makes new array
let squares = numbers.map(square);
function square (elt)
{
    return Math.pow(elt, 2);
}
console.log(numbers);
console.log(squares);
//filter: make new array with function to filter
let over3 = numbers.filter(over3F);
function over3F(elt)
{
    return elt > 3;
}
console.log(numbers);
console.log(over3);
//reduce: array to single value
let total = numbers.reduce(checkOut);
console.log(total);
function checkOut(total, elt)
{
    return total + elt;
}
//sort
numbers = numbers.sort(ascending);
function ascending(x, y)
{
    return x - y; //descending y - x
}
console.log(numbers);
numbers = numbers.sort((x, y) => x - y); //same thing
console.log(numbers);


let count = 0;
document.getElementById("increase").onclick = function()
{
    count++;
    document.getElementById("counter").innerHTML = count;
}
document.getElementById("decrease").onclick = () =>
{
    count--;
    document.getElementById("counter").innerHTML = count;
}

numbers = numbers.sort((x, y) => x - y);

let cards = ["J", "Q", "K", "A"];
function shuffle(arr)
{
    let curr = arr.length;
    while (curr != 0)
    {
        let rand = Math.floor(Math.random() * arr.length);
        curr--;
        let temp = arr[curr];
        arr[curr] = arr[rand];
        arr[rand] = temp;
    }
    return arr;
}
shuffle(cards);
console.log(cards);

//nested functions prevent nested ones from being accessed outside the parent function
//map stores key value pairs of any data type
const store = new Map
([
    ["steak", 10], 
    ["fish", 5]
]);
store.forEach((value, key) => console.log(`${key} $${value}`));
//.set(x,y) .delete(x) .has(x) .size

//object
const device =
{
    model: "phone",
    restart : function()
    {
        console.log(`restarting ${this.model}`);
    }
}
device.restart();

//classes are basically the same as java
class Phone
{
    constructor(model, ID)
    {
        this.model = model
        this._ID = ID;
    }
    get ID()
    {
        return `ID: ${this._ID}`;
    }
    set ID(x)
    {
        this._ID = x;
    }
    call()
    {
        console.log(`${this.model} is calling`);
    }
}
let phone1 = new Phone("iPhone 14", 1234);
phone1.call();
phone1.ID = 10000;
console.log(phone1.ID);
//static = shared, inheritance extends
//super(x,y,z,...) for child constructor when repeating parent constructor
//objects as arguments, array of objects

//anonymous objects
let phones = [new Phone("Galaxy s23", 2345), new Phone("Pixel 8", 3456)];

try
{
    // let x = window.prompt("number: ");
    let x;
    x = Number(x);
    if (isNaN(x)) throw "not a number";
}
catch(error){console.log(error);}
finally{console.log("will always execute");}
// let emoji = ":)";
// let important1 = setTimeout(important, 2000, emoji);
// function important(text)
// {
//     alert(`this message is important ${text}!!`)
// }
// document.getElementById("ok").onclick = function()
// {
//     clearTimeout(important1);
// }

//ex. invokes countUp function every 1s until max value reached
// const myTimer = setInterval(countUp, 1000, max);

// let date = new Date() OR (1000) OR (2024, 0, 1, 2, 3, 4, 5)
let date = new Date("January 1, 2024 00:00:00");
date = date.toLocaleString();
console.log(date);
//date.getFullYear, getMonth, getDate, getDay, getMonth, etc.
//.setFullYear, .setMonth, setDate
//jan is 0, feb is 1

//sync: seqeunce, step by step linear, start now finish now
//async: start now finish later

// console.time("runtime");
// //code (only tracks sync operations)
// console.timeEnd("runtime");

//promise: async to return like sync
const promise = new Promise((resolve, reject) => {
    let fileLoaded = true;
    if(fileLoaded) {resolve("file loaded");}
    else {reject("file not loaded");}
});
promise.then(value => console.log(value))
       .catch(error => console.log(error));
// const promise2 = time => new Promise(resolve => {
//     setTimeout(resolve, time);
// });
// promise2(4000).then(() => console.log("done"));
//if no async:
async function loadFile()
{
    let fileLoaded = false;
    if(fileLoaded) {return "file loaded";}
    //Promise.resolve("file loaded");
    else {throw "file not loaded";}
    //Promise.reject("file not loaded");
}
async function start()
{
    try
    {
        let message = await loadFile(); //locateFile, closeFile
        console.log(message);
    }
    catch(error){console.log(error);}
}
loadFile().then(value => console.log(value)) //promise.
          .catch(error => console.log(error));

// console.log(PI + getCircumference(10) + getArea(10));
console.log(myMath.PI + myMath.getCircumference(10) + myMath.getArea(10));

//DOM document object model (API) to change content of page
console.log(document); //display DOM
console.log(document.title); //.URL
console.dir(document); //display DOM properties
document.title = "learnJS";
//document.location = "website"
document.body.style.backgroundColor = "lightGray";
//document.getElementById("ID").innerHTML = "text";
let name = document.getElementById("myLabel");
name.style.backgroundColor = "yellow";
//getElementByName for HTML names, getElementByTagName("li") HTML collection
let robot = document.getElementById("checkBox");
if (robot.checked){console.log("not a robot!!")};
let brand = document.getElementsByClassName("phones");
//document.querySelector: Id ex. #myTitle, ClassName ex. .deserts, tag ex. li, or attribute ex. [for]
//querySelectorAll selects all, can put into for each loop

//DOM traversal
let element = document.body;
let child = element.firstElementChild;
child.style.backgroundColor = "lightgreen";
//.lastElementChild, .parentElement, .nextElementSibling, .previousElementSibling
//.children[], Array.from(element.children) foreach to loop

//.textContent instead of .innerHTML
const myList = document.querySelector("#phones");
const listItem = document.createElement("li");
listItem.textContent = "Google";
// myList.append(listItem); //prepend
myList.insertBefore(listItem, myList.getElementsByTagName("li")[1]);

const title = document.getElementById("myTitle");
title.style.backgroundColor = "skyblue" //rgb(1,2,3) or #123456
title.style.textAlign = "center"
//.color, .fontFamily, .border = "2px solid", display = "none" or "block"

const elt = document.getElementById("myButton");
elt.onclick = submitted; //.onload .onchange (ex. when leaving textbox after typing something)
function submitted()
{alert("submitted");}
const box = document.getElementById("myDiv");
box.onmouseover = on; 
box.onmouseout = off; //and many other onmouse attributes
function on(){box.style.backgroundColor = "lightgreen";}
function off(){box.style.backgroundColor = "red";}

const innerDiv = document.getElementById("innerDiv");
const outerDiv = document.getElementById("outerDiv");

// innerDiv.addEventListener("mouseover", changeRed);
// innerDiv.addEventListener("mouseout", changeGreen);
// function changeRed(){innerDiv.style.backgroundColor = "red"};
// function changeGreen(){innerDiv.style.backgroundColor = "lightgreen"};

innerDiv.addEventListener("click", changeBlue);
outerDiv.addEventListener("click", changeBlue, true); //true so outerDiv is preference
function changeBlue(){this.style.backgroundColor = "lightblue"};

const toggle = document.querySelector("#toggle");
const mini = document.querySelector("#mini");
toggle.addEventListener("click", () => {
    if(mini.style.visibility == "hidden")
    {
        mini.style.visibility = "visible";
    }
    else
    {
        mini.style.visibility = "hidden";
    }
})
//.display "none" and "block" used to completely remove image
//but visibility just hides it and reserves space

// window.addEventListener("keydown", event => console.log(event.key));
const myDiv = document.getElementById("myDiv");
window.addEventListener("keydown", move); //keyup
let x = 0; let y = 0;
function move(event)
{
    switch(event.key)
    {
        case "ArrowDown":
            y+=5;
            myDiv.style.top = y + "px";
            break;
        case "ArrowUp":
            y-=5;
            myDiv.style.top = y + "px";
            break;
        case "ArrowRight":
            x+=5;
            myDiv.style.left = x + "px";
            break;
        case "ArrowLeft":
            x-=5;
            myDiv.style.left = x + "px";
            break;
        default:
            break;
    }
}

const animate = document.getElementById("animate");
const myAnimation = document.getElementById("myDiv");
animate.addEventListener("click", begin);
function begin()
{
    let timeId = null;
    let x = 0; let y = 0;
    let degrees = 0;
    let scaleX = 1; let scaleY = 1;
    timeId = setInterval(frame, 5);
    function frame()
    {
        if (x >= 200 || y >= 200)
        // if (degrees >= 360)
        // if(scaleX >= 2 || scaleY >= 2) //<= 0.1 shrink
        {
            clearInterval(timeId);
        }
        else
        {
            x+=1;
            y+=1;
            myAnimation.style.left = x + "px"
            myAnimation.style.top = y + "px"
            degrees+=4; //speed
            myAnimation.style.transform = "rotateX("+degrees+"deg)" //y and z too
            // scaleX += 0.1; 
            // scaleY += 0.1; //-= 0.1 shrink
            // myAnimation.style.transform = "scale("+scaleX+","+scaleY+")";
        }
    }
}

let canvas = document.getElementById("myCanvas");
let context = canvas.getContext("2d");
context.beginPath(); //.lineWidth = 10 .strokeStyle = "color"
context.moveTo(0, 0);
context.lineTo(250, 250); //brush to cords
context.lineTo(250, 500);
context.moveTo(500, 0); //moves "brush"
context.lineTo(250, 250);
//.fill() .fillStyle = "color"
context.strokeRect(0, 0, 250, 250) //.fillRect
//x, y, r, start Angle, end, counterclockwise
context.arc(250, 250, 200, 1, 2 * Math.PI, true);
context.stroke(); //border
context.textAlign = "center";
context.fillText("TEXT", canvas.width / 2, canvas.height / 2);

//DOM is property of window
// console.dir(window);
console.log(window.innerWidth);
console.log(window.outerWidth); //height too
//.scrollX .scrollY how far scrolled
console.log(window.location.hostname); //.hostname .pathname
//window.location.href = "website" sends page to website

const print = document.querySelector("#print");
print.addEventListener("click", () => window.print())
//.open .close .alert .confirm .prompt

//cookie small text file about user in name=value pairs
// console.log(navigator.cookieEnabled);
// document.cookie = "firstName=John; expires=Sun, 1 January 2030 12:00:00 UTC; path=/";
// setCookie("email", "john@gmail.com", 365); 
setCookie("firstName", "John", 365);
setCookie("lastName", "Smith", 365);
console.log(getCookie("firstName"));
function setCookie(name, value, daysToLive)
{
    const date = new Date();
    date.setTime(date.getTime() + daysToLive * 24 *  60 * 60 * 1000);
    let expires = "expires = " + date.toUTCString();
    document.cookie = `${name}=${value}; ${expires}; path:/`
}
function deleteCookie(name)
{
    setCookie(name, null, null);
}
function getCookie(name)
{
    const cDecoded = decodeURIComponent(document.cookie);
    // console.log(cDecoded);
    const cArray = cDecoded.split("; ");
    // console.log(cArray);
    let result = null
    cArray.forEach(element => {
        if(element.indexOf(name) == 0)
        {
            result = element.substring(name.length + 1);
        }
    })
    return result;
}
console.log(document.cookie);

//projects: stopwatch, rock paper sissors, tic tac toe, snake, pong