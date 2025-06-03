import java.util.ArrayList;

public class MotorDefault implements MotorDeSugerencias{


  @Override
  public ArrayList<Prenda> getPrendasAptas(Guardarropas guardarropas) {
    return guardarropas.getPrendas();
  }
}
