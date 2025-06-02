import java.util.ArrayList;

public class MotorAntiViejos implements MotorDeSugerencias{

  public ArrayList<Prenda> getPrendasSuperiores(Usuario usuario) {
    return null;
  }

  public ArrayList<Prenda> getPrendasInferiores(Usuario usuario) {
    return null;
  }

  public ArrayList<Prenda> getCalzado(Usuario usuario) {
    return null;
  }

  private ArrayList<Prenda> filtrarSoloFormalesYNeutralesSiEsMayorde55(ArrayList<Prenda> prendas, Integer edad){
    if (edad > 55){
      return prendas;
    }else return prendas;
  }
}
