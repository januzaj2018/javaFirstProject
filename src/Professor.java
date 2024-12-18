
public class Professor {
    private static int idGen = 0;
    private final int id;
    private String professorName;

    public Professor(String professorName, String department) {
        this.id = idGen++;
        this.professorName = professorName;
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


    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", professorName='" + professorName + '\'' +
                '}';
    }
}
