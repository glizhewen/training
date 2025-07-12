package com.nttdata.training.backend.product.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import jakarta.validation.constraints.NotBlank;

@Data
public class ProductRequestDTO {
    @NotNull(message = "更新の場合、idを指定してください。", groups = {ProductRequestDTO.Update.class, ProductRequestDTO.PartialUpdate.class})
    private Long id;

    @NotBlank(message = "商品コードを指定してください。", groups = {ProductRequestDTO.Add.class, ProductRequestDTO.Update.class})
    private String productCode;

    @NotBlank(message = "商品名を指定してください。", groups = {ProductRequestDTO.Add.class, ProductRequestDTO.Update.class})
    private String productName;

    @Min(value = 0, groups = {ProductRequestDTO.Add.class, ProductRequestDTO.Update.class, ProductRequestDTO.PartialUpdate.class})
    @Max(value = 10000, groups = {ProductRequestDTO.Add.class, ProductRequestDTO.Update.class, ProductRequestDTO.PartialUpdate.class})
    @NotNull(message = "値段を指定してください。", groups = {ProductRequestDTO.Add.class, ProductRequestDTO.Update.class})
    private BigDecimal price;

    private String description;

    public interface Add {}

    public interface Update {}

    public interface PartialUpdate {}
}
