import java.util.ArrayList;
import java.util.List;

public class Guardarropas {

  ArrayList<Prenda> prendasSuperiores;
  ArrayList<Prenda> prendasInferiores;
  ArrayList<Prenda> calzado;

  public Guardarropas(ArrayList<Prenda> prendasSuperiores, ArrayList<Prenda> prendasInferiores, ArrayList<Prenda> calzado) {
    this.prendasSuperiores = prendasSuperiores;
    this.prendasInferiores = prendasInferiores;
    this.calzado = calzado;
  }

  public Atuendo generarSugerencia() {
    return new Atuendo(
        Randoms.atRandom(prendasSuperiores),
        Randoms.atRandom(prendasInferiores),
        Randoms.atRandom(calzado)
    );
  }

  public List<Atuendo> generarTodasLasSugerencias() {
    List<Atuendo> sugerencias = new ArrayList<>();

    for (Prenda prendaSuperior : prendasSuperiores) {
      for (Prenda prendaInferior : prendasInferiores) {
        for (Prenda zapato : calzado) {
          sugerencias.add(new Atuendo(prendaSuperior, prendaInferior, zapato));
        }
      }
    }

    return sugerencias;
  }
}

