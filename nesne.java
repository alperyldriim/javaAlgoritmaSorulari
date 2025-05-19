
import java.util.ArrayList;
import java.util.Arrays;

public class nesne {
    public static void main(String[] args) {

        System.out.println("Girilen bir dizinin elemanlarını ,sıralarını bozmadan yeni diziye aktaran program yazınız.\n" + //
                        "{3,3,87,56,1,87,3,2} -> {3,87,56,1,2}");
        int[] array = {3,3,87,56,1,87,3,2};
        int count = 0;
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            boolean isNotHasAnother = true ;
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    isNotHasAnother = false ;
                }
            } if (isNotHasAnother) {
                newArray[count] = array[i] ;
                count++;
            }
        } 
        newArray = Arrays.copyOf(newArray, count);
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }


        System.out.println("\n\nGirilen bir sayının asal bölenlerini bulun.");
        int sayı = 125 , tempSayı = sayı, bolen , bolum;
        System.out.print(sayı + " = ");
        for (int i = 2; i < tempSayı; i++) {
            bolum = 0 ;
            bolen = i ;
            while(tempSayı % bolen == 0) {
                tempSayı /= bolen ;
                bolum++ ;
            } if (bolum != 0 && tempSayı == 1) {
                System.out.print(bolen + "^" + bolum);
            } else if (bolum != 0) {
                System.out.print(bolen + "^" + bolum + " * ");
            }
        }



    }
}
