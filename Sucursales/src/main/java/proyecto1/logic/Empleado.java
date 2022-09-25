package proyecto1.logic;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlIDREF;

@XmlAccessorType(XmlAccessType.FIELD)
public class Empleado {
    @XmlID
    String cedula;
    String nombre;
    String telefono;
    Double salario;
    Double salarioTotal;
    @XmlIDREF
    Sucursal sucursal1; //Objeto sucursal
    Double zonaje; //Zonaje de la sucursal al cual está asociado

    public Empleado() {
        this("","","",0.0,0.0,new Sucursal(),0.0);
    }

    public Empleado(String cedula, String nombre, String telefono, Double salario,Double salarioTotal,Sucursal sucursal1,Double zonaje) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.salario = salario;
        this.salarioTotal = salarioTotal;
        this.sucursal1 = sucursal1;
        this.zonaje = sucursal1.getZonaje();
    }
    public Double getZonaje() {
        return sucursal1.getZonaje();
    }
    public void setZonaje(Double zonaje) {
        this.zonaje = zonaje;
    }
    public Sucursal getSucursal() {
        return sucursal1;
    }
    public void setSucursal(Sucursal sucursal1) {
        this.sucursal1 = sucursal1;
    }
    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public Double getSalario() { return salario; }

    public void setSalario(Double salario) { this.salario = salario; }

    public Double getSalarioTotal() {
        return salarioTotal + (salarioTotal * getZonaje());
    }

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
