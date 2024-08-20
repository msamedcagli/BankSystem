import java.util.ArrayList;
import java.util.List;

public class Banka 
{
    private List<Hesap> hesaplar;

    public Banka() 
    {
        hesaplar = new ArrayList<>();
    }

    public void hesapEkle(Hesap hesap) throws negatifExc 
    {
        Musteri musteri = hesap.getMusteri();
        if (musteri.hesapVarMi()) 
        {
            throw new negatifExc("Müşteri zaten bir hesaba sahip.");
        }
        hesaplar.add(hesap);
        musteri.setHesap(hesap);
    }

    public Hesap hesapBul(String hesapNumarasi) 
    {
        for (Hesap hesap : hesaplar) 
        {
            if (hesap.getHesapNumarasi().equals(hesapNumarasi)) 
            {
                return hesap;
            }
        }
        return null;
    }

    public double toplamBakiye() 
    {
        double toplam = 0;
        for (Hesap hesap : hesaplar) 
        {
            toplam += hesap.getBakiye();
        }
        return toplam;
    }

    public void aylikBakimIslemleri() 
    {
        for (Hesap hesap : hesaplar) 
        {
            hesap.aylikBakim();
        }
    }
}

