import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestBorrador {

  @Test
  @DisplayName("Armo una prenda sin material y arroja excepcion")
  public void ArmoUnaPrendaSinMaterialYTiraUnaExcepcion() {
    Borrador borrador = new Borrador(TipoPrenda.REMERA);

    assertThrows(PrendaInvalidaException.class, () -> borrador.crearPrenda());
  }

  @Test
  @DisplayName("Armo una prenda sin trama y se pone por defecto LISA")
  public void ArmoUnaPrendaSinTramaYSePonePorDefectoLisa()
  {
    Borrador borrador = new Borrador(TipoPrenda.REMERA);
    borrador.elegirMaterial(Material.LINO);
    borrador.elegirColorPrimario(new Color("Rojo"));
    Prenda prendaCreada = borrador.crearPrenda();

    assertEquals(Trama.LISA , prendaCreada.getTrama());

  }
}
