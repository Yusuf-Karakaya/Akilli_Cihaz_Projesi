package Akıllıcihaz;

public class ServisElemani implements IObserver {
    @Override
    public void update(String mesaj) {
        System.out.println("Servis Elemanına Gelen Mesaj -->"+mesaj);
    }

}
