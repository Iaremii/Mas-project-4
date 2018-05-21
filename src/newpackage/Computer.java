package newpackage;

public class Computer {

    private int id;
    private String model;
    private static int counter = 0;

    public Computer(String model) {
        setCounter(counter);
        this.id = getCounter();
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        counter++;
        Computer.counter = counter;
    }

    @Override
    public String toString() {
        return "Computer{" + "id=" + id + ", model=" + model + '}';
    }
    

}
