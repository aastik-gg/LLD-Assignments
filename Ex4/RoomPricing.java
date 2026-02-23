public interface RoomPricing {
    boolean supports(int roomType);
    Money price(BookingRequest request);
}
