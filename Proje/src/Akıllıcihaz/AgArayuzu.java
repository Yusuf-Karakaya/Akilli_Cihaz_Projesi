package Akıllıcihaz;

public class AgArayuzu implements IAgArayuzu
{
    private ISicaklikAlgilayicisi iSicaklikAlgilayicisi;
    private IEyleyici ieyleyici;
    Kullanici kullanici=new Kullanici.KullaniciBuilder(null,null).build();
    ServisElemani srvElemani=new ServisElemani();
    public AgArayuzu(ISicaklikAlgilayicisi iSicaklikAlgilayicisi ,IEyleyici iEyleyici){
        this.iSicaklikAlgilayicisi=iSicaklikAlgilayicisi;
        this.ieyleyici=iEyleyici;
    }
    public void sicaklikGoruntule(){
      double SicaklikDegeri=iSicaklikAlgilayicisi.sicaklikAlgila(0);
        System.out.println("Sıcaklık Değeri :"+SicaklikDegeri);
        if(SicaklikDegeri<-5||SicaklikDegeri>60)
        {
            srvElemani.update("Cihaz Arızalanmıştır Lütfen Cihaz tamiri için yola çıkınız...");
        }
    }


    public void mesajGoruntule(String mesaj){ System.out.println(mesaj); }

}
