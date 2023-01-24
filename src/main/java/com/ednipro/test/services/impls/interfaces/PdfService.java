package com.ednipro.test.services.impls.interfaces;

import com.ednipro.test.models.WorkbookModel;

public interface PdfService {
    String makePdfFromWorkbook(WorkbookModel workbookModel);
}
