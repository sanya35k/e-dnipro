package com.ednipro.test.services.impls;

import com.ednipro.test.models.WorkbookModel;
import com.ednipro.test.repositories.WorkbookRepository;
import com.ednipro.test.services.impls.interfaces.WorkbookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkbookServiceImpl implements WorkbookService {
    private final WorkbookRepository workbookRepository;

    public WorkbookServiceImpl(WorkbookRepository workbookRepository) {
        this.workbookRepository = workbookRepository;
    }

    @Override
    public WorkbookModel getById(Long id) {
        return workbookRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Can't find table with id " + id));
    }

    @Override
    public List<WorkbookModel> getWithCell(String info) {
        List<WorkbookModel> byCell = workbookRepository.findByCell(info);
        return byCell;
    }

    @Override
    public List<WorkbookModel> getHistoryOf(Long id) {
        return workbookRepository.findByName(getById(id).getName());
    }

    @Override
    public WorkbookModel save(WorkbookModel book) {
        return workbookRepository.save(book);
    }
}
