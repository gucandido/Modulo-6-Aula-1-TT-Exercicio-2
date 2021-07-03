package com.company.produtos.classe;

import com.company.produtos.dto.ProdutoDto;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto implements ProdutoEq{

    private long id;
    private String nome;
    private String codigo;
    private BigDecimal preco;

    public Produto(ProdutoDto p) {
        this.nome = p.getNome();
        this.codigo = p.getCodigo();
        this.preco = p.getPreco();
    }

    public Produto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public boolean equalsDto(Object o){
        ProdutoDto produto = (ProdutoDto) o;
        return codigo == produto.getCodigo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id == produto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                ", preco=" + preco +
                '}';
    }

}
