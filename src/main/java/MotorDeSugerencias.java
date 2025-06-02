import java.util.ArrayList;

public interface MotorDeSugerencias {

 public ArrayList<Prenda> getPrendasSuperiores(Usuario usuario);
 public ArrayList<Prenda> getPrendasInferiores(Usuario usuario);
 public ArrayList<Prenda> getCalzado(Usuario usuario);
}
