package Test9;

public class Student {
    private String name;
    private String gender;
    private int age;


        public Student() {
    }

//    public Student(E name, E gender, E age) {
//        this.name = name;
//        this.gender = gender;
//        this.age = age;
//    }
//
//    public E getName() {
//        return name;
//    }
//
//    public void setName(E name) {
//        this.name = name;
//    }
//
//    public E getGender() {
//        return gender;
//    }
//
//    public void setGender(E gender) {
//        this.gender = gender;
//    }
//
//    public E getAge() {
//        return age;
//    }
//
//    public void setAge(E age) {
//        this.age = age;
//    }
//
    @Override
    public String toString() {
        return "Student{" +
                "name=" + name +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }

    public Student(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
