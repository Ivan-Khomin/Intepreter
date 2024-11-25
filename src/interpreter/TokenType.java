package interpreter;

public enum TokenType {
    ID,
    PRINT,
    LET,

    L_PAREN,
    R_PAREN,
    COLON,
    SEMICOLON,
    ASSIGN,

    STRING,
    INT,
    STRING_LITERAL,
    NUMBER_LITERAL,

    EOF,
}