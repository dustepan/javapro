package ru.javapro.tasksix.tasksix.dto;

import lombok.Data;

/**
 * @author SDudin
 */
@Data
public class RequestDto {
    private Long id;
    private String product;
    private Integer balance;
}
