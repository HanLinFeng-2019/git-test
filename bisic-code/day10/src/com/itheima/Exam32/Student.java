package com.itheima.Exam32;

import java.util.Scanner;

public class Student implements Study {

    private String name;//姓名
    private double score;//分数
    private Line lin;//班级

    @Override
    public void studyLine() {
        System.out.println("您报名的就业班为："+lin.getEmplymentClass()+",应缴纳学费："+lin.getMoney()+"元。");
    }
    public void exam(){
        if(score>=60){
            System.out.println("您的成绩为"+score+",考试通过");
        }else{
            System.out.println("您的成绩为"+score+",考试不通过");
        }

    }

    public Student() {

    }
    public Student(String name, double score, Line lin) {
        this.name = name;
        this.score = score;
        this.lin = lin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Line getLin() {
        return lin;
    }

    public void setLin(Line lin) {
        this.lin = lin;
    }
}
