public enum TipoPrenda{


  PANTALON(Categoria.PARTE_INFERIOR, 20),
  SHORT(Categoria.PARTE_INFERIOR, 40),
  ANTEOJO(Categoria.ACCESORIO , 50),
  REMERA_MANGA_LARGA(Categoria.PARTE_SUPERIOR, 20),
  REMERA_MANGA_CORTA(Categoria.PARTE_SUPERIOR, 40),
  ZAPATILLAS(Categoria.CALZADO , 30),
  ZAPATOS(Categoria.CALZADO, 25),
  OJOTAS(Categoria.CALZADO , 40),
  ;

  private Categoria categoria;
  private double maxTemp;

  TipoPrenda(Categoria categoria, Integer maxTemp){
    this.categoria = categoria;
    this.maxTemp = maxTemp;
  }

  public Categoria getCategoria(){
    return categoria;
  }

  public double getMaxTemp(){
    return maxTemp;
  }

}
