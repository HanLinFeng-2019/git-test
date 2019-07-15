package Test12;
/*
：对Java基础班学生的考试成绩进行排序
1.定义一个学生类，有两个属性。姓名，考试成绩
2.在测试类中定义一个学生数组，存储学生信息。
使用Lambda省略格式写法对学生数组按照考试成绩由高到低进行排序
 */
public class Student {
    private String name;
    private int score;

    public Student() {
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
