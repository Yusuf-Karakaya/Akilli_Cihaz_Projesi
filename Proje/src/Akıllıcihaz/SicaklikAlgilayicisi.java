package Akıllıcihaz;

import java.util.Random;

public class SicaklikAlgilayicisi implements ISicaklikAlgilayicisi{

    private double sicaklikDegeri=0;

    public double getSicaklikDegeri(double sicaklikDegeri) {
        return sicaklikDegeri;
    }

    public void setSicaklikDegeri(double sicaklikDegeri) {
        this.sicaklikDegeri = sicaklikDegeri;
    }
    public double sicaklikDegeriOlustur(double sicaklikDegeri) {
        Random random =new Random();
        sicaklikDegeri=random.nextInt(90)-40;
        return sicaklikDegeri;
    }
    public double sicaklikAlgila(double sicaklikDegeri) {
        return sicaklikDegeriOlustur(sicaklikDegeri);
    }
}
