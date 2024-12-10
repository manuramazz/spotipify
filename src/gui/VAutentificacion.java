/*
 * Created by JFormDesigner on Fri Apr 19 17:56:23 CEST 2024
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author davra
 */
public class VAutentificacion extends JDialog {

    private aplicacion.fachadaAplicacion fa;


    public VAutentificacion(aplicacion.fachadaAplicacion fa) {
        super();
        this.fa = fa;
        initComponents();
    }

    private void olvidarContrasena(ActionEvent e) {
        // abre un enlace para recuperar la contraseña
        try {
            Desktop.getDesktop().browse(new URI("https://support.spotify.com/mx/article/cannot-remember-login/"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void registrarse(ActionEvent e) {
        // abre un jframe para registrarse
        boolean b = false;
        VRegistrarsee vr = new VRegistrarsee(this, b , fa);
        vr.setVisible(true);
    }



    private void inicioSesion(ActionEvent e) {
        //comprobar si los campos de usuario y contraseña están vacíos
        if (usuario.getText().equals("") || contraseña.getText().equals("")) {
            fa.muestraExcepcion("Introduce un usuario y una contraseña");
            return;
        }
        int op=0;
        //comprueba si el usuario y la contraseña son correctos
        if (fa.comprobarAutentificacionOyente(usuario.getText(), contraseña.getText())!=null){
            op=1;
            VPrincipal vpa = new VPrincipal(fa,op,usuario.getText() );
            vpa.setVisible(true);
            this.dispose();
        }else if(fa.comprobarAutentificacionArtista(usuario.getText(), contraseña.getText())!=null){
            op=2;
            VPrincipal vpa = new VPrincipal(fa,op,usuario.getText());
            vpa.setVisible(true);
            this.dispose();
        }else if(fa.comprobarAutentificacionAdministrador(usuario.getText(), contraseña.getText())!=null){
            op=3;
            VPrincipal vpa = new VPrincipal(fa,op,usuario.getText());
            vpa.setVisible(true);
            this.dispose();
        }else{
            fa.muestraExcepcion("Usuario o contraseña incorrectos");
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
        inicioSesion = new JButton();
        olvidarContrasena = new JButton();
        registrar = new JButton();

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
                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addGap(41, 41, 41)
                            .addComponent(label2, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addGap(75, 75, 75))
                );
            }

            //---- label3 ----
            label3.setText("INICIAR SESI\u00d3N");
            label3.setForeground(new Color(0x00d856));

            //---- label4 ----
            label4.setText("Usuario:");

            //---- label5 ----
            label5.setText("Contrase\u00f1a:");

            //---- inicioSesion ----
            inicioSesion.setText("Entrar");
            inicioSesion.setBackground(new Color(0x00d856));
            inicioSesion.setForeground(Color.white);
            inicioSesion.addActionListener(e -> inicioSesion(e));

            //---- olvidarContrasena ----
            olvidarContrasena.setText("\u00bfHas olvidado tu contrase\u00f1a?");
            olvidarContrasena.setBackground(new Color(0xf2f2f2));
            olvidarContrasena.setBorderPainted(false);
            olvidarContrasena.setForeground(new Color(0x00d856));
            olvidarContrasena.addActionListener(e -> olvidarContrasena(e));

            //---- registrar ----
            registrar.setText("\u00bfA\u00fan no tienes cuenta? Reg\u00edstrate aqu\u00ed.");
            registrar.setBackground(new Color(0xf2f2f2));
            registrar.setBorderPainted(false);
            registrar.setForeground(new Color(0x00d856));
            registrar.addActionListener(e -> registrarse(e));

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
                                        .addGap(18, 18, 18)
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(label4)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(usuario, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(label5)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(contraseña, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(126, 126, 126)
                                        .addComponent(label3))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(registrar)
                                            .addComponent(olvidarContrasena))))
                                .addContainerGap(34, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                                .addComponent(inicioSesion)
                                .addGap(135, 135, 135))))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(label3)
                        .addGap(31, 31, 31)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(usuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5)
                            .addComponent(contraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inicioSesion)
                        .addGap(12, 12, 12)
                        .addComponent(olvidarContrasena)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(registrar)
                        .addContainerGap(13, Short.MAX_VALUE))
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
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private JButton inicioSesion;
    private JButton olvidarContrasena;
    private JButton registrar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
