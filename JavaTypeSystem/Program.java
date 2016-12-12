class Program {
	public static void main(String[] args) {
		int i = 10;
		boolean b = true;
		double d = 0.7;
		byte by = 3;
		char c = 'a';

		d = 13.75;
		i = 65;

		double d1 = i;
		System.out.println("int to double: d1=" + d1);

		// char c1 = i;
		// int i1 = d1;
		char c1 = (char)i;
		System.out.println("int to char: c1=" + c1);

		int i1 = (int)d;
		System.out.println("double to int: i1=" + i1);

		int x = 7 % 3; // x - 1
		int y = 8 / 3; // y - 2
	}	
}