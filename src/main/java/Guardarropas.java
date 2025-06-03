import ConsultadorClima.ConsultadorClima;
import Exceptions.NoHayPrendasSuficientesParaAtuendoException;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Guardarropas {

  ArrayList<Prenda> prendas;
  MotorDeSugerencias motor;
  Integer edad;
  ConsultadorClima consultador;

  public Guardarropas(ArrayList<Prenda> prendas, MotorDeSugerencias motor, Integer edad, ConsultadorClima consultadorClima) {
    this.prendas = prendas;
    this.motor = motor;
    this.edad = edad;
    this.consultador = consultadorClima;
  }

  public Atuendo generarSugerencia() {

    ArrayList<Prenda> prendasAcordes = motor.getPrendasAptas(this);
    prendasAcordes = filtrarPrendasPorTemperatura(prendasAcordes);

    validarPrendasSuficientesParaGenerarAtuendo(prendasAcordes);

    return new Atuendo(
        Randoms.atRandom(filtrarPrendasPorCategoria(prendasAcordes, Categoria.PARTE_SUPERIOR)),
        Randoms.atRandom(filtrarPrendasPorCategoria(prendasAcordes, Categoria.PARTE_INFERIOR)),
        Randoms.atRandom(filtrarPrendasPorCategoria(prendasAcordes, Categoria.CALZADO))
    );
  }

  private void validarPrendasSuficientesParaGenerarAtuendo(ArrayList<Prenda> prendasAcordes) {
    if(
        filtrarPrendasPorCategoria(prendasAcordes, Categoria.PARTE_SUPERIOR).isEmpty() ||
            filtrarPrendasPorCategoria(prendasAcordes, Categoria.PARTE_INFERIOR).isEmpty()  ||
            filtrarPrendasPorCategoria(prendasAcordes, Categoria.CALZADO).isEmpty() ){
      throw new NoHayPrendasSuficientesParaAtuendoException("No se puede generar un atuendo porq no hay suficientes prendas");
    }
  }

  public ArrayList<Atuendo> generarTodasLasSugerencias() {
    ArrayList<Atuendo> sugerencias = new ArrayList<>();
    ArrayList<Prenda> prendasAcordes = motor.getPrendasAptas(this);


    for (Prenda prendaSuperior : filtrarPrendasPorCategoria(prendasAcordes, Categoria.PARTE_SUPERIOR)) {
      for (Prenda prendaInferior : filtrarPrendasPorCategoria(prendasAcordes, Categoria.PARTE_INFERIOR)) {
        for (Prenda zapato : filtrarPrendasPorCategoria(prendasAcordes, Categoria.CALZADO)) {
          sugerencias.add(new Atuendo(prendaSuperior, prendaInferior, zapato));
        }
      }
    }

    return sugerencias;
  }

  private ArrayList<Prenda> filtrarPrendasPorTemperatura(ArrayList<Prenda> prendas) {
    return prendas.stream()
        .filter(p -> p.getMaxTemp() >= consultador.getTemperaturaActual())
        .collect(Collectors.toCollection(ArrayList::new));
  }

  public ArrayList<Prenda> getPrendasSuperiores() {
    return filtrarPrendasPorCategoria(prendas, Categoria.PARTE_SUPERIOR);
  }
  public ArrayList<Prenda> getPrendasInferiores() {
    return filtrarPrendasPorCategoria(prendas, Categoria.PARTE_INFERIOR);
  }
  public ArrayList<Prenda> getCalzado() {
    return filtrarPrendasPorCategoria(prendas, Categoria.CALZADO);
  }

  public void setMotor(MotorDeSugerencias motor) {
    this.motor = motor;
  }

  private ArrayList<Prenda> filtrarPrendasPorCategoria(ArrayList<Prenda> prendas, Categoria categoria) {
    return prendas.stream()
        .filter(p -> p.getCategoria() == categoria)
        .collect(Collectors.toCollection(ArrayList::new));
  }

  public ArrayList<Prenda> getPrendas(){
    return prendas;
  }
}

