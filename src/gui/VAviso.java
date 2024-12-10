/*
 * Created by JFormDesigner on Tue Apr 23 13:05:55 CEST 2024
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author davra
 */
public class VAviso extends JDialog {
    public VAviso(String mensaje) {
        super();
        initComponents();
        this.mensaje.setText(mensaje);
    }

    private void cerrar(ActionEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        buttonCerrar = new JButton();
        scrollPane1 = new JScrollPane();
        mensaje = new JTextArea();
        label1 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(Color.red);

            //---- buttonCerrar ----
            buttonCerrar.setText("Cerrar");
            buttonCerrar.setFont(new Font("Arial", Font.PLAIN, 12));
            buttonCerrar.addActionListener(e -> cerrar(e));

            //======== scrollPane1 ========
            {

                //---- mensaje ----
                mensaje.setFont(new Font("Arial", Font.PLAIN, 12));
                mensaje.setForeground(Color.red);
                mensaje.setBackground(Color.white);
                mensaje.setBorder(null);
                mensaje.setDisabledTextColor(Color.black);
                mensaje.setCaretColor(Color.white);
                mensaje.setLineWrap(true);
                mensaje.setAutoscrolls(false);
                scrollPane1.setViewportView(mensaje);
            }

            //---- label1 ----
            label1.setText("ERROR");
            label1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 16));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(scrollPane1)
                                .addContainerGap())
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(buttonCerrar)
                                .addGap(72, 72, 72))))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap(16, Short.MAX_VALUE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonCerrar)
                        .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JButton buttonCerrar;
    private JScrollPane scrollPane1;
    private JTextArea mensaje;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
