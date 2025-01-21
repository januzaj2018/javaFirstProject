import java.util.List;

public class Main {
    public static void main(String[] args) {
        Students student1 = new Students("John", 18, "Computer Science");
        Students student2 = new Students("Jane", 19, "Computer Science");
        student1.saveToDatabase(2);
        student2.saveToDatabase(2);
    }
}
