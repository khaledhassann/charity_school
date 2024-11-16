package Student;
public abstract class StudentDecorator extends Student {
    protected Student decoratorStudent;

    public StudentDecorator(Student decoratorStudent) {
        super(decoratorStudent.getUserID(), decoratorStudent.getName(),
                decoratorStudent.getContactInfo(), decoratorStudent.getEmail(),
                decoratorStudent.getPhone(), decoratorStudent.getAddress(),
                decoratorStudent.isBeneficiaryStatus(), decoratorStudent.getDateOfBirth(),
                decoratorStudent.getNationality(), decoratorStudent.getMajor(),
                decoratorStudent.getEnrollmentYear(), decoratorStudent.getDonors(),
                decoratorStudent.getSubjects());
        this.decoratorStudent = decoratorStudent;
    }

    @Override
    public void register() {
        decoratorStudent.register();
    }

}
