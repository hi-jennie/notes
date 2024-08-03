package CS61B.Practice;

public class Student {
    private final String name;
    private final int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return id == student.id && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + id;
    }

    @Override
    public String toString() {
        return STR."Student{name='\{name}\{'\''}, id=\{id}\{'}'}";
    }
}
