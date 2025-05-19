public class TelNoKontrol {
    public static void main(String[] args) {
        String numara = "5554443333" ;
        if (numaraKontrol(numara)) {
            System.out.println("Doğrulanmış Telefon Numarası: " + dogrulanmısNumara(numara));
        } else {
            System.out.println("Geçersiz Telefon Numarası.");
        }
    }

    static char metniTekTekParcala(String numara , int indeks) {
        char[] str = numara.toCharArray();
        return str[indeks];
    }

    static String metniParcala(String numara , int indeks) {
        String[] str = numara.split(" ") ;
        if (numara.contains(" ")) {
            return str[indeks] ;
        } return numara ;
    }

    static boolean parantez(String numara) {
        char prntz1 , prntz2 ;
        prntz1 = metniTekTekParcala(numara, 0) ;
        prntz2 = metniTekTekParcala(numara, 4) ;
        if (prntz1 == 40 && prntz2 == 41) {
            return true ;
        } return false ;
    }

    static boolean parantezIci(String numara) {
        char sayı1 , sayı2 , sayı3 ;
        sayı1 = metniTekTekParcala(numara,1) ;
        sayı2 = metniTekTekParcala(numara,2) ;
        sayı3 = metniTekTekParcala(numara,3) ;
        if (sayı1 != 48 && Character.isDigit(sayı3) && Character.isDigit(sayı2) && Character.isDigit(sayı1)) {
            return true ;
        } return false ;
    }

    static boolean rakamMi(String numara) {
        String numara2 = metniParcala(numara, 1) ;
        char n1 , n2 , n3 , n4 , n5 , n6 , n7 ;
        n1 = metniTekTekParcala(numara2, 0) ;
        n2 = metniTekTekParcala(numara2, 1) ;
        n3 = metniTekTekParcala(numara2, 2) ;
        n4 = metniTekTekParcala(numara2, 4) ;
        n5 = metniTekTekParcala(numara2, 5) ;
        n6 = metniTekTekParcala(numara2, 6) ;
        n7 = metniTekTekParcala(numara2, 7) ;
        return (Character.isDigit(n7) && Character.isDigit(n6) && Character.isDigit(n5) && Character.isDigit(n4) && Character.isDigit(n3) && Character.isDigit(n2) && Character.isDigit(n1)) ;
    }

    static boolean kısaCizgi(String numara) {
        String numara2 = metniParcala(numara, 1) ;
        char ksCzg = metniTekTekParcala(numara2, 3) ;
        return ksCzg == 45 ;
    }

    static boolean numaraKontrol(String numara) {
        return rakamMi(numara) && kısaCizgi(numara) && parantezIci(numara) && parantez(numara) ;
    }
    
    static String dogrulanmısNumara(String numara) {
        String numara1 , numara2 ;
        numara1 = metniParcala(numara, 0) ;
        numara2 = metniParcala(numara, 1) ;
        return numara1.substring(1, 4) + " " + numara2;
    }
}
