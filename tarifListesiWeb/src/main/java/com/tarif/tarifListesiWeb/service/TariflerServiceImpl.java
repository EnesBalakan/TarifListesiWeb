package com.tarif.tarifListesiWeb.service;

import com.tarif.tarifListesiWeb.dao.TariflerRepository;
import com.tarif.tarifListesiWeb.entity.Tarifler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TariflerServiceImpl implements TariflerService {

    private final TariflerRepository tariflerRepository;

    public TariflerServiceImpl(TariflerRepository tariflerRepository) {
        this.tariflerRepository = tariflerRepository;
    }

    @Override
    public List<Tarifler> findAll() {
        return tariflerRepository.findAll();
    }

    @Override
    public Tarifler findById(int theId) {
        Optional<Tarifler> result = tariflerRepository.findById(theId);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("Böyle bir ID'de tarif bulunamadı - " + theId);
        }
    }

    @Override
    public Tarifler save(Tarifler theTarifler) {
        return tariflerRepository.save(theTarifler);
    }

    @Override
    public void deleteById(int theId) {
        tariflerRepository.deleteById(theId);
    }
}