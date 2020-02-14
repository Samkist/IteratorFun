package me.Samkist.Sort;

import java.util.ArrayList;

public class Student implements Comparable<Student> {
    private ArrayList<Double> tests = new ArrayList<>();
    private ArrayList<Double> quizzes = new ArrayList<>();
    private double finalAverage;
    private double homeWorkAverage;
    private String name;

    //    final average=0.5(Test Average)+0.3(Quiz Average)+0.2( Homework Average)
    public Student(String name) {
        this.name = name;
    }

    public void addTest(Double t) throws IndexOutOfBoundsException {
        if(tests.size() + 1 > 5) throw new IndexOutOfBoundsException();
        tests.add(t);
        updateFinalAverage();
    }

    public void addQuiz(Double q) throws IndexOutOfBoundsException {
        if(quizzes.size() + 1 > 8) throw new IndexOutOfBoundsException();
        quizzes.add(q);
        updateFinalAverage();
    }

    public void setHomeWorkAverage(Double h) {
        homeWorkAverage = h;
        updateFinalAverage();
    }

    public void updateFinalAverage() {
        finalAverage = (0.5 * getTestAverage()) + (0.3 * getQuizAverage()) + (0.2 * homeWorkAverage);
    }

    public double getFinalAverage() {
        return finalAverage;
    }

    public double getTestAverage() {
        double total = 0;
        for(Double d : tests) {
            total += d;
        }
        return total / tests.size();
    }

    public double getQuizAverage() {
        double total = 0;
        for(Double d : quizzes) {
            total += d;
        }
        return total / quizzes.size();
    }

    //Used for comparison
    @Override
    public String toString() {
        return name;
    }

    //Used for printing
    public String print() {
        return "Name: " + toString() + "\n"
                + "HW Average: " + homeWorkAverage + "\n"
                + "Quiz Average: " + getQuizAverage() + "\n"
                + "Test Average: " + getTestAverage() + "\n"
                + "Final Average: " + getFinalAverage() + "\n";
    }

    @Override
    public int compareTo(Student student) {
        return (int) (student.getFinalAverage() - getFinalAverage());
    }
}
