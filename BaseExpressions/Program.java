class Program {
	public static void main(String[] args) {
		int i = 8; 
		int j = 9;

		if (i < j) {
			System.out.println("MAX: " + j);
		} else if (i > j) {
			System.out.println("MAX: " + i);
		} else {
			System.out.println("IS EQUALS");
		}

		while (i < 10) {
			System.out.println(i);
			i = i + 1; // i++
		}

		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}

		do {
			System.out.println(i);
			i++;
		} while (i < 10);
	}
}