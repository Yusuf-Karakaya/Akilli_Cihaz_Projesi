package Akıllıcihaz;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Kullanici implements IObserver{
    private String adi;
    private String sifre;
    private int yetki;
    VeriTabaniSurucusu vtb=new VeriTabaniSurucusu();


    public Kullanici(KullaniciBuilder builder) {
        this.adi = builder.adi;
        this.sifre = builder.sifre;
        this.yetki=builder.yetki;

    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public double getYetki() {
        return yetki;
    }

    public void setYetki(int yetki) {
        this.yetki = yetki;
    }
    @Override
    public void update(String mesaj)
    {
        vtb.veritabanibaglan();
        String adKontrol=getAdi();
        String sifreKontrol=getSifre();
        try {
            vtb.st = vtb.conn.createStatement();
            ResultSet rs = vtb.st.executeQuery("select * from kullanicibilgileri where kullaniciadi='"+adKontrol+"'");
            while (rs.next())
            {
                String kontrolAd=rs.getString("KullaniciAdi");
                String kontrolSifre=rs.getString("KullaniciSifre");
                String kontrolMesaj=rs.getString("KullaniciMesaj");
                if(getAdi().equals(kontrolAd)&&getAdi().equals(kontrolSifre))
                {
                    String sql = "update kullanicibilgileri set kullanicimesaj = ? where kullaniciadi='"+adKontrol+"'";
                    PreparedStatement pstmt = vtb.conn.prepareStatement(sql);
                    pstmt.setString(1, mesaj);
                    pstmt.executeUpdate();

                }

            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

    }
    public static class KullaniciBuilder
    {
        private String adi;
        private String sifre;
        private int yetki;

        public KullaniciBuilder(String adi, String sifre) {
            this.adi = adi;
            this.sifre = sifre;
        }
        public KullaniciBuilder yetki (int yetki) {
            this.yetki = yetki;
            return this;
        }


        //Return the finally consrcuted Dikdortgen object
        public Kullanici build() {

            return new Kullanici(this);
        }

    }
}
