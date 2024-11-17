// Context Class to use the Strategy
class SocialMediaContext {
    private SocialMediaStrategy strategy;

    // Set the current strategy dynamically
    public void setStrategy(SocialMediaStrategy strategy) {
        this.strategy = strategy;
    }

    // Execute the strategy
    public void executeAdCampaign(String content) {
        if (strategy != null) {
            strategy.createAdCampaign(content);
        } else {
            System.out.println("No strategy selected.");
        }
    }

    // Execute user interaction action
    public void executeUserInteraction() {
        if (strategy != null) {
            strategy.interactWithUsers();
        } else {
            System.out.println("No strategy selected.");
        }
    }
}