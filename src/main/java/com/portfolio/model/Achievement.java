package com.portfolio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Achievement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private TranslationString description;
    @JsonBackReference("project-achievements")
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    @JsonBackReference("education-achievements")
    @ManyToOne
    @JoinColumn(name = "education_id")
    private Education education;
}
