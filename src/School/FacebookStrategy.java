package School;

// Concrete Strategy for Facebook
class FacebookStrategy implements SocialMediaStrategy {
    @Override
    public void createAdCampaign(String content) {

        DonationView.adsList.add("Facebook Ad: " + content);
        System.out.println("Running Facebook Ad Campaign: " + content);
    }

    @Override
    public void interactWithUsers() {
        System.out.println("Interacting with users on Facebook.");
    }
}