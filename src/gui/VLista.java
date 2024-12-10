/*
 * Created by JFormDesigner on Fri Apr 26 23:28:02 CEST 2024
 */

package gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import aplicacion.*;

/**
 * @author User
 */
public class VLista extends JFrame {
    String usuarioActual;
    fachadaAplicacion fa;
    public VLista(fachadaAplicacion fa, java.util.List<Elemento> canciones,String titulo,String artista,String usuarioActual) {
        this.fa=fa;
        this.usuarioActual=usuarioActual;
        initComponents();
        labelTitulo.setText(titulo);
        labelAutor.setText(artista);


        modeloTablaBuscarCanciones m;
        m = (modeloTablaBuscarCanciones) tabla.getModel();
        m.setFilas(canciones);
    }

    private void createUIComponents() {
        tabla = new JTable();
        tabla.setModel(new modeloTablaBuscarCanciones());
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    String nombreCancion = (String)tabla.getValueAt(tabla.getSelectedRow(),0);
                    Cancion cancion=fa.buscarCancionesEn(nombreCancion).get(0);
                    fa.muestraCancion(cancion,usuarioActual);
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        createUIComponents();

        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        labelAutor = new JLabel();
        labelTitulo = new JLabel();
        panel2 = new JPanel();
        label2 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(tabla);
            }

            //---- labelAutor ----
            labelAutor.setText("text");
            labelAutor.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));

            //---- labelTitulo ----
            labelTitulo.setText("text");
            labelTitulo.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 18));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelTitulo, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                            .addComponent(labelAutor, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                        .addGap(85, 85, 85))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(16, Short.MAX_VALUE)
                        .addComponent(labelTitulo, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelAutor, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
        }

        //======== panel2 ========
        {
            panel2.setBackground(new Color(0x00d856));

            //---- label2 ----
            label2.setIcon(new ImageIcon(getClass().getResource("/fotos/spotipify100.png")));

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(label2)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(label2)
                        .addGap(0, 0, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable tabla;
    private JLabel labelAutor;
    private JLabel labelTitulo;
    private JPanel panel2;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
