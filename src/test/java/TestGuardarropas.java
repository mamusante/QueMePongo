import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestGuardarropas {

  static ArrayList<Prenda> prendasSuperiores = new ArrayList<>();;
  static ArrayList<Prenda> prendasInferiores = new ArrayList<>();;
  static ArrayList<Prenda> calzados= new ArrayList<>();

  @BeforeAll
  public static void iniciarTests(){
    Borrador borrador1 = new Borrador(TipoPrenda.REMERA);
    borrador1.elegirMaterial(Material.LINO);
    borrador1.elegirColorPrimario(new Color("Rojo"));
    Prenda remeraLinoLisa = borrador1.crearPrenda();

    Borrador borrador2 = new Borrador(TipoPrenda.REMERA);
    borrador2.elegirMaterial(Material.ALGODON);
    borrador2.elegirColorPrimario(new Color("Negro"));
    borrador2.elegirTrama(Trama.A_CUADROS);
    Prenda remeraAlgodonACuadros = borrador2.crearPrenda();

    Borrador borrador3 = new Borrador(TipoPrenda.PANTALON);
    borrador3.elegirMaterial(Material.ALGODON);
    borrador3.elegirColorPrimario(new Color("Verde"));
    borrador3.elegirTrama(Trama.A_CUADROS);
    Prenda pantalonVerdeACuadros = borrador3.crearPrenda();

    Borrador borrador4 = new Borrador(TipoPrenda.ZAPATOS);
    borrador4.elegirMaterial(Material.CUERO);
    borrador4.elegirColorPrimario(new Color("Marron"));
    Prenda zapatosAzulesDeCuero = borrador4.crearPrenda();

    prendasSuperiores.add(remeraLinoLisa);
    prendasSuperiores.add(remeraAlgodonACuadros);

    prendasInferiores.add(pantalonVerdeACuadros);

    calzados.add(zapatosAzulesDeCuero);


  }

  @Test
  @DisplayName("Genero un atuendo y me devuelve uno completo")
  public void meDevuelveUnAtuendoCompleto(){

    Guardarropas guardarropasdeMaria = new Guardarropas(prendasSuperiores, prendasInferiores, calzados);

    assertDoesNotThrow(() -> {
      Atuendo miNuevoAtuendo = guardarropasdeMaria.generarSugerencia();
    });

  }

  @Test
  @DisplayName("Genero todos los atuendos y me devuelve todas las combinaciones posibles")
  public void todasLascombinacionesPosibles(){

    Guardarropas guardarropas = new Guardarropas(prendasSuperiores, prendasInferiores, calzados);

    ArrayList<Atuendo> combinaciones = guardarropas.generarTodasLasSugerencias();

    assertEquals(prendasSuperiores.size() * prendasInferiores.size() * calzados.size(), combinaciones.size());
  }
//
//
//   // 4 combinaciones
}
