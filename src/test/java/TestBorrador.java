import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestBorrador {

  @Test
  @DisplayName("Armo una prenda sin material y arroja excepcion")
  public void ArmoUnaPrendaSinMaterialYTiraUnaExcepcion() {
    Borrador borrador = new Borrador(TipoPrenda.REMERA_MANGA_CORTA);

    assertThrows(PrendaInvalidaException.class, () -> borrador.crearPrenda());
  }

  @Test
  @DisplayName("Armo una prenda sin trama y se pone por defecto LISA")
  public void ArmoUnaPrendaSinTramaYSePonePorDefectoLisa()
  {
    Borrador borrador = new Borrador(TipoPrenda.REMERA_MANGA_CORTA);
    borrador.elegirMaterial(Material.LINO);
    borrador.elegirColorPrimario(new Color("Rojo"));
    borrador.elegirEstilo(Estilo.FORMAL);
    Prenda prendaCreada = borrador.crearPrenda();

    assertEquals(Trama.LISA , prendaCreada.getTrama());

  }

  @Test
  @DisplayName("Armo una remera de cuero y me dice que material no se condice con tipo")
  public void PrendaConMaterialNoCondiceConTipo()
  {
    Borrador borrador = new Borrador(TipoPrenda.REMERA_MANGA_CORTA);

    assertThrows(MaterialInconsistenteConTipoException.class, () -> borrador.elegirMaterial(Material.CUERO));

  }

}
