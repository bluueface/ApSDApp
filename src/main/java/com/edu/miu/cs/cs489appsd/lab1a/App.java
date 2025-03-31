package com.edu.miu.cs.cs489appsd.lab1a;

import com.edu.miu.cs.cs489appsd.lab1a.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class App {

    public static void main(String[] args) {
        Product[] products = new Product[]{
                new Product("3128874119", "Banana", LocalDate.parse("2023-01-24"), 124, 0.55),
                new Product("2927458265", "Apple", LocalDate.parse("2022-12-09"), 18, 1.09),
                new Product("9189927460", "Carrot", LocalDate.parse("2023-03-31"), 89, 2.99)
        };

        printProducts(products);
    }

    public static void printProducts(Product[] products) {
        // Sort by Unit Price descending
        Arrays.sort(products, Comparator.comparing(Product::getUnitPrice).reversed());

        System.out.println("=== JSON ===");
        try {
            ObjectMapper jsonMapper = new ObjectMapper();
            jsonMapper.registerModule(new JavaTimeModule()); // Handle LocalDate
            String jsonOutput = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(products);
            System.out.println(jsonOutput);
        } catch (IOException e) {
            System.out.println("JSON Error: " + e.getMessage());
        }

        System.out.println("\n=== XML ===");
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.registerModule(new JavaTimeModule()); // Handle LocalDate
            String xmlOutput = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(products);
            System.out.println(xmlOutput);
        } catch (IOException e) {
            System.out.println("XML Error: " + e.getMessage());
        }

        System.out.println("\n=== CSV ===");
        try {
            CsvMapper csvMapper = new CsvMapper();
            csvMapper.registerModule(new JavaTimeModule()); // Handle LocalDate
            CsvSchema schema = csvMapper.schemaFor(Product.class).withHeader();
            String csvOutput = csvMapper.writer(schema).writeValueAsString(Arrays.asList(products));
            System.out.println(csvOutput);
        } catch (IOException e) {
            System.out.println("CSV Error: " + e.getMessage());
        }
    }
}