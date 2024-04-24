import java.util.List;

public class ConsoleMenu {
    public List<String> menuItems;

    public ConsoleMenu(String[] menuItems) {
        this.menuItems = List.of(menuItems);
    }

    void printMenu() {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i));
        }
    }
}
