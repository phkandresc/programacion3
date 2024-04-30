import java.util.Stack;


public class ExpressionTester {
    public String expression;
    private Stack<Character> stackSymbols;

    public ExpressionTester() {
        stackSymbols = new Stack<>();
    }

    public void setExpression(String expression) {
        if(expression.contains("(") || expression.contains(")") || expression.contains("{") || expression.contains("}") || expression.contains("[") || expression.contains("]")){
            this.expression = expression;
        } else {
            System.out.println("Expression must contain at least one of the following symbols: (, ), {, }, [, ]");
        }
    }

    public boolean testExpression() {
        for (char symbol : expression.toCharArray()) {
            if (isOpenSymbol(symbol)) {
                stackSymbols.push(symbol);
            } else if (isCloseSymbol(symbol)) {
                if (stackSymbols.isEmpty() || !isMatchingPair(stackSymbols.pop(), symbol)) {
                    return false;
                }
            }
        }
        return stackSymbols.isEmpty();
    }

    private boolean isOpenSymbol(char symbol) {
        return symbol == '(' || symbol == '{' || symbol == '[';
    }

    private boolean isCloseSymbol(char symbol) {
        return symbol == ')' || symbol == '}' || symbol == ']';
    }

    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
    }

}