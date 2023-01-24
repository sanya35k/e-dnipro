package com.ednipro.test.services.impls;

import com.ednipro.test.models.CellModel;
import com.ednipro.test.models.RowModel;
import com.ednipro.test.models.SheetModel;
import com.ednipro.test.models.WorkbookModel;
import com.ednipro.test.services.impls.interfaces.WorkbookService;
import com.ednipro.test.services.impls.interfaces.XlsFileReaderService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class XlsFileReaderServiceImpl implements XlsFileReaderService {
    private final WorkbookService workbookService;

    public XlsFileReaderServiceImpl(WorkbookService workbookService) {
        this.workbookService = workbookService;
    }

    public WorkbookModel saveWorkbookToDb(String file) {
        return workbookService.save(readWorkbook(file));
    }

    private WorkbookModel readWorkbook(String filePath) {
        WorkbookModel book = new WorkbookModel();
        book.setSavingDateTime(LocalDateTime.now());

        List<RowModel> rows = new ArrayList<>();
        List<SheetModel> sheetModels = new ArrayList<>();
        List<CellModel> cells = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
                Workbook workbook = new XSSFWorkbook(fileInputStream)) {
            Iterator<Sheet> sheetIterator = workbook.sheetIterator();
            Sheet sheet;
            while (sheetIterator.hasNext()) {
                sheet = sheetIterator.next();
                for (Row row : sheet) {
                    int numberOfCellsInRow = 0;
                    for (Cell cell : row) {
                        if (!cell.getStringCellValue().isEmpty()) {
                            CellModel cellDto = new CellModel();
                            cellDto.setValue(cell.getStringCellValue());
                            cells.add(cellDto);
                            numberOfCellsInRow++;
                        }
                    }
                    if (numberOfCellsInRow > 0) {
                        RowModel rowDto = new RowModel();
                        rowDto.setCellModels(List.copyOf(cells));
                        rows.add(rowDto);
                        cells.clear();
                    }
                }
                SheetModel pageDto = new SheetModel();
                pageDto.setRowModels(List.copyOf(rows));
                rows.clear();
                sheetModels.add(pageDto);
            }
            book.setName(filePath.substring(filePath.indexOf('/') + 1));
            book.setSheetModels(sheetModels);
            return book;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
