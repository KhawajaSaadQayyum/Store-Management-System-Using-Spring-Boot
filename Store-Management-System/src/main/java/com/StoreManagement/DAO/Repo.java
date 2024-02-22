package com.StoreManagement.DAO;

import com.StoreManagement.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<Model, Integer> {
}
