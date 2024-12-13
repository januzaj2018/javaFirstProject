import java.util.ArrayList;
import java.util.List;
public class Course {
    private static int idGen = 0;
    private int courseId;
    private String courseName;
    private int credits;
    private List<Professor> professor;

    public Course(String courseName, int credits) {
        this.courseId= idGen++;
        this.courseName = courseName;
        this.credits = credits;
        this.professor = new ArrayList<>();
    }

    public int getCourseId() {
        return courseId;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {this.courseName = courseName;    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public List<Professor> getProfessor() {
        return professor;
    }

    public void addProfessor(Professor professor) {
        this.professor.add(professor);
    }
}
