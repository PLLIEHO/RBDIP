package study.cursach.dto;

import lombok.Data;

@Data
public class CustomsDTO {
    private String name;
    private Integer max_size;
    private Integer max_weight;
    private boolean is_importable;
}
