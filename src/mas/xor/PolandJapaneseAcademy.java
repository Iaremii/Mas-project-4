package mas.xor;

import java.util.HashSet;
import java.util.Set;

public class PolandJapaneseAcademy {
    private long id;
    private String faculty;
    private Set<Student> students = new HashSet<>();

    public PolandJapaneseAcademy(long id, String faculty) {
        this.id = id;
        this.setFaculty(faculty);
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        if (faculty == null) {
            throw new IllegalArgumentException("Faculty can't be null!");
        }
        this.faculty = faculty;
    }

    public void addStudent(Student student) {
        if (!this.students.contains(student)) {
            this.students.add(student);
            student.addToUniversity(this);
        }
    }

    public void removeStudent(Student student) {
        if (this.students.contains(student)) {
            this.students.remove(student);
            student.removeStudent();
        }
    }

    public Set<Student> getStudents() {
        
        return new HashSet<Student>(students);
    }

    public String toString() {
        return getFaculty();
    }
}