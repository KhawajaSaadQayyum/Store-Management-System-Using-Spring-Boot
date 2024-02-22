package com.StoreManagement.serviceImpl;


import com.StoreManagement.DAO.Repo;
import com.StoreManagement.model.Model;
import com.StoreManagement.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    @Autowired
    Repo repository;
    @Override
    public ResponseEntity<String> addItem(Map<String, String> requestMap) {
        try {
            Model model = new Model();
          model.setName(requestMap.get("name"));
          model.setEmail(requestMap.get("email"));
          model.setContactNumber(requestMap.get("contactNumber"));
          model.setTotalAmount(requestMap.get("totalAmount"));
          repository.save(model);
          return new ResponseEntity<>("Data successfully added",HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>("Something wentWrong in Service", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<Model>> getItems() {
        try{

            return new ResponseEntity<List<Model>>(repository.findAll(),HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<List<Model>>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> deleteItem(int productId) {
        try{

            return new ResponseEntity("Deleted Successfully",HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>("Something went Wrong in Service", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
