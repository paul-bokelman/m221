class Staff {

    private String firstname;
    private String lastname;
    private int employeeID;
    private int yearsExperience;
    private int accomplishments;

    public void Staff(String firstname, String lastname, int employeeID, int yearsExperience, int accomplishments) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.employeeID = employeeID;
        this.yearsExperience = yearsExperience;
        this.accomplishments = accomplishments;
    }

    public void Staff() {
        firstname = "unknown";
        lastname = "unknown";
        employeeID = -1;
        yearsExperience = -1;
        accomplishments = -1;
    }

    public String fullName() {
        return firstname + " " + lastname;
    }

    public boolean isExperienced() {
        if (yearsExperience >= 10) {
            return true;
        } else if (yearsExperience >= 5 && accomplishments >= 2) {
            return true;
        }
        return false;
    }

}

public class MinilabNumber3 {
    public static void main(String[] args) {

        Staff roop = new Staff();
        roop.Staff("jag", "roop", 123, 7, 3);
        System.out.println(roop.fullName() + " is experienced? : " + roop.isExperienced());

    }
}
