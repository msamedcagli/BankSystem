public class TasarrufHesabi extends Hesap 
{
    private double faizOrani;

    public TasarrufHesabi(Musteri musteri, String hesapNumarasi, double baslangicBakiyesi, double faizOrani) 
    {
        super(musteri, hesapNumarasi, baslangicBakiyesi);
        this.faizOrani = faizOrani;
    }

    public void faizUygula() 
    {
        bakiye += bakiye * faizOrani;
    }

    @Override
    public void aylikBakim() 
    {
        faizUygula();
    }
}




