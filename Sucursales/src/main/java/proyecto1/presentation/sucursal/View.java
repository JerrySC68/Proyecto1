package proyecto1.presentation.sucursal;

import proyecto1.Application;
import proyecto1.logic.Sucursal;

import javax.swing.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {
    private JPanel panel;
    private JTextField codigoFld;
    private JTextField referenciaFld;
    private JButton guardarFld;
    private JButton cancelarFld;
    private JLabel cedulaLbl;
    private JLabel nombreLbl;
    private JTextField direcionFld;
    private JTextField zonajeFld;

    public View() {
        guardarFld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validate()) {
                    Sucursal n = take();
                    try {
                        controller.guardar(n);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(panel, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        cancelarFld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.hide();
            }
        });
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
        Sucursal current = model.getCurrent();
        this.codigoFld.setEnabled(model.getModo() == Application.MODO_AGREGAR);
        this.codigoFld.setText(current.getCodigo());
        referenciaFld.setText(current.getRefencia());
        direcionFld.setText(current.getDireccion());
        zonajeFld.setText(String.valueOf(current.getZonaje()));
        this.panel.validate();
    }

    public Sucursal take() {
        Sucursal e = new Sucursal();
        e.setCodigo(codigoFld.getText());
        e.setRefencia(referenciaFld.getText());
        e.setDireccion(direcionFld.getText());
        e.setZonaje(Double.parseDouble(zonajeFld.getText()));
        return e;
    }

    private boolean validate() {
        boolean valid = true;
        if (codigoFld.getText().isEmpty()) {
            valid = false;
            cedulaLbl.setBorder(Application.BORDER_ERROR);
            cedulaLbl.setToolTipText("Id requerido");
        } else {
            cedulaLbl.setBorder(null);
            cedulaLbl.setToolTipText(null);
        }

        if (referenciaFld.getText().length() == 0) {
            valid = false;
            nombreLbl.setBorder(Application.BORDER_ERROR);
            nombreLbl.setToolTipText("Nombre requerido");
        } else {
            nombreLbl.setBorder(null);
            nombreLbl.setToolTipText(null);
        }
        return valid;
    }
}
