public class Prenda {
  private TipoPrenda tipo; //zapato, camisa manga corta, pantalon
  private Material material;
  private Color colorPrimario;
  private Color colorSecundario;
  private Trama trama;
  private Estilo estilo;

  public Prenda(TipoPrenda tipo, Material material, Trama trama, Color colorPrimario, Color colorSecundario, Estilo estilo) {

    this.tipo = tipo;
    this.material = material;
    this.trama = trama;
    this.colorPrimario = colorPrimario;
    this.colorSecundario = colorSecundario;
    this.estilo = estilo;

  }

  public Boolean isInformal() {
    return estilo == Estilo.INFORMAL;
  }

  public Categoria getCategoria(){
    return tipo.getCategoria();
  }

  public Trama getTrama(){
    return trama;
  }

  public Estilo getEstilo(){
    return estilo;
  }
}

