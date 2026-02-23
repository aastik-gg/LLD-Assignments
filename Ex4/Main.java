import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");
        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));
    List<RoomPricing> roomPricings = List.of(
        new FixedRoomPricing(LegacyRoomTypes.SINGLE, 14000.0),
        new FixedRoomPricing(LegacyRoomTypes.DOUBLE, 15000.0),
        new FixedRoomPricing(LegacyRoomTypes.TRIPLE, 12000.0),
        new FixedRoomPricing(LegacyRoomTypes.DELUXE, 16000.0)
    );

    List<AddOnPricing> addOnPricings = List.of(
        new FixedAddOnPricing(AddOn.MESS, 1000.0),
        new FixedAddOnPricing(AddOn.LAUNDRY, 500.0),
        new FixedAddOnPricing(AddOn.GYM, 300.0)
    );

    Money deposit = new Money(5000.0);
    HostelFeeCalculator calc = new HostelFeeCalculator(roomPricings, addOnPricings, deposit);
    HostelFeeResult result = calc.calculate(req);

    ReceiptPrinter.print(req, result.monthly, result.deposit);

    String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));
    FakeBookingRepo repo = new FakeBookingRepo();
    repo.save(bookingId, req, result.monthly, result.deposit);
    }
}