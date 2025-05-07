package com.inditex.prices.infrastructure.controller;

import com.inditex.prices.application.IFindPriceUseCase;
import com.inditex.prices.application.exception.PriceNotFoundException;
import com.inditex.prices.infrastructure.rest.PriceRequest;
import com.inditex.prices.infrastructure.rest.PriceResponse;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerErrorException;

import javax.swing.text.Utilities;

@RestController
@RequestMapping("prices")
public class PriceController {

    private final IFindPriceUseCase findPriceUseCase;

    @Autowired
    public PriceController(IFindPriceUseCase findPriceUseCase) {
        this.findPriceUseCase = findPriceUseCase;
    }

    @GetMapping("/getPrice")
    public ResponseEntity<PriceResponse> getPrice(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Valid PriceRequest data) {
        try {
            PriceResponse priceResponse = findPriceUseCase.findPrice(data);
            if (priceResponse==null)
                throw new PriceNotFoundException("No se encontró un precio para el producto y fecha indicados");
            else
                return new ResponseEntity<>(priceResponse, HttpStatus.OK);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error inesperado en el servidor");
        }
    }


}
