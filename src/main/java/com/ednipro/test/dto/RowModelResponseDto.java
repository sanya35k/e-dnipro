package com.ednipro.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RowModelResponseDto {
    private List<CellModelResponseDto> listResponseDto;
}
