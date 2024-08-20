public class CariHesap extends Hesap 
{
	private double aylikUcret;

	public CariHesap(Musteri musteri, String hesapNumarasi, double baslangicBakiyesi, double aylikUcret) 
	{
		super(musteri, hesapNumarasi, baslangicBakiyesi);
	    this.aylikUcret = aylikUcret;
	}

	    @Override
	    public void aylikBakim() 
	    {
	        try 
	        {
	            paraCek(aylikUcret);
	        } 
	        catch (negatifExc e) 
	        {
	            System.out.println(e.getMessage());
	        }
	    }
}


