import cuentapalabras.ContadorPalabras;

public class PruebaContadorPalabras {
    public static void main(String[] args) {
        String[] datos = {
                "Esta es la primera frase del ejemplo",
                "Y esta es la segunda frase"
        };
        ContadorPalabras c = new ContadorPalabras();
        String d = "[ ]";
        c.incluyeTodas(datos, d);
        System.out.println(c);
    }
}