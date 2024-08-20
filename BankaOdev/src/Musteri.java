public class Musteri 
{
    private String isim;
    private Hesap hesap;

    public Musteri(String isim) 
    {
        this.isim = isim;
    }

    public String getIsim() 
    {
        return isim;
    }

    public Hesap getHesap() 
    {
        return hesap;
    }

    public void setHesap(Hesap hesap) 
    {
        this.hesap = hesap;
    }

    public boolean hesapVarMi() 
    {
        return hesap != null;
    }
}

