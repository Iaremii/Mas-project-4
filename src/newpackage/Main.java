package newpackage;

import java.util.Calendar;

/**
 *
 * @author Oleksandr
 */
public class Main {

    public static void main(String[] args) {

        Computer asus = new Computer("k55vm");
        Computer lenovo = new Computer("k5511vm");
        Computer acer = new Computer("k12m");
        System.out.println(Computer.getCounter());
        //xor
        Person p1 = new Person("Adam", "Ptach", PersonType.WORKER);
        Person p2 = new Person("Kuba", "Syta", PersonType.MANAGER);
        Person p3 = new Person("Nazar", "Iaremii", PersonType.WORKER);
        //ordered
        p1.getWorker().addComputer(asus);
        p1.getWorker().addComputer(lenovo);
        p3.getWorker().addComputer(asus);

        for (Computer arg : p1.getWorker().getComputers()) {
            System.out.println(arg.getModel());
        }
        Group test1 = new Group("GrupaMans");
        Group test2 = new Group("GrupaMans");

        //bag
        test1.addManager(p1.getManager());
        p2.getManager().addManager(test2);
        Calendar date = Calendar.getInstance();
        date.set(Calendar.MONTH, 12);
        test1.addManager(p1.getManager(), date);
        
        
        
    }

}
