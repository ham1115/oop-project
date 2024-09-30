import java.util.Arrays;
import java.util.List;

public class Vehicle {
    private final List<String> vehicleTypes = Arrays.asList("bike", "motorcycle", "car", "van", "truck");

    // validates if the given goods type is correct
    public boolean isValidVehicleType(String vehicleType) {
        return vehicleTypes.contains(vehicleType.toLowerCase());
    }

    // tentative
    public List<String> getAllVehicleTypes() {
        return vehicleTypes;
    }
}
