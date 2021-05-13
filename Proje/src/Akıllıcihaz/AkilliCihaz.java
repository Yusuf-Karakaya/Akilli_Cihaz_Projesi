package Akıllıcihaz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AkilliCihaz
{
    private ISicaklikAlgilayicisi sicaklikAlgilayicisi;
    private IAgArayuzu agArayuzu;
    private IEyleyici eyleyici;
    Scanner input=new Scanner(System.in);
    VeriTabaniSurucusu vtb=new VeriTabaniSurucusu();
    String adGiris;
    String sifreGiris;
    int giris=0;
    int yetki;
    public AkilliCihaz()
    {
        sicaklikAlgilayicisi=new SicaklikAlgilayicisi();
        agArayuzu=new AgArayuzu(sicaklikAlgilayicisi,eyleyici);
        eyleyici=new Eyleyici();
    }
    public void basla(){
        agArayuzu.mesajGoruntule("Akıllı Cihaz Sistemine Hoşgeldiniz...");
        do {
            agArayuzu.mesajGoruntule("Kullanıcı Adınızı Giriniz...");
            adGiris=input.nextLine();
            agArayuzu.mesajGoruntule("Kullanıcı Şifrenizi Giriniz...");
            sifreGiris =input.nextLine();
            Kullanici kullanici=new Kullanici.KullaniciBuilder(adGiris,sifreGiris).yetki(0).build();
            agArayuzu.mesajGoruntule("Kullanıcı Bilgileri Doğrulanıyor...");
            kullanici.setAdi(adGiris);
            kullanici.setSifre(sifreGiris);
            vtb.veritabanibaglan();
            try
            {
                vtb.st=vtb.conn.createStatement();
                String query = "select * from kullanicibilgileri where kullaniciadi='"+adGiris+"'";
                ResultSet rs=vtb.st.executeQuery(query);//where ondan kullanici girdipi bilgi kontrol eiştse yetki kontrolü sağla yetere
                while(rs.next()){
                    String kontrolAd=rs.getString("KullaniciAdi");
                    String kontrolSifre=rs.getString("KullaniciSifre");
                    yetki=rs.getInt("KullaniciYetki");

                    if(adGiris.equals(kontrolAd))
                    {
                        if(sifreGiris.equals(kontrolSifre))
                        {
                            System.out.println("Hoşgeldiniz ..."+kullanici.getAdi());
                            giris=1;
                        }
                        else
                        {
                            System.out.println("Hatalı Şifre Tekrar Giriş Yapınız...");

                        }
                    }
                    else
                    {
                        System.out.println("Hatalı Kullanıcı Adı veya Şifre Tekrar Giriş Yapınız");

                    }
                }

            }
            catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        }
        while(giris==0);

        agArayuzu.mesajGoruntule("Yapmak İstediğiniz İşlemi Giriniz...");
        agArayuzu.mesajGoruntule("1. Sıcaklık Görüntüle");
        agArayuzu.mesajGoruntule("2. Soğutucu Aç");
        agArayuzu.mesajGoruntule("3. Soğutucu Kapa");
        agArayuzu.mesajGoruntule("4.Çıkış");
        int islem= input.nextInt();
        switch (islem){
            case 1:
                    IIslem sicaklikGoruntule=new SicaklikGoruntule(agArayuzu);
                    sicaklikGoruntule.islemYap();

                    break;
            case 2:
                if(yetki==1)
                {
                    IIslem sogutucuAc = new SogutucuAc(eyleyici);
                    sogutucuAc.islemYap();
                    break;
                }
                else
                    System.out.println("Yetkiniz Olmadığı için işlem Yapılamıyor...");
                break;
            case 3:
                if(yetki==1)
                {
                    IIslem sogutucuKapa = new SogutucuKapa(eyleyici);
                    sogutucuKapa.islemYap();
                    break;
                }
                else
                    System.out.println("Yetkiniz Olmadığı için işlem Yapılamıyor...");
                break;
            case 4:

                break;
            default:
                System.out.println("Hatalı Tuşlama Yaptınız..");
                break;
        }


    }
}
