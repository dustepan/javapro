package ru.javapro.tasksix.tasksix.dto;

import lombok.Data;

import java.util.List;

/**
 * @author SDudin
 */
@Data
public class ResponseWithList {
    private List<Product> list;
}
