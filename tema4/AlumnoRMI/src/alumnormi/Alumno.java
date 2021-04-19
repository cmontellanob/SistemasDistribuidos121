/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnormi;

import java.io.Serializable;

/**
 *
 * @author Carlos
 */

public class Alumno  implements Serializable {
    private String nombres;
    private String apellidos;
    private int  edad;
    private Carrera  carera;

    public Alumno(String nombres, String apellidos, int edad, Carrera carera)  {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.carera = carera;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Carrera getCarera() {
        return carera;
    }

    public void setCarera(Carrera carera) {
        this.carera = carera;
    }
    
    
    
    
}
