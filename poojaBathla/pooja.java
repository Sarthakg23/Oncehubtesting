package poojaBathla;
class stack{
    int stack[]= new int[10];
    int top=0;

    public void push(int data){
        stack[top]=data;
        top++;
}
    public void show(){
        for(int n: stack){
            System.out.println(n+" ");
        }
    }
    public int pop(){
        int data;
        top--;
        data=stack[top];
        stack[top]=0;
        return data;
    }
    public int peek(){
        int data;
        data=stack[top-1];
        return data;
    }
}

public class pooja {
    public static void main(String[] args) {
        stack s = new stack();
        s.push(9);
        s.push(10);
        s.push(11);
        
        s.show();
        
        System.out.println(s.pop());
        
        s.show();
        System.out.println(s.peek());
    } 
}
