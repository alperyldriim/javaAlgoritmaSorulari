package Algoritma;

import java.util.Scanner;

public class cumleList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Bir Metin Giriniz: ");
        String metin = sc.nextLine() ;

        byte[] dizi = new byte[65535] ;
        for (int i = 0; i < metin.length(); i++) {
            dizi[metin.charAt(i)]++ ;
        }

        LinkList cumle = new LinkList() ;
        for (int i = 0; i < dizi.length; i++) 
            if (dizi[i] != 0) 
                cumle.elemanEkle((char) i, dizi[i]);
        
        cumle.yazdir();

        Link current = cumle.head ;

        Huffman table = new Huffman() ;
        if (table.bosMu(current))
            System.out.println("LinkList Kümesi Boş");
        else
            System.out.println("LinkList Kümesi Dolu");
    }

 
}

class Link {
    char ch ;
    int frekans , indis;
    double yuzdeKac ;
    Link next , prev ;

    Link (char ch , int frekans) {
        this.ch = ch ; 
        this.indis = (int) ch ;
        this.frekans = frekans ;
        next = null ;
    }   
}

class LinkList {
    Link head , tail ;

    LinkList () {
        head = null ;
        tail = null ;
    }

    void elemanEkle(char ch , int frekans) {
        Link eleman = new Link(ch , frekans) ;
        if (head == null) {
            head = eleman ;
            tail = eleman ;
        } else {
            Link kopya = head.next , current = head;
            int maxFrekans = tail.frekans , minFrekans = head.frekans ;
            if ((eleman.frekans < minFrekans) || ((eleman.frekans == minFrekans) && (head.indis > eleman.indis))) {
                eleman.next = head ;
                head.prev = eleman ;
                head = eleman ;
            } else if ((eleman.frekans > maxFrekans) || (eleman.frekans == maxFrekans && eleman.indis < tail.indis)) {
                tail.next = eleman ;
                eleman.prev = tail ;
                tail = eleman ;
            } else {
                while (kopya != null) {
                    if ((eleman.frekans < kopya.frekans) || ((eleman.frekans == kopya.frekans) && (eleman.indis < kopya.indis))) {
                        current.next = eleman ;
                        eleman.prev = current ;
                        eleman.next = kopya ;
                        kopya.prev = eleman ;
                        return;
                    }
                    kopya = kopya.next ;
                    current = current.next ;
                }
            }  
        }
    }

    int elemanSayisi(Link head) {
        if (head == null)
            return 0 ;
        return 1 + elemanSayisi(head.next) ;
    }

    Link bastakiElemanSilGoster() {
        if (head == null) 
            return null;
        Link current = head ;
        head.next = head ;
        head.prev = null ;
        return current ;   
    }

    Link bastakiElemanGoster() {
        if (head == null) 
            return null;
        return head ;   
    }

    void yazdir () {
        if (head == null) 
            return ;
        else {
            Link kopya = head ;
            int topChar = topChar(kopya) ;
            System.out.println("\nFarklı Çeşitteki Char Sayısı: " + charSayisi(kopya));
            System.out.println("Metindeki Toplam Char Sayısı: " + topChar);
            System.out.println("Sıralama Sırası (Min Adet --> Max Adet); ");
            while (kopya != null) {
                System.out.println("\nChar       : "  + kopya.ch);
                System.out.println("Char İndisi: "  + kopya.indis);
                System.out.println("Frekans    : "  + kopya.frekans);
                System.out.println("Yüzde Kaç  : %" + (100 * kopya.frekans / (double) topChar)  + "\n");
                kopya = kopya.next ;
            }
        }
    }

    int charSayisi(Link head) {
        if (head == null) 
            return 0;
        return 1 + charSayisi(head.next);
    }

    int topChar(Link head) {
        if (head == null)
            return 0;
        return head.frekans + topChar(head.next) ;
    }
}

class HuffmanNode {
    char ch ;
    int frekans ;
    HuffmanNode leftChild , rightChild ;

    HuffmanNode (Link node) {
        this.ch = node.ch ;
        this.frekans = node.frekans ;
    }

    HuffmanNode(int frekans) {
        this.ch = null ;
        this.frekans = frekans ;
    }
    

}

class Huffman {
    LinkList children = new LinkList();
    HuffmanNode root ;

    void agacOlustur() {
        Link current = children.head ;
        while (children.charSayisi(current) != 1) {
            System.out.println(children.charSayisi(current));
            HuffmanNode parent = new HuffmanNode(current.frekans + current.next.frekans); 
            if (children.charSayisi(current) == 2)
                root = parent ;
            parent.leftChild = elemanEkle(children.bastakiElemanSilGoster());
            parent.rightChild = elemanEkle(children.bastakiElemanSilGoster()); 
            children.elemanEkle(parent.ch, parent.frekans);
        }
    }

    void elemanEkle(Link children) {
        HuffmanNode parent = new HuffmanNode(children) ;
        parent.leftChild = null ;
        parent.rightChild = null ;
    }


    void yazdir (HuffmanNode localRoot) {
        if (localRoot != null){
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.ch + ": " + localRoot.frekans);
            inOrder(localRoot.rightChild);
        }
    }

    boolean bosMu(Link head) {
        if (head == null) 
            return true;
        return false ;
    }

}
