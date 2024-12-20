import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public String toString() {
        return String.format(
                "Course ID: %d%nName: %s%nCredits: %d%nStudents Enrolled: %d",
                id, courseName, credits, getStudentCount()
        );
    }

    public int compareTo(Course other) {
        return Integer.compare(this.credits, other.credits);
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
}
