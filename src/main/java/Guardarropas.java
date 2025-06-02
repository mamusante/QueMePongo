import java.util.ArrayList;

public class Guardarropas {

  ArrayList<Prenda> prendasSuperiores;
  ArrayList<Prenda> prendasInferiores;
  ArrayList<Prenda> calzado;
  MotorDeSugerencias motor;
  Integer edad;

  public Guardarropas(ArrayList<Prenda> prendasSuperiores, ArrayList<Prenda> prendasInferiores, ArrayList<Prenda> calzado, MotorDeSugerencias motor, Integer edad) {
    this.prendasSuperiores = prendasSuperiores;
    this.prendasInferiores = prendasInferiores;
    this.calzado = calzado;
    this.motor = motor;
    this.edad = edad;
  }

  public Atuendo generarSugerencia() {
    return motor.generarSugerencia(this);
  }

  public ArrayList<Atuendo> generarTodasLasSugerencias() {
    ArrayList<Atuendo> sugerencias = new ArrayList<>();

    for (Prenda prendaSuperior : prendasSuperiores) {
      for (Prenda prendaInferior : prendasInferiores) {
        for (Prenda zapato : calzado) {
          sugerencias.add(new Atuendo(prendaSuperior, prendaInferior, zapato));
        }
      }
    }

    return sugerencias;
  }

  public ArrayList<Prenda> getPrendasSuperiores() {
    return prendasSuperiores;
  }
  public ArrayList<Prenda> getPrendasInferiores() {
    return prendasInferiores;
  }
  public ArrayList<Prenda> getCalzado() {
    return calzado;
  }
}

