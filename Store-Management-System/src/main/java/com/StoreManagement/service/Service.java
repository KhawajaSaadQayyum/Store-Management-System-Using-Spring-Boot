package com.StoreManagement.service;

import com.StoreManagement.model.Model;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
@org.springframework.stereotype.Service

public interface Service {
    ResponseEntity<String> addItem(Map<String, String> requestMap);

    ResponseEntity<List<Model>> getItems();

    ResponseEntity<String> deleteItem(int productId);
}
