import java.util.ArrayList;

public class Usuario {

  ArrayList<Prenda> prendasSuperiores;
  ArrayList<Prenda> prendasInferiores;
  ArrayList<Prenda> calzado;
  MotorDeSugerencias motor;
  Integer edad;

  public Usuario(ArrayList<Prenda> prendasSuperiores, ArrayList<Prenda> prendasInferiores, ArrayList<Prenda> calzado, MotorDeSugerencias motor, Integer edad) {
    this.prendasSuperiores = prendasSuperiores;
    this.prendasInferiores = prendasInferiores;
    this.calzado = calzado;
    this.motor = motor;
    this.edad = edad;
  }

  public Atuendo generarSugerencia() {
    return new Atuendo(
        Randoms.atRandom(motor.getPrendasSuperiores(this)),
        Randoms.atRandom(motor.getPrendasInferiores(this)),
        Randoms.atRandom(motor.getCalzado(this))
    );
  }

  public ArrayList<Atuendo> generarTodasLasSugerencias() {
    ArrayList<Atuendo> sugerencias = new ArrayList<>();

    for (Prenda prendaSuperior : motor.getPrendasSuperiores(this)) {
      for (Prenda prendaInferior : motor.getPrendasInferiores(this)) {
        for (Prenda zapato : motor.getCalzado(this)) {
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

  public void setMotor(MotorDeSugerencias motor) {
    this.motor = motor;
  }
}

