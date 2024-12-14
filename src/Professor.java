
public class Professor {
    private static int idGen = 0;
    private final int id;
    private String professorName;
    private String department;

    public Professor(String professorName, String department) {
        this.id = idGen++;
        this.professorName = professorName;
        this.department = department;
    }
    public int getId() {
        return id;
    }
    public String getProfessorName() {
        return professorName;
    }
    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", professorName='" + professorName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
