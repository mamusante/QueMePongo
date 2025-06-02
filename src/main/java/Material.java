public enum Material {

  CUERO{
    @Override
    protected void consistenteCon(TipoPrenda tipo) {
      if(tipo != TipoPrenda.ZAPATOS && tipo != TipoPrenda.PANTALON ){
        throw new MaterialInconsistenteConTipoException("El material y el tipo no son consistentes.");
      }
    }
  },
  GABARDINA{
    @Override
    protected void consistenteCon(TipoPrenda tipo) {

    }
  },
  LINO{
    @Override
    protected void consistenteCon(TipoPrenda tipo) {

    }
  },
  ALGODON{
    @Override
    protected void consistenteCon(TipoPrenda tipo) {

    }
  };

  protected abstract void consistenteCon(TipoPrenda tipo);
}
