package newpackage;

import java.util.Calendar;

public class Manager {

    private Person person;

    public Manager(Person person) {
        setPerson(person);
    }

    public void setPerson(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person can't be null");
        }
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void addManager(Group group) {
        new ManagerGroup(this, group);
    }

    public void addManager(Group group, Calendar to) {
        new ManagerGroup(this, group, to);
    }

    @Override
    public String toString() {
        return "Manager " + this.getPerson().getName() + " " + getPerson().getSurname(); //To change body of generated methods, choose Tools | Templates.
    }

}
