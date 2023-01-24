package com.ednipro.test.services.mappers;

import com.ednipro.test.dto.SheetModelResponseDto;
import com.ednipro.test.dto.WorkbookModelResponseDto;
import com.ednipro.test.models.SheetModel;
import com.ednipro.test.models.WorkbookModel;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class WorkbookResponseMapper
        implements ResponseMapper<WorkbookModel, WorkbookModelResponseDto> {
    private final ResponseMapper<SheetModel, SheetModelResponseDto> sheetResponseMapper;

    public WorkbookResponseMapper(ResponseMapper<SheetModel,
                    SheetModelResponseDto> sheetResponseMapper) {
        this.sheetResponseMapper = sheetResponseMapper;
    }

    @Override
    public WorkbookModelResponseDto mapToDto(WorkbookModel model) {
        WorkbookModelResponseDto dto = new WorkbookModelResponseDto();
        dto.setListSheetModelResponseDto(model.getSheetModels().stream()
                .map(sheetResponseMapper::mapToDto)
                .collect(Collectors.toList()));
        dto.setSavingDateTime(model.getSavingDateTime());
        return dto;
    }
}
