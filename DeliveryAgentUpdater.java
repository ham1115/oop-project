import java.util.Scanner;

public class DeliveryAgentUpdater {
    private DeliveryAgentManager manager;
    private Scanner scanner = new Scanner(System.in);

    public DeliveryAgentUpdater(DeliveryAgentManager manager) {
        this.manager = manager;
    }

    public void updateAgentDetails() {
        System.out.print("Enter Agent ID to update: ");
        String agentID = scanner.nextLine();

        DeliveryAgent existingAgent = manager.read(agentID); // Retrieve the existing agent
        if (existingAgent == null) {
            System.out.println("Agent not found.");
            return; // Exit if agent does not exist
        }

        // Use input methods directly within this class
        DeliveryAgent updatedAgent = inputUpdatedDetails(existingAgent);

        // Update the agent details
        manager.update(updatedAgent);
    }

    // Input method for updating agent details
    public DeliveryAgent inputUpdatedDetails(DeliveryAgent existingAgent) {
        System.out.print("Enter new name (current: " + existingAgent.getName() + "): ");
        String newName = scanner.nextLine();
        newName = NameFormatting.formatName(newName);


        System.out.print("Enter new contact number (current: " + existingAgent.getContactNumber() + "): ");
        String newContactNumber = scanner.nextLine();

        System.out.print("Enter new vehicle type (current: " + existingAgent.getVehicleType() + "): ");
        String newVehicleType = scanner.nextLine();

        System.out.print("Is the agent available? (current: " + existingAgent.isAvailable() + ") (true/false): ");
        boolean newAvailability = scanner.nextBoolean();
        scanner.nextLine();

        // Delegate to a method that handles the updated agent creation based on its type
        return createUpdatedAgent(existingAgent, newName, newContactNumber, newAvailability, newVehicleType);
    }

    private DeliveryAgent createUpdatedAgent(DeliveryAgent existingAgent, String newName, String newContactNumber, boolean newAvailability, String newVehicleType) {
        if (existingAgent instanceof DocumentDeliveryAgent) {
            return new DocumentDeliveryAgent(newName, newContactNumber, newAvailability, existingAgent.getAgentID(), newVehicleType);
        } else if (existingAgent instanceof FoodDeliveryAgent) {
            return new FoodDeliveryAgent(newName, newContactNumber, newAvailability, existingAgent.getAgentID(), newVehicleType);
        } else if (existingAgent instanceof MedicalDeliveryAgent) {
            return new MedicalDeliveryAgent(newName, newContactNumber, newAvailability, existingAgent.getAgentID(), newVehicleType);
        } else if (existingAgent instanceof HazardDeliveryAgent) {
            return new HazardDeliveryAgent(newName, newContactNumber, newAvailability, existingAgent.getAgentID(), newVehicleType);
        } else if (existingAgent instanceof FreightDeliveryAgent) {
            return new FreightDeliveryAgent(newName, newContactNumber, newAvailability, existingAgent.getAgentID(), newVehicleType);
        } else {
            return existingAgent;
        }
    }
}
