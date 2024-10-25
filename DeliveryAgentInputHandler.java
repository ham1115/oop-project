import java.util.Scanner;

public class DeliveryAgentInputHandler {
    private Scanner scanner = new Scanner(System.in);
    private DeliveryAgentManager manager; 
    private DeliveryAgentUpdater updater;
    private DeliveryAgentDeleter deleter;
    private ExceptionHandling exceptionHandler;
    private InputValidator validator;

    public DeliveryAgentInputHandler(DeliveryAgentManager manager) {
        this.manager = manager;
        this.updater = new DeliveryAgentUpdater(manager);
        this.deleter = new DeliveryAgentDeleter(manager);
        this.exceptionHandler = new ExceptionHandling();
        this.validator = new InputValidator();
    }

    public void inputAgentDetails() {
        System.out.println("\n==================== Add Delivery Agent ====================");
        System.out.println("============================================================");
    
        while (true) { 
            try {
                System.out.print("Enter Agent ID (5 digits): ");
                String agentID = scanner.nextLine().trim();
                if (!validator.validateAgentID(agentID)) { 
                    System.out.println("Invalid. Please enter a ID of 5 digits");
                    continue; 
                }

                System.out.print("Enter Agent Name (First Last): ");
                String name = scanner.nextLine().trim();
                if (!validator.validateName(name)) {
                    exceptionHandler.handleInvalidInputException();
                    continue;
                }
                name = NameFormatting.formatName(name);

                System.out.print("Enter Agent Contact Number (11 digits): ");
                String contactNumber = scanner.nextLine().trim();
                if (!validator.validateContactNumber(contactNumber)) {
                    exceptionHandler.handleInvalidInputException();
                    continue;
                }

                System.out.print("Enter Vehicle Type (car/bike/motorcycle/truck/van): ");
                String vehicleType = scanner.nextLine().trim();
                if (!validator.validateVehicleType(vehicleType)) {
                    exceptionHandler.handleInvalidInputException();
                    continue;
                }

                System.out.print("Enter Agent Availability (true/false): ");
                String availabilityInput = scanner.nextLine().trim();
                if (!validator.validateAvailability(availabilityInput)) {
                    exceptionHandler.handleInvalidInputException();
                    continue;
                }
                boolean available = availabilityInput.equalsIgnoreCase("true");

                System.out.print("Enter Delivery Type (documents/medical/food/hazardous/freight): ");
                String deliveryType = scanner.nextLine().trim();
                if (!validator.validateDeliveryType(deliveryType)) {
                    exceptionHandler.handleInvalidInputException();
                    continue;
                }

                DeliveryAgent agent = createDeliveryAgent(name, contactNumber, available, agentID, deliveryType, vehicleType);

                if (agent != null) {
                    manager.create(agent);
                    System.out.println("============================================================");
                    break; 
                    
                } else {
                    exceptionHandler.handleInvalidInputException();
                }
            } catch (Exception e) {
                exceptionHandler.handleGeneralException(e.getMessage());
            }
        }
    }

    private DeliveryAgent createDeliveryAgent(String name, String contactNumber, boolean available, String agentID, String deliveryType, String vehicleType) {
        switch (deliveryType.toLowerCase()) {
            case "documents":
                return new DocumentDeliveryAgent(name, contactNumber, available, agentID, vehicleType);
            case "medical":
                return new MedicalDeliveryAgent(name, contactNumber, available, agentID, vehicleType);
            case "food":
                return new FoodDeliveryAgent(name, contactNumber, available, agentID, vehicleType);
            case "hazardous": 
                return new HazardDeliveryAgent(name, contactNumber, available, agentID, vehicleType);
            case "freight":
                return new FreightDeliveryAgent(name, contactNumber, available, agentID, vehicleType);
            default:
                System.out.println("Invalid delivery type. Agent not created.");
                return null;
        }
    }

    public void run() {
        while (true) {
            System.out.println("\n=====================================================");
            System.out.println("       Delivery Agent Management System       ");
            System.out.println("=====================================================");

            System.out.println("1. Add Delivery Agent");
            System.out.println("2. Update Delivery Agent");
            System.out.println("3. Delete Delivery Agent");
            System.out.println("4. Display Delivery Agents");
            System.out.println("5. Exit");
            System.out.println("=====================================================");
            System.out.print("Please select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    inputAgentDetails();
                    break;
                case 2:
                    updater.updateAgentDetails();
                    break;
                case 3:
                    deleter.deleteAgent();
                    break;
                case 4:
                    manager.displayAgents();
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
