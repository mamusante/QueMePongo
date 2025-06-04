package ConsultadorClima;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import Exceptions.TemperaturaNoValidaException;

import AccuWeatherApi.AccuWeatherAPI;

public class AccuWeather implements ConsultadorClima {

  AccuWeatherAPI api = new AccuWeatherAPI();
  private int consultasRealizadasHoy = 1; //arranca en 1 porque al isntanciar la clase se hace una consulta
  private LocalDate fechaUltimaConsulta = LocalDate.now();
  List<Map<String, Object>> datos = api.getWeather("Buenos Aires, Argentina");

  @Override
  public double getTemperaturaActual() {

    consultarApiSiEsPosible();

    if (datos.isEmpty()) throw new TemperaturaNoValidaException("No se puede acceder a los datos de temp de BS AS");

    Map<String, Object> primerDato = datos.get(0);
    Map<String, Object> temperatura = (Map<String, Object>) primerDato.get("Temperature");


    double valor = (int) temperatura.get("Value");
    valor = pasarACelsius(valor);

    return valor;
  }

  private double pasarACelsius(double valor){
    return (valor - 32) * 5.0 / 9.0;
  }

  private void consultarApiSiEsPosible() {
    LocalDate hoy = LocalDate.now();

    if (!hoy.equals(fechaUltimaConsulta)) {
      consultasRealizadasHoy = 0;
      fechaUltimaConsulta = hoy;
    }

    if (consultasRealizadasHoy < 10) {
      // Solo consultás si no pasaste el límite
      datos = api.getWeather("Buenos Aires, Argentina");
      consultasRealizadasHoy++;
    }
  }


}


