package com.javaKodCalismaKarti.model;

public class Flashcard {  //bu class kartlar üzerinde işlem yapmak için oluşturduk
    private String konu;    // karlar iki yüzlü bir konu birde açıklama adında iki kartımız var onları tanımladık ve işlemleri entegre ettik
    private String aciklama;

    public Flashcard(String konu, String aciklma) {
        this.konu = konu;
        this.aciklama = aciklma;
    }

    // Getter metotları
    public String getKonu() { return konu; }
    public String getAciklama() { return aciklama; }
}
