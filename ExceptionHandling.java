public class ExceptionHandling {
        public void handleInvalidInputException() {
            System.out.println("Error: Invalid input. Please check your input and try again.");
        }
    
        public void handleAgentNotFoundException() {
            System.out.println("Error: Agent not found. Please provide a valid agent ID.");
        }
    
        public void handleGeneralException(String message) {
            System.out.println("Error: " + message);
        }
    }
    