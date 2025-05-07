package com.inditex.prices.application;

import com.inditex.prices.infrastructure.rest.PriceRequest;
import com.inditex.prices.infrastructure.rest.PriceResponse;

public interface IFindPriceUseCase {

    public PriceResponse findPrice(PriceRequest priceRequest);

}
