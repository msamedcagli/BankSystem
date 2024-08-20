import java.util.Scanner;

public class Main {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Banka banka = new Banka();

        while (true) 
        {
            System.out.println("\nBanka İşlemleri Menüsü:");
            System.out.println("1. Hesap Aç");
            System.out.println("2. Para Yatır");
            System.out.println("3. Para Çek");
            System.out.println("4. Bakiye Görüntüle");
            System.out.println("5. Aylık Bakım İşlemlerini Gerçekleştir");
            System.out.println("6. Toplam Banka Bakiyesini Görüntüle");
            System.out.println("7. Çıkış");
            System.out.print("Seçiminiz:");
            int secim = scanner.nextInt();
            scanner.nextLine();  

            switch (secim) 
            {
                case 1:
                    System.out.print("Müşteri İsmi: ");
                    String isim = scanner.nextLine();
                    Musteri musteri = new Musteri(isim);

                    System.out.print("Hesap Numarası: ");
                    String hesapNumarasi = scanner.nextLine();

                    System.out.print("Başlangıç Bakiyesi: ");
                    double bakiye = scanner.nextDouble();

                    System.out.print("Hesap Türü (1: Tasarruf, 2: Cari): ");
                    int hesapTuru = scanner.nextInt();

                    try 
                    {
                        if (hesapTuru == 1) 
                        {
                            System.out.print("Faiz Oranı: ");
                            double faizOrani = scanner.nextDouble();
                            Hesap tasarrufHesabi = new TasarrufHesabi(musteri, hesapNumarasi, bakiye, faizOrani);
                            banka.hesapEkle(tasarrufHesabi);
                        } 
                        else if (hesapTuru == 2) 
                        {
                            System.out.print("Aylık Ücret: ");
                            double aylikUcret = scanner.nextDouble();
                            Hesap cariHesap = new CariHesap(musteri, hesapNumarasi, bakiye, aylikUcret);
                            banka.hesapEkle(cariHesap);
                        }
                        System.out.println("Hesap başarıyla açıldı.");
                    } 
                    catch (negatifExc e) 
                    {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Hesap Numarası: ");
                    String hesapNumarasiParaYatir = scanner.nextLine();
                    Hesap hesapParaYatir = banka.hesapBul(hesapNumarasiParaYatir);
                    if (hesapParaYatir != null) 
                    {
                        System.out.print("Yatırılacak Miktar: ");
                        double yatirMiktar = scanner.nextDouble();
                        hesapParaYatir.paraYatir(yatirMiktar);
                        System.out.println("Para başarıyla yatırıldı.");
                    } 
                    else 
                    {
                        System.out.println("Hesap bulunamadı.");
                    }
                    break;

                case 3:
                    System.out.print("Hesap Numarası: ");
                    String hesapNumarasiParaCek = scanner.nextLine();
                    Hesap hesapParaCek = banka.hesapBul(hesapNumarasiParaCek);
                    if (hesapParaCek != null) 
                    {
                        System.out.print("Çekilecek Miktar: ");
                        double cekMiktar = scanner.nextDouble();
                        try 
                        {
                            hesapParaCek.paraCek(cekMiktar);
                            System.out.println("Para başarıyla çekildi.");
                        } 
                        catch (negatifExc e) 
                        {
                            System.out.println(e.getMessage());
                        }
                    } 
                    else 
                    {
                        System.out.println("Hesap bulunamadı.");
                    }
                    break;

                case 4:
                    System.out.print("Hesap Numarası: ");
                    String hesapNumarasiBakiyeGor = scanner.nextLine();
                    Hesap hesapBakiyeGor = banka.hesapBul(hesapNumarasiBakiyeGor);
                    if (hesapBakiyeGor != null) 
                    {
                        System.out.println("Hesap Bakiyesi: " + hesapBakiyeGor.getBakiye());
                    } 
                    else 
                    {
                        System.out.println("Hesap bulunamadı.");
                    }
                    break;

                case 5:
                    banka.aylikBakimIslemleri();
                    System.out.println("Aylık bakım işlemleri gerçekleştirildi.");
                    break;

                case 6:
                    System.out.println("Toplam Banka Bakiyesi: " + banka.toplamBakiye());
                    break;

                case 7:
                    System.out.println("Çıkış yapılıyor...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                    break;
            }
        }
    }
}
