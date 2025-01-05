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

    @Override
    public String toString() {
        return String.format("Student { %s, Age: %d, Major: %s }", super.toString(), age, major);
    }
}
