import java.util.ArrayList;
import java.util.List;
public class Department {
    private static int idGen= 0;
    private final int id;
    private String departmentName;
    private List<Professor> professors;
    private List<Course> courses;
    public  Department(String departmentName){
        this.id = idGen++;
        this.departmentName = departmentName;
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }
    public void addProfessor(Professor professor){
        this.professors.add(professor);
    }
    public List<Professor> getProfessors(){
        return professors;
    }
    public void removeProfessor(Professor professor){
        this.professors.remove(professor);
    }
    public void addCourse(Course course){
        this.courses.add(course);
    }
    public List<Course> getCourses(){
        return courses;
    }
    public void removeCourse(Course course){
        this.courses.remove(course);
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

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
        // it's a setter method
        // it nulls list and sets it to given professors
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
        // it's a setter method
        // its nulls list and sets it to given courses
    }
}
