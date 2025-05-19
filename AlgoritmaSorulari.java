import java.util.Random;
import java.util.Scanner;

public class AlgoritmaSorulari {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Bir Sayı Giriniz: ");
        int sayi1 = sc.nextInt() ;
        System.out.print("Bir Sayı Giriniz: ");
        int sayi2 = sc.nextInt() ;
        mukemmelSayi1(sayi1, sayi2);
        
        
        
    }

    // ***Soru 10: Girilen Sayının Basamak Sayısı Kaç?
    static int kacBasamak1(int sayi) {
        if (sayi/10 == 0) 
            return 1;
        return 1 + kacBasamak1(sayi/10) ;
    }

    static void kacBasamak(int sayi) {
        System.out.print("Girilen Sayının Basamak Değeri: " + kacBasamak1(sayi));
    }


    // ***Soru 11: Girilen 3 Basamaklı Sayının Basamak Değerlerinin Küpleri Toplamı Sayıya Eşit Mi?
    static double armstrongSayi1(int sayi) {
        if (sayi == 0) 
            return 0;
        return Math.pow(sayi%10, 3) + armstrongSayi1(sayi/10) ;
    }

    static void armstrongSayi(int sayi) {
        if (kacBasamak1(sayi) != 3) {
            System.out.println("Sayı 3 Basamaklı değil");
        } else {
            if (armstrongSayi1(sayi) == sayi) 
                System.out.println("Girilen Sayının Basamak Değerlerinin Toplamı Sayıya Eşit");
            else 
                System.out.println("Girilen Sayının Basamak Değerlerinin Toplamı Sayıya Eşit Değil");   
        }
    }


    // ***Soru 12: Girilen Sayı Adedindeki Sayılardan Çift sayıların Tek Sayılara Oranı Kaç?
    static void ciftinTekeOranı(int sayiAdet) {
        Scanner sc = new Scanner(System.in);
        double topTek = 0 , topCift = 0 ;
        int sayac = 1;
        while (sayac <= sayiAdet) {
            System.out.print(sayac + ".Sayı: ");
            int sayi = sc.nextInt() ;
            if (sayi % 2 == 0) 
                topCift += sayi ;
            else 
                topTek += sayi ;
            sayac++ ;
        }
        System.out.println("Girilen Çift Sayıların Tek Sayılara Oranı: " + topCift/topTek);
    }


    // ***Soru 13: Girilen 2 Sayı Arasındaki Tam Kare Sayılar
    static void tamKareSayilar(int kucuk , int buyuk) {
        if (kucuk < 0 || buyuk < 0) {
            System.out.println("Sayılar Pozitif Olmalıdır!");
            return;
        } if (buyuk < kucuk) {
            int kopya = kucuk ;
            kucuk = buyuk ;
            buyuk = kopya ;
        } int sayi = 0 ;
        System.out.print(kucuk + " ile " + buyuk + " Arasındaki Tam Kare Sayılar: ");
        while (sayi*sayi <= buyuk) {
            if (sayi*sayi >= kucuk) {
                System.out.print(sayi*sayi + " ");
            }
            sayi++;
        }
    }


    // ***Soru 17: Girilen 2 Sayı Dost Sayı Mı?
    static void dostSayilar(int sayi1 , int sayi2) {
        if (sayi1 < 0 || sayi2 < 0) 
            System.out.println("Sayılar Pozitif Olmalıdır!");
        else if (bolenleriToplami(sayi1, sayi1-1) == sayi2 && bolenleriToplami(sayi2, sayi2-1) == sayi1) 
            System.out.println("Girilen 2 Sayı Dost Sayı");
        else
            System.out.println("Girilen 2 Sayı Dost Sayı Değil");
    }

    static int bolenleriToplami(int sayi , int sayac) {
        if (sayac == 0)
            return 0 ;
        else if (sayi % sayac == 0)
            return sayac + bolenleriToplami(sayi, sayac-1) ;
        return bolenleriToplami(sayi, sayac-1) ;
    }
    

    // ***Soru 20: Girilen Sayı Mükemmel Sayı Mı?
    static void mukemmelSayi(int sayi) {
        if (bolenleriToplami(sayi, sayi) == sayi*2) 
            System.out.println("Girilen Sayı Mükemmel Sayı");
        else 
            System.out.println("Girilen Sayı Mükemmel Sayı Değil");
    }


    // ***Soru 21: Girilen 2 Sayı Arasındaki Çift Sayıların Toplamı Mükemmel Sayı Mı?
    static void mukemmelSayi1(int min , int maks) {
        if (maks < min) {
            int kopya = min ;
            min = maks ;
            maks = kopya ;
        } int top = 0 ;
        while (min <= maks) {
            if (min % 2 != 0) 
                min++;
            top += min ;
            min += 2 ;
        } mukemmelSayi(top);
    }


    // ***Soru 22: Girilen Sayının Girilen Üssünü Bulma
    static int usBulma1(int sayi , int us) {
        if (us == 0)
            return 1 ;
        return sayi * usBulma1(sayi, us-1) ;
    }

    static void usBulma(int sayi , int us) {
        System.out.println("Girilen Sayının Üssü: " + usBulma1(sayi, us));
    }


    // ***Soru 23: Girilen Sayı Abudant (Zengin) Sayı Mı?
    static void abundantSayi(int sayi) {
        if (bolenleriToplami(sayi, sayi-1) > sayi) 
            System.out.println("Girilen Sayı Abudant (Zengin) Sayı");
        else 
            System.out.println("Girilen Sayı Abudant (Zengin) Sayı Değil");
    }


    // ***Soru 25: Girilen İki Sayı 50'den Büyükse c=a+b Değilse Uygun Değil
    static void ellidenBuyukMu(int sayi1 , int sayi2) {
        if (sayi1 >= 50 && sayi2 >= 50) 
            System.out.println("İşlem Sonucu (c = a+b): " + (sayi1+sayi2));
        else
            System.out.println("Girilen Sayılar 50'den Büyük değil");
    }


    // ***Soru 26: Girilen Minimum Sayı ile Girilen Maksimum Sayı Arasındaki Rastgele Sayıyı En Kısa Sürede Bulma
    static void randomSayiBul(int min , int maks) {
        Random rd = new Random();
        if (maks < min) {
            int kopya = min ;
            min = maks ;
            maks = kopya ;
        }
        int sayi = rd.nextInt(min,maks);
        int sayac = 1 ;
        System.out.println("\nRastgele Üretilen Sayı: " + sayi);
        System.out.print("Sırasıyla Denetlenen Sayılar: {");
        while ((min+maks)/2 != sayi) {
            System.out.print((min+maks)/2 + " - ");
            if (sayi < (min+maks)/2) 
                maks = (min+maks)/2 ;
            else 
                min = (min+maks)/2 ;
            sayac++;
        } System.out.println(sayi + "}");
        System.out.println("Yapılan Deneme Sayısı: " + sayac + "\n");
    }


    // ***Soru 27: Girilen Decimal Sayıyı Binary Sayıya Çevirme
    static String decimalBinary1(int sayi) {
        if (sayi/2 == 0 || sayi/2 == 1) 
            return String.valueOf(sayi/2) + String.valueOf(sayi%2)  ;
        return decimalBinary1(sayi/2) + String.valueOf(sayi%2) ;
    }

    static void decimalBinary(int sayi) {
        System.out.println("Girilen Decimal Sayının Binary Hali: " + decimalBinary1(sayi));
    }


}
