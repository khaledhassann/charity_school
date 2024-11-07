import java.util.List;
import java.util.Date;

public abstract class GraduateStudent extends Student {
    private String thesisTopic;
    private String advisorName;
    private boolean hasAppliedForResearchAid = false;
    private float grad_gpa;

    // Constructor
    public GraduateStudent(String userID, String name, String contactInfo, String email,
                           String phone, String address, boolean beneficiaryStatus,
                           String dateOfBirth, String nationality, String major, Date enrollmentYear,
                           List<Donor> donors, List<Subject> subjects,
                           String thesisTopic, String advisorName,float grad_gpa) {
        super(userID, name, contactInfo, email, phone, address, beneficiaryStatus,
                dateOfBirth, nationality, major, enrollmentYear, donors, subjects);
        this.thesisTopic = thesisTopic;
        this.advisorName = advisorName;
        this.grad_gpa=grad_gpa;
    }


    public void applyForResearchAid() {
        // Check if GPA is available and above a threshold for eligibility
        if (getGpa() < 3.0) {
            System.out.println(getName() + " is not eligible for research aid due to a GPA below the minimum requirement (3.0).");
            return;
        }

        // Check if thesis topic is defined
        if (thesisTopic == null || thesisTopic.isEmpty()) {
            System.out.println(getName() + " cannot apply for research aid without a defined thesis topic.");
            return;
        }

        // Check if student has applied for aid before (could be stored in a boolean flag, for example)
        if (hasAppliedForResearchAid()) {
            System.out.println(getName() + " has already applied for research aid. No further applications are allowed.");
            return;
        }

        // Mark that the student has applied for aid
        setHasAppliedForResearchAid(true);

        // Process the application (this could involve more steps like sending data to a database)
        System.out.println(getName() + " has successfully applied for research aid for the thesis topic: '" + thesisTopic + "' under advisor " + advisorName + ".");
    }
    public boolean hasAppliedForResearchAid() {
        return hasAppliedForResearchAid;
    }

    public void setHasAppliedForResearchAid(boolean hasApplied) {
        this.hasAppliedForResearchAid = hasApplied;
    }



    public void submitThesis() {
        System.out.println(name + " has submitted their thesis titled '" + thesisTopic + "' under advisor " + advisorName);
    }

    // Getters and Setters
    public String getThesisTopic() {
        return thesisTopic;
    }

    public void setThesisTopic(String thesisTopic) {
        this.thesisTopic = thesisTopic;
    }

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }
    public double getGpa() {
        return grad_gpa;
    }

    // Setter for GPA (if needed)
    public void setGpa(float grad_gpa) {
        this.grad_gpa = grad_gpa;
    }
}
