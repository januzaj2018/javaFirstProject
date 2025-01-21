import java.sql.*;
public class Students extends Person {
    private int age;
    private String major;
    public Students(String name, int age, String major) {
        super(name);
        this.age = age;
        this.major = major;
    }
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    public void saveToDatabase(int courseId) {
        String sql = "INSERT INTO student (name, age, major, course_id) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, super.getName());
            stmt.setInt(2, age);
            stmt.setString(3, major);
            stmt.setInt(4, courseId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }}
    @Override
    public String toString() {
        return String.format("Student { %s, Age: %d, Major: %s }", super.toString(), age, major);
    }
}
