package Stack.application;
import java.util.Scanner;
import java.util.Stack;

public class BalancingParenthesis {
	static boolean areBracketsBalanced(String expr) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < expr.length(); i++) {
			char x = expr.charAt(i);
			if (x == '(' || x == '[' || x == '{') {
				stack.push(x);
				continue;
			}
			if (stack.isEmpty())
				return false;
			char check;
			switch (x) {
				case ')':
					check = stack.pop();
					if (check == '{' || check == '[')
						return false;
					break;
				case '}':
					check = stack.pop();
					if (check == '(' || check == '[')
						return false;
					break;
				case ']':
					check = stack.pop();
					if (check == '(' || check == '{')
						return false;
					break;
			}
		}
		return (stack.isEmpty());
	}

	public static void main(String[] args) {
		System.out.println("Enter the expression : ");
		Scanner sc = new Scanner(System.in);
		String expr = sc.nextLine();
		if (areBracketsBalanced(expr))
			System.out.println("Balanced ");
		else
			System.out.println("Not Balanced ");
	}
}
