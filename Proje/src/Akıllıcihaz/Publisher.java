package Akıllıcihaz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Publisher implements ISubject{
    private List<IObserver> servisElemanlari = new ArrayList<>();
    private ISicaklikAlgilayicisi sicaklikAlgilayicisi;
    private IAgArayuzu agArayuzu;
    private IEyleyici eyleyici;
    private IObserver iObserver;
    Kullanici kullanici=new Kullanici.KullaniciBuilder(null,null).build();

    @Override
    public void attach(IObserver servisElemani) { servisElemanlari.add(servisElemani);}

    @Override
    public void detach(IObserver servisElemani) {servisElemanlari.remove(servisElemani); }

    @Override
    public void notify(String mesaj) {
        if(sicaklikAlgilayicisi.sicaklikAlgila(0)>90||sicaklikAlgilayicisi.sicaklikAlgila(0)<-5)
        {
            kullanici.update("Sıcaklık Değeri Tehlikeli Seviyeye Geldi Cihaz Kapatılıyor...");
            eyleyici.kapa();
            //burda kullanıcaya
            for(IObserver servisElemani: servisElemanlari)
            {
                servisElemani.update(mesaj);
            }
        }
//sıcaklik degeri aşildi kullaniciya bilgi ve agarayüzü eyleyiciye mesaj gönder eyleyyici sistemi kapatsın...
    }

}

