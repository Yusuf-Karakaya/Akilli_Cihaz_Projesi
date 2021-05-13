package Akıllıcihaz;

public class SogutucuAc implements IIslem{
    private IEyleyici iEyleyici;
    public SogutucuAc(IEyleyici iEyleyici )
    {
        this.iEyleyici=iEyleyici;
    }
    @Override
    public void islemYap() {
        iEyleyici.ac();
    }

}
