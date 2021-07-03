package com.company.produtos.dao;

import com.company.produtos.classe.Produto;
import com.company.produtos.dto.ProdutoDto;

import java.util.List;

import static com.company.produtos.ProdutosApplication.staticProdutos;

public class ProdutoDao {

    public static Produto save(ProdutoDto p){

        long id;

        if(!staticProdutos.isEmpty()){
            id = staticProdutos.stream().max((o1, o2) -> Long.compare(o1.getId(),o2.getId())).get().getId()+1;
        }else{
            id = 0L;
        }

        Produto produto = new Produto(p);
        produto.setId(id);

        staticProdutos.add(produto);

        return produto;

    }

    public static Produto readById(long id){

        return staticProdutos.stream().filter(x->x.getId() == id).findFirst().get();

    }

    public static List<Produto> readAll(){
        return staticProdutos;
    }

    public static Produto update(ProdutoDto newProduto){

        Produto p = staticProdutos.stream().filter(newProduto::equalsDto).findFirst().get();

        p.setCodigo(newProduto.getCodigo());
        p.setNome(newProduto.getNome());
        p.setPreco(newProduto.getPreco());

        System.out.println(staticProdutos.stream().filter(newProduto::equalsDto).findFirst().get().toString());

        return p;

    }

    public static void delete(ProdutoDto p){

        staticProdutos.removeIf(p::equalsDto);

    }


}
