import ConsultadorClima.ConsultadorClima;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class AsesorDeImagen {

  ConsultadorClima consultador;

  AsesorDeImagen(ConsultadorClima consultador) {
    this.consultador = consultador;
  }

  public ArrayList<Prenda> seleccionarPrendasAptas(ArrayList<Prenda> prendas) {
    return prendas.stream()
        .filter(p -> p.getMaxTemp() >= consultador.getTemperaturaActual())
        .collect(Collectors.toCollection(ArrayList::new));
  }
}
