package com.ednipro.test.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "workbook")
public class WorkbookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "workbook_sheets",
            joinColumns = @JoinColumn(name = "workbook_id"),
            inverseJoinColumns = @JoinColumn(name = "sheet_id"))
    private List<SheetModel> sheetModels;
    private LocalDateTime savingDateTime;
}
