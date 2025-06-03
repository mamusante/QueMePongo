import Exceptions.PrendaInvalidaException;

public class Borrador {
  private TipoPrenda tipo; //zapato, camisa manga corta, pantalon
  private Material material;
  private Color colorPrimario;
  private Color colorSecundario = null;
  private Trama trama = Trama.LISA;
  private Estilo estilo;

  Borrador(TipoPrenda tipo){
    this.validateNotNull(tipo);
    this.tipo = tipo;
  }

  public void elegirMaterial(Material material){
    this.validateNotNull(material);
    this.validarMaterialConsistenteConTipo(material);
    this.material = material;
  }

  public void elegirTrama(Trama trama){
    if(trama == null){
      this.trama = Trama.LISA;
    }else this.trama = trama;
  }

  public void elegirEstilo(Estilo estilo){
    this.estilo = estilo;
  }

  public void elegirColorPrimario(Color colorPrimario){
    this.validateNotNull(colorPrimario);
    this.colorPrimario = colorPrimario;

  }

  public void elegirColorSecundario(Color colorSecundario){
    this.colorSecundario = colorSecundario;
  }

  public Prenda crearPrenda(){
    this.validateNotNull(tipo);
    this.validateNotNull(material);
    this.validateNotNull(colorPrimario);
    this.validateNotNull(estilo);
    return new Prenda(tipo,material,trama,colorPrimario,colorSecundario,estilo);
  }

  private void validateNotNull(Object o){
    if(o == null){
      throw new PrendaInvalidaException("El campo no puede ser nulo");
    }
  }

  private void validarMaterialConsistenteConTipo(Material material){
    material.consistenteCon(tipo);
  }
}
