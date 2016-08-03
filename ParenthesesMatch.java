package stack;

import java.util.Stack;

public class ParenthesesMatch {

	public static boolean isParenthesesMatch(String str) {
		if (str.isEmpty()) {
			return true;
		}

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			char current = str.charAt(i);

			if ((current == '{') || (current == '[') || (current == '(')) {
				stack.push(current);
			}

			if ((current == '}') || (current == ']') || (current == ')')) {
				if (stack.isEmpty()) {
					return false;
				}

				char last = stack.peek();
				if (((current == '}') && (last == '{')) || (current == ']')
						&& (last == '[') || (current == ')') && (last == '(')) {

					stack.pop();
				} else {
					return false;
				}
			}

		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String str4 = "({[]})";
		String str5 = "{}({[]})";
		String str6 = ")({[]})(";
		System.out.println("check str4 = " + isParenthesesMatch(str4));
		System.out.println("check str5 = " + isParenthesesMatch(str5));
		System.out.println("check str6 = " + isParenthesesMatch(str6));

	}

}
