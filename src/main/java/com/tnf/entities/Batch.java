package com.tnf.entities;

import javax.persistence.*;

// Placeholder only - Batch is owned and fully defined by Group 2.
// Included here so Trainee.java compiles against the batch_id relationship.
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
