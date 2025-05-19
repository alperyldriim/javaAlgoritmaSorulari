package Algoritma;

public class en_uzun_Sirali_dizi {
    public static void main(String[] args) {
        int[] A = {2 , 1 , 5 , 0 , 1 , 2 , 5 , 4} ;
        int son_indis = 0;

        int ilk_indis = 0 ;
        int maks_uzunluk = 0 ;
        for (int i = 0; i < A.length-2; i++) {
            int uzunluk = 1 ;
            if (A[i] < A[i+1]) {
                uzunluk++ ;
                for (int j = i+1; j < A.length-1; j++) {
                    if (A[j] < A[j+1]) {
                        uzunluk++;
                    }
                    else {
                        if (uzunluk > maks_uzunluk) {
                            maks_uzunluk = uzunluk ;
                            son_indis = j ;
                            ilk_indis = i ;
                            i = j ;
                            break;
                        }
                    }
                }
            } 
        } 

        System.out.print("A Dizisi : ");
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println("\nİlk İndis: " + ilk_indis + "\nSon İndis : " + son_indis);
    }
}
