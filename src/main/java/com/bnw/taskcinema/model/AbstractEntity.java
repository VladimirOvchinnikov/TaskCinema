package com.bnw.taskcinema.model;

import com.bnw.taskcinema.model.common.LocalDateTimeFieldValue;
import com.bnw.taskcinema.model.common.converter.LocalDateTimeFieldValueConverter;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractEntity {

//    private static final Echo DEFAULT = new Echo();
    public static final AbstractEntity DEFAULT = new AbstractEntity(){};
    {
        setId(0);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid")
    private Integer id;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    @Convert(converter = LocalDateTimeFieldValueConverter.class)
    private LocalDateTimeFieldValue createdAt = new LocalDateTimeFieldValue();
    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    @Convert(converter = LocalDateTimeFieldValueConverter.class)
    private LocalDateTimeFieldValue updatedAt = new LocalDateTimeFieldValue();
    @Column(name = "deleted_at", insertable = false, updatable = false)
//    @Convert(converter = LocalDateTimeFieldValueConverter.class)
    private LocalDateTime deletedAt;


    @PrePersist
    private void prePersist() {
//        LocalDateTime cd = LocalDateTime.now();
//        createdAt.setValue(cd);
//        updatedAt.setValue(cd);
        preSaveInit();
    }

    @PreUpdate
    public void preUpdate() {
//        updatedAt.setValue(LocalDateTime.now());
    }

    public void preSaveInit() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt.getValue();
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt.setValue(createdAt);
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt.getValue();
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt.setValue(updatedAt);
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
