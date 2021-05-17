/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerparcial;

import java.io.Serializable;

/**
 *
 * @author Carlos
 */
class Cuenta implements Serializable {
    Banco banco;
    String nrocuenta;
    String ci;
    String nombres;
    String apellidos;
    Double Saldo;

    public Cuenta(Banco banco, String nrocuenta, String ci, String nombres, String apellidos, Double Saldo) {
        this.banco = banco;
        this.nrocuenta = nrocuenta;
        this.ci = ci;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.Saldo = Saldo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public String getNrocuenta() {
        return nrocuenta;
    }

    public void setNrocuenta(String nrocuenta) {
        this.nrocuenta = nrocuenta;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Double getSaldo() {
        return Saldo;
    }

    public void setSaldo(Double Saldo) {
        this.Saldo = Saldo;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "banco=" + banco + ", nrocuenta=" + nrocuenta + ", ci=" + ci + ", nombres=" + nombres + ", apellidos=" + apellidos + ", Saldo=" + Saldo + '}';
    }
            
}
