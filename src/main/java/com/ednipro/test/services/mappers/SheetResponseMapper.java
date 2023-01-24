package com.ednipro.test.services.mappers;

import com.ednipro.test.dto.RowModelResponseDto;
import com.ednipro.test.dto.SheetModelResponseDto;
import com.ednipro.test.models.RowModel;
import com.ednipro.test.models.SheetModel;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class SheetResponseMapper implements ResponseMapper<SheetModel, SheetModelResponseDto> {
    private final ResponseMapper<RowModel, RowModelResponseDto> rowMapper;

    public SheetResponseMapper(ResponseMapper<RowModel, RowModelResponseDto> rowMapper) {
        this.rowMapper = rowMapper;
    }

    @Override
    public SheetModelResponseDto mapToDto(SheetModel model) {
        SheetModelResponseDto sheetDto = new SheetModelResponseDto();
        sheetDto.setListRowResponseDto(model.getRowModels().stream()
                .map(rowMapper::mapToDto)
                .collect(Collectors.toList()));
        return sheetDto;
    }
}
