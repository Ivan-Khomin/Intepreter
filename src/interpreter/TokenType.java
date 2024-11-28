package interpreter;

public enum TokenType {
    // Identifiers
    ID,
    PRINT,
    LET,
    CONST,
    NULL,

    // Symbols
    L_PAREN,
    R_PAREN,
    COLON,
    SEMICOLON,
    ASSIGN,

    // Data types
    STRING,
    INT,
    DOUBLE,
    FLOAT,
    CHAR,
    BYTE,
    STRING_LITERAL,
    NUMBER_LITERAL,

    // EOF - enf of file
    EOF,
}