package model;

public class Conta {

    private Integer agencia;
    private Integer numero;
    private String nomeDoCliente;
    private Double saldo;

    public Conta(Integer agencia, Integer numero, String nomeDoCliente) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = 0.0;
        this.nomeDoCliente = nomeDoCliente;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

}
