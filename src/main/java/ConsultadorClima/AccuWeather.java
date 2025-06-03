package ConsultadorClima;
import java.util.List;
import java.util.Map;
import Exceptions.TemperaturaNoValidaException;

import AccuWeatherApi.AccuWeatherAPI;

public class AccuWeather implements ConsultadorClima {

  AccuWeatherAPI api = new AccuWeatherAPI();

  @Override
  public double getTemperaturaActual() {
    List<Map<String, Object>> datos = api.getWeather("Buenos Aires, Argentina");
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

}
