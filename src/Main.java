import interpreter.Interpreter;

public class Main {
    public static void main(String[] args) {
        String code = "const PI: double = 3.14159;";
        Interpreter interpreter = Interpreter.getInstance(code);
        interpreter.run();
    }
}