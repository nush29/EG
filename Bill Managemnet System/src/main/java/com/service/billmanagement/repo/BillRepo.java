package com.service.billmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.billmanagement.model.Bill;

@Repository
public interface BillRepo extends JpaRepository<Bill, Integer>{

}
