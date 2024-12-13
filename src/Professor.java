import java.util.List;
import java.util.ArrayList;
public class Professor {
    private static int idGen = 0;
    private int id;
    private String professorName;
    private String department;
    private List<Course> courses;
    public Professor(String professorName, String department) {
        this.id = idGen++;
        this.professorName = professorName;
        this.department = department;
        this.courses = new ArrayList<>();
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
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public List<Course> getCourses() {
        return courses;
    }
    public void addCourses(Course course) {
        this.courses.add(course);
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", professorName='" + professorName + '\'' +
                ", department='" + department + '\'' +
                ", courses=" + courses +
                '}';
    }
}
