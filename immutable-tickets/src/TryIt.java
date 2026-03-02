import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;

import java.util.List;

/**
 * Starter demo that shows why mutability is risky.
 *
 * After refactor:
 * - direct mutation should not compile (no setters)
 * - external modifications to tags should not affect the ticket
 * - service "updates" should return a NEW ticket instance
 */
public class TryIt {

    public static void main(String[] args) {
        TicketService service = new TicketService();

        IncidentTicket ticket = service.createTicket("TCK-1001", "reporter@example.com", "Payment failing on checkout");
        System.out.println("Created: " + ticket);

        // Demonstrate post-creation mutation through service
        ticket = service.assign(ticket, "agent@example.com");
        ticket = service.escalateToCritical(ticket);
        System.out.println("\nAfter service mutations: " + ticket);

        // Demonstrate external mutation via leaked list reference
        List<String> tags = ticket.getTags();
        tags.add("HACKED_FROM_OUTSIDE");
        System.out.println("\nAfter external tag mutation: " + ticket);

        // Starter compiles; after refactor, you should redesign updates to create new objects instead.
    }
}