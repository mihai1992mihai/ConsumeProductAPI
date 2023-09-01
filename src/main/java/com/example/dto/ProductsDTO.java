package com.example.dto;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

@Getter
@Setter
public class ProductsDTO {

    private MetaDTO meta;
    private ArrayList<ProductDTO> products;

}