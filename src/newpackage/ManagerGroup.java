package newpackage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

public class ManagerGroup {

    private Manager manager;
    private Group group;
    private Calendar dateFrom;
    private Calendar dateTo;
    private static ArrayList<ManagerGroup> managerGroup = new ArrayList<>();

    public ManagerGroup(Manager manager, Group group, Calendar to) {
        setManager(manager);
        setGroup(group);
        setFrom(Calendar.getInstance());
        setTo(to);
        managerGroup.add(this);
    }
    public ManagerGroup(Manager manager, Group group) {
        setManager(manager);
        setGroup(group);
        setFrom(Calendar.getInstance());
        setTo(null);
        managerGroup.add(this);
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public static ArrayList<ManagerGroup> getManagerGroup() {
        return managerGroup;
    }

    public static void setManagerGroup(ArrayList<ManagerGroup> managerGroup) {
        ManagerGroup.managerGroup = managerGroup;
    }

    public void setFrom(Calendar from) {
        this.dateFrom = Calendar.getInstance();
        dateFrom.clear();
        dateFrom.set(from.get(Calendar.YEAR), from.get(Calendar.MONTH), from.get(Calendar.DAY_OF_MONTH));

    }

    public void setTo(Calendar dateTo) throws RuntimeException {

        if (dateTo == null) {
            this.dateTo = null;
        } else if (dateTo.compareTo(this.dateFrom) < 0) {
            throw new RuntimeException("The end date is earlier than the start date");
        } else {
            this.dateTo = Calendar.getInstance();
            this.dateTo.clear();
            this.dateTo.set(dateTo.get(Calendar.YEAR), dateTo.get(Calendar.MONTH), dateTo.get(Calendar.DAY_OF_MONTH));
        }
    }

    public static boolean removeGroup(Group group) {
        for (ManagerGroup cg : managerGroup) {
            if (cg.getGroup() == group) {
                for (ManagerGroup item : getManagerGroups(group)) {
                    managerGroup.remove(item);
                }
                return true;
            }
        }
        return false;
    }

    public static ArrayList<ManagerGroup> getManagerGroups(Group group) {
        ArrayList<ManagerGroup> allGroups = new ArrayList<ManagerGroup>();
        for (ManagerGroup item : managerGroup) {
            if (item.getGroup() == group) {
                allGroups.add(item);
            }
        }
        return allGroups;
    }

}
