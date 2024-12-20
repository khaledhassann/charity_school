package School;

// Concrete Strategy for Twitter
class TwitterStrategy implements SocialMediaStrategy {
    @Override
    public void createAdCampaign(String content) {

        DonationView.adsList.add("Twitter Ad: " + content);
        System.out.println("Running Twitter Ad Campaign: " + content);
    }

    @Override
    public void interactWithUsers() {
        System.out.println("Interacting with users on Twitter.");
    }
}