package com.ednipro.test.services.mappers;

import com.ednipro.test.dto.CellModelResponseDto;
import com.ednipro.test.dto.RowModelResponseDto;
import com.ednipro.test.models.CellModel;
import com.ednipro.test.models.RowModel;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class RowResponseMapper implements ResponseMapper<RowModel, RowModelResponseDto> {
    private final ResponseMapper<CellModel, CellModelResponseDto> cellResponseMapper;

    public RowResponseMapper(ResponseMapper<CellModel, CellModelResponseDto> cellResponseMapper) {
        this.cellResponseMapper = cellResponseMapper;
    }

    @Override
    public RowModelResponseDto mapToDto(RowModel model) {
        RowModelResponseDto rowDto = new RowModelResponseDto();
        rowDto.setListResponseDto(model.getCellModels().stream()
                .map(cellResponseMapper::mapToDto)
                .collect(Collectors.toList()));
        return rowDto;
    }
}
