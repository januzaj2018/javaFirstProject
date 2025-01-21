import java.util.*;
import java.sql.*;
import java.util.stream.Collectors;
public class University {
    private static int idGen = 0;
    private int id;
    private String universityName;
    private String location;
    private List<Professor> professors;
    private List<Course> courses;
    private Map<Professor, List<Course>> professorCourses;

    public University(String universityName, String location) {
        this.id = idGen++;
        this.universityName = universityName;
        this.location = location;
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.professorCourses = new HashMap<>();
    }

    public int getId() {
        return id;
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
        return new ArrayList<>(professors);
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public void removeProfessor(Professor professor) {
        professors.remove(professor);
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void assignCourse(Professor professor, Course course) {
        professorCourses.computeIfAbsent(professor, k -> new ArrayList<>()).add(course);
    }

    public List<Course> getCoursesForProfessor(Professor professor) {
        return professorCourses.getOrDefault(professor, new ArrayList<>());
    }
    public List<Course> filterCoursesByCredits(int minCredits) {
        return courses.stream()
                .filter(course -> course.getCredits() >= minCredits)
                .collect(Collectors.toList());
    }

    public Professor findProfessorByName(String name) {
        return professors.stream()
                .filter(professor -> professor.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public Course findCourseByName(String name) {
        return courses.stream()
                .filter(course -> course.getCourseName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<Course> sortCoursesByCredits() {
        return courses.stream()
                .sorted(Comparator.comparingInt(Course::getCredits))
                .collect(Collectors.toList());
    }

    public List<Professor> sortProfessorsByCourses() {
        return professors.stream()
                .sorted((p1, p2) -> Integer.compare(
                        getCoursesForProfessor(p2).size(),
                        getCoursesForProfessor(p1).size()
                ))
                .collect(Collectors.toList());
    }
    public void saveToDatabase() {
        String sql = "INSERT INTO university (name, location) VALUES (?, ?) RETURNING id";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, universityName);
            stmt.setString(2, location);

            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                this.id = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<University> getAllUniversities() {
        List<University> universities = new ArrayList<>();
        String sql = "SELECT * FROM university";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while (resultSet.next()) {
                University university = new University(
                        resultSet.getString("name"),
                        resultSet.getString("location")
                );
                university.id = resultSet.getInt("id");
                universities.add(university);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return universities;}

    @Override
    public String toString() {
        return String.format(
                "University ID: %d, Name: %s, Location: %s, Professors: %d, Courses: %d",
                id, universityName, location, professors.size(), courses.size()
        );
    }
}
