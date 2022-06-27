package Stack.implementation;
import java.util.Scanner;
import static java.lang.System.exit;

class StackLinkedListMain {
	private class Node {
		int data;
		Node link;
	}
	Node top;
	StackLinkedListMain() {this.top = null;}

	public void push(int x) {// insert at the beginning
		Node temp = new Node();
		if (temp == null) {
			System.out.print("\nStack Overflow");
			return;
		}
		temp.data = x;
		temp.link = top;
		top = temp;
	}

	public boolean isEmpty() {return top == null;}

	public int peek() {
		if (!isEmpty()) {return top.data;}
		else {
			System.out.println("Stack is empty");
			return -1;
		}
	}

	public void pop() {
		if (top == null) {
			System.out.print("\nStack Underflow");
			return;
		}
		top = (top).link;
	}

	public void print() {
		if (top == null) {
			System.out.print("\nStack Underflow");
			exit(1);
		}
		else {
			Node temp = top;
			while (temp != null) {
				System.out.print(temp.data+" ");
				temp = temp.link;
			}
		}
	}
}

class StackUsingLinkedList {
	public static void main(String args[]) {
		StackLinkedListMain s = new StackLinkedListMain();
		Scanner sc = new Scanner(System.in);
		String yn;
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
					System.out.println(s.peek());
					break;
				case 4:
					s.print();
			}
			System.out.print("press 'y' to Continue or 'n' to exit : ");
			yn = sc.next();
		}
		while (yn.equalsIgnoreCase("y"));
	}
}
