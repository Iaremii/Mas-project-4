package newpackage;

import java.util.ArrayList;

public class Worker {

    private Person person;

    private ArrayList<Computer> computers;

    public Worker(Person person) {
        setPerson(person);
    }

    public void setPerson(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person can't be null");
        }
        this.person = person;
        this.computers = new ArrayList<>();
    }

    public Person getPerson() {
        return person;
    }

    public ArrayList<Computer> getComputers() {
        return this.computers;
    }
    public void removeComputer(Computer computer){
        if(computer == null){
            throw new IllegalArgumentException("Computer is not found");
        }
            computers.remove(computer);
    }

    public void addComputer(Computer computer) {
        computers.add(computer);
    }

    @Override
    public String toString() {
        return "Worker{" + "person=" + getPerson().getName() + " " + getPerson().getSurname() + ", computers=" + computers + '}';
    }
    
    

}
