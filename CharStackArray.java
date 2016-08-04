package stack;

class CharStackArray {
	private char[] array;
	private int top;
	private int capacity;

	// Constructor
	public CharStackArray(int cap) {
		capacity = cap;
		array = new char[capacity];
		top = -1;
	}

	public void push(char data) {
		if (isFull()) {
			char[] temp = new char[array.length + 1];
			System.arraycopy(array, 0, temp, 0, array.length);
			array = temp;

		}
		array[++top] = data;
	}

	public char pop() {
		return array[top--];
	}

	public void display() {
		for (int i = 0; i <= top; i++) {
			System.out.print(array[i]);
		}
	}

	public char peek() throws Exception {
		return array[top];
	}

	/* Call this method by passing a string expression */
	public boolean isParenthesesMatch(String str) throws Exception {
		if (str.isEmpty()) {
			return true;
		}

		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '[' || arr[i] == '{' || arr[i] == '(')
				push(arr[i]);

			if ((arr[i] == '}') || (arr[i] == ']') || (arr[i] == ')')) {
				if (isEmpty()) {
					return false;
				}
				if ((arr[i] == '}' && peek() == '{')
						|| ((arr[i] == ']' && peek() == '['))
						|| (arr[i] == ')' && peek() == '(')) {
					pop();
				} else {
					return false;
				}
			}
		}

		return isEmpty();
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == array.length - 1);
	}

	public static void main(String[] args) throws Exception {
		CharStackArray stack = new CharStackArray(2);

		String str5 = "{}({[]})";
		System.out.println("check str5 = " + stack.isParenthesesMatch(str5));
	}
}