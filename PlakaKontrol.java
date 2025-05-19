import java.util.Scanner;

public class PlakaKontrol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Plakayı Giriniz: ");
        String plaka = sc.nextLine();
        
        if (plakaKontrol(plaka)) {
            System.out.println("Plaka Uygun Formatta.");
        } else {
            System.out.println("Plaka Uygun Formatta Değil.");
        }
    }

    static char metniTekTekParcala(String plaka , int indeks) {
        char[] str = plaka.toCharArray();
        return str[indeks];
    }

    static String metniParcala(String plaka , int indeks) {
        String[] str = plaka.split(" ") ;
        return str[indeks] ;
    }

    static boolean ilkİkiRakamMi(String plaka) {
        String plakaRakam = metniParcala(plaka, 0) ;
        char plaka1 = metniTekTekParcala(plakaRakam, 0) ;
        char plaka2 = metniTekTekParcala(plakaRakam, 1) ;
        if (Character.isDigit(plaka1) && Character.isDigit(plaka2)) {
            if ((plaka1) < 56) {
                if ((plaka1) == 48 && (plaka2) == 48) {
                    return false;
                } else if ((plaka1) == 55 && (plaka2) > 55) { 
                    return false ;
                } return true ;
            }
        } return false ;
    }

    static boolean dokuzKarakterliMi(String plaka) {
        if (plaka.length() == 9) {
            return true ;
        } return false ;
    }

    static boolean ikiHarfliMi(String plaka) {
        String plakaRakam = metniParcala(plaka, 1) ;
        char ilkHarf = metniTekTekParcala(plakaRakam, 0) ;
        char ikinciHarf = metniTekTekParcala(plakaRakam, 1) ;
        if (Character.isLetter(ilkHarf) && Character.isUpperCase(ilkHarf) && Character.isLetter(ikinciHarf) && Character.isUpperCase(ikinciHarf) && plakaRakam.length() == 2) {
            if ((ilkHarf == 81 || ilkHarf == 87 || ilkHarf == 88) || (ikinciHarf == 81 || ikinciHarf == 87 || ikinciHarf == 88)) {
                return false ;
            } return true ;
        } return false ;
    }

    static boolean sonUcRakamMi(String plaka) {
        String plakaRakam = metniParcala(plaka, 2) ;
        char plaka1 = metniTekTekParcala(plakaRakam, 0) ;
        char plaka2 = metniTekTekParcala(plakaRakam, 1) ;
        char plaka3 = metniTekTekParcala(plakaRakam, 2) ;
        if (Character.isDigit(plaka3) && Character.isDigit(plaka2) && Character.isDigit(plaka1)) {
            return true ;
        } return false ;
    }

    static boolean plakaKontrol(String plaka) {
        if (dokuzKarakterliMi(plaka) && ilkİkiRakamMi(plaka) && ikiHarfliMi(plaka) && sonUcRakamMi(plaka)) {
            return true ;
        } return false ;
    }
}
