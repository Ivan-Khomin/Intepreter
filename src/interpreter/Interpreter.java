package interpreter;

import java.util.List;

public class Interpreter implements Runnable {
    private String code;
    private static Interpreter instance = null;

    public static Interpreter getInstance(String code) {
        if (instance == null) {
            instance = new Interpreter(code);
        }
        return instance;
    }

    private Interpreter(String code) {
        this.code = code;
    }

    @Override
    public void run() {
        Lexer lexer = new SimpleLexer(code);
        List<Token> tokens = lexer.tokenize();

        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}