package com.xinthe.pmp.service;

import com.xinthe.pmp.model.PmsCollection;

import java.util.List;

public interface PmsService {
    List<PmsCollection> getAllCollections();
    PmsCollection getCollectionById(String id);
    PmsCollection createCollection(PmsCollection collection);
    PmsCollection updateCollection(String id, PmsCollection collection);
    void deleteCollection(String id);
}
