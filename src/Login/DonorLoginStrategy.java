package Login;
import java.util.ArrayList;
import java.util.List;

import DonorPackage.*;
public class DonorLoginStrategy extends ILoginStrategy {

    private final String[] filePaths = {"./src/Data/DonorsMonetary.txt", "./src/Data/DonorsTeaching.txt"};

    @Override
    public boolean login(String username, String password) {
        // System.out.print("Validating credentials..." + username + " " + password);

        for(int i=0; i<filePaths.length; i++){
            if (validate(username, password, filePaths[i])){  

                // Route to relevant page
                // Create appropriate donor based on login info
                List<Subject> subjects = new ArrayList<>();
                subjects.add(new Subject("Math", 1));
                subjects.add(new Subject("Science", 2));
                subjects.add(new Subject("History", 3));
                School school = new School(subjects, "school1");

                Donor donor =  null;
                if(i==0){
                    donor = new MonetaryDonor(username, (username + "@gmail.com"), school);
                    System.out.println("\nWelcome Monetary Donor " + username);
                }else{
                    donor = new TeacherDonor(username, (username + "@gmail.com"), school);
                    System.out.println("\nWelcome Teacher Donor " + username);
                }
                // Call the donor menu
                DonorMain donorMain = new DonorMain();
                donorMain.showMenu(donor, school);

                return true;
            }
        }
        System.out.println("Invalid credentials. Please try again.");
        return false;

    }
}
