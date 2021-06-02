package com.bets.Bets.Services;
public class Validdate {
    public static boolean isNumeric(String cadena){
        try {
                Integer.parseInt(cadena);
                return false;
        } catch (NumberFormatException e){
                return true;
        }
    }
}
