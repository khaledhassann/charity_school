import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Subject> subjects = new ArrayList<Subject>() {
            {
                add(new AdvancedModule(new Math()));
                add(new Science());
                add(new ExtraCurricular(new History()));
            }
        };

        School AinShamsLanguageSchool = new School("Ain Shams Language School", "Abbaseya", subjects);
        SchoolController schoolController = new SchoolController(AinShamsLanguageSchool);
        SchoolView schoolView = new SchoolView(schoolController);

        schoolView.showMenu();
    }

}
