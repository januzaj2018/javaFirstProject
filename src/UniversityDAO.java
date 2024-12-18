import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UniversityDAO {
    public void addUniversity(String name, String location) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO university (name, location) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, location);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<String> getUniversities() {
        List<String> universities = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT id, name, location FROM university";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String location = resultSet.getString("location");
                    universities.add("ID: " + id + ", Name: " + name + ", Location: " + location);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return universities;
    }
    public void updateUniversity(int id, String name, String location) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "UPDATE university SET name = ?, location = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, location);
                preparedStatement.setInt(3, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteUniversity(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM university WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void searchUniversity(String name) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT id, name, location FROM university WHERE name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String location = resultSet.getString("location");
                    System.out.println("ID: " + id + ", Name: " + name + ", Location: " + location);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
