import java.util.ArrayList;
import java.util.stream.Collectors;

public class MotorAntiViejos implements MotorDeSugerencias{

  public ArrayList<Prenda> getPrendasSuperiores(Usuario usuario) {
    return filtrarSoloFormalesYNeutralesSiEsMayorde55(usuario.getPrendasSuperiores(), usuario.edad);
  }

  public ArrayList<Prenda> getPrendasInferiores(Usuario usuario) {
    return filtrarSoloFormalesYNeutralesSiEsMayorde55(usuario.getPrendasInferiores(), usuario.edad);
  }

  public ArrayList<Prenda> getCalzado(Usuario usuario) {
    return filtrarSoloFormalesYNeutralesSiEsMayorde55(usuario.getCalzado(), usuario.edad);
  }

  private ArrayList<Prenda> filtrarSoloFormalesYNeutralesSiEsMayorde55(ArrayList<Prenda> prendas, Integer edad) {
    return edad > 55
        ? prendas.stream()
        .filter(p -> !p.isInformal())
        .collect(Collectors.toCollection(ArrayList::new))
        : prendas;
  }


}
