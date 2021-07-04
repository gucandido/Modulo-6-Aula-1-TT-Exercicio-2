package com.company.produtos.dto;

import com.company.produtos.classe.Produto;
import com.company.produtos.classe.ProdutoEq;

import java.math.BigDecimal;
import java.util.Objects;

public class ProdutoDto implements ProdutoEq {

    private String nome;
    private String codigo;
    private BigDecimal preco;

    public ProdutoDto() {
    }

    public ProdutoDto(Produto p) {
        this.nome = p.getNome();
        this.preco = p.getPreco();
        this.codigo = p.getCodigo();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public static Produto convert(ProdutoDto p){
        return new Produto(p);
    }

    public static ProdutoDto convertDto(Produto p){
        return new ProdutoDto(p);
    }

    @Override
    public boolean equalsDto(Object o){
        Produto produto = (Produto) o;
        return codigo.equals(produto.getCodigo());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoDto that = (ProdutoDto) o;
        return codigo.equals(that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
