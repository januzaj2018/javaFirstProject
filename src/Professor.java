import java.util.List;

public class Professor extends Person {
    public Professor(String name) {
        super(name);
    }
    public List<Course> getCourses(University university) {
        return university.getCoursesForProfessor(this);
    }

    public int getTotalWorkHours(University university) {
        return getCourses(university).stream().mapToInt(Course::getCredits).sum() * 2;
    }

    @Override
    public String toString() {
        return String.format("Professor { %s }", super.toString());
    }
}