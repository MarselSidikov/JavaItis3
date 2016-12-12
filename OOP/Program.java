class Program {
	public static void main(String[] args) {
		Human1 h; 
		h = new Human1();
		h.age = 22;
		h.name = "Marsel";

		Human1 h2 = h;
		h2.age = 99;
		System.out.println(h.age);
		h.introduce();

		h.age = -9; // it's bad
		Human2 h3 = new Human2();
		// h3.age = 10;
		h3.setAge(10);
		System.out.println(h3.getAge());
	}
}