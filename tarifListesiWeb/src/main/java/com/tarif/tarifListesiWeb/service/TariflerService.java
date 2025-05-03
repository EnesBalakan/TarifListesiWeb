package com.tarif.tarifListesiWeb.service;

import com.tarif.tarifListesiWeb.entity.Tarifler;

import java.util.List;

// Controller, doğrudan Repository’ye erişmek yerine bu Service interface’ini ve onun implementasyonunu kullanarak çalışır.
// Bu da daha esnek, test edilebilir ve katmanlı bir yapı sağlar.

public interface TariflerService {
    List<Tarifler> findAll();

    Tarifler findById(int theId);

    Tarifler save(Tarifler theTarifler);

    void deleteById(int theId);
}
