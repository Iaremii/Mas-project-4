package mas.subset;

/**
 *
 * @author Oleksandr
 */
public class Main {

    public static void main(String[] args) {
        Person p = new Person("John", "Smith");
        Collective g = new Collective("Group no 1");

        try {
            p.addLink(Person.roleBelongsTo, Collective.roleConsistsOf, g);
            p.addLink_subset(Person.manages, Collective.roleManagedBy, Person.roleBelongsTo, g);
            p.showLinks(System.out);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
