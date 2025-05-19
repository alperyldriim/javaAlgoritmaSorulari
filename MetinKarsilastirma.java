import java.util.Scanner;

public class MetinKarsilastirma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String birinciMetin , ikinciMetin ;
        int baslangic , kacKarakter ;
        System.out.print("Birinci Stringi Giriniz: ");
        birinciMetin = sc.nextLine();
        System.out.print("İkinci Stringi Giriniz: ");
        ikinciMetin = sc.nextLine();
        metinTamamenAyniMi(birinciMetin, ikinciMetin);
        metinAyniMi(birinciMetin, ikinciMetin);
        leksikografik(birinciMetin, ikinciMetin);
        System.out.print("Karşılaştırma İçin Başlangıç İndisi Giriniz: ");
        baslangic = sc.nextInt() ;
        System.out.print("Karşılaştırma İçin Kaç Karakterin Kontrol Edileceğini Giriniz: ");
        kacKarakter = sc.nextInt() ;
        metinKarsilastirma(birinciMetin, ikinciMetin, baslangic, kacKarakter);
    }

    static boolean metinKontrol(String birinci , String ikinci) {
        if (birinci.length() == ikinci.length()) {
            for (int i = 0; i < birinci.length(); i++) {
                if (birinci.charAt(i) != ikinci.charAt(i)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    static void metinTamamenAyniMi(String birinci , String ikinci) {
        if (metinKontrol(birinci, ikinci)) {
            System.out.println("İki String Aynıdır.");
        } else {
            System.out.println("İki String Farklıdır.");
        }
    }

    static void metinAyniMi(String birinci , String ikinci) {
        birinci = birinci.toUpperCase();
        ikinci = ikinci.toUpperCase() ;
        if (metinKontrol(birinci, ikinci)) {
            System.out.println("İki String Büyük/Küçük Harf Farkını Yok Sayarak Aynıdır.");
        } else {
            System.out.println("İki String Büyük/Küçük Harf Farkını Yok Sayarak Farklıdır.");
        }
    }

    static void leksikografik(String birinci , String ikinci) {
        int result = birinci.compareTo(ikinci) ;
        if (result == 0) {
            System.out.println("Birinci String, İkinci Stringden Leksikografik Olarak Aynıdır.");
        } else if (result == 1) {
            System.out.println("Birinci String, İkinci Stringden Leksikografik Olarak Sonradır.");
        } else {
            System.out.println("Birinci String, İkinci Stringden Leksikografik Olarak Öncedir.");
        }
    }

    static void metinKarsilastirma(String birinci , String ikinci , int baslangic , int kacKarakter) {
        boolean result = birinci.regionMatches(baslangic , ikinci , baslangic , kacKarakter) ;
        if (result) {
            System.out.println("Belirtilen Bölgelerdeki Karakterler Aynıdır.");
        } else {
            System.out.println("Belirtilen Bölgelerdeki Karakterler Farklıdır.");
        }
    }
}
