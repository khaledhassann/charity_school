public class SocialMediaHandler extends StudentDecorator {
    private final String socialMediaHandle;

    public SocialMediaHandler(Student decoratorStudent, String socialMediaHandle) {
        super(decoratorStudent);
        this.socialMediaHandle = socialMediaHandle;
    }

    public void linkSocialMedia(String socialMedia) {
        System.out.println(
                decoratorStudent.getName() + " linked to " + socialMedia + " using handle: " + socialMediaHandle);
    }

    public void shareEvent(String eventName, String eventDate) {
        System.out.println(decoratorStudent.getName() + " shared the event '" + eventName + "' scheduled for "
                + eventDate + " on social media.");
    }

    public void viewRecentPosts() {
        System.out.println(decoratorStudent.getName() + " is viewing recent social media posts.");
    }
}