package com.tnf.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Dummy Entity for FK
@Entity
@Table(name = "batch")
public class Batch {

    @Id
    @Column(name = "batch_id")
    private int batchId;

    public Batch() {
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }
}
