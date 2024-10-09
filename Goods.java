import java.util.Arrays;
import java.util.List;

public class Goods {
    private final List<String> goodsTypes = Arrays.asList("documents", "medical services", "food", "hazardous materials", "freight");

    // validates if the given goods type is correct
    public boolean isValidGoodsType(String goodsType) {
        return goodsTypes.contains(goodsType.toLowerCase());
    }

    // tentative
    public List<String> getAllGoodsTypes() {
        return goodsTypes;
    }

    public class Vehicle {
        private final List<String> vehicleTypes = Arrays.asList("bike", "motorcycle", "car", "van", "truck");

        public boolean isValidVehicleType(String vehicleType) {
            return vehicleTypes.contains(vehicleType.toLowerCase());
    }
    public List<String> getAllVehicleTypes() {
        return  vehicleTypes;

    }
}

}
