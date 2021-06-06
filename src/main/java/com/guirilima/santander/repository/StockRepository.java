package com.guirilima.santander.repository;

import com.guirilima.santander.model.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<StockEntity,Long> {

}
