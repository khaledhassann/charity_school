## Objective
Implement the **Class Room** part of the class diagram using the **Decorator Design Pattern**, where a classroom can be "upgraded" with new components, such as:

- **Seats**
- **Benches**
- **Smart Boards**
- **Projectors**

These upgrades impact the classroom's:
- **Capacity**
- **Value**
- **Daily Running Cost**

A configuration file (`config.java`) is used to read constant values (e.g., the value of a projector). In a future phase, a database will be integrated to manage these constants.

## Login Functionality
In addition to the classroom functionality, a **login system** has been implemented using the **Strategy Design Pattern** to handle different login requirements for various user types. Each user type (e.g., `Student`, `Volunteer`, `Donor`) has its own login strategy, providing flexibility and scalability in managing diverse login behaviors. 

The main components of the login system are as follows:

- **`LoginStrategy` Interface**: Defines a common `login()` method that each user type implements.
- **Concrete Strategies**: Each user type has its own class (e.g., `StudentLoginStrategy`, `VolunteerLoginStrategy`, `DonorLoginStrategy`) that implements `LoginStrategy`. These classes encapsulate the specific login behavior for each user type, such as redirecting to different dashboards based on the user type.
- **LoginContext Class**: This class holds a reference to a `LoginStrategy` and delegates the login functionality to the appropriate strategy, enabling dynamic assignment and easy swapping of login behaviors at runtime.

This setup allows the application to support various login behaviors without modifying the core login functionality, making it easy to add new user types as needed.