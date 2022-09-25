package proyecto1;

import proyecto1.presentation.empleados.Controller;
import proyecto1.presentation.empleados.Model;
import proyecto1.presentation.empleados.View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Application {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");}
        catch (Exception ex) {};

        //empleados
        Model empleadosModel= new Model();
        View empleadosView = new View();
        empleadosController = new Controller(empleadosView,empleadosModel);

        //empleado
        proyecto1.presentation.empleado.Model empleadoModel= new proyecto1.presentation.empleado.Model();
        proyecto1.presentation.empleado.View empleadoView = new proyecto1.presentation.empleado.View();
        empleadoController = new proyecto1.presentation.empleado.Controller(empleadoView,empleadoModel);

        //sucursales
        proyecto1.presentation.sucursales.Model sucursalesModel= new proyecto1.presentation.sucursales.Model();
        proyecto1.presentation.sucursales.View sucursalesView = new proyecto1.presentation.sucursales.View();
        sucursalesController = new proyecto1.presentation.sucursales.Controller(sucursalesView,sucursalesModel);

        //sucursal
        proyecto1.presentation.sucursal.Model sucursalModel= new proyecto1.presentation.sucursal.Model();
        proyecto1.presentation.sucursal.View sucursalView = new proyecto1.presentation.sucursal.View();
        sucursalController = new proyecto1.presentation.sucursal.Controller(sucursalView,sucursalModel);

        //maain
        proyecto1.presentation.main.Model mainModel= new proyecto1.presentation.main.Model();
        proyecto1.presentation.main.View mainView = new proyecto1.presentation.main.View();
        mainController = new proyecto1.presentation.main.Controller(mainView, mainModel);

        mainView.getPanel().add("Empleados",empleadosView.getPanel());
        mainView.getPanel().add("Sucursales",sucursalesView.getPanel());

        window = new JFrame();
        window.setSize(400,300);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("SISTEMA...");
        window.setVisible(true);
        mainController.show();
    }

    public static Controller empleadosController;
    public static proyecto1.presentation.sucursales.Controller sucursalesController;
    public static proyecto1.presentation.empleado.Controller empleadoController;
    public static proyecto1.presentation.sucursal.Controller sucursalController;

    public static proyecto1.presentation.main.Controller mainController;

    public static JFrame window;

    public static  final int  MODO_AGREGAR=0;
    public static final int MODO_EDITAR=1;

    public static Border BORDER_ERROR = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.RED);

}
