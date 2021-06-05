package com.bets.Bets.Services;
public class BetServices {
    public static boolean isNumeric(String cadena){
        try {
                Integer.parseInt(cadena);
                return false;
        } catch (NumberFormatException e){
                return true;
        }
    }
    public static String getcolorvaluerandom(int randomvalue) {
        try {
            if (randomvalue % 2 == 0) {
                return "rojo";
            } else {

                return "negro";
            }
        } catch (Exception e) {
            
            return "Operacion Fallida";
        }
    }
}
