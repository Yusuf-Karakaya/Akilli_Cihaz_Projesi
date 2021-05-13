package Akıllıcihaz;

public class SogutucuKapa implements IIslem{
    private IEyleyici iEyleyici;
    public SogutucuKapa(IEyleyici iEyleyici )
    {
        this.iEyleyici=iEyleyici;
    }
    @Override
    public void islemYap() {
        iEyleyici.kapa();
    }
}
