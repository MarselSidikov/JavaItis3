package ru.itis;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;


public class Human {
    private int age;
    private String name;
    private boolean isStudent;

    public Human(int age, String name, boolean isStudent) {
        this.age = age;
        this.name = name;
        this.isStudent = isStudent;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public String toString() {
        // return "age: " + age + " name: " + name + " isStudent: " + isStudent;
        return MoreObjects.toStringHelper(this)
                .add("age of man", this.age)
                .add("name", this.name)
                .add("isStudent", this.isStudent()).toString();

    }

    public boolean equals(Object object) {
        if (object == null || !object.getClass().equals(this.getClass())) {
            return false;
        } else {
            Human that = (Human)object;
            //return this.name.equals(that.name) &&
            //        (this.age == that.age) && (this.isStudent == that.isStudent);
            return Objects.equal(this.age, that.age) &&
                    Objects.equal(this.name, that.name) &&
                    Objects.equal(this.isStudent, this.isStudent);
        }
    }

    public int hashCode() {
        return java.util.Objects.hash(this.age, this.name, this.isStudent);
    }

}
