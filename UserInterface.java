import java.util.Scanner;
import java.util.List;

public class UserInterface extends ExceptionHandling {
    private Scanner scanner = new Scanner(System.in);
    private GoodsInterface goods = new Goods();
    private VehicleInterface vehicle = new Vehicle();

    public void displayMenu() {
        System.out.println("===== Delivery Management System =====");
        System.out.println("1. Register Agent");
        System.out.println("2. Update Agent");
        System.out.println("3. Delete Agent");
        System.out.println("4. View All Agents");
        System.out.println("5. Exit");
    }

    public String getUserInput() {
        return scanner.nextLine();
    }

    public void handleRegistration(DeliveryAgentManager agentManager) {
        try {
            System.out.print("Enter agent ID: ");
            int agentID = Integer.parseInt(getUserInput());

            System.out.print("Enter agent name: ");
            String name = getUserInput();
            name = capitalizeString(name); // Capitalize the name

            System.out.print("Enter contact number: ");
            long contactNumber;
            while (true) {
                try {
                    contactNumber = Long.parseLong(getUserInput());
                    break;
                } catch (Exception e) {
                    handleInvalidInputException();
                }
            }

            System.out.print("Enter vehicle type [Bike, Motorcycle, Car, Van, Truck]: ");
            String vehicleType = getUserInput();
            vehicleType = capitalizeString(vehicleType); // Capitalize the vehicle type
            while (!vehicle.isValidVehicleType(vehicleType)) {
                System.out.println("Invalid vehicle type. Please enter a valid vehicle type.");
                System.out.print("Enter vehicle type [Bike, Motorcycle, Car, Van, Truck]: ");
                vehicleType = getUserInput();
                vehicleType = capitalizeString(vehicleType);
            }

            System.out.print("Enter goods type [Documents, Medical Services, Food, Hazardous Materials, Freight]: ");
            String goodsType = getUserInput();
            goodsType = capitalizeString(goodsType); // Capitalize the goods type
            while (!goods.isValidGoodsType(goodsType)) {
                System.out.println("Invalid goods type. Please enter a valid goods type.");
                System.out.print("Enter goods type [Documents, Medical Services, Food, Hazardous Materials, Freight]: ");
                goodsType = getUserInput();
                goodsType = capitalizeString(goodsType);
            }

            System.out.print("Is the agent available? (true/false): ");
            boolean availability = Boolean.parseBoolean(getUserInput());

            DeliveryAgent agent = new DeliveryAgent(agentID, name, contactNumber, vehicleType, goodsType, availability);
            agentManager.addAgent(agent);
            System.out.println("Agent registered successfully.");
        } catch (Exception e) {
            handleInvalidInputException();
        }
    }

    public String capitalizeString(String str) {
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }
        return String.join(" ", words);
    }

    public void handleUpdate(DeliveryAgentManager agentManager, int agentID) {
        try {
            System.out.print("Enter new name: ");
            String name = getUserInput();
            name = capitalizeString(name);

            System.out.print("Enter new contact number: ");
            long contactNumber = Long.parseLong(getUserInput());

            System.out.print("Enter new vehicle type: ");
            String vehicleType = getUserInput();
            vehicleType = capitalizeString(vehicleType);
            while (!vehicle.isValidVehicleType(vehicleType)) {
                System.out.println("Invalid vehicle type. Please enter a valid vehicle type.");
                System.out.print("Enter vehicle type [Bike, Motorcycle, Car, Van, Truck]: ");
                vehicleType = getUserInput();
                vehicleType = capitalizeString(vehicleType);
            }

            System.out.print("Enter new goods type: ");
            String goodsType = getUserInput();
            goodsType = capitalizeString(goodsType);
            while (!goods.isValidGoodsType(goodsType)) {
                System.out.println("Invalid goods type. Please enter a valid goods type.");
                System.out.print("Enter goods type [Documents, Medical Services, Food, Hazardous Materials, Freight]: ");
                goodsType = getUserInput();
                goodsType = capitalizeString(goodsType);
            }


            agentManager.updateAgent(agentID, name, contactNumber, vehicleType, goodsType);
            System.out.println("Agent updated successfully.");
        } catch (Exception e) {
            handleAgentNotFoundException();
        }
    }

    public void displayAgentsList(List<DeliveryAgent> agents) {
        if (agents == null || agents.isEmpty()) {  // Check if list is null or empty
            System.out.println("No agents available.");
        } else {
            System.out.println("===== Delivery Agents List =====");
            System.out.println("-----------------------------------");
            for (DeliveryAgent agent : agents) {
                System.out.printf("Agent ID: %d%n", agent.getAgentID());
                System.out.printf("Name: %s%n", agent.getName());
                System.out.printf("Contact Number: %d%n", agent.getContactNumber());
                System.out.printf("Vehicle Type: %s%n", agent.getVehicleType());
                System.out.printf("Goods Type: %s%n", agent.getGoodsType());
                System.out.printf("Availability: %b%n", agent.isAvailability());
                System.out.println("-----------------------------------");
            }
            }
        }

    public void displayDeletionSuccess() {
        System.out.println("Agent deleted successfully.");
    }

    public void displayErrorMessage(String message) {
        handleGeneralException(message);
    }
}
