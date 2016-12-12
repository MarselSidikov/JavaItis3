class Program {
	// int - type of returned value
	// sum - name of function
	// int a, int b - formal parameters
	// return
	public static int sum(int a, int b) {
		int result = a + b;
		return result;
	}

	public static void show(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(i);
		}
	}

	public static void swap(int x, int y) {
		int temp = x;
		x = y;
		y = temp;
	}

	public static void swap(int array[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String args[]) {
		// call sum-function
		// 5 and 6 - arguments
		int x = sum(5, 6);
		int y = 4;
		int z = 6;
		x = sum(y, z);
		show();
		// -------
		swap(y, z); // dont work
		int a[] = {2, 3, 5, 4, 3};
		swap(a, 2, 3); // works
	}
}