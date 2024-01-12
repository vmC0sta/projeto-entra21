package com.example.projetofinal.exceptions.error;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Data
public class StandardError implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}

