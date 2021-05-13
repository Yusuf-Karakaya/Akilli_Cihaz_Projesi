package Akıllıcihaz;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Eyleyici implements IEyleyici
{
    private int sogutucuDurum;
    public void ac()
    {
        System.out.println("Soğutucu Açıldı..");
        sogutucuDurum=1;
    }
    public void kapa()
    {
        System.out.println("Soğutucu Kapatıldı..");
        sogutucuDurum=0;

    }

}
