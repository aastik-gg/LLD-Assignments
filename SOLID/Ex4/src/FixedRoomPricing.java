package src;
public class FixedRoomPricing implements RoomPricing {
    private final int roomType;
    private final Money rate;

    public FixedRoomPricing(int roomType, double monthlyAmount) {
        this.roomType = roomType;
        this.rate = new Money(monthlyAmount);
    }

    @Override
    public boolean supports(int roomType) {
        return this.roomType == roomType;
    }

    @Override
    public Money price(BookingRequest request) {
        return rate;
    }
}
