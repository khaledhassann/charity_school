package Student;
public class Aid {
    private String aidName;
    private String description;
    private boolean isAvailable;

    public Aid(String aidName, String description, boolean isAvailable) {
        this.aidName = aidName;
        this.description = description;
        this.isAvailable = isAvailable;
    }

    public String getAidName() {
        return aidName;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
