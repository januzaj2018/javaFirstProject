import java.util.ArrayList;
import java.util.List;

public class Department {
    private static int idGen = 0;
    private final int id;
    private String departmentName;
    private List<Professor> professors;
    private List<Course> courses;

    public Department(String departmentName) {
        this.id = idGen++;
        this.departmentName = departmentName;
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Professor> getProfessors() {
        return new ArrayList<>(professors);
    }

    public void addProfessor(Professor professor) {
        this.professors.add(professor);
    }

    public void removeProfessor(Professor professor) {
        this.professors.remove(professor);
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void removeCourse(Course course) {
        this.courses.remove(course);
    }

    @Override
    public String toString() {
        return String.format(
                "Department ID: %d, Name: %s, Professors: %d, Courses: %d",
                id, departmentName, professors.size(), courses.size()
        );
    }
}
