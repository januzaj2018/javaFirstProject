public class Course {
    private static int idGen = 0;
    private final int id;
    private String courseName;
    private int credits;

    public Course(String courseName, int credits) {
        this.id = idGen++;
        this.courseName = courseName;
        this.credits = credits;

    }

    public int getCourseId() {
        return id;
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


    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + id +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                '}';
    }
}
