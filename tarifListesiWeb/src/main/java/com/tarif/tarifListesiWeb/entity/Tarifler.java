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
    private int tarif_adi;

    @Column(name="malzemeler")
    private int malzemeler;

    @Column(name="pisirme_suresi")
    private int pisirme_suresi;

    public Tarifler(int id, int malzemeler, int pisirme_suresi, int tarif_adi) {
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

    public int getMalzemeler() {
        return malzemeler;
    }

    public void setMalzemeler(int malzemeler) {
        this.malzemeler = malzemeler;
    }

    public int getPisirme_suresi() {
        return pisirme_suresi;
    }

    public void setPisirme_suresi(int pisirme_suresi) {
        this.pisirme_suresi = pisirme_suresi;
    }

    public int getTarif_adi() {
        return tarif_adi;
    }

    public void setTarif_adi(int tarif_adi) {
        this.tarif_adi = tarif_adi;
    }

    @Override
    public String toString() {
        return "Tarifler{" +
                "id=" + id +
                ", tarif_adi=" + tarif_adi +
                ", malzemeler=" + malzemeler +
                ", pisirme_suresi=" + pisirme_suresi +
                '}';
    }
}
