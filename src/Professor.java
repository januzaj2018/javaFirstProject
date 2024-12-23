import java.util.List;
import java.util.Objects;

public class Professor extends Person {
    public Professor(String name){
        super(name);
    }

    // Get the courses assigned to this professor from the University
    public List<Course> getCourses(University university) {
        return university.getCoursesForProfessor(this);
    }

    // Calculate total work hours based on course credits
    public int getTotalWorkHours(University university) {
        return getCourses(university).stream().mapToInt(Course::getCredits).sum() * 2; // 2 hours per credit
    }

    @Override
    public String toString() {
        return String.format("Professor { %s }", super.toString());
    }

    public int compareTo(Professor other, University university) {
        int courseComparison = Integer.compare(
                university.getCoursesForProfessor(this).size(),
                university.getCoursesForProfessor(other).size()
        );
        if (courseComparison != 0) return courseComparison;

        return Integer.compare(this.getTotalWorkHours(university), other.getTotalWorkHours(university));
    }

}
