import java.util.Scanner;

public class DeliveryAgentDeleter {
    private DeliveryAgentManager manager;
    private Scanner scanner = new Scanner(System.in);
    private ExceptionHandling exceptionHandler;

    public DeliveryAgentDeleter(DeliveryAgentManager manager) {
        this.manager = manager;
    }

    public void deleteAgent() {
        System.out.print("Enter Agent ID to delete: ");
        String agentID = scanner.nextLine();

        try {
            if (manager.delete(agentID)) {
                System.out.println("Agent with ID " + agentID + " successfully deleted.");
            }
        } catch (Exception e) {
            exceptionHandler.handleAgentNotFoundException();
        }
}}
