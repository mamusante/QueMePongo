import java.util.ArrayList;
import java.util.stream.Collectors;

public class MotorAntiViejos implements MotorDeSugerencias{


  @Override
  public ArrayList<Prenda> getPrendasAptas(Guardarropas guardarropas) {
    return guardarropas.edad > 55
        ? guardarropas.getPrendas().stream()
        .filter(p -> !p.isInformal())
        .collect(Collectors.toCollection(ArrayList::new))
        : guardarropas.getPrendas();
  }



}
