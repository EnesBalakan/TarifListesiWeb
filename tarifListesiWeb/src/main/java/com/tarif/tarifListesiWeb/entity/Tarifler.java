package com.tarif.tarifListesiWeb.entity;

import jakarta.persistence.*;

@Entity
@Table(name="tarifler")
public class Tarifler {
    // sütunları tanımla

    @Id
    // Bu otomatik olarak arttırır
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // sonra da database deki tablolarla yeni varlıkları eşitliyoruz
    @Column(name="id")
    private int id;

    @Column(name="tarif_adi")
    private String tarif_adi;

    @Column(name="malzemeler")
    private String malzemeler;

    @Column(name="pisirme_suresi")
    private String pisirme_suresi;

    public Tarifler() {
    }


    public Tarifler(int id, String malzemeler, String pisirme_suresi, String tarif_adi) {
        this.id = id;
        this.malzemeler = malzemeler;
        this.pisirme_suresi = pisirme_suresi;
        this.tarif_adi = tarif_adi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMalzemeler() {
        return malzemeler;
    }

    public void setMalzemeler(String malzemeler) {
        this.malzemeler = malzemeler;
    }

    public String getPisirme_suresi() {
        return pisirme_suresi;
    }

    public void setPisirme_suresi(String pisirme_suresi) {
        this.pisirme_suresi = pisirme_suresi;
    }

    public String getTarif_adi() {
        return tarif_adi;
    }

    public void setTarif_adi(String tarif_adi) {
        this.tarif_adi = tarif_adi;
    }

    @Override
    public String toString() {
        return "Tarifler{" +
                "id=" + id +
                ", tarif_adi='" + tarif_adi + '\'' +
                ", malzemeler='" + malzemeler + '\'' +
                ", pisirme_suresi='" + pisirme_suresi + '\'' +
                '}';
    }
}
