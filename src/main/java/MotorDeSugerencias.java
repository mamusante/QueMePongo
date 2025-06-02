import java.util.ArrayList;

public interface MotorDeSugerencias {
  public Atuendo generarSugerencia(Guardarropas guardarropas);

  public ArrayList<Atuendo> generarTodasLasSugerencias(Guardarropas guardarropas);
}
