package Student;
import java.util.List;
import java.util.Date;

public  class GraduateStudent extends Student {
    private String thesisTopic;
    private String advisorName;
    private boolean hasAppliedForResearchAid ;
    private float grad_gpa;

    // Constructor
    public GraduateStudent(String userID, String name, String contactInfo, String email,
                           String phone, String address, boolean beneficiaryStatus,
                           String dateOfBirth, String nationality, String major, Date enrollmentYear,
                           List<Donor> donors, List<Subject> subjects,
                           String thesisTopic, String advisorName, float grad_gpa, boolean hasAppliedForResearchAid) {
        super(
                userID != null ? userID : StudentConfig.DEFAULT_USER_ID,
                name != null ? name : StudentConfig.DEFAULT_NAME,
                contactInfo != null ? contactInfo : StudentConfig.DEFAULT_CONTACT_INFO,
                email != null ? email : StudentConfig.DEFAULT_EMAIL,
                phone != null ? phone : StudentConfig.DEFAULT_PHONE,
                address != null ? address : StudentConfig.DEFAULT_ADDRESS,
                beneficiaryStatus,
                dateOfBirth != null ? dateOfBirth : StudentConfig.DEFAULT_DATE_OF_BIRTH,
                nationality != null ? nationality : StudentConfig.DEFAULT_NATIONALITY,
                major != null ? major : StudentConfig.DEFAULT_MAJOR,
                enrollmentYear != null ? enrollmentYear : StudentConfig.DEFAULT_ENROLLMENT_YEAR,
                (donors != null && !donors.isEmpty()) ? donors : StudentConfig.DEFAULT_DONORS,
                (subjects != null && !subjects.isEmpty()) ? subjects : StudentConfig.DEFAULT_SUBJECTS
        );

        this.thesisTopic = thesisTopic != null ? thesisTopic : StudentConfig.DEFAULT_THESIS_TOPIC;
        this.advisorName = advisorName != null ? advisorName : StudentConfig.DEFAULT_ADVISOR_NAME;
        this.grad_gpa = grad_gpa > 0 ? grad_gpa : StudentConfig.DEFAULT_Grad_GPA;
        boolean defaultResearchAidStatus = StudentConfig.DEFAULT_RESEARCH_AID_STATUS;

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


    public void setGpa(float grad_gpa) {
        this.grad_gpa = grad_gpa;
    }
}
