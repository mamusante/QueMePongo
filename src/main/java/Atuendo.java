import Exceptions.AtuendoInvalidoException;

public class Atuendo {
  Prenda prendaSuperior;
  Prenda prendaInferior;
  Prenda calzado;

  Atuendo(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado) {
    validateNotNull(prendaSuperior);
    validateNotNull(prendaInferior);
    validateNotNull(calzado);
    this.prendaSuperior = prendaSuperior;
    this.prendaInferior = prendaInferior;
    this.calzado = calzado;
  }

  private void validateNotNull(Object o){
    if(o == null){
      throw new AtuendoInvalidoException("Un atuendo debe tener parte superior, inferior y calzado");
    }
  }
}
