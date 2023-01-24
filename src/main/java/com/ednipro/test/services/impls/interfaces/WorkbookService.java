package com.ednipro.test.services.impls.interfaces;

import com.ednipro.test.models.WorkbookModel;
import java.util.List;

public interface WorkbookService {
    WorkbookModel getById(Long id);

    WorkbookModel save(WorkbookModel book);

    List<WorkbookModel> getWithCell(String info);

    List<WorkbookModel> getHistoryOf(Long id);
}
