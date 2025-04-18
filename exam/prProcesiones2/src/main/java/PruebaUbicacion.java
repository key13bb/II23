import procesiones.ProcesionesException;
import procesiones.Ubicacion;

public class PruebaUbicacion {
    public static void main(String[] args) {
        Ubicacion larios = new Ubicacion("Larios", 210, 1000);
        Ubicacion molina = new Ubicacion("Molina Larios", 270, 1900);

        System.out.println(larios);
        System.out.println(molina);

        if (larios.equals(molina)) {
            System.out.println("Las ubicaciones son iguales");
        } else {
            System.out.println("Las ubicaciones no son iguales");
        }

        try {
            Ubicacion arg = new Ubicacion(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
