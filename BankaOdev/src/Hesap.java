public abstract class Hesap 
{
    private Musteri musteri;
    private String hesapNumarasi;
    protected double bakiye;

    public Hesap(Musteri musteri, String hesapNumarasi, double baslangicBakiyesi) 
    {
        this.musteri = musteri;
        this.hesapNumarasi = hesapNumarasi;
        this.bakiye = baslangicBakiyesi;
    }

    public String getHesapNumarasi() 
    {
        return hesapNumarasi;
    }

    public String getMusteriIsim() 
    {
        return musteri.getIsim();
    }

    public double getBakiye() 
    {
        return bakiye;
    }

    public Musteri getMusteri() 
    {
        return musteri;
    }

    public void paraYatir(double miktar) 
    {
        if (miktar > 0) {
            bakiye += miktar;
        }
    }

    public void paraCek(double miktar) throws negatifExc 
    {
        if (miktar > 0 && miktar <= bakiye) 
        {
            bakiye -= miktar;
        } else 
        {
            throw new negatifExc("Yetersiz bakiye!");
        }
    }

    public abstract void aylikBakim();
}


