package com.mycompany.aulaspring3.model;

import java.io.Serializable;
import java.util.Date;

public class Produto implements Serializable {

    private int id;
    private String tipo;
    private String marca;
    private float valor;
    private Date ultimoRestoque;
    private int quantidadeEstoque;

    public Produto(int id, String tipo, String marca, float valor, int quantidade, Date ultimoRestoque) {
        this.setId(id);
        this.setTipo(tipo);
        this.setMarca(marca);
        this.setValor(valor);
        this.setQuantidadeEstoque(quantidade);
        this.ultimoRestoque = ultimoRestoque;
    }

    public Produto(String tipo, String marca, float valor, int quantidade, Date ultimoRestoque) {
        this.setTipo(tipo);
        this.setMarca(marca);
        this.setValor(valor);
        this.setQuantidadeEstoque(quantidade);
        this.ultimoRestoque = ultimoRestoque;
    }

    public Produto() {

    }

    @Override
    public String toString() {
        return "Produto{" +
                "int=" + id +
                ", tipo='" + tipo + '\'' +
                ", valor='" + valor + '\'' +
                ", qtd='" + quantidadeEstoque + '\'' +
                ", ultimoRestoque='" + ultimoRestoque + '\'' +
                '}';
    }

    public Date getUltimoRestoque() {
        return ultimoRestoque;
    }

    public void setUltimoRestoque(Date ultimoRestoque) {
        this.ultimoRestoque = ultimoRestoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public float getValor() {
        return valor;
    }

    public void restoque() {
        this.ultimoRestoque = new Date();
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void addQuantidadeEstoque(int quantidade) {
        this.quantidadeEstoque += quantidade;
    }

    public void setQuantidadeEstoque(int quantidade) {
        this.quantidadeEstoque = quantidade;
    }

    public void diminuirQuantidadeEstoque(int quantidade) {
        this.quantidadeEstoque -= quantidade;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

}

