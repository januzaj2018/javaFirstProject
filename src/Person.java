public abstract class Person {
    private static int idGen = 0;
    private final int id;
    private String name;
    private int age;

    public Person(String name) {
        this.id = idGen++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s", id, name);
    }
}
