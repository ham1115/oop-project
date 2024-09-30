import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final Scanner input = new Scanner(System.in);

    // displays the main menu to the user
    public void displayMenu() {
        System.out.println("1. Register Agent");
        System.out.println("2. Update Agent");
        System.out.println("3. Delete Agent");
        System.out.println("4. Show All Agents");
        System.out.println("5. Exit");
    }

    // gets input from the user
    public String getUserInput() {
        return input.nextLine();
    }

    // displays a list of all agents
    public void displayAgentsList(List<DeliveryAgent> agents) {
        if (agents.isEmpty()) {
            System.out.println("No agents are currently registered.");
        } else {
            for (DeliveryAgent agent : agents) {
                System.out.println(agent);
            }
        }
    }

    public void displayErrorMessage(String message) {
        System.out.println("Error: " + message);
    }

    /* tentative
    public void displayAgentDetails() {

    }
     */

    public void displayRegistrationSuccess() {
        System.out.println("Agent registered successfully!");
    }

    public void displayUpdateSuccess() {
        System.out.println("Agent updated successfully!");
    }

    public void displayDeletionSuccess() {
        System.out.println("Agent deleted successfully!");
    }

    /* tentative
    public void displayAvailabilityUpdateSuccess() {
        System.out.println("Agent availability updated successfully!");
    }
     */

    // registering a delivery agent
    public void handleRegistration(DeliveryAgentManager manager) {
        try {
            System.out.print("Enter Agent's ID: ");
            int agentID = Integer.parseInt(getUserInput());

            System.out.print("Enter Agent's Name: ");
            String name = getUserInput();
            if (!name.matches("[a-zA-Z ]+")) {
                throw new IllegalArgumentException("Name must not contain numbers or special characters.");
            }

            System.out.print("Enter Agent's Contact Number: ");
            int contactNumber = Integer.parseInt(getUserInput());

            System.out.print("Enter Vehicle Type (Bike, Motorcycle, Car, Van, Truck): ");
            String vehicleType = getUserInput().toLowerCase();
            if (!manager.getVehicleValidator().isValidVehicleType(vehicleType)) {
                throw new IllegalArgumentException("Invalid vehicle type.");
            }

            System.out.print("Enter Goods Type (Documents, Medical Services, Food, Hazardous Materials, Freight): ");
            String goodsType = getUserInput().toLowerCase();
            if (!manager.getGoodsValidator().isValidGoodsType(goodsType)) {
                throw new IllegalArgumentException("Invalid goods type.");
            }

            System.out.print("Enter Availability (True/False): ");
            String availabilityInput = getUserInput().toLowerCase();
            if (!availabilityInput.equals("true") && !availabilityInput.equals("false")) {
                throw new IllegalArgumentException("Availability must be 'true' or 'false'.");
            }
            boolean availability = Boolean.parseBoolean(availabilityInput);

            DeliveryAgent newAgent = new DeliveryAgent(agentID, name, contactNumber, vehicleType, goodsType, availability);
            manager.addAgent(newAgent);
            displayRegistrationSuccess();
        } catch (NumberFormatException e) {
            displayErrorMessage("Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            displayErrorMessage(e.getMessage());
        }
    }

    // updating agent information
    public void handleUpdate(DeliveryAgentManager manager, int agentID) {
        try {
            DeliveryAgent agent = manager.getAgentById(agentID);
            if (agent == null) {
                displayErrorMessage("Agent not found.");
                return;
            }

            System.out.print("Enter new Name (leave blank to keep current): ");
            String name = getUserInput();
            if (!name.isEmpty() && !name.matches("[a-zA-Z ]+")) {
                throw new IllegalArgumentException("Name must not contain numbers or special characters.");
            }

            System.out.print("Enter new Contact Number (leave blank to keep current): ");
            String contactInput = getUserInput();
            int contactNumber = contactInput.isEmpty() ? agent.getContactNumber() : Integer.parseInt(contactInput);

            System.out.print("Enter new Vehicle Type (leave blank to keep current): ");
            String vehicleType = getUserInput().toLowerCase();
            if (!vehicleType.isEmpty() && !manager.getVehicleValidator().isValidVehicleType(vehicleType)) {
                throw new IllegalArgumentException("Invalid vehicle type.");
            }

            System.out.print("Enter new Goods Type (leave blank to keep current): ");
            String goodsType = getUserInput().toLowerCase();
            if (!goodsType.isEmpty() && !manager.getGoodsValidator().isValidGoodsType(goodsType)) {
                throw new IllegalArgumentException("Invalid goods type.");
            }

            System.out.print("Enter new Availability (true/false, leave blank to keep current): ");
            String availabilityInput = getUserInput().toLowerCase();
            Boolean availability = availabilityInput.isEmpty() ? agent.isAvailability() : Boolean.parseBoolean(availabilityInput);


            agent.updateAgentDetails(
                    name.isEmpty() ? agent.getName() : name,
                    contactNumber,
                    vehicleType.isEmpty() ? agent.getVehicleType() : vehicleType,
                    goodsType.isEmpty() ? agent.getGoodsType() : goodsType
            );

            if (!availabilityInput.isEmpty()) {
                agent.setAvailability(availability);
            }

            displayUpdateSuccess();
        } catch (NumberFormatException e) {
            displayErrorMessage("Invalid input for contact number.");
        } catch (IllegalArgumentException e) {
            displayErrorMessage(e.getMessage());
        }
    }
}
