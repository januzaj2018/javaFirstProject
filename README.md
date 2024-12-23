# University Management System

This project is a **University Management System** implemented in Java. It models key entities like Universities, Departments, Courses, Professors, and Students, with functionality to manage and interact with these entities programmatically.

## Features

### University
- Manage professors, students, and courses.
- Assign courses to professors.
- Retrieve professors and students associated with specific courses.
- Organize courses within departments.

### Professor
- Automatically assigned unique IDs.
- Retrieve courses assigned to them from the university.
- Calculate total work hours based on assigned courses.

### Students
- Automatically assigned unique IDs.
- Represent students with attributes like age, name, and major.
- Easily retrieve student details.

### Department
- Organize professors and courses within a department.
- Add or remove professors and courses.

### Course
- Automatically assigned unique IDs.
- Store attributes like course name and credits.
- Associate with professors and students.

## Class Diagram

- **Base Classes**
  - `Person`: Abstract class for `Professor` and `Students`.
  - `UniversityEntity`: Abstract class for `Course` and `Department`.
- **Inheritance Relationships**
  - `Professor` and `Students` inherit from `Person`.
  - `Course` and `Department` inherit from `UniversityEntity`.

## Installation and Setup

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/university-management-system.git
   cd university-management-system
   ```

2. **Compile the Code**
   Compile all `.java` files in the `src` directory:
   ```bash
   javac src/*.java
   ```

3. **Run the Program**
   Execute the `Main` class:
   ```bash
   java src.Main
   ```

## Example Usage

Below is an example of how to use the system programmatically:

```java
public class Main {
    public static void main(String[] args) {
        University university = new University("Global University", "New York");

        Professor professor = new Professor("Dr. Smith");
        Students student = new Students("Alice", 20, "Computer Science");
        Course course = new Course("Math 101", 3);

        university.addProfessor(professor);
        university.addCourse(course);
        university.assignCourse(professor, course);

        System.out.println(professor);
        System.out.println("Courses: " + professor.getCourses(university));

        System.out.println(student);
    }
}
```

### Output
```
Professor { ID: 0, Name: Dr. Smith }
Courses: [Course { ID: 0, Name: Math 101, Credits: 3 }]
Student { ID: 1, Name: Alice, Age: 20, Major: Computer Science }
```

## Project Structure
```
.
|-- src/
|   |-- University.java
|   |-- Department.java
|   |-- Course.java
|   |-- Professor.java
|   |-- Students.java
|   |-- Person.java
|   |-- Main.java
|-- README.md
```

## Technologies Used
- Java 17
- Stream API for collections management.
- Object-Oriented Programming principles including inheritance and polymorphism.

## Future Improvements
- **Persistence**: Add database integration to store and retrieve university data.
- **GUI**: Develop a graphical user interface for easier management.
- **API Integration**: Expose functionality through a REST API for external systems.
- **Enrollment System**: Allow students to enroll in courses programmatically.

## Contributing
1. Fork the repository.
2. Create a new branch for your feature/bug fix.
3. Commit your changes and push to your branch.
4. Open a Pull Request for review.

## License
This project is licensed under the MIT License. See the LICENSE file for details.

## Contact
For any questions or suggestions, feel free to reach out at [your_email@example.com].

