package Akıllıcihaz;

public class SicaklikGoruntule implements IIslem{

    private IAgArayuzu iAgArayuzu;
    public SicaklikGoruntule(IAgArayuzu iAgArayuzu )
    {
        this.iAgArayuzu=iAgArayuzu;
    }
    @Override
    public void islemYap() {
        iAgArayuzu.mesajGoruntule("Sıcaklık Değeri Algılanıyor...");
        iAgArayuzu.sicaklikGoruntule();
    }
}
