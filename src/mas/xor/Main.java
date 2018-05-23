package mas.xor;

/**
 *
 * @author Oleksandr
 */
public class Main {

    public static void main(String[] args) {
        Student oleksandr = new Student(1, "Oleksandr", "Iaremii");
        Student damian = new Student(2, "Damian", "Kondraciuk");

        PolandJapaneseAcademy pja = new PolandJapaneseAcademy(1, "Information Technology");

        WarsawPolitechnic wp = new WarsawPolitechnic(1, "History");

        //oleksandr.addToUniversity(pja);
        //damian.addToUniversity(pja);
        pja.addStudent(oleksandr);
        pja.addStudent(damian);

        System.out.println(pja.getStudents());

        damian.addToUniversity(wp);
        System.out.println(pja.getStudents());
        System.out.println(wp.getStudents());
        
        System.out.println("-----------------------");
        Student Rafal = new Student(0, "Rafal", "Tomaszewki", UniversityName.PJA, 1, "Culture of Japan");
        System.out.println(Rafal);
        wp.addStudent(Rafal);

        System.out.println(Rafal);
        System.out.println(wp.getStudents());

    }

}
