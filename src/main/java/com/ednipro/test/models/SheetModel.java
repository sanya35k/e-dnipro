package com.ednipro.test.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "sheet")
public class SheetModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "sheet_line",
            joinColumns = @JoinColumn(name = "sheet_id"),
            inverseJoinColumns = @JoinColumn(name = "line_id"))
    private List<RowModel> rowModels;
}
