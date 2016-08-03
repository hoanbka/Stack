package stack;

//There is a problem with this 
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
	public void balanceSymbol(String str) {
		try {
			char[] arr = str.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '[' || arr[i] == '{' || arr[i] == '(')
					push(arr[i]);
				else if (arr[i] == '}' && peek() == '{') {
					pop();
				} else if (arr[i] == ']' && peek() == '[')
					pop();
				else if (arr[i] == ')' && peek() == '(')
					pop();
			}
			if (isEmpty()) {
				System.out.println("String is balanced");
			} else {
				System.out.println("String is not balanced");
			}
		} catch (Exception e) {
			System.out.println("String not balanced");
		}

	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public static void main(String[] args) throws Exception {
		CharStackArray stack = new CharStackArray(10);
		stack.balanceSymbol("[a+b{c+(e-f[p-q])}]");
		stack.display();

		System.out.println();
		stack.balanceSymbol("({[)}]");
		stack.display();

		System.out.println();
		stack.balanceSymbol("({[]})");
		stack.display();

	}

}