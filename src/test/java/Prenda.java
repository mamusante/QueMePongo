public class Prenda {
  private TipoPrenda tipo; //zapato, camisa manga corta, pantalon
  private Material material;
  private Color colorPrimario;
  private Color colorSecundario;
  private Trama trama;

  public Prenda(TipoPrenda tipo, Material material, Trama trama, Color colorPrimario, Color colorSecundario) {

    this.tipo = tipo;
    this.material = material;
    this.trama = trama;
    this.colorPrimario = colorPrimario;
    this.colorSecundario = colorSecundario;

  }

  public Categoria getCategoria(){
    return tipo.getCategoria();
  }

}

