import java.util.List;

public class Main {
    public static void main(String[] args) {
        University university = new University("Astana IT University", "Astana");

        Professor professor1 = new Professor("Raikhan Madi");
        Professor professor2 = new Professor("Syndar");
        university.addProfessor(professor1);
        university.addProfessor(professor2);

        Course course1 = new Course("Calculus", 5);
        Course course2 = new Course("Physics", 3);
        Course course3 = new Course("Computer Science", 5);
        university.addCourse(course1);
        university.addCourse(course2);
        university.addCourse(course3);

        university.assignCourse(professor1, course1);
        university.assignCourse(professor2, course2);
        university.assignCourse(professor2, course3);


        System.out.println("Courses with at least 4 credits:");
        List<Course> filteredCourses = university.filterCoursesByCredits(4);
        filteredCourses.forEach(System.out::println);


        System.out.println("\nSearching for Professor 'Dr Junior':");
        Professor foundProfessor = university.findProfessorByName("Dr Junior");
        System.out.println(foundProfessor != null ? foundProfessor : "Professor not found");


        System.out.println("\nSearching for Course 'Physics':");
        Course foundCourse = university.findCourseByName("Physics");
        System.out.println(foundCourse != null ? foundCourse : "Course not found");


        System.out.println("\nCourses sorted by credits:");
        List<Course> sortedCourses = university.sortCoursesByCredits();
        sortedCourses.forEach(System.out::println);


        System.out.println("\nProfessors sorted by number of courses:");
        List<Professor> sortedProfessors = university.sortProfessorsByCourses();
        sortedProfessors.forEach(System.out::println);
    }
}