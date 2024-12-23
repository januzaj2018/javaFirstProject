public abstract class Person {
    private static int idGen = 0;
    private final int id;
    private String name;

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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s", id, name);
    }
}
