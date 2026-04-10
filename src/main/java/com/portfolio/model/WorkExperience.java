package com.portfolio.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperience implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String companyName;
    @ManyToOne(cascade = CascadeType.ALL)
    private TranslationString description;
    private String companyLogo;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne(cascade = CascadeType.ALL)
    private TranslationString position;
    private Boolean active;
    @ManyToOne(cascade = CascadeType.ALL)
    private Location location;
    @JsonManagedReference("company-projects")
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Project> projects;
}
