package com.guirilima.santander.service;

import com.guirilima.santander.exceptions.BusinessException;
import com.guirilima.santander.exceptions.NotFoundException;
import com.guirilima.santander.mapper.StockMapper;
import com.guirilima.santander.model.dto.StockDTO;
import com.guirilima.santander.model.entity.StockEntity;
import com.guirilima.santander.repository.StockRepository;
import com.guirilima.santander.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    private final StockRepository stockRepository;
    private final StockMapper stockMapper;

    @Autowired
    public StockService(StockRepository stockRepository,StockMapper stockMapper) {
        this.stockRepository = stockRepository;
        this.stockMapper = stockMapper;
    }

    @Transactional
    public StockDTO save(StockDTO stockDTO) {
        Optional<StockEntity> optionalStockEntity = stockRepository.findByNameAndDate(stockDTO.getName(), stockDTO.getDate());

        if (optionalStockEntity.isPresent()) {
            throw new BusinessException(MessageUtils.ACTIVE_ALREADY_EXISTS);
        }

        StockEntity stockEntity = stockMapper.toEntity(stockDTO);
        stockRepository.save(stockEntity);
        return stockMapper.toDto(stockEntity);
    }

    @Transactional
    public StockDTO update(StockDTO dto) {
        Optional<StockEntity> optionalEntity = stockRepository.findByStockUpdate(dto.getName(), dto.getId(), dto.getDate());
        if (optionalEntity.isPresent()) {
            throw new BusinessException(MessageUtils.ACTIVE_ALREADY_EXISTS);
        }
        StockEntity stockEntity = stockMapper.toEntity(dto);
        stockRepository.save(stockEntity);
        return stockMapper.toDto(stockEntity);
    }

    @Transactional
    public StockDTO delete(Long id) {
        StockDTO stockDTO = findById(id);
        stockRepository.deleteById(stockDTO.getId());
        return stockDTO;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<StockDTO> findAll() {
        List<StockEntity> list = stockRepository.findAll();
        if (list.isEmpty()) {
            throw new NotFoundException();
        }
        return stockMapper.toDto(list);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public StockDTO findById(Long id) {
        return stockRepository.findById(id)
                .map(stockMapper::toDto)
                .orElseThrow(NotFoundException::new);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<StockDTO> findByCurrentDate() {
        return stockRepository.findByCurrentDate(LocalDate.now())
                .map(stockMapper::toDto)
                .orElseThrow(NotFoundException::new);
    }
}
