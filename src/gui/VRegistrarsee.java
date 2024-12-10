/*
 * Created by JFormDesigner on Sun Apr 21 12:29:11 CEST 2024
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author davra
 */
public class VRegistrarsee extends JDialog {

    private aplicacion.fachadaAplicacion fa;

    public VRegistrarsee(Dialog owner, boolean modal, aplicacion.fachadaAplicacion fa) {
        super(owner, modal);
        this.fa = fa;
        initComponents();
         bttError.setVisible(false);
    }

    public void registrar(java.awt.event.ActionEvent evt) {
        String usuariostr = usuario.getText();
        String correostr = correo.getText();
        String contraseñastr = contraseña.getText();
        String textField1str = textField1.getText();
        if (!usuariostr.isEmpty() && !correostr.isEmpty() && !contraseñastr.isEmpty() && !textField1str.isEmpty()) {
            // Todos los campos tienen contenido
            if(fa.buscarArtistasAutentificacion(usuariostr).isEmpty() && fa.buscarAdminAutentificacion(usuariostr).isEmpty()){
                fa.registrarOyente(usuariostr, correostr, contraseñastr, textField1str);
                fa.registrarPlaylist("Canciones que te gustan", usuario.getText());
                this.dispose();
            }else {
                fa.muestraExcepcion("Nombre de usuario no válido");
                return;
            }
        }else {
            fa.muestraExcepcion("Nombre de usuario no válido");
        }
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        panel2 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        usuario = new JTextField();
        contraseña = new JTextField();
        registrar = new JButton();
        correo = new JTextField();
        label6 = new JLabel();
        label7 = new JLabel();
        textField1 = new JTextField();
        bttError = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {

            //======== panel2 ========
            {
                panel2.setBackground(new Color(0x00d856));

                //---- label1 ----
                label1.setIcon(new ImageIcon(getClass().getResource("/fotos/spotipify200.png")));

                //---- label2 ----
                label2.setForeground(Color.white);
                label2.setToolTipText("ESCUCHA M\u00daSICA SIN L\u00cdMITES");
                label2.setText("ESCUCHA M\u00daSICA SIN L\u00cdMITES");

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(label2, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                            .addContainerGap())
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(41, 41, 41)
                            .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(75, 75, 75))
                );
            }

            //---- label3 ----
            label3.setText("REGISTRARSE");
            label3.setForeground(new Color(0x00d856));

            //---- label4 ----
            label4.setText("Usuario:");

            //---- label5 ----
            label5.setText("Contrase\u00f1a:");

            //---- registrar ----
            registrar.setText("Confirmar");
            registrar.setBackground(new Color(0x00d856));
            registrar.setForeground(Color.white);
            registrar.addActionListener(e -> registrar(e));

            //---- label6 ----
            label6.setText("E-mail:");

            //---- label7 ----
            label7.setText("Fecha de nacimimento:");

            //---- textField1 ----
            textField1.setText("aaaa-mm-dd");
            textField1.setForeground(Color.gray);

            //---- bttError ----
            bttError.setText("Nombre de usuario ya registrado");
            bttError.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 12));
            bttError.setForeground(Color.red);

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(134, 134, 134)
                                        .addComponent(label3))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(label7)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(label4)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(usuario, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(label6)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(correo, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(label5)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(contraseña, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(127, 127, 127)
                                        .addComponent(registrar)))
                                .addContainerGap(29, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                                .addComponent(bttError)
                                .addGap(88, 88, 88))))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(label3)
                        .addGap(26, 26, 26)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(usuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(correo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(contraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label7)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(registrar)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bttError, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private JPanel panel2;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField usuario;
    private JTextField contraseña;
    private JButton registrar;
    private JTextField correo;
    private JLabel label6;
    private JLabel label7;
    private JTextField textField1;
    private JLabel bttError;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
