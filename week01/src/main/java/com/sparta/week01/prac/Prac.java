package com.sparta.week01.prac;

import java.util.ArrayList;
import java.util.List;

public class Prac {

    public static int sub(int num1, int num2) {
        return num1 - num2;
    }

    public static void main(String[] args) {

        List<String> courseList = new ArrayList<>();
        String course1 = "웹 개발의 봄 Spring";
        String course2 = "웹 개발의 꽃 React";

        courseList.add(course1);
        courseList.add(course2);
//        courseList.remove(1);

        for (int i = 0; i < courseList.size(); i++) {
            String course = courseList.get(i);
            System.out.println("course = " + course);
        }

        for (String course : courseList) {
            System.out.println("course = " + course);
        }


        System.out.println("courseList = " + courseList);

        int ret = sub(1, 2);
        System.out.println("ret = " + ret);


        Course course = new Course();
        course.setTitle("웹개발의 봄, Spring");
        course.setTutor("남병관");
        System.out.println(course.getTitle());
        System.out.println(course.getTutor());

        String title = "웹 개발의 꽃 React";
        String tutor = "임민영";
        int days = 35;
        Course course3 = new Course(title, tutor, days);

        System.out.println(course3.getTitle());
        System.out.println(course3.getTutor());

    }
}
