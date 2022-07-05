/*
 * The MIT License
 *
 * Copyright 2022 Daniel Frey.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.com.infox.model;

/**
 *
 * @author Daniel Frey
 * @version 1.0.0
 */
public class OS_OrdemServico {

    private int os;
    private String data_os;
    private String equipamento;
    private String defeito;
    private String servico;
    private String valor;
    private int id_cliente;
    private int id_usuario_tecnico;
    private String tipo;
    private String situacao;
    private String nomeCliente;
    private String nomeTecnico;

    public OS_OrdemServico() {
    }

    public OS_OrdemServico(String tipo) {
        this.tipo = tipo;
    }

    public OS_OrdemServico(int os) {
        this.os = os;
    }

    public OS_OrdemServico(String equipamento, String defeito, String servico, float valor, int id_cliente, int id_usuario_tecnico, String tipo, String situacao) {
        this.equipamento = equipamento;
        this.defeito = defeito;
        this.servico = servico;
        this.valor = String.format("%.2f", valor);
        this.id_cliente = id_cliente;
        this.id_usuario_tecnico = id_usuario_tecnico;
        this.tipo = tipo;
        this.situacao = situacao;

    }

    public OS_OrdemServico(int os, String data_os, String equipamento, String defeito, String servico, String valor, int id_cliente, int id_usuario_tecnico, String tipo, String situacao, String nomeCliente, String nomeTecnico) {
        this.os = os;
        this.data_os = data_os;
        this.equipamento = equipamento;
        this.defeito = defeito;
        this.servico = servico;
        this.valor = valor;
        this.id_cliente = id_cliente;
        this.id_usuario_tecnico = id_usuario_tecnico;
        this.tipo = tipo;
        this.situacao = situacao;
        this.nomeCliente = nomeCliente;
        this.nomeTecnico = nomeTecnico;
    }

    public OS_OrdemServico(int os, String equipamento, String defeito, String servico, float valor, int id_cliente, int id_usuario_tecnico, String tipo, String situacao) {
        this.os = os;
        this.equipamento = equipamento;
        this.defeito = defeito;
        this.servico = servico;
        this.valor = String.format("%.2f", valor);
        this.id_cliente = id_cliente;
        this.id_usuario_tecnico = id_usuario_tecnico;
        this.tipo = tipo;
        this.situacao = situacao;

    }

    public int getOs() {
        return os;
    }

    public void setOs(int os) {
        this.os = os;
    }

    public String getData_os() {
        return data_os;
    }

    public void setData_os(String data_os) {
        this.data_os = data_os;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_usuario_tecnico() {
        return id_usuario_tecnico;
    }

    public void setId_usuario_tecnico(int id_usuario_tecnico) {
        this.id_usuario_tecnico = id_usuario_tecnico;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeTecnico() {
        return nomeTecnico;
    }

    public void setNomeTecnico(String nomeTecnico) {
        this.nomeTecnico = nomeTecnico;
    }

}
