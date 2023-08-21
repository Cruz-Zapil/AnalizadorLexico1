package com.leng.analizador.backEnd.enums.concatenables;


public enum Keywords {

    AND("and"),
    AS("as"),
    ASSERT("assert"),
    BREAK("break"),
    CLASS("class"),
    CONTINUE("continue"),
    DEF("def"),
    DEL("del"),
    ELIF("elif"),
    ELSE("else"),
    EXCEPT("except"),
    FALSE("False"),
    FINALLY("finally"),
    FOR("for"),
    FROM("from"),
    GLOBAL("global"),
    IF("if"),
    IMPORT("import"),
    IN("in"),
    IS("is"),
    LAMBDA("lambda"),
    NONE("None"),
    NONLOCAL("nonlocal"),
    NOT("not"),
    OR("or"),
    PASS("pass"),
    RAISE("raise"),
    RETURN("return"),
    TRUE("True"),
    TRY("try"),
    WHILE("while"),
    WITH("with"),
    YIELD("yield");

    /// tomar en cuenta que true y false, son palabras reservadas pero tambien son
    /// tipos de contrates

    private String simbolo;
    private Keywords(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return this.simbolo;
    }

    public static boolean probandoKW(String simbolo){

        for (Keywords key : Keywords.values()) {

            if (key.getSimbolo().equals(simbolo)) {
               
                return true;
            }
        }
        return false;      
        
    }


    /// marca la posicion del enums
    public int getPosicion() {
        return this.ordinal();
    }

    public static Keywords getEnum(int posicion) {
        return Keywords.values()[posicion];
    }

}
