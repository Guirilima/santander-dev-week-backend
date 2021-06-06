package com.guirilima.santander.mapper;

import com.guirilima.santander.model.dto.StockDTO;
import com.guirilima.santander.model.entity.StockEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StockMapper {

    public StockEntity toEntity(StockDTO dto) {
        return StockEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .price(dto.getPrice())
                .variation(dto.getVariation())
                .date(dto.getDate())
                .build();
    }

    public StockDTO toDto(StockEntity entity) {
        return StockDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .variation(entity.getVariation())
                .date(entity.getDate())
                .build();
    }

    public List<StockDTO> toDto(List<StockEntity> list) {
        return list.stream().map(this::toDto).collect(Collectors.toList());
    }
}
