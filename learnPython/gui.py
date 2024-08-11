from tkinter import *
from tkinter import messagebox
from tkinter import colorchooser
from tkinter import filedialog
from tkinter import ttk
from tkinter.ttk import *
import time
from device import *

#GUI
window = Tk()

window.geometry("200x300")
window.title("GUI Program")
icon = PhotoImage(file='image.png')
window.iconphoto(True, icon)
window.config(background="#5cffff")

#labels
photo=PhotoImage(file='image.png')
label = Label(window,text="This is some text",font=('Arial',40,'bold'),fg='green',
              bg='black',relief=RAISED,bd=10,padx=20,pady=20,image=photo,compound='bottom')
label.place(x=0,y=0)

#buttons
def click(): print("button clicked")
button = Button(window,text="submit",command=click,activeforeground="#00FF00",
                activebackground="black",state=ACTIVE)
button.pack()

#entrybox
entry = Entry(window, font=("Arial",50), show="*")
entry.insert(0,'enter password')
entry.pack(side=LEFT)
#to delete make button and function with entry.delete(0,END)
#backspace do entry.delete(len(entry.get())-1,END)
#entry.config(state=DISABLED)

#checkbox can add command with function for on and off
x = IntVar()
check = Checkbutton(window, text="check this",variable=x,onvalue=1,offvalue=0)
check.pack()

#radio buttons
stationary = ["pen", "pencil"]
for i in range(len(stationary)):
    radiobutton = Radiobutton(window,text=stationary[i], value=i, indicatoron=0, width=300)
radiobutton.pack

#scale
scale = Scale(window,from_=0,to=100,length=600,orient=VERTICAL,tickinterval=10,
              showvalue=0,resolution=5,troughcolor='#123ABC')
scale.set(((scale['from']-scale['to'])/2)*scale['to'])
scale.pack()

#listbox
listbox = Listbox(window)
listbox.pack()
listbox.insert(1,"item 1")
listbox.insert(2,"item 2")
listbox.config(height=listbox.size())

#messagebox
def click():
    messagebox.showinfo(title='title',message='message')
    messagebox.showwarning(title='warning',message='virus')
    #showerror, askokcancel, askyesno, askquestion, askyesnocancel
button = Button(window,command=click,text='click me')
button.pack()

#colorchooser
def click(): window.config(bg=colorchooser.askcolor()[1])
button = Button(text='click',command=click)
button.pack

#text area, add button with submit func, input = text.get("1.0",END)
text = Text(window)
text.pack()

#open file
def openFile():
    filepath = filedialog.askopenfilename(initialdir="file path",title="open file", 
                                          filetypes=(("text files","*.txt"),("all files","*.*")))
    file = open(filepath,'rt') #rb for binary
    print(file.read())
    file.close()
button = Button(text="Open",command=openFile)
button.pack()

#save file
def saveFile():
    file = filedialog.asksaveasfile(initialdir="file path",
                                    defaultextension='.txt',filetypes=[("Text file",".txt"),
                                                                       ("HTML file",".html"),
                                                                       ("All files","*.*")])
    if file is None: return
    # filetext = str(text.get(1.0,END))
    filetext = input("add text")
    file.write(filetext)
    file.close()
button = Button(text="Open",command=saveFile)
button.pack()
text = Text(window)
text.pack()

#menubar
menubar = Menu(window)
window.config(menu=menubar)
fileMenu = Menu(menubar,tearoff=0)
menubar.add_cascade(label="File",menu=fileMenu)
fileMenu.add_command(label="Open",command=openFile)
fileMenu.add_separator()
fileMenu.add_command(label="Save",command=saveFile) #command=quit
editMenu = Menu(menubar,tearoff=0)

#frames
frame = Frame(window,bd=5,relief=SUNKEN)
frame.pack(side=BOTTOM)
frame.place(x=100,y=100)
Button(frame,text="W",width=3).pack(side=TOP)
Button(frame,text="A",width=3).pack(side=LEFT)
Button(frame,text="S",width=3).pack(side=BOTTOM)
Button(frame,text="D",width=3).pack(side=RIGHT)

#new windows
def create_window():
    new_window = Toplevel()
    old_window.destroy

old_window = Tk()
Button(window,text="create window",command=create_window).pack() #old_window

#window tabs
notebook = ttk.Notebook(window)
tab1 = Frame(notebook)
tab2 = Frame(notebook)
notebook.add(tab1,text="tab 1")
notebook.add(tab2,text="tab 2")
notebook.pack(expand=True,fill="both")
Label(tab1,text="tab1").pack()
Label(tab2,text="tab2").pack()

#grid
titleLabel  = Label(window,text="NAME",width=20).grid(row=0,column=0)
firstLabel  = Label(window,text="First: ",width=20).grid(row=1,column=0)
firstEntry = Entry(window).grid(row=0,column=1)
submitButton = Button(window,text="Submit").grid(row=2,column=0,columnspan=2)

#progress bar
#downloader have labels and start func to fill bar when clicked, window.update_idletasks()
bar = Progressbar(window,orient=HORIZONTAL,length=300)
bar.pack(pady=10)

#canvas
canvas = Canvas(window,height=500,width=500)
points = [0,0,500,500]
blueLine = canvas.create_line(points,fill="blue",width=5)
#rectangle, polygon (outline), arc (styles,start,extent), oval
canvas.pack()

#keyboard events
def doSomething(event):
    print("something " + event.keysym)
    label.config(text=event.keysym)
window.bind("<Key>",doSomething) #<Return>
label = Label(window)
label.pack()

#mouse events
def doSomething(event):
    print("click cords: "+str(event.x)+","+str(event.y))
window.bind("<Button-1>",doSomething) #left click, 2 scroll, 3 right
#buttonRelease, Enter, Leave, Motion

#drag and drop
def drag_start(event):
    widget = event.widget
    widget.startX = event.x
    widget.starty = event.y
def drag_motion(event):
    widget = event.widget
    x = widget.winfo_x() - widget.startX + widget.x
    y = widget.winfo_y() - widget.startY + widget.y
    widget.place(x=x,y=y)
label = Label(window,bg="red",width=10,height=5)
label.place(x=0,y=0)
label.bind("<Button-1>",drag_start)
label.bind("<B1-Motion>",drag_motion)

label2 = Label(window,bg="red",width=10,height=5)
label2.place(x=0,y=0)
label2.bind("<Button-1>",drag_start)
label2.bind("<B1-Motion>",drag_motion)

#move image with keys using label
def move_up(event): label.place(x=label.winfo_x(), y=label.winfo_y()-10)
window.geometry("500x500")
window.bind("<w>",move_up)
myimage = PhotoImage(file='image.png')
label = Label(window,image=myimage,bg="red")
label.place(x=0,y=0)

#move image with keys using canvas
def move_up(event): canvas.move(myimage,0,-10)
window.bind("<w>",move_up)
canvas = Canvas(window,width=500,height=500)
canvas.pack()
photoimage = PhotoImage(file='image.png')
myimage = canvas.create_image(0,0,image=photoimage,anchor=NW)

#animations
WIDTH = 500
HEIGHT = 500
xVelocity = 1
yVelocity = 1


canvas = Canvas(window,width=WIDTH,height=HEIGHT)
canvas.pack()
photo_image = PhotoImage(file='image.png')
my_image = canvas.create_image(0,0,image=photo_image,anchor=NW)
image_width = photo_image.width()
image_height = photo_image.height()

# while True:
#     coordinates = canvas.coords(my_image)
#     print(coordinates)
#     if(coordinates[0]>=WIDTH-image_width or coordinates[0]<0):
#         xVelocity = -xVelocity
#     if(coordinates[1]>=HEIGHT-image_width or coordinates[1]<0):
#         yVelocity = -yVelocity
#     canvas.move(my_image,xVelocity,yVelocity)
#     window.update()
#     time.sleep(0.01)

#multiple animations
class Ball:
    def __init__(self,canvas,x,y,diameter,xVelocity,yVelocity,color): 
        self.canvas = canvas
        self.image = canvas.create_oval(x,y,diameter,diameter,fill=color)
        self.xVelocity = xVelocity 
        self.yVelocity = yVelocity
    def move(self):
        coordinates = self.canvas.coords(self.image)
        if(coordinates[2]>=(self.canvas.winfo_width()) or coordinates[0]<0):
            self.xVelocity = -self.xVelocity
        if(coordinates[3]>=(self.canvas.winfo_height()) or coordinates[1]<0):
            yVelocity = -yVelocity
        self.canvas.move(self.image,self.xVelocity,self.yVelocity)

volley_ball = Ball(canvas,0,0,100,1,1,"white")
tennis_ball = Ball(canvas,0,0,50,4,3,"yellow")

# while True:
#     volley_ball.move()
#     window.update()
#     time.sleep(0.01)

window.mainloop()