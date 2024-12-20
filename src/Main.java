public class Main {
    public static void main(String[] args) {

        University uni = new University("Global University", "New York");


        Professor prof1 = new Professor("Dr. Smith");
        Professor prof2 = new Professor("Dr. Brown");


        Course course1 = new Course("Math 101", 3);
        Course course2 = new Course("Physics 101", 4);
        Course course3 = new Course("History 101", 2);

        uni.addProfessor(prof1);
        uni.addProfessor(prof2);

        uni.addCourse(course1);
        uni.addCourse(course2);
        uni.addCourse(course3);


        uni.assignCourse(prof1, course1);
        uni.assignCourse(prof1, course2);
        uni.assignCourse(prof2, course3);


        System.out.println(prof1);
        System.out.println("Courses: " + prof1.getCourses(uni));
        System.out.println("Total Work Hours: " + prof1.getTotalWorkHours(uni) + " hours");

        System.out.println("\n" + prof2);
        System.out.println("Courses: " + prof2.getCourses(uni));
        System.out.println("Total Work Hours: " + prof2.getTotalWorkHours(uni) + " hours");

        System.out.println("\nComparing Professors:");
        int comparison = prof1.compareTo(prof2, uni);
        if (comparison > 0) {
            System.out.println(prof1.getProfessorName() + " has more courses or work hours than " + prof2.getProfessorName());
        } else if (comparison < 0) {
            System.out.println(prof2.getProfessorName() + " has more courses or work hours than " + prof1.getProfessorName());
        } else {
            System.out.println(prof1.getProfessorName() + " and " + prof2.getProfessorName() + " are equal in terms of courses and work hours.");
        }
    }
}
