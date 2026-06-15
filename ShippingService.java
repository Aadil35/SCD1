public class ShippingService {
    private static final int LOCAL_DISTANCE_LIMIT = 10;
    private static final int CITY_DISTANCE_LIMIT = 50;
    private static final int REGIONAL_DISTANCE_LIMIT = 100;

    private static final int LOCAL_SHIPPING_COST = 50;
    private static final int CITY_SHIPPING_COST = 100;
    private static final int REGIONAL_SHIPPING_COST = 150;
    private static final int LONG_DISTANCE_SHIPPING_COST = 200;

    public int calculateShippingCost(int distance) {
        if (distance < LOCAL_DISTANCE_LIMIT) {
            return LOCAL_SHIPPING_COST;
        }

        if (distance < CITY_DISTANCE_LIMIT) {
            return CITY_SHIPPING_COST;
        }

        if (distance < REGIONAL_DISTANCE_LIMIT) {
            return REGIONAL_SHIPPING_COST;
        }

        return LONG_DISTANCE_SHIPPING_COST;
    }
}
