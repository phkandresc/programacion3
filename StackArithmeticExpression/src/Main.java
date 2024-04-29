public class Main {
    public static void main(String[] args) {
        String [] items = {"Write expression", "Add task(Manual)", "View tasks"};
        ConsoleMenu menu = new ConsoleMenu("Main Menu", items);

        int option = -1;
        while(option != menu.menuItems.size()){
            menu.displayMenu();
            option = menu.getOption();
            switch(option){
                case 1:
                    System.out.println("Add task");
                    break;
                case 2:
                    System.out.println("Add task(Manual)");
                    break;
                case 3:
                    System.out.println("View tasks");
                    break;
                case 4:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

    }
}
