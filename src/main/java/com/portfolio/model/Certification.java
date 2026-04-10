package com.portfolio.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Certification implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private TranslationString name;
    private String issuer;
    @Formula("CASE WHEN expiry_date IS NULL OR expiry_date > CURRENT_DATE THEN true ELSE false END")
    private boolean active;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    @OneToOne(cascade = CascadeType.ALL)
    private TranslationString description;
    private String badgeUrl;
    private String logo;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    private List<TechnologyTopicRate> technologies;
}
