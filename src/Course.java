import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.sql.*;


public class Course {
    private static int idGen = 0;
    private final int id;
    private String courseName;
    private int credits;
    private List<Students> enrolledStudents;

    public Course(String courseName, int credits) {
        this.id = idGen++;
        this.courseName = courseName;
        this.credits = credits;
        this.enrolledStudents = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void addStudent(Students student) {
        enrolledStudents.add(student);
    }

    public int getStudentCount() {
        return enrolledStudents.size();
    }

    public List<Students> getEnrolledStudents() {
        return new ArrayList<>(enrolledStudents);
    }
    public void saveToDatabase(int professorId) {
        String sql = "INSERT INTO course (name, credits, professor_id) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, courseName);
            stmt.setInt(2, credits);
            stmt.setInt(3, professorId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM course";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while (resultSet.next()) {
                Course course = new Course(
                        resultSet.getString("name"),
                        resultSet.getInt("credits")
                );
                courses.add(course);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && credits == course.credits && courseName.equals(course.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, credits);
    }

    @Override
    public String toString() {
        return String.format(
                "Course ID: %d, Name: %s, Credits: %d, Students Enrolled: %d",
                id, courseName, credits, getStudentCount()
        );
    }

    public int compareTo(Course other) {
        return Integer.compare(this.credits, other.credits);
    }
}