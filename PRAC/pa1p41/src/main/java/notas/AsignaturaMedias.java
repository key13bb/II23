package notas;

public class AsignaturaMedias extends Asignatura{
    private CalculoMedia calcMedia;
    public AsignaturaMedias(String n, String[] ests) {//throws EstudianteException {
        super(n, ests);
    }
    public double getMedia() throws EstudianteException {
        return super.getMedia();
    }
    public double getMedia(CalculoMedia calc) throws EstudianteException {
        calcMedia = calc;
        double media = calcMedia.calcula(getEstudiantes());
        return media;
    }
}
