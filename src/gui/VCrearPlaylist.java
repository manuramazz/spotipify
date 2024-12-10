/*
 * Created by JFormDesigner on Wed Apr 24 18:04:33 CEST 2024
 */

package gui;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

import aplicacion.*;

import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;

/**
 * @author davra
 */
public class VCrearPlaylist extends JDialog {
    fachadaAplicacion fa;
    String usuario;
    List<Elemento> listaElementos = new ArrayList<>();
    Frame owner;
    public VCrearPlaylist(Frame owner, fachadaAplicacion fa, String usuario) {
        super(owner);
        this.owner=owner;
        this.fa=fa;
        this.usuario=usuario;
        initComponents();
        //bttAnadir.setVisible(false);
    }

    private void bttLupa(ActionEvent e) {
        if(buscadorCancion.getText().equals("")){
            return;
        }
        String nombre=buscadorCancion.getText();
        java.util.List<Elemento> lista = new ArrayList<>();

        java.util.List<Cancion> listaCanciones = fa.buscarCanciones(nombre);
        for(Cancion a : listaCanciones){
            String artista = fa.obtenerArtistaDeCancion(a.getNombre());
            lista.add(new Elemento(a.getNombre(),artista,0));
        }

        modeloTablaBuscarCanciones m;
        m = (modeloTablaBuscarCanciones) listaBuscador.getModel();
        m.setFilas(lista);
    }

    private void lupaKeyPressed(KeyEvent e) {
        // TODO add your code here
    }
    private void createUIComponents() {
        listaBuscador = new JTable();
        listaPlaylist = new JTable();
        listaBuscador.setModel(new modeloTablaBuscarCanciones());
        listaPlaylist.setModel(new modeloTablaBuscarCanciones());
        /*listaBuscador.addMouseListener(new MouseAdapter(){
            private void listaBuscadorMouseClicked(MouseEvent e) {
                bttAnadir.setVisible(true);
            }
        });*/
    }






    private void bttAnadir(ActionEvent e) {
        int row = listaBuscador.getSelectedRow();
         if(row>=0) {
             Elemento elementoBuscado=new Elemento((String)listaBuscador.getValueAt(row,0),(String)listaBuscador.getValueAt(row,1),0);
             boolean encontrado = false;
            for (Elemento elemento : listaElementos) {
                if (elemento.getNombre().equals(elementoBuscado.getNombre())&&elemento.getArtista().equals(elementoBuscado.getArtista())) {
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                listaElementos.add(elementoBuscado);
            }
        }
        modeloTablaBuscarCanciones m;
        m = (modeloTablaBuscarCanciones) listaPlaylist.getModel();
        m.setFilas(listaElementos);
    }

    private void bttGuardar(ActionEvent e) {
        if(buscadorNombre.getText().equals("")){
            return;
        }
        fa.registrarPlaylist(buscadorNombre.getText(),usuario);
        int idPlaylist = fa.buscarIDPlaylists(buscadorNombre.getText(),usuario);
        for(Elemento elem : listaElementos){
            fa.insertarCancionEnPlaylist(elem.getNombre(),idPlaylist);
        }
        this.dispose();
        owner.dispose();
        fa.muestraBiblioteca(1,usuario);
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        createUIComponents();

        panel3 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        buscadorNombre = new JTextField();
        buscadorCancion = new JTextField();
        bttLupa = new JButton();
        scrollPane1 = new JScrollPane();
        scrollPane2 = new JScrollPane();
        bttGuardar = new JButton();
        label4 = new JLabel();
        bttAnadir = new JButton();
        panel4 = new JPanel();
        label1 = new JLabel();
        label5 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel3 ========
        {

            //---- label2 ----
            label2.setText("Nombre:");
            label2.setFont(new Font("Arial", Font.PLAIN, 12));

            //---- bttLupa ----
            bttLupa.setIcon(new ImageIcon(getClass().getResource("/fotos/lupa20.png")));
            bttLupa.setBorder(null);
            bttLupa.setBackground(new Color(0xf2f2f2));
            bttLupa.addActionListener(e -> bttLupa(e));
            bttLupa.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    lupaKeyPressed(e);
                }
            });

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(listaBuscador);
            }

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(listaPlaylist);
            }

            //---- bttGuardar ----
            bttGuardar.setText("GUARDAR");
            bttGuardar.setFont(new Font("Arial", Font.BOLD, 12));
            bttGuardar.setBackground(new Color(0x00d856));
            bttGuardar.setForeground(Color.white);
            bttGuardar.addActionListener(e -> bttGuardar(e));

            //---- label4 ----
            label4.setText("PLAYLIST");
            label4.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 14));
            label4.setForeground(new Color(0x00d856));

            //---- bttAnadir ----
            bttAnadir.setText("A\u00d1ADIR");
            bttAnadir.setFont(new Font("Arial", Font.BOLD, 12));
            bttAnadir.setForeground(Color.white);
            bttAnadir.setBackground(new Color(0x00d856));
            bttAnadir.addActionListener(e -> {
			button2(e);
			bttAnadir(e);
		});

            //======== panel4 ========
            {
                panel4.setBackground(new Color(0x00d856));

                //---- label1 ----
                label1.setText("CREAR PLAYLIST");
                label1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 30));
                label1.setForeground(Color.white);

                //---- label5 ----
                label5.setIcon(new ImageIcon(getClass().getResource("/fotos/spotipify100.png")));

                GroupLayout panel4Layout = new GroupLayout(panel4);
                panel4.setLayout(panel4Layout);
                panel4Layout.setHorizontalGroup(
                    panel4Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(label1)
                            .addContainerGap(170, Short.MAX_VALUE))
                );
                panel4Layout.setVerticalGroup(
                    panel4Layout.createParallelGroup()
                        .addComponent(label5, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                        .addGroup(panel4Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(label1)
                            .addContainerGap(27, Short.MAX_VALUE))
                );
            }

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGroup(panel3Layout.createParallelGroup()
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addGroup(panel3Layout.createSequentialGroup()
                                                .addComponent(bttLupa)
                                                .addGap(18, 18, 18)
                                                .addGroup(panel3Layout.createParallelGroup()
                                                    .addComponent(buscadorCancion, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(panel3Layout.createParallelGroup()
                                                    .addGroup(panel3Layout.createSequentialGroup()
                                                        .addGap(42, 42, 42)
                                                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(34, 34, 34))))
                                            .addGroup(panel3Layout.createSequentialGroup()
                                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buscadorNombre, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addComponent(bttAnadir)
                                        .addGap(170, 170, 170)
                                        .addComponent(bttGuardar)
                                        .addGap(111, 111, 111)))))
                        .addContainerGap())
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2)
                            .addComponent(buscadorNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel3Layout.createParallelGroup()
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(label3))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(buscadorCancion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bttLupa)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel3Layout.createParallelGroup()
                            .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(bttAnadir)
                            .addComponent(bttGuardar))
                        .addGap(11, 11, 11))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel3, GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel3;
    private JLabel label2;
    private JLabel label3;
    private JTextField buscadorNombre;
    private JTextField buscadorCancion;
    private JButton bttLupa;
    private JScrollPane scrollPane1;
    private JTable listaBuscador;
    private JScrollPane scrollPane2;
    private JTable listaPlaylist;
    private JButton bttGuardar;
    private JLabel label4;
    private JButton bttAnadir;
    private JPanel panel4;
    private JLabel label1;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
