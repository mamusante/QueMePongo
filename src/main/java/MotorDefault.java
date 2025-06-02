import java.util.ArrayList;

public class MotorDefault implements MotorDeSugerencias{

  public Atuendo generarSugerencia(Guardarropas guardarropas) {
    return new Atuendo(
        Randoms.atRandom(guardarropas.getPrendasSuperiores()),
        Randoms.atRandom(guardarropas.getPrendasInferiores()),
        Randoms.atRandom(guardarropas.getCalzado())
    );
  }

  public ArrayList<Atuendo> generarTodasLasSugerencias(Guardarropas guardarropas) {
    ArrayList<Atuendo> sugerencias = new ArrayList<>();

    for (Prenda prendaSuperior : guardarropas.getPrendasSuperiores()) {
      for (Prenda prendaInferior : guardarropas.getPrendasInferiores()) {
        for (Prenda zapato : guardarropas.getCalzado()) {
          sugerencias.add(new Atuendo(prendaSuperior, prendaInferior, zapato));
        }
      }
    }

    return sugerencias;
  }
}
