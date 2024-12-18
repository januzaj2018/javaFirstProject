public class Students {
    private static int idGen = 0;
    private final int id;
    private String studentName;
    private int age;
    private String studentMajor;
    public Students(String studentName, int age, String studentMajor) {
        this.id = idGen++;
        this.studentName = studentName;
        this.age = age;
        this.studentMajor = studentMajor;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }

    public int getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getAge() {
        return age;
    }

    public String getStudentMajor() {
        return studentMajor;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", age=" + age +
                ", studentMajor='" + studentMajor + '\'' +
                '}';
    }
}
