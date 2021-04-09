class Stack {
	int limit = 100;
	int top;
	int a[] = new int[limit];

    Stack()
	{
		top = -1;
	}

	boolean isEmpty()
	{
		if (top==-1)
        return true;
        else
        return false;
	}
	

	boolean push(int value)
	{
		if (top >= (limit - 1)) {
			System.out.println("Stack Overflow");
			return false;
		}
		else {
			a[++top] = value;
			System.out.println(value + " pushed into stack");
			return true;
		}
	}

	int pop()
	{
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			int value = a[top--];
			return value;
		}
	}

	int peek()
	{
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			int value = a[top];
			return value;
		}
	}
}
class Main {
	public static void main(String args[])
	{
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
        s.push(4);
		System.out.println(s.pop() + " Popped from stack");
        System.out.println(s.peek() + " Peeked from Stack");
        System.out.println("Stack is Empty :"+s.isEmpty());
	}
}
