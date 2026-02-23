import java.util.*;

public class HostelFeeCalculator {
    private final List<RoomPricing> roomPricings;
    private final List<AddOnPricing> addOnPricings;
    private final Money deposit;

    public HostelFeeCalculator(List<RoomPricing> roomPricings, List<AddOnPricing> addOnPricings, Money deposit) {
        this.roomPricings = List.copyOf(roomPricings);
        this.addOnPricings = List.copyOf(addOnPricings);
        this.deposit = deposit;
    }

    public HostelFeeResult calculate(BookingRequest req) {
        Money roomCharge = priceRoom(req.roomType, req);
        Money addOnCharge = priceAddOns(req.addOns);
        Money monthly = roomCharge.plus(addOnCharge);
        return new HostelFeeResult(monthly, deposit);
    }

    private Money priceRoom(int roomType, BookingRequest req) {
        for (RoomPricing pricing : roomPricings) {
            if (pricing.supports(roomType)) {
                return pricing.price(req);
            }
        }
        throw new IllegalArgumentException("Unknown room type: " + roomType);
    }

    private Money priceAddOns(List<AddOn> addOns) {
        Money total = new Money(0.0);
        for (AddOn addOn : addOns) {
            total = total.plus(priceAddOn(addOn));
        }
        return total;
    }

    private Money priceAddOn(AddOn addOn) {
        for (AddOnPricing pricing : addOnPricings) {
            if (pricing.supports(addOn)) {
                return pricing.price(addOn);
            }
        }
        throw new IllegalArgumentException("Unsupported add-on: " + addOn);
    }
}