package com.StoreManagement.controller;

import com.StoreManagement.model.Model;
import com.StoreManagement.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/store")
public class Controller {
    @Autowired
    Service service;
   @PostMapping("/addItem")
    private ResponseEntity<String> addItem(@RequestBody (required = true) Map<String, String> requestMap){
       try{
           return service.addItem(requestMap);
       }
       catch (Exception e){
           e.printStackTrace();
       }
       return new ResponseEntity<>("Something went wrong in Controller", HttpStatus.INTERNAL_SERVER_ERROR);
   }
   @GetMapping("/getItems")
   private ResponseEntity<List<Model>> getItems(){
       try{
           return service.getItems();
       }
       catch (Exception e){
           e.printStackTrace();
       }
       return new ResponseEntity<List<Model>>(new ArrayList<Model>(),HttpStatus.INTERNAL_SERVER_ERROR);
   }
   @DeleteMapping("/deleteItem{id}")
    private ResponseEntity<String> deleteItem(@PathVariable int id){
       try{
           return service.deleteItem(id);
       }catch (Exception e){
           e.printStackTrace();
       }
       return new ResponseEntity<>("Something went wrong in Controller", HttpStatus.INTERNAL_SERVER_ERROR);
   }
}
