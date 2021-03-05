package com.example.demo.domain;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class ProductNameTest {


    @TestFactory
    List<DynamicTest> validValues() {
        List<DynamicTest> tests = new ArrayList<>();
        List<String> validValues = Arrays.asList(
                "product 1",
                "product 2"
        );
        for (String value : validValues) {
            String testName = "Valid values for product name";
            Executable assertions = () -> {
                assertDoesNotThrow(() ->  ProductName.of(value));
            };
            DynamicTest dynamicTest = dynamicTest(testName, assertions);
            tests.add(dynamicTest);
        }

        return tests;
    }



    @TestFactory
    Stream<DynamicTest> invalidValuesTest() {
        return Stream.of(null, "", " ")
                .map(invalidValue -> {
                    String testName = "Value " + invalidValue + " should be invalid";
                    return dynamicTest(testName, () -> {
                        assertThrows(
                                RuntimeException.class,
                                () -> ProductName.of(invalidValue)
                        );
                    });
                });
    }

    @TestFactory
    Stream<DynamicTest> invalidLongNames() {
        return Stream.of(
                StringUtils.repeat("a", 129),
                StringUtils.repeat("a", 256)
        )
                .map(invalidValue -> {
                    String testName = "Value " + invalidValue + " should be invalid for long value";
                    return dynamicTest(testName, () -> {
                        assertThrows(
                                IllegalArgumentException.class,
                                () -> ProductName.of(invalidValue)
                        );
                    });
                });
    }
}