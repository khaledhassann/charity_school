package School;

import java.util.ArrayList;
import java.util.List;

// Concrete Subject for Charity (Donation Tracker)
class DonationTracker implements Subject {
    private static List<Observer> observers = new ArrayList<>();
    private double totalDonations;
    private List<String> ads = new ArrayList<>();

    // In DonationTracker class
    static Observer findObserverByUsername(String username) {
        for (Observer observer : observers) {
            if (observer instanceof Donor && ((Donor) observer).getName().equals(username)) {
                return observer;
            }
        }
        return null;
    }

    public void subscribeObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println(observer + " has been subscribed to donation updates.");
        } else {
            System.out.println(observer + " is already subscribed.");
        }
    }

    public void unsubscribeObserver(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
            System.out.println(observer + " has been unsubscribed from donation updates.");
        } else {
            System.out.println(observer + " is not subscribed.");
        }
    }

    public DonationTracker() {
        this.totalDonations = 0.0;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(totalDonations);
        }
    }

    public void addAd(String adContent) {
        ads.add(adContent);
        System.out.println("Ad added successfully: " + adContent);
    }

    // Method to make a donation and notify observers
    public void donate(double amount) {
        totalDonations += amount;
        System.out.println(Colors.GREEN + "Donation of " + amount + " received. Total donations are now: "
                + totalDonations + Colors.RESET);
        notifyObservers();
    }

    public List<String> getAds() {
        return new ArrayList<>(ads); // Return a copy of the ads list
    }

    // Method to get the total donations (used to show the current amount)
    public double getTotalDonations() {
        return totalDonations;
    }
}