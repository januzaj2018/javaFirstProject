public class Main {
    public static void main(String[] args) {

        University uni = new University("Global University", "New York");


        Professor prof1 = new Professor("Dr. Smith");
        Students student1 = new Students("Alice", 20, "Computer Science");


        Course course1 = new Course("Math 101", 3);


        uni.addProfessor(prof1);
        uni.addCourse(course1);


        uni.assignCourse(prof1, course1);

        System.out.println(prof1);
        System.out.println("Courses: " + prof1.getCourses(uni));

        System.out.println(student1);
    }
}
