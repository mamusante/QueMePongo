package ConsultadorClima;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import Exceptions.TemperaturaNoValidaException;

import AccuWeatherApi.AccuWeatherAPI;

public class AccuWeather implements ConsultadorClima {

  AccuWeatherAPI api = new AccuWeatherAPI();
  private List<Map<String, Object>> ultimaRespuesta;
  private LocalDateTime proximaExpiracion;
  private Duration expiracion = Duration.ofHours(2).plusMinutes(30);

  @Override
  public double getTemperaturaActual() {

    if (this.ultimaRespuesta == null || this.expiro()) {
      this.ultimaRespuesta = consultarApi();
      this.proximaExpiracion = LocalDateTime.now().plus(this.expiracion);
    }

    Map<String, Object> primerDato = ultimaRespuesta.get(0);
    Map<String, Object> temperatura = (Map<String, Object>) primerDato.get("Temperature");


    double valor = (int) temperatura.get("Value");
    valor = pasarACelsius(valor);

    return valor;

    }



private boolean expiro() {
  return proximaExpiracion.isAfter(LocalDateTime.now());
}

  private double pasarACelsius(double valor){
    return (valor - 32) * 5.0 / 9.0;
  }

  private List<Map<String, Object>> consultarApi(){
    return api.getWeather("Buenos Aires, Argentina");
  }
}


