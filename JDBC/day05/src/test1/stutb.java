package test1;

public class stutb {
    private String name;
    private int age;
    private String sex;
    private String department;
    private int score;

    public stutb() {
    }

    public stutb(String name, int age, String sex, String department, int score) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.department = department;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "stutb{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", department='" + department + '\'' +
                ", score=" + score +
                '}';
    }
}
