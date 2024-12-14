import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
public class University {
    private static int idGen = 0;
    private final int id;
    private static String universityName;
    private String location;
    private List<Professor> professors;
    private  List<Course> courses;
    private Map<Professor, List<Course>> professorCourses;
    public University(String universityName, String location) {
        this.id = idGen++;
        this.universityName = universityName;
        this.location = location;
        this.professors = new ArrayList<Professor>();
        this.courses = new ArrayList<>();
        this.professorCourses = new HashMap<>();
    }
    public int getId() {
        return id;
    }
    public static String getName() {
        return universityName;
    }
    public void setName(String universityName) {
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
    public void addProfessor(Professor professor) {
        professors.add(professor);
    }
    public void removeProfessor(Professor professor){
        this.professors.remove(professor);
    }
    public List<Course> getCourses() {
        return courses;
    }
    public void addCourse (Course course){
        this.courses.add(course);
    }
    public void addCourses(List<Course> courses) {
        this.courses.addAll(courses);
    }

    public void removeCourse(Course course){
        this.courses.remove(course);
    }
    public void assignCourse(Professor professor, Course course){
        if (!professors.contains(professor)){
            throw new IllegalArgumentException("Professor is not in the university");
        }
        if (!courses.contains(course)){
            throw new IllegalArgumentException("Course is not offered by university");
        }
        if (!professorCourses.containsKey(professor)) {
            professorCourses.put(professor, new ArrayList<>());
        }
        professorCourses.get(professor).add(course);


    }
    public void unassignCourse(Professor professor, Course course){
        if (!professors.contains(professor)){
            throw new IllegalArgumentException("Professor is not in the university");
        }
        if (!courses.contains(course)){
            throw new IllegalArgumentException("Course is not offered by university");
        }
        professorCourses.get(professor).remove(course);
    }
    public List<Course> getCoursesForProfessor(Professor professor){
        return professorCourses.getOrDefault(professor, new ArrayList<>());
    }
    public void removeCoursesForProfessor(Professor professor){
        professorCourses.remove(professor);
    }
    public List<Professor> getProfessorsForCourse(Course course){
        return professorCourses.entrySet().stream()
                .filter(entry -> entry.getValue().contains(course))
                .map(Map.Entry::getKey)
                .toList();
    }
    public void removeProfessorsForCourse(Course course){
        for (Map.Entry<Professor, List<Course>> entry : professorCourses.entrySet()){
            if (entry.getValue().contains(course)){
                professorCourses.get(entry.getKey()).remove(course);
            }
        }
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + universityName + '\'' +
                ", location='" + location + '\'' +
                ", professors=" + professors.stream()
                .map(Professor::getProfessorName)
                .toList() +
                ", courses=" + courses.stream()
                .map(Course::getCourseName)
                .toList() +
                '}';
    }

}
