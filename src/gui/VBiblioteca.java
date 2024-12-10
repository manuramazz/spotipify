/*
 * Created by JFormDesigner on Tue Apr 23 20:11:00 CEST 2024
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import aplicacion.*;

import net.miginfocom.swing.*;

/**
 * @author User
 */
public class VBiblioteca extends JFrame {
    fachadaAplicacion fa;
    String usuarioActual;
    List<Elemento> playlistsUsuario = new ArrayList<>();
    int op;

    public VBiblioteca(fachadaAplicacion fa,int op, String usuarioActual) {
        this.op=op;
        this.fa = fa;
        this.usuarioActual = usuarioActual;
        initComponents();
        switch(op){
            case 1:
                bttGestion.setVisible(false);
                bttPublicar.setVisible(false);
                break;
            case 2:
                bttGestion.setVisible(false);

                break;
            case 3:
                bttPublicar.setVisible(false);
                bttInicio.setVisible(false);
                bttBiblioteca.setVisible(false);
                bttBuscar.setVisible(false);
                break;
        }

        playlistsUsuario = fa.buscarPlaylistsUsuario(usuarioActual);

        modeloTablaPlaylistUsuario modelo;
        modelo = (modeloTablaPlaylistUsuario) table1.getModel();
        modelo.setFilas(playlistsUsuario);

    }

    private void bttInicio(ActionEvent e) {
        fa.muestraPrincipal(op, usuarioActual);
        this.dispose();
    }

    private void bttBuscar(ActionEvent e) {
        fa.muestraBuscar(op,usuarioActual);
        this.dispose();
    }

    private void bttLupa(ActionEvent e) {
        // TODO add your code here
    }

    private void bttBiblioteca(ActionEvent e) {
        // TODO add your code here
    }

    private void createUIComponents() {
        table1 = new JTable();
        table1.setModel(new modeloTablaPlaylistUsuario());
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                    String titulo = (String)table1.getValueAt(table1.getSelectedRow(),0);
                    String autor = "Playlist creada por ";
                    autor += fa.buscarCreadorPlaylist((String)table1.getValueAt(table1.getSelectedRow(),0));
                    List<Elemento> elems = new ArrayList<>();
                    List<Cancion> canciones= fa.obtenerCancionesDePlaylist(titulo);
                    for(Cancion cancion: canciones){
                        elems.add(new Elemento(cancion.getNombre(),fa.obtenerArtistaDeCancion(cancion.getNombre()),0));
                    }
                    fa.muestraLista(elems,titulo,autor,usuarioActual);

            }
        });
    }

    private void bttCrearPlaylist(ActionEvent e) {
        fa.muestraCrearPlaylist(this,fa,op,usuarioActual);
    }

    private void bttPublicar(ActionEvent e) {
        fa.muestraPublicar(usuarioActual);
        this.dispose();
    }

    private void bttAjustes(ActionEvent e) {
        fa.muestraAjustes(this);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        createUIComponents();

        panel1 = new JPanel();
        panel2 = new JPanel();
        label1 = new JLabel();
        bttInicio = new JButton();
        bttBuscar = new JButton();
        bttBiblioteca = new JButton();
        bttPerfil = new JButton();
        bttAjustes = new JButton();
        bttPublicar = new JButton();
        bttGestion = new JButton();
        scrollPane1 = new JScrollPane();
        label2 = new JLabel();
        bttCrearPlaylist = new JButton();
        label3 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {

            //======== panel2 ========
            {
                panel2.setBackground(new Color(0x00d856));

                //---- label1 ----
                label1.setIcon(new ImageIcon(getClass().getResource("/fotos/spotipify200.png")));

                //---- bttInicio ----
                bttInicio.setText("INICIO");
                bttInicio.setBackground(new Color(0x00d856));
                bttInicio.setForeground(Color.white);
                bttInicio.setBorder(null);
                bttInicio.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 18));
                bttInicio.addActionListener(e -> bttInicio(e));

                //---- bttBuscar ----
                bttBuscar.setText("BUSCAR");
                bttBuscar.setBackground(new Color(0x00d856));
                bttBuscar.setForeground(Color.white);
                bttBuscar.setBorder(null);
                bttBuscar.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 18));
                bttBuscar.addActionListener(e -> bttBuscar(e));

                //---- bttBiblioteca ----
                bttBiblioteca.setText("BIBLIOTECA");
                bttBiblioteca.setBackground(new Color(0x00d856));
                bttBiblioteca.setForeground(Color.white);
                bttBiblioteca.setBorder(null);
                bttBiblioteca.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 18));
                bttBiblioteca.addActionListener(e -> bttBiblioteca(e));

                //---- bttPerfil ----
                bttPerfil.setText("PERFIL");
                bttPerfil.setBackground(new Color(0x00d856));
                bttPerfil.setForeground(Color.white);
                bttPerfil.setBorder(null);
                bttPerfil.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 18));

                //---- bttAjustes ----
                bttAjustes.setText("AJUSTES");
                bttAjustes.setBackground(new Color(0x00d856));
                bttAjustes.setForeground(Color.white);
                bttAjustes.setBorder(null);
                bttAjustes.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 18));
                bttAjustes.addActionListener(e -> bttAjustes(e));

                //---- bttPublicar ----
                bttPublicar.setText("PUBLICAR");
                bttPublicar.setBackground(new Color(0x00d856));
                bttPublicar.setForeground(Color.white);
                bttPublicar.setBorder(null);
                bttPublicar.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 18));
                bttPublicar.addActionListener(e -> bttPublicar(e));

                //---- bttGestion ----
                bttGestion.setText("GESTI\u00d3N");
                bttGestion.setBackground(new Color(0x00d856));
                bttGestion.setForeground(Color.white);
                bttGestion.setBorder(null);
                bttGestion.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 18));

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addComponent(bttInicio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(bttBuscar, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
                                .addComponent(bttBiblioteca, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
                                .addComponent(bttPublicar, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
                                .addComponent(bttAjustes, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
                                .addComponent(bttPerfil, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
                                .addComponent(bttGestion, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                            .addComponent(bttInicio)
                            .addGap(18, 18, 18)
                            .addComponent(bttBuscar)
                            .addGap(18, 18, 18)
                            .addComponent(bttBiblioteca)
                            .addGap(18, 18, 18)
                            .addComponent(bttPublicar)
                            .addGap(18, 18, 18)
                            .addComponent(bttGestion)
                            .addGap(67, 67, 67)
                            .addComponent(bttPerfil)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bttAjustes)
                            .addGap(28, 28, 28))
                );
            }

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(table1);
            }

            //---- label2 ----
            label2.setText("MI BIBLIOTECA");
            label2.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 24));
            label2.setBackground(new Color(0x00d856));
            label2.setForeground(new Color(0x00d856));

            //---- bttCrearPlaylist ----
            bttCrearPlaylist.setIcon(new ImageIcon(getClass().getResource("/fotos/descarga (1).png")));
            bttCrearPlaylist.setForeground(new Color(0x00d856));
            bttCrearPlaylist.setFont(new Font("Arial", Font.BOLD, 14));
            bttCrearPlaylist.setBorder(null);
            bttCrearPlaylist.setBackground(new Color(0xf2f2f2));
            bttCrearPlaylist.addActionListener(e -> bttCrearPlaylist(e));

            //---- label3 ----
            label3.setText("Crear playlist");
            label3.setForeground(new Color(0x00d856));
            label3.setFont(new Font("Arial", Font.BOLD, 14));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(bttCrearPlaylist)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label3)
                                .addContainerGap())))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(bttCrearPlaylist, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)))
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(49, Short.MAX_VALUE))
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
    private JButton bttInicio;
    private JButton bttBuscar;
    private JButton bttBiblioteca;
    private JButton bttPerfil;
    private JButton bttAjustes;
    private JButton bttPublicar;
    private JButton bttGestion;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label2;
    private JButton bttCrearPlaylist;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
