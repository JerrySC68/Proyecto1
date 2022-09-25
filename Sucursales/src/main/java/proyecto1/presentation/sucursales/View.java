package proyecto1.presentation.sucursales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {
    private JPanel panel;
    private JTextField nombreFld;
    private JButton buscarFld;
    private JButton agregarFld;
    private JTable sucursalesFld;
    private JLabel nombreLbl;
    private JLabel labelMap;
    private JButton borrarFld;
    private JButton reporteFld;

    public View() {
        // setMapa();
        buscarFld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.buscar(nombreFld.getText());
            }
        });
        agregarFld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                controller.preAgregar();
            }
        });
        sucursalesFld.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = sucursalesFld.getSelectedRow();
                    controller.editar(row);
                }
            }
        });
        borrarFld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = sucursalesFld.getSelectedRow();
                controller.borrar(row);
            }
        });

        reporteFld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.imprimir();
                    if (Desktop.isDesktopSupported()) {
                        File myFile = new File("sucursales.pdf");
                        Desktop.getDesktop().open(myFile);
                    }
                } catch (Exception ex) { }
            }
        });
    }
    void setMapa() {

        labelMap.setSize(100, 100);
        ImageIcon icon = new ImageIcon("C:\\Users\\50683\\Desktop\\I CICLO 2022\\II CICLO 2022\\Programacion III\\icons\\mapa.png");
        labelMap.setIcon(icon);

    }

    public JPanel getPanel() {
        return panel;
    }

    Controller controller;
    Model model;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setModel(Model model) {
        this.model = model;
        model.addObserver(this);
    }

    @Override
    public void update(Observable updatedModel, Object parametros) {
        int[] cols = {TableModel.CODIGO, TableModel.REFERENCIA, TableModel.DIRECCION, TableModel.ZONAJE};
        sucursalesFld.setModel(new TableModel(cols, model.getSucursales()));
        sucursalesFld.setRowHeight(30);
        this.panel.revalidate();
    }

}
