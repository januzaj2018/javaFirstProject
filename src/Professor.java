import java.util.List;
import java.sql.*;
import java.util.ArrayList;
public class Professor extends Person {
    public Professor(String name) {
        super(name);
    }
    public List<Course> getCourses(University university) {
        return university.getCoursesForProfessor(this);
    }

    public int getTotalWorkHours(University university) {
        return getCourses(university).stream().mapToInt(Course::getCredits).sum() * 2;
    }
    public void saveToDatabase() {
        String query = "INSERT INTO professor (name) VALUES (?) RETURNING id";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, getName());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    setId(resultSet.getInt("id")); // Set the auto-generated ID
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setId(int id) {
        super.id = id;
    }


    public static List<Professor> getAllProfessors() {
        List<Professor> professors = new ArrayList<>();
        String sql = "SELECT * FROM professor";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while (resultSet.next()) {
                Professor professor = new Professor(resultSet.getString("name"));
                professors.add(professor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professors;
    }
    @Override
    public String toString() {
        return String.format("Professor { %s }", super.toString());
    }
}