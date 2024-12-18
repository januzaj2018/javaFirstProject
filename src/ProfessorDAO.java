import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ProfessorDAO {
    public void addProfessor(String name, String surname, String title) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO professor (name, surname, title) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, surname);
                preparedStatement.setString(3, title);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<String> getProfessors() {
        List<String> professors = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT id, name, surname, title FROM professor";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String surname = resultSet.getString("surname");
                    String title = resultSet.getString("title");
                    professors.add("ID: " + id + ", Name: " + name + ", Surname: " + surname + ", Title: " + title);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professors;
    }
    public void updateProfessor(int id, String name, String surname, String title) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "UPDATE professor SET name = ?, surname = ?, title = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, surname);
                preparedStatement.setString(3, title);
                preparedStatement.setInt(4, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteProfessor(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM professor WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void searchProfessor(String name) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT id, name, surname, title FROM professor WHERE name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String surname = resultSet.getString("surname");
                    String title = resultSet.getString("title");
                    System.out.println("ID: " + id + ", Name: " + name + ", Surname: " + surname + ", Title: " + title);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
