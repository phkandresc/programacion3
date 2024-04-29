import java.util.ArrayList;
import java.util.List;

class ConsoleMenu{
    ArrayList<String> menuItems;
    String menuTitle;

    public ConsoleMenu(String title, String [] items){
        menuTitle = title;
        menuItems = new ArrayList<>(List.of(items));
        menuItems.add("Exit");
    }

    public void displayMenu(){
        System.out.println("*************************");
        System.out.println(menuTitle);
        System.out.println("*************************");
        for(String item: menuItems){
            System.out.println(menuItems.indexOf(item)+ 1+". " + item);
        }
        System.out.println("Choose an option:");
    }

    public int getOption(){
        try{
            int option = Integer.parseInt(System.console().readLine());
            if(option > 0 && option <= menuItems.size()){
                return option;
            }
            else{
                System.out.println("Invalid option. Please try again.");
                return getOption();
            }
        }
        catch(NumberFormatException e){
            System.out.println("Invalid option. Please try again.");
            return getOption();
        }
    }


}