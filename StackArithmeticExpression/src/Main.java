public class Main {
    public static void main(String[] args) {
        String [] items = {"Write expression"};
        ConsoleMenu menu = new ConsoleMenu("Expression Tester", items);
        ExpressionTester expressionTester = new ExpressionTester();

        int option = -1;
        while(option != menu.menuItems.size()){
            menu.displayMenu();
            option = menu.getOption();
            switch(option){
                case 1:
                    System.out.println("Write expression");
                    expressionTester.setExpression("({[])}");
                    if(expressionTester.testExpression()) {
                        System.out.println("Expression is CORRECT");
                    }else {
                        System.out.println("Expression is INCORRECT");
                    }
                    break;
                case 2:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

    }
}
