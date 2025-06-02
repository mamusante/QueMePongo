import java.util.ArrayList;

public class MotorDefault implements MotorDeSugerencias{


  public ArrayList<Prenda> getPrendasSuperiores(Usuario usuario) {
    return usuario.getPrendasSuperiores();
  }

  public ArrayList<Prenda> getPrendasInferiores(Usuario usuario) {
    return usuario.getPrendasInferiores();
  }

  public ArrayList<Prenda> getCalzado(Usuario usuario) {
    return usuario.getCalzado();
  }
}
