package ru.itis.inherritance;

public class Main {

    public static void main(String[] args) {

	    Human marsel = new Human(22, "Marsel");
        Flash john = new Flash(22, "John", 160);
        marsel.introduce();
        john.introduce();

        // Восходящее преобразование
        Human johnAsHuman = john;
        johnAsHuman.introduce();

        Flash michael = new Flash(34,"Michael", 79);
        Human slava = new Human(23, "Slava");

        Human humans[] = {john, marsel, slava, michael};

        for (Human human : humans) {
            human.introduce();
            human.sayBye();
        }




    }
}
