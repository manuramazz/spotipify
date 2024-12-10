/*
 * Created by JFormDesigner on Tue Apr 23 16:35:33 CEST 2024
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;

import aplicacion.Cancion;
import aplicacion.Playlist;
import aplicacion.Elemento;
import aplicacion.fachadaAplicacion;

/**
 * @author davra
 */
public class VPrincipal extends JFrame {
    private fachadaAplicacion fa;
    private String usuarioActual;
    List<String> nombresPlaylists = new ArrayList<>();
    int op;
    public VPrincipal(fachadaAplicacion fa, int op, String usuarioActual) {
        this.fa = fa;
        this.op=op;
        this.usuarioActual=usuarioActual;
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
                list1.setVisible(false);
                label2.setVisible(false);
                break;
        }

        List <Elemento> listaP = new ArrayList<>();
        listaP= fa.buscarPlaylistsUsuario("spotify");
        for(Elemento playlistIndice: listaP){
            nombresPlaylists.add(playlistIndice.getNombre());
        }

        modeloListaBiblioteca modelo;
        modelo = (modeloListaBiblioteca) list1.getModel();
        modelo.agregarLista(nombresPlaylists);
    }
    private void bttBuscar(ActionEvent e) {
        fa.muestraBuscar(op, usuarioActual);
        this.dispose();
    }

    private void bttBiblioteca(ActionEvent e) {
        fa.muestraBiblioteca(op, usuarioActual);
        this.dispose();
    }

    private void createUIComponents() {
        list1 = new JList<>();
        list1.setModel(new modeloListaBiblioteca());
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {


                    String titulo = (String)list1.getSelectedValue();
                    String autor = "Playlist creada por ";
                    autor += fa.buscarCreadorPlaylist(titulo);
                    List<Elemento> elems = new ArrayList<>();
                    List<Cancion> canciones= fa.obtenerCancionesDePlaylist(titulo);
                    for(Cancion cancion: canciones){
                        elems.add(new Elemento(cancion.getNombre(),fa.obtenerArtistaDeCancion(cancion.getNombre()),0));
                    }
                    fa.muestraLista(elems,titulo,autor,usuarioActual);

            }
        });
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
                scrollPane1.setViewportView(list1);
            }

            //---- label2 ----
            label2.setText("LO QUE NO TE PUEDES PERDER:");
            label2.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 18));
            label2.setForeground(new Color(0x00d856));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 36, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private JList list1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
