public enum TipoPrenda{


  PANTALON(Categoria.PARTE_INFERIOR),
  ANTEOJO(Categoria.ACCESORIO),
  REMERA(Categoria.PARTE_SUPERIOR),
  ZAPATILLAS(Categoria.CALZADO),
  ZAPATOS(Categoria.CALZADO)
  ;

  private Categoria categoria;

  TipoPrenda(Categoria categoria){
    this.categoria = categoria;
  }

  public Categoria getCategoria(){
    return categoria;
  }

}
