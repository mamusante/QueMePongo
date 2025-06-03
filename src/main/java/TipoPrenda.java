public enum TipoPrenda{


  PANTALON(Categoria.PARTE_INFERIOR, 20),
  ANTEOJO(Categoria.ACCESORIO , -1),
  REMERA_MANGA_LARGA(Categoria.PARTE_SUPERIOR, 20),
  REMERA_MANGA_CORTA(Categoria.PARTE_SUPERIOR, -1),
  ZAPATILLAS(Categoria.CALZADO , 30),
  ZAPATOS(Categoria.CALZADO, 30)
  ;

  private Categoria categoria;
  private Integer maxTemp;

  TipoPrenda(Categoria categoria, Integer maxTemp){
    this.categoria = categoria;
    this.maxTemp = maxTemp;
  }

  public Categoria getCategoria(){
    return categoria;
  }

  public Integer getMaxTemp(){
    return maxTemp;
  }

}
