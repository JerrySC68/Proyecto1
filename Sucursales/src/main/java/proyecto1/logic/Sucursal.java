package proyecto1.logic;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlID;

import java.awt.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Sucursal {
    @XmlID
    String codigo;
    String refencia;
    String direccion;
    double zonaje;
    Point xy;


    public Sucursal() {
    }

    public Sucursal(String codigo, String refencia, String direccion, double zonaje, Point xy) {
        this.codigo = codigo;
        this.refencia = refencia;
        this.direccion = direccion;
        this.zonaje = zonaje;
        this.xy = xy;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRefencia() {
        return refencia;
    }

    public void setRefencia(String refencia) {
        this.refencia = refencia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getZonaje() {
        return zonaje;
    }

    public void setZonaje(double zonaje) {
        this.zonaje = zonaje;
    }

    public Point getXy() {
        return xy;
    }

    public void setXy(Point xy) {
        this.xy = xy;
    }
}
