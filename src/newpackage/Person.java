package newpackage;

public class Person {

    private String name;
    private String surname;
    private Worker worker;
    private Manager manager;

    public Person(String name, String surname, PersonType type) {
        setName(name);
        setSurname(surname);
        if (type == PersonType.WORKER) {
            this.worker = new Worker(this);
            this.manager = null;
        } else if (type == PersonType.MANAGER) {
            this.worker = null;
            this.manager = new Manager(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Worker getWorker() {
        return this.worker;
    }

    public Manager getManager() {
        return this.manager;
    }

    public String toString() {
        if (this.worker != null) {
            return this.getWorker().toString();
        } else {
            return this.getManager().toString();
        }
    }
}
