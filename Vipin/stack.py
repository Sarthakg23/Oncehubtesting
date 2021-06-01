max=20
top=0
array=[None]*max

def push(item):
    global top, array
    if top>20:
        print("Overflow!")
        return
    array[top]=item
    top+=1
    print("Item pushed!")
    
def pop():
    global top, array
    if top<0:
        print("Underflow!")
        return
    del array[-1]
    top-=1
    print("Item popped!")

def printstack():
    global top, array
    for i in range(top):
        print(array[i],end=", ")

def menu():
    while True:
        print("\n1. push\n2. pop\n3. print\n4. exit")
        opt=int(input("Enter option: "))
        if opt==1:
            item=int(input("Enter the number: "))
            push(item)
        elif opt==2:
            pop()
        elif opt==3:
            printstack()
        elif opt==4:
            return
        else:
            print("Please enter a valid choice!")


def stack():
    menu()

if __name__=="__main__":
    stack()