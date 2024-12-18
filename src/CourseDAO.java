import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CourseDAO {
    public void addCourse(String name, int credits) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO course (name, credits) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, credits);
                preparedStatement.executeUpdate();
                System.out.println("Successfully added course " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<String> getCourses() {
        List<String> courses = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT id, name, credits FROM course";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");

                    int credits = resultSet.getInt("credits");
                    courses.add("ID: " + id + ", Name: " + name + ", Credits: " + credits);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
    public void updateCourse(int id, String name, String description, int credits) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "UPDATE course SET name = ?, credits = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, credits);
                preparedStatement.setInt(3, id);
                preparedStatement.executeUpdate();
                System.out.println("Successfully updated course " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteCourse(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM course WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                System.out.println("Successfully deleted course with id " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void searchCourse(String name) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT id, name, credits FROM course WHERE name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.isBeforeFirst() == false) {
                    System.out.println("Course not found");
                }
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String courseName = resultSet.getString("name");

                    int credits = resultSet.getInt("credits");
                    System.out.println("ID: " + id + ", Name: " + courseName +  ", Credits: " + credits);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
