package com.mycompany.aulaspring3;

import com.mycompany.aulaspring3.model.Produto;
import com.mycompany.aulaspring3.rest.ProdutoRest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private ProdutoRest produtoRest;

    public Application(ProdutoRest produtoRest) {
        this.produtoRest = produtoRest;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        String uri = "http://localhost:8080/rest/produto";
        int id = 389;

        //get todos
        String json = produtoRest.getAsJSON(uri);
        System.out.println(json);

        //get por id
        Class produtoClass = Produto.class;
        Object getProduto = produtoRest.get(uri, produtoClass, id);
        System.out.println("Tipo: "+((Produto) getProduto).getTipo());

        //put
        Produto putProduto = new Produto(id, "Nestle", "Chocolate",5,56, new Date());
        System.out.println("Tipo: "+ produtoRest.put(uri, putProduto, id));

        //post
        Produto postProduto = new Produto("Nestle","Chocolate",5,56, new Date());
        produtoRest.post(uri, postProduto);

        //delete
        produtoRest.delete(uri, id);

    }
}
