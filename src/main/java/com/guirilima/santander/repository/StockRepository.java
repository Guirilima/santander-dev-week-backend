package com.guirilima.santander.repository;

import com.guirilima.santander.model.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<StockEntity,Long> {

    Optional<StockEntity> findByNameAndDate(String name, LocalDate date);

    @Query("SELECT stock FROM StockEntity stock WHERE stock.name = :name AND stock.date = :date AND stock.id <> :id ")
    public Optional<StockEntity> findByStockUpdate(String name, Long id, LocalDate date);

    @Query("SELECT stock FROM StockEntity stock WHERE stock.date = :date ")
    Optional<List<StockEntity>> findByCurrentDate(LocalDate date);
}
