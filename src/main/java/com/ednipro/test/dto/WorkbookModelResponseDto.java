package com.ednipro.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class WorkbookModelResponseDto {
    private List<SheetModelResponseDto> listSheetModelResponseDto;
    private LocalDateTime savingDateTime;
}
