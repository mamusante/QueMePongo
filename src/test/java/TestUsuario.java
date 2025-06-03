import ConsultadorClima.AccuWeather;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestUsuario {

  static ArrayList<Prenda> prendas = new ArrayList<>();


  @BeforeAll
  public static void iniciarTests(){
    Borrador borrador1 = new Borrador(TipoPrenda.REMERA_MANGA_CORTA);
    borrador1.elegirMaterial(Material.LINO);
    borrador1.elegirColorPrimario(new Color("Rojo"));
    borrador1.elegirEstilo(Estilo.FORMAL);
    Prenda remeraLinoLisa = borrador1.crearPrenda();


    Borrador borrador2 = new Borrador(TipoPrenda.REMERA_MANGA_CORTA);
    borrador2.elegirMaterial(Material.ALGODON);
    borrador2.elegirColorPrimario(new Color("Negro"));
    borrador2.elegirTrama(Trama.A_CUADROS);
    borrador2.elegirEstilo(Estilo.INFORMAL);
    Prenda remeraAlgodonACuadros = borrador2.crearPrenda();

    Borrador borrador3 = new Borrador(TipoPrenda.PANTALON);
    borrador3.elegirMaterial(Material.ALGODON);
    borrador3.elegirColorPrimario(new Color("Verde"));
    borrador3.elegirTrama(Trama.A_CUADROS);
    borrador3.elegirEstilo(Estilo.FORMAL);
    Prenda pantalonVerdeACuadros = borrador3.crearPrenda();

    Borrador borrador4 = new Borrador(TipoPrenda.ZAPATOS);
    borrador4.elegirMaterial(Material.CUERO);
    borrador4.elegirEstilo(Estilo.FORMAL);
    borrador4.elegirColorPrimario(new Color("Marron"));
    Prenda zapatosAzulesDeCuero = borrador4.crearPrenda();

    prendas.add(remeraLinoLisa);
    prendas.add(remeraAlgodonACuadros);
    prendas.add(pantalonVerdeACuadros);
    prendas.add(zapatosAzulesDeCuero);


  }

  @Test
  @DisplayName("Genero un atuendo y me devuelve uno completo")
  public void meDevuelveUnAtuendoCompleto(){

    Guardarropas guardarropasdeMaria = new Guardarropas(prendas, new MotorDefault(), 22, new AccuWeather());

    assertDoesNotThrow(() -> {
      Atuendo miNuevoAtuendo = guardarropasdeMaria.generarSugerencia();
    });

  }

  @Test
  @DisplayName("Genero todos los atuendos y me devuelve todas las combinaciones posibles")
  public void todasLascombinacionesPosibles(){

    Guardarropas guardarropasdeMaria = new Guardarropas(prendas, new MotorDefault(), 22, new AccuWeather());

    ArrayList<Atuendo> combinaciones = guardarropasdeMaria.generarTodasLasSugerencias();

    assertEquals(
        guardarropasdeMaria.getPrendasSuperiores().size() * guardarropasdeMaria.getPrendasInferiores().size() * guardarropasdeMaria.getCalzado().size(),
        combinaciones.size()
    );
  }

  @Test
  @DisplayName("Genero todos los atuendos y me devuelve todas las combinaciones posibles para un +55 con motorAntiViejos")
  public void todasLascombinacionesPosiblesParaUnSenior(){
    Guardarropas guardarropasdeunSenior = new Guardarropas(prendas, new MotorAntiViejos(), 60, new AccuWeather());
    ArrayList<Atuendo> combinaciones = guardarropasdeunSenior.generarTodasLasSugerencias();

    assertEquals(1, combinaciones.size());
  }

}
