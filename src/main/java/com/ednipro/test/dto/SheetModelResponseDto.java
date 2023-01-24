package com.ednipro.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SheetModelResponseDto {
    private List<RowModelResponseDto> listRowResponseDto;
}
