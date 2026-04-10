package com.portfolio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coursework {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private TranslationString title;

    @JsonBackReference("education-courseworks")
    @ManyToOne
    @JoinColumn(name = "course_education_id")
    private Education educationCourse;

    @JsonBackReference("education-projects")
    @ManyToOne
    @JoinColumn(name = "project_education_id")
    private Education educationProject;
}
