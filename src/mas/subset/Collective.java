package mas.subset;

public class Collective extends Object4 {

    private String collectiveName;
    public static final String roleConsistsOf = "Consists of"; 
	public static final String roleManagedBy = "Managed by"; 

    public Collective(String collectiveName) {
        super();
        this.collectiveName = collectiveName;
    }

    public String getCollectiveName() {
        return collectiveName;
    }

    public void setCollectiveName(String collectiveName) {
        this.collectiveName = collectiveName;
    }

    @Override
    public String toString() {
        return collectiveName; //To change body of generated methods, choose Tools | Templates.
    }

}
