package com.dat.easyresumebackend.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Pham Tien Dat on 06/11/2017.
 */
@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
