package Akıllıcihaz;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeriTabaniSurucusu
{
    Statement st;
    Connection conn;
    private String url="jdbc:postgresql://localhost:5432/AkilliCihazKullaniciBilgileri";
    private String name="postgres";
    private String pass="YusufKarakaya1";
        public void veritabanibaglan()
        {
            try
            {
                conn=DriverManager.getConnection(url,name,pass);
                System.out.println("Bağlantı Gerçekleşti");
                 st = conn.createStatement();
            }
            catch (SQLException e){
                System.out.println("error");
                e.printStackTrace();
            }
        }





}
