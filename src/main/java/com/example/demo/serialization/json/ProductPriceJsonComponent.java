package com.example.demo.serialization.json;

import com.example.demo.domain.ProductPrice;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.math.BigDecimal;

@JsonComponent
public class ProductPriceJsonComponent {

    public static class Serializer extends JsonSerializer<ProductPrice> {

        @Override
        public void serialize(ProductPrice value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeNumber(value.getValue());
        }
    }


    public static class Deserializer extends JsonDeserializer<ProductPrice> {

        @Override
        public ProductPrice deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            BigDecimal value = p.readValueAs(BigDecimal.class);
            return ProductPrice.of(value);
        }
    }
}
