package proyecto1.logic;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Empleado {
    String cedula;
    String nombre;
    String telefono;
    Double salario;
    Double salarioTotal;
    //Falta sucursal.
    // Falta zonaje, que se obtiene de sucursales.
    public Empleado() {this("","","",0.0,0.0);}

    public Empleado(String cedula, String nombre, String telefono, Double salario,Double salarioTotal) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.salario = salario;
        this.salarioTotal = salarioTotal;
    }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public Double getSalario() { return salario; }

    public void setSalario(Double salario) { this.salario = salario; }

    public Double getSalarioTotal() { return salarioTotal; }

    public void setSalarioTotal(Double salarioTotal) { this.salarioTotal = salarioTotal; }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
