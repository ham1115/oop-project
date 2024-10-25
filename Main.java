public class Main {
    public static void main(String[] args) {
        DeliveryAgentManager manager = new DeliveryAgentManager();
        DeliveryAgentInputHandler inputHandler = new DeliveryAgentInputHandler(manager);
        inputHandler.run();
    }
}
