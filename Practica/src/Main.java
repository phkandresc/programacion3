public class Main {
    static final String[] menuItems = {
        "Add an item",
        "List all items",
        "Delete an item",
        "Exit"
    };
    public static void main(String[] args) {
        ConsoleMenu menu = new ConsoleMenu(menuItems);
        menu.printMenu();
    }
}
