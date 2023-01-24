package com.ednipro.test.services.mappers;

import com.ednipro.test.dto.CellModelResponseDto;
import com.ednipro.test.models.CellModel;
import org.springframework.stereotype.Service;

@Service
public class CellResponseMapper implements ResponseMapper<CellModel, CellModelResponseDto> {
    @Override
    public CellModelResponseDto mapToDto(CellModel model) {
        CellModelResponseDto cellDto = new CellModelResponseDto();
        cellDto.setValue(model.getValue());
        return cellDto;
    }
}
