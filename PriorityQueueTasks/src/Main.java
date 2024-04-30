public class Main {
    public static void main(String[] args) {
        String [] items = {"Add task", "Add task(Manual)", "View tasks"};
        ConsoleMenu menu = new ConsoleMenu("Main Menu", items);
        TaskManager taskManager = new TaskManager();

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
                    taskManager.addTask(new Task("Task 1", 5, 5));
                    taskManager.addTask(new Task("Task 2", 2, 1));
                    taskManager.addTask(new Task("Task 3", 15, 2));
                    taskManager.addTask(new Task("Task 4", 10, 3));
                    taskManager.addTask(new Task("Task 5", 1, 1));
                    break;
                case 3:
                    System.out.println("View tasks");
                    taskManager.viewTasks();
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
