package src;
import java.util.LinkedHashMap;
import java.util.Map;

public class MenuCatalog {
    private final Map<String, MenuItem> items = new LinkedHashMap<>();

    public void add(MenuItem item) {
        items.put(item.id, item);
    }

    public MenuItem require(String id) {
        MenuItem found = items.get(id);
        if (found == null) {
            throw new IllegalArgumentException("Unknown menu item: " + id);
        }
        return found;
    }
}
