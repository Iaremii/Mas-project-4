package newpackage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Group {

    private int id;
    private String name;
    private static int counter = 0;
    private static Map<String, Group> groups = new HashMap<String, Group>();

    public Group(String name) throws RuntimeException {
        counter++;
        setId(counter);
        setName(name);
        groups.put(name, this);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (findGroup(name)) {
            throw new RuntimeException("Group already exists.");
        }
        this.name = name;
    }

    public static boolean findGroup(String name) {
        return groups.containsKey(name);
    }

    public static void removeGroup(Group group) {
        if (groups.containsValue(group)) {
            groups.remove(group);
        } else {
            throw new RuntimeException("This group has not of extension");
        }
    }

    public void addManager(Manager manager, Calendar to) {
        new ManagerGroup(manager, this, to);
    }

    public void addManager(Manager manager) {
        new ManagerGroup(manager, this);
    }

    public ArrayList<ManagerGroup> getManagerPairs() {
        return ManagerGroup.getManagerGroups(this);
    }

    public Set<Manager> getManager() {
        Set<Manager> manager = new HashSet<Manager>();
        for (ManagerGroup item : getManagerPairs()) {
            manager.add(item.getManager());
        }
        return manager;
    }

    @Override
    public String toString() {
        return "Group{" + "id=" + id + ", name=" + name + '}';
    }
    
}
