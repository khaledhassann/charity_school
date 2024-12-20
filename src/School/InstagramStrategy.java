package School;

// Concrete Strategy for Instagram
class InstagramStrategy implements SocialMediaStrategy {
    @Override
    public void createAdCampaign(String content) {

        DonationView.adsList.add("Instagram Ad: " + content);
        System.out.println("Running Instagram Ad Campaign: " + content);
    }

    @Override
    public void interactWithUsers() {
        System.out.println("Interacting with users on Instagram.");
    }
}