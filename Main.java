import java.util.List;

public class Main {
    public static void main(String[] args) {
        DeliveryAgentManager agentManager = new DeliveryAgentManager();
        UserInterface userInterface = new UserInterface();

        boolean running = true;
        while (running) {
            userInterface.displayMenu();
            String choice = userInterface.getUserInput();

            switch (choice) {
                case "1": // Adding
                    userInterface.handleRegistration(agentManager);
                    break;
                case "2": // Updating
                    try {
                        System.out.print("Enter Agent's ID to update: ");
                        int updateID = Integer.parseInt(userInterface.getUserInput());
                        if (agentManager.getAgentById(updateID) == null) {
                            System.out.println("Agent ID not found.");
                            break;
                        }
                        userInterface.handleUpdate(agentManager, updateID);
                    } catch (NumberFormatException e) {
                        userInterface.displayErrorMessage("Invalid input. Please enter a valid number.");
                    }
                    break;
                case "3": // Deleting
                    try {
                        System.out.print("Enter Agent's ID to delete: ");
                        int deleteID = Integer.parseInt(userInterface.getUserInput());
                        agentManager.removeAgent(deleteID);
                        userInterface.displayDeletionSuccess();
                    } catch (NumberFormatException e) {
                        userInterface.displayErrorMessage("Invalid input. Please enter a valid number.");
                    }
                    break;
                case "4": // Listing
                    List<DeliveryAgent> agents = agentManager.getAllAgents();
                    userInterface.displayAgentsList(agents);
                    break;
                case "5": // Exit
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
