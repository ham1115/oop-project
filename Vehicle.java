import java.util.Arrays;
import java.util.List;

public class Vehicle implements VehicleInterface {
    private final List<String> vehicleTypes = Arrays.asList("bike", "motorcycle", "car", "van", "truck");

    @Override
    public boolean isValidVehicleType(String vehicleType) {
        return vehicleTypes.contains(vehicleType.toLowerCase());
    }

    @Override
    public List<String> getAllVehicleTypes() {
        return vehicleTypes;
    }
}