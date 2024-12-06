package main;
import main.nombres.*;

public class PruebaNombre {
    public static void main(String[] args) {
        try {
            // Charlotte F Lorena F Gael M Alexis M
            if (args[1].length()!=1 || args[3].length()!=1 || args[5].length()!=1 || args[7].length()!=1) {
                throw new RegistroCivilException("ERROR: género es 'F' o 'M'");
            }
            Nombre nombre1 = new Nombre(args[0], args[1].charAt(0));
            Nombre nombre2 = new Nombre(args[2], args[3].charAt(0));
            Nombre nombre3 = new Nombre(args[4], args[5].charAt(0));
            Nombre nombre4 = new Nombre(args[6], args[7].charAt(0));

            System.out.println(nombre1);
            System.out.println(nombre2);
            System.out.println(nombre3);
            System.out.println(nombre4);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("ERROR: faltan datos.");
        } catch (RegistroCivilException e) {
            e.printStackTrace();
            //System.err.println(e.getMessage());
        }
    }

}