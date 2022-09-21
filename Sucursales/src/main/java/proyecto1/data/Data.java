package proyecto1.data;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import proyecto1.logic.Empleado;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {
    private List<Empleado> empleados;

    public Data() {
        empleados = new ArrayList<>();

//        empleados.add(new Empleado("111", "Franklin Chang"));
//        empleados.add(new Empleado("222", "Sandra Cauffman"));
//        empleados.add(new Empleado("333", "Ivan Vargas"));
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
}
