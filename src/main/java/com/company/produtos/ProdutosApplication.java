package com.company.produtos;

import com.company.produtos.classe.Produto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProdutosApplication {

    public static List<Produto> staticProdutos = new ArrayList<>();

    public static void main(String[] args) {

        SpringApplication.run(ProdutosApplication.class, args);

    }

}
