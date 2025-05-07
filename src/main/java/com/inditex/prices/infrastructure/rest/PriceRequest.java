package com.inditex.prices.infrastructure.rest;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PriceRequest {
    @NotNull(message = "productId es requerido")
    @Positive(message = "productId es requerido y debe ser mayor que cero")
    int product_id;
    @NotNull(message = "brandId es requerido")
    @Positive(message = "brandId es requerido y debe ser mayor que cero")
    int brand_id;
    @NotNull(message = "query_date es requerida")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    LocalDateTime query_date;
}
