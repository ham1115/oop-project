public class InputValidator {

    public boolean validateName(String name) {
        return name != null && name.trim().split(" ").length >= 2;
    }

    public boolean validateContactNumber(String contactNumber) {
        return contactNumber != null && contactNumber.matches("\\d{11}");
    }

    public boolean validateVehicleType(String vehicleType) {
        return vehicleType.equalsIgnoreCase("car") ||
                vehicleType.equalsIgnoreCase("bike") ||
                vehicleType.equalsIgnoreCase("motorcycle") ||
                vehicleType.equalsIgnoreCase("truck") ||
                vehicleType.equalsIgnoreCase("van");
    }

    public boolean validateAvailability(String availability) {
        return availability.equalsIgnoreCase("true") || availability.equalsIgnoreCase("false");
    }

    public boolean validateDeliveryType(String deliveryType) {
        return deliveryType.equalsIgnoreCase("documents") ||
                deliveryType.equalsIgnoreCase("medical") ||
                deliveryType.equalsIgnoreCase("food") ||
                deliveryType.equalsIgnoreCase("hazardous") ||
                deliveryType.equalsIgnoreCase("freight");
    }

    public boolean validateAgentID(String agentID) {
        return agentID.matches("\\d{5}"); // Check if the ID is numeric and 5 digits or less
    }
}
