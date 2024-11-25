import interpreter.Interpreter;

public class Main {
    public static void main(String[] args) {
        String code = "let x: int = 5;";
        Interpreter interpreter = Interpreter.getInstance(code);
        interpreter.run();
    }
}