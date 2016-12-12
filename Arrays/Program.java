class Program {
	public static void main(String[] args) {
		int array[]; // int[] array;
		array = new int[5];
		array[0] = 6;
		array[1] = 5;
		array[2] = 2;
		array[3] = 1;
		array[4] = 7;

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

		int array2[] = {6, 5, 2, 1, 7};

		for (int current : array2) {
			System.out.println(current);
		}
	}
}