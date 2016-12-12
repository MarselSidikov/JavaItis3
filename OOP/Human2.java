class Human2 {
	private static final String DEFAULT_NAME = "DEFAULT";
	private static final int DEFAULT_AGE = 1;

	// private - access modifier
	private int age;
	private String name;

	// constructor - it's a thing that initialize object
	public Human2() {
		this.age = DEFAULT_AGE;
		this.name = DEFAULT_NAME;
	}

	public Human2(int age, String name) {
		setAge(age);
		setName(name);
	}

	// access methods - getters/setters
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age >= 0) {
			this.age = age;
		} else {
			this.age = DEFAULT_AGE;
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
 }