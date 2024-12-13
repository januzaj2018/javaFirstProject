import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Professor professor1 = new Professor("Raikhan Madi",
                "Computational and Data Sciences");
        Professor professor2 = new Professor("Burbekova Saule",
                "General Education Disciplines");

        University university1 = new University("Astana IT University", "Astana");
        university1.addProfessor(professor1);
        university1.addProfessor(professor2);
        Course course1 = new Course("Calculus 1", 5);
        Course course2 = new Course("Calculus 2", 5);
        Course course3 = new Course("Foreign Language 2", 5);
        professor1.addCourses(course1);
        professor1.addCourses(course2);
        professor2.addCourses(course3);
        university1.addCourse(course1);
        university1.addCourse(course2);
        university1.addCourse(course3);
        System.out.println(university1);
    }


}