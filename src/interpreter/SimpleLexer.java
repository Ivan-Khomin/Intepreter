package interpreter;

import java.util.ArrayList;
import java.util.List;

public class SimpleLexer implements Lexer {
    private String input;
    private List<Token> tokens;
    private int currentPosition = 0;

    public SimpleLexer(String input) {
        this.input = input;
        tokens = new ArrayList<>();
    }

    @Override
    public List<Token> tokenize() {
        while (currentPosition < input.length()) {
            char currentChar = input.charAt(currentPosition);

            if (Character.isSpaceChar(currentChar)) {
                advance();
            } else if (Character.isAlphabetic(currentChar)) {
                checkExpressionOrID();
            } else if (currentChar == '(') {
                tokens.add(new Token(TokenType.L_PAREN, "("));
                advance();
            } else if (currentChar == ')') {
                tokens.add(new Token(TokenType.R_PAREN, ")"));
                advance();
            } else if (currentChar == ':') {
                tokens.add(new Token(TokenType.COLON, ":"));
                advance();
            } else if (currentChar == ';') {
                tokens.add(new Token(TokenType.SEMICOLON, ";"));
                advance();
            } else if (currentChar == '=') {
                tokens.add(new Token(TokenType.ASSIGN, "="));
                advance();
            } else if (currentChar == '"') {
                handleStringLiteral();
                advance();
            } else if (Character.isDigit(currentChar)) {
                handleNumberLiteral();
            } else {
                advance();
            }
        }
        tokens.add(new Token(TokenType.EOF, null));
        return tokens;
    }

    private void advance() {
        if (currentPosition >= input.length()) {
            return;
        }
        currentPosition++;
    }

    private void checkExpressionOrID() {
        StringBuilder stringBuilder = new StringBuilder();

        while (currentPosition < input.length() && Character.isLetterOrDigit(input.charAt(currentPosition))) {
            stringBuilder.append(input.charAt(currentPosition));
            advance();
        }

        String value = stringBuilder.toString();
        if (value.equalsIgnoreCase(TokenType.PRINT.name())) {
            tokens.add(new Token(TokenType.PRINT, value));
        } else if (value.equalsIgnoreCase(TokenType.LET.name())) {
            tokens.add(new Token(TokenType.LET, value));
        } else if (value.equalsIgnoreCase(TokenType.STRING.name())) {
            tokens.add(new Token(TokenType.STRING, value));
        } else if (value.equalsIgnoreCase(TokenType.INT.name())) {
            tokens.add(new Token(TokenType.INT, value));
        } else {
            tokens.add(new Token(TokenType.ID, value));
        }
    }

    private void handleStringLiteral() {
        StringBuilder stringBuilder = new StringBuilder();
        advance();

        while (currentPosition < input.length() && input.charAt(currentPosition) != '"') {
            stringBuilder.append(input.charAt(currentPosition));
            advance();
        }

        tokens.add(new Token(TokenType.STRING_LITERAL, stringBuilder.toString()));
    }

    private void handleNumberLiteral() {
        StringBuilder stringBuilder = new StringBuilder();
        boolean hasDecimalPoint = false;

        while (currentPosition < input.length() && (Character.isDigit(input.charAt(currentPosition)) || input.charAt(currentPosition) == '.')) {
            char currentChar = input.charAt(currentPosition);

            if (currentChar == '.') {
                if (hasDecimalPoint) {
                    break;
                }
                hasDecimalPoint = true;
            }

            stringBuilder.append(currentChar);
            advance();
        }

        tokens.add(new Token(TokenType.NUMBER_LITERAL, stringBuilder.toString()));
    }
}