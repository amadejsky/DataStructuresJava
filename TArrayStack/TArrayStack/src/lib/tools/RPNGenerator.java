package lib.tools;

import lib.TArrayStack;

import java.util.NoSuchElementException;

public class RPNGenerator {
    protected final int DEFAULT_BUFFER_SIZE = 256;
    protected final TArrayStack<Character> stack;
    protected final StringBuilder outBuilder;
    public RPNGenerator(int bufferSize) {
        if(  bufferSize < 64)
            stack = new TArrayStack<>(DEFAULT_BUFFER_SIZE);
        else
            stack = new TArrayStack<>(bufferSize);
        outBuilder = new StringBuilder();
    }

    public String generator(String expression) {
        outBuilder.setLength(0);
        while(!stack.isEmpty() ){
            stack.pop();
        }
        if( expression == null || expression.trim().isEmpty()){
            throw new NoSuchElementException();
        }

        String[] tokens = expression.trim().split("\\s+");

        try{
            mainAlgorithm(tokens);
        } catch(Exception e){
            System.out.println(  String.format("Error: %s",e.toString()) );
            return "";
        }


        return outBuilder.toString();
    }

    private void mainAlgorithm(String[] tokens) {
        for (var token : tokens) {
            if( isNumberOrVariable(token) ) {
                outBuilder.append(token).append(" ");
            } else if (token.charAt(0) == '(' ) {
                stack.push(token.charAt(0));
            } else if (token.charAt(0) == ')' ) {
                endingBracketCase();
            } else if( isOperation(token.charAt(0)) ) {
                pushOperationToStack(token.charAt(0));
            }
        }
        turnStackOut();
    }

    private void turnStackOut() {
        //todo
    }

    private void pushOperationToStack(char charAt) {
        //todo
        //first check, then push
    }

    private boolean isOperation(char charAt) {
        //todo
        return false;
    }

    private boolean isNumberOrVariable(String token) {
        var sign = token.toLowerCase().charAt(0);
        if( sign >= '0' && sign <= '9' ||
                sign >= 'a' && sign <= 'z' ){
            return true;
        } else {
            return false;
        }
    }

    private void endingBracketCase() {
        //todo
    }

    private int priority(Character c) {
        switch (c) {
            case '(':
                return 0;
            case '+':
            case '-':
            case ')':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
        }
        throw new IllegalArgumentException();
    }
}
