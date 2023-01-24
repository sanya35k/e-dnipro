package com.ednipro.test.services.impls.interfaces;

import com.ednipro.test.models.WorkbookModel;

public interface XlsFileReaderService {
    WorkbookModel saveWorkbookToDb(String file);
}
