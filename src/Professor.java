import java.util.List;
import java.util.Objects;

public class Professor {
    private static int idGen = 0;
    private final int id;
    private String professorName;

    public Professor(String professorName) {
        this.id = idGen++;
        this.professorName = professorName;
    }

    public int getId() {
        return id;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
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
        return String.format("Professor ID: %d%nName: %s", id, professorName);
    }

    public int compareTo(Professor other, University university) {
        int courseComparison = Integer.compare(
                university.getCoursesForProfessor(this).size(),
                university.getCoursesForProfessor(other).size()
        );
        if (courseComparison != 0) return courseComparison;

        return Integer.compare(this.getTotalWorkHours(university), other.getTotalWorkHours(university));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return id == professor.id && Objects.equals(professorName, professor.professorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, professorName);
    }
}
