package Stack.implementation;
import java.util.Scanner;

class StackArrayMain {
	static final int MAX = 10;
	int top;
	int a[] = new int[MAX]; // Maximum size of Stack

	boolean isEmpty()
	{
		return (top < 0);
	}//checks if stack is empty or not
	StackArrayMain()
	{
		top = -1;
	}

	boolean push(int x) {// pushes the value into stack
		if (top >= (MAX - 1)) {
			System.out.println("Stack Overflow!");
			return false;
		}
		else {
			a[++top] = x;
			System.out.println(x + " pushed into stack");
			return true;
		}
	}

	void pop() { // pops the value from stack
		if (top < 0) {
			System.out.println("Stack Underflow");
		}
		else {
			int x = a[top--];
			System.out.println(x + " popped from the stack");
		}
	}

	void peek() { // returns top element
		if (top < 0) {
			System.out.println("Stack Underflow");
		}
		else {
			int x = a[top];
			System.out.println("Top element of the stack : "+x);
		}
	}
	void print(){
		System.out.println("---------------Stack Elements---------------");
		for(int i = top;i>-1;i--){
			System.out.print(" "+ a[i]);
		}
		System.out.println();
	}
}
class StackUsingArray {
	public static void main(String args[]) {
		StackArrayMain s = new StackArrayMain();
		Scanner sc = new Scanner(System.in);
		String yn ;
		int choice;
		do {
			System.out.print("Enter '1' - Push, '2' - Pop, '3' - Peer, '4' - Print stack elements : ");
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					System.out.print("Enter the value to be pushed : ");
					int val = sc.nextInt();
					s.push(val);
					break;
				case 2:
					s.pop();
					break;
				case 3:
					s.peek();
					break;
				case 4:
					s.print();
			}
			System.out.print("press 'y' to Continue or 'n' to exit : ");
			yn = sc.next();
		}
		while(yn.equalsIgnoreCase("y"));
	}
}
