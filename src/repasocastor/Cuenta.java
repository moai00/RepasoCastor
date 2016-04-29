/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasocastor;

/**
 *
 * @author usu21
 */
public class Cuenta {

    private int id;
    private String titular; 
    private Double saldo;
    private Double comision;   
    private boolean tipo;

    @Override
    public String toString() {
        
        String tipus;
        if (tipo){
            tipus= "personal";
            comision=0.05;
        }else{
            tipus = "empresa";
            comision=0.02;
        }
            
        return "id: " + id + ", titular: " + titular + ", saldo: " + saldo + ", comision: " + comision + ", tipo: " + tipus;
    }
    
    

    public Cuenta(int id, String titular, Double saldo, Double comision, boolean tipo) {
        this.id = id;
        this.titular = titular;
        this.saldo = saldo;
        this.comision = comision;
        this.tipo = tipo;
    }

    
    
    

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }
    

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }


    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
