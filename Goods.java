import java.util.Arrays;
import java.util.List;

public class Goods implements GoodsInterface {
    private final List<String> goodsTypes = Arrays.asList("documents", "medical services", "food", "hazardous materials", "freight");

    @Override
    public boolean isValidGoodsType(String goodsType) {
        return goodsTypes.contains(goodsType.toLowerCase());
    }

    @Override
    public List<String> getAllGoodsTypes() {
        return goodsTypes;
    }
}