package mas.xor;

enum UniversityName {
    WP, PJA
}

public class Student {

    private long id;
    private String firstName, secondName;
    private WarsawPolitechnic wp;
    private PolandJapaneseAcademy pja;

    public Student(long id, String firstName, String secondName) {
        this.id = id;
        this.setFirstName(firstName);
        this.setSecondName(secondName);
    }

    public Student(long id, String firstName, String secondName, UniversityName type, long universityId, String nameOfFaculty) {
        this.id = id;
        this.setFirstName(firstName);
        this.setSecondName(secondName);
        if (type == UniversityName.WP) {
            this.wp = new WarsawPolitechnic(universityId, nameOfFaculty);
            this.wp.addStudent(this);
        } else if (type == UniversityName.PJA) {
            this.pja = new PolandJapaneseAcademy(universityId, nameOfFaculty);
            this.pja.addStudent(this);
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("First name can't be null");
        }
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        if (secondName == null) {
            throw new IllegalArgumentException("Second name can't be null");
        }
        this.secondName = secondName;
    }

    public void addToUniversity(WarsawPolitechnic wp) {
        if (wp == null) {
            throw new IllegalArgumentException("University can't be null");
        }
        if (this.wp == wp) {
            return;
        }
        this.wp = wp;
        if (this.pja != null) {
            getPolandJapaneseAcademy().removeStudent(this);
        }
        wp.addStudent(this);

    }

    public void addToUniversity(PolandJapaneseAcademy pja) {
        if (pja == null) {
            throw new IllegalArgumentException("University can't be null");
        }
        if (this.pja == pja) {
            return;
        }
        this.pja = pja;
        if (this.wp != null) {
            getWarsawPolitechnic().removeStudent(this);
        }
        pja.addStudent(this);
    }

    public void removeStudent() {
        if (this.wp != null) {
            this.wp.removeStudent(this);
            this.wp = null;
        } 
        if (this.pja != null) {
            this.pja.removeStudent(this);
            this.pja = null;
        }
    }

    public WarsawPolitechnic getWarsawPolitechnic() {
        if (this.wp == null) {
            throw new IllegalArgumentException("Not a student of Warsaw Politechnic ");
        }
        return wp;
    }

    public PolandJapaneseAcademy getPolandJapaneseAcademy() {
        if (this.pja == null) {
            throw new IllegalArgumentException("Not a student of Poland Japanese Academy");
        }
        return pja;
    }

    public String toString() {
        return "\nStudent: " + getFirstName() + " " + getSecondName() + "\n" + (this.wp != null ? "Study in " + wp.getClass().getSimpleName() + ", on faculty of " + getWarsawPolitechnic(): "Not study in WP")
                + "\n" + (this.pja != null ? "Study in " + pja.getClass().getSimpleName() + ", on faculty of " + getPolandJapaneseAcademy() : "Not Study in PJATK");
    }

}
