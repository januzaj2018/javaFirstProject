import java.util.ArrayList;
import java.util.List;

public class University {
    private static int idGen = 0;
    private int id;
    private String universityName;
    private String location;
    private List<Professor> professors;
    private  List<Course> courses;
    public University(String universityName, String location) {
        this.id = idGen++;
        this.universityName = universityName;
        this.location = location;
        this.professors = new ArrayList<Professor>();
        this.courses = new ArrayList<>();
    }
    public String getUniversityName() {
        return universityName;
    }
    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public List<Professor> getProfessors() {
        return professors;
    }
    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }
    public List<Course> getCourses() {
        return courses;
    }
    public void addCourse (Course course){
        this.courses.add(course);
    }

}
