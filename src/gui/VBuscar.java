/*
 * Created by JFormDesigner on Tue Apr 23 19:03:35 CEST 2024
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;

import aplicacion.*;

/**
 * @author davra
 */
public class VBuscar extends JFrame {
    fachadaAplicacion fa;
    String usuarioActual;
    int op;
    public VBuscar(fachadaAplicacion fa,int op, String usuarioActual) {
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
    }

    private void bttBuscar(ActionEvent e) {
        // TODO add your code here
    }

    private void bttInicio(ActionEvent e) {
        fa.muestraPrincipal(this.op, usuarioActual);
        this.dispose();
    }

    private void bttLupa(ActionEvent e) {
        busqueda();
    }

    private void busqueda(){
        if(buscador.getText().equals("")){
            return;
        }
        String nombre=buscador.getText();
        List<Elemento> lista = new ArrayList<Elemento>();
        List<Artista> listaArtistas = fa.buscarArtistas(nombre);
        for(Artista a : listaArtistas){
            Elemento e0 = new Elemento(a.getNombreArtistico(),"Artista");
            lista.add(e0);
        }
        List<Podcast> listaPodcast = fa.buscarPodcastsPorNombre(nombre);
        for(Podcast a : listaPodcast){
            String artista = fa.obtenerArtistaDePodcast(a.getNombre());
            Elemento e2 = new Elemento(a.getNombre() /*+" - "+artista*/,"Podcast");
            lista.add(e2);
        }
        List<Playlist> listaPlaylist = fa.buscarPlaylists(nombre);
        for(Playlist a : listaPlaylist){
            if(!a.getNombrePlaylist().equals("Canciones que te gustan")){
                Elemento e3 = new Elemento(a.getNombrePlaylist()/* + " - "+a.getCreador()*/,"Playlist");
                lista.add(e3);
            }
        }
        List<Cancion> listaCanciones = fa.buscarCanciones(nombre);
        for(Cancion a : listaCanciones){
            String artista = fa.obtenerArtistaDeCancion(a.getNombre());
            Elemento e4 = new Elemento(a.getNombre()/*+ " - "+artista*/,"Cancion");
            lista.add(e4);
        }
        List<Album> listaAlbums = fa.buscarAlbum(nombre);
        for(Album a : listaAlbums){
            String artista = fa.obtenerArtistaDeAlbum(a.getNombre()).get(0);
            Elemento e5 = new Elemento(a.getNombre(),a.getTipo());
            //+ " - "+artista
            lista.add(e5);
        }

        modeloTablaBuscar m;
        m = (modeloTablaBuscar) tabla.getModel();
        m.setFilas(lista);
    }

    private void bttBiblioteca(ActionEvent e) {
        fa.muestraBiblioteca(this.op, usuarioActual);
        this.dispose();
    }



    private void createUIComponents() {
        tabla = new JTable();
        tabla.setModel(new modeloTablaBuscar());
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(tabla.getValueAt(tabla.getSelectedRow(),0).equals("Cancion")){
                    String nombreCancion = (String)tabla.getValueAt(tabla.getSelectedRow(),1);
                    Cancion cancion=fa.buscarCancionesEn(nombreCancion).get(0);
                    fa.muestraCancion(cancion,usuarioActual);
                }
                String type = (String)tabla.getValueAt(tabla.getSelectedRow(),0);

                if(type.equals("EP")||type.equals("Album")||type.equals("Single")){
                    String titulo = (String)tabla.getValueAt(tabla.getSelectedRow(),1);
                        String artista = "";
                        java.util.List<String> artistas = fa.obtenerArtistaDeAlbum((String)tabla.getValueAt(tabla.getSelectedRow(),1));
                        if(!artistas.isEmpty()){
                            artista+=artistas.get(0);
                        }
                        for(int i=0;i<artistas.size();i++){
                            if(i>0){
                                artista+=","+artistas;
                            }

                        }
                        List<Elemento> elems = new ArrayList<>();
                        for(String cancion: fa.obtenerCancionesPorAlbum(titulo,artistas.get(0))){
                            elems.add(new Elemento(cancion,artista,0));
                        }
                        fa.muestraLista(elems,titulo,artista,usuarioActual);
                }
                if(type.equals("Playlist")){
                    String titulo = (String)tabla.getValueAt(tabla.getSelectedRow(),1);
                    String autor = "Playlist creada por ";
                    autor += fa.buscarCreadorPlaylist((String)tabla.getValueAt(tabla.getSelectedRow(),1));
                    List<Elemento> elems = new ArrayList<>();
                    List<Cancion> canciones= fa.obtenerCancionesDePlaylist(titulo);
                    for(Cancion cancion: canciones){
                        elems.add(new Elemento(cancion.getNombre(),fa.obtenerArtistaDeCancion(cancion.getNombre()),0));
                    }
                    fa.muestraLista(elems,titulo,autor,usuarioActual);
                }
                if(type.equals("Podcast")){
                    //TODO df
                    String titulo = (String)tabla.getValueAt(tabla.getSelectedRow(),1);
                    Podcast podcast = fa.obtenerIDPodcast(titulo);
                    List<Capitulo> elems = new ArrayList<>();
                    elems = fa.buscarCapitulosPodcast(podcast.getIdPodcast());
                    fa.muestraPodcast(podcast,elems);
                }
            }
        });
    }

    private void panel1KeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void lupaKeyPressed(KeyEvent e) {
        // TODO add your code here
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
        buscador = new JTextField();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    panel1KeyPressed(e);
                }
            });

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

            //---- button1 ----
            button1.setIcon(new ImageIcon(getClass().getResource("/fotos/lupa20.png")));
            button1.setBorder(null);
            button1.setBackground(new Color(0xf2f2f2));
            button1.addActionListener(e -> bttLupa(e));
            button1.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    lupaKeyPressed(e);
                }
            });

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(tabla);
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(button1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(buscador, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(16, Short.MAX_VALUE))))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(buscador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button1))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(29, Short.MAX_VALUE))
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
    private JTextField buscador;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable tabla;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
