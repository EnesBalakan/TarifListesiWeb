package com.tarif.tarifListesiWeb.dao;

import com.tarif.tarifListesiWeb.entity.Tarifler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariflerRepository extends JpaRepository<Tarifler, Integer> {
    // bu kadar... başka bişey yazmamıza gerek yok!
    // Veritabanı işlemleri için arayüz
    // DAO olmadan Service çalışamaz.

}
