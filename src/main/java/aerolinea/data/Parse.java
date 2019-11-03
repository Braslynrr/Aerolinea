/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parse {
    public static final int PALABRAS = 0;
    public static final int CORREO = 1;
    public static final int CODIGOS = 2;
    public static final int NOMBRES=3;
   
   public static Boolean Aprove(String line,int code){
        String aux=line;
        Pattern compile;
        Matcher match;
        switch(code){
            case PALABRAS:
                compile= Pattern.compile("^[A-Za-z0-9ü][A-Za-z0-9ü_]{3,15}$");
                match=compile.matcher(aux);
                return match.find();
            case CORREO:
                compile= Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                match=compile.matcher(aux);
                 return match.find();
            case CODIGOS:
                compile= Pattern.compile("^[a-zA-Z0-9]{3,15}");
                match=compile.matcher(aux);
                return match.find();
            case NOMBRES:
                compile=Pattern.compile("^([a-zA-Z]{2,}\\s[a-zA-z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)");
                match=compile.matcher(aux);
                return match.find();
            default:
                return false;
        }
    }
}
