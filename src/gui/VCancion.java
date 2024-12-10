/*
 * Created by JFormDesigner on Thu Apr 25 18:13:38 CEST 2024
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import aplicacion.*;
import aplicacion.Artista;
/**
 * @author User
 */
public class VCancion extends JFrame {
    fachadaAplicacion fa;
    Cancion cancion;
    String usuarioActual;

    boolean like=false;
    //static
    public VCancion(fachadaAplicacion fa,Cancion cancion,String usuarioActual) {
        this.fa=fa;
        this.cancion=cancion;
        this.usuarioActual=usuarioActual;
        initComponents();
        labelCancion.setText(cancion.getNombre());
        String strArtistas="";
        java.util.List<Artista> artistas = fa.obtenerArtistasDeCancion(cancion.getNombre());
        if(!artistas.isEmpty()){
            strArtistas+=artistas.get(0).getNombreArtistico();
        }
        for(int i=0;i<artistas.size();i++){
            if(i>0){
                strArtistas+=","+artistas.get(i).getNombreArtistico();
            }
        }
        int idFavoritos = fa.buscarIDPlaylists("Canciones que te gustan",usuarioActual);
        /*if(){

        }*/
        labelLike2.setVisible(false);
        labelArtistas.setText(strArtistas);
        labelDuracion.setText(cancion.getDuracion());
        if(fa.buscarCancionEnPlaylists(cancion.getIDCancion(),fa.buscarIDPlaylists("Canciones que te gustan",usuarioActual))>=1){
            bttLike.setVisible(false);
            labelLike.setVisible(false);
            labelLike2.setVisible(true);
        }
        if(fa.comprobarValoracionCancion(cancion.getIDCancion(),usuarioActual)!=0){
            esValorado();
        }
    }

    private void bttValorar(ActionEvent e) {

    }
    public void esValorado(){
        bttValorar5.setVisible(false);
        bttValorar6.setVisible(false);
        bttValorar7.setVisible(false);
        bttValorar8.setVisible(false);
        bttValorar9.setVisible(false);
        label2.setText("Valoraste esta canción");
        label1.setText(String.valueOf(fa.mediaValoraciones(cancion.getIDCancion(),usuarioActual)));
    }

    private void bttValorar5(ActionEvent e) {
        fa.valorarCancion(usuarioActual,cancion.getIDCancion(),1);
        esValorado();
    }

    private void bttValorar6(ActionEvent e) {
        fa.valorarCancion(usuarioActual,cancion.getIDCancion(),2);
        esValorado();
    }

    private void bttValorar7(ActionEvent e) {
        fa.valorarCancion(usuarioActual,cancion.getIDCancion(),3);
        esValorado();
    }

    private void bttValorar8(ActionEvent e) {
        fa.valorarCancion(usuarioActual,cancion.getIDCancion(),4);
        esValorado();
    }

    private void bttValorar9(ActionEvent e) {
        fa.valorarCancion(usuarioActual,cancion.getIDCancion(),5);
        esValorado();
    }

    private void bttLike(ActionEvent e) {
        int idPlaylist = fa.buscarIDPlaylists("Canciones que te gustan",usuarioActual);
        fa.insertarCancionEnPlaylist(cancion.getNombre(),idPlaylist);
        bttLike.setVisible(false);
        labelLike.setText("Te gusta esta canción");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        panel2 = new JPanel();
        label6 = new JLabel();
        labelCancion = new JLabel();
        labelArtistas = new JLabel();
        button1 = new JButton();
        label9 = new JLabel();
        labelDuracion = new JLabel();
        bttLike = new JButton();
        labelLike = new JLabel();
        bttValorar5 = new JButton();
        bttValorar6 = new JButton();
        bttValorar7 = new JButton();
        bttValorar8 = new JButton();
        bttValorar9 = new JButton();
        label2 = new JLabel();
        labelLike2 = new JLabel();
        label7 = new JLabel();
        label1 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {

            //---- label3 ----
            label3.setIcon(new ImageIcon(getClass().getResource("/fotos/siguiente-pista.png")));

            //---- label4 ----
            label4.setIcon(new ImageIcon(getClass().getResource("/fotos/play.png")));

            //---- label5 ----
            label5.setIcon(new ImageIcon(getClass().getResource("/fotos/siguiente-pistaizq.png")));

            //======== panel2 ========
            {
                panel2.setBackground(new Color(0x00d856));

                //---- label6 ----
                label6.setIcon(new ImageIcon(getClass().getResource("/fotos/spotipify100.png")));

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(129, 129, 129)
                            .addComponent(label6)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                            .addContainerGap(10, Short.MAX_VALUE)
                            .addComponent(label6)
                            .addContainerGap())
                );
            }

            //---- labelCancion ----
            labelCancion.setText("text");
            labelCancion.setFont(new Font("Franklin Gothic Demi", labelCancion.getFont().getStyle() | Font.BOLD, 16));

            //---- labelArtistas ----
            labelArtistas.setText("text");
            labelArtistas.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));

            //---- button1 ----
            button1.setBackground(Color.black);

            //---- label9 ----
            label9.setText("00:00:00");
            label9.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 12));

            //---- labelDuracion ----
            labelDuracion.setText("text");
            labelDuracion.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 12));

            //---- bttLike ----
            bttLike.setIcon(new ImageIcon(getClass().getResource("/fotos/coraz (1).png")));
            bttLike.setForeground(new Color(0x00d856));
            bttLike.setBorderPainted(false);
            bttLike.addActionListener(e -> bttLike(e));

            //---- labelLike ----
            labelLike.setText("Dar me gusta");
            labelLike.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 12));

            //---- bttValorar5 ----
            bttValorar5.setBorderPainted(false);
            bttValorar5.setIcon(new ImageIcon(getClass().getResource("/fotos/estrella (1).png")));
            bttValorar5.setBorder(null);
            bttValorar5.setBackground(new Color(0xf2f2f2));
            bttValorar5.addActionListener(e -> {
			bttValorar(e);
			bttValorar5(e);
		});

            //---- bttValorar6 ----
            bttValorar6.setBorderPainted(false);
            bttValorar6.setIcon(new ImageIcon(getClass().getResource("/fotos/estrella (1).png")));
            bttValorar6.setBackground(new Color(0xf2f2f2));
            bttValorar6.setBorder(null);
            bttValorar6.addActionListener(e -> {
			bttValorar(e);
			bttValorar6(e);
		});

            //---- bttValorar7 ----
            bttValorar7.setBorderPainted(false);
            bttValorar7.setIcon(new ImageIcon(getClass().getResource("/fotos/estrella (1).png")));
            bttValorar7.setBorder(null);
            bttValorar7.setBackground(new Color(0xf2f2f2));
            bttValorar7.addActionListener(e -> {
			bttValorar(e);
			bttValorar7(e);
		});

            //---- bttValorar8 ----
            bttValorar8.setBorderPainted(false);
            bttValorar8.setIcon(new ImageIcon(getClass().getResource("/fotos/estrella (1).png")));
            bttValorar8.setBorder(null);
            bttValorar8.setBackground(new Color(0xf2f2f2));
            bttValorar8.addActionListener(e -> {
			bttValorar(e);
			bttValorar8(e);
		});

            //---- bttValorar9 ----
            bttValorar9.setBorderPainted(false);
            bttValorar9.setIcon(new ImageIcon(getClass().getResource("/fotos/estrella (1).png")));
            bttValorar9.setBorder(null);
            bttValorar9.setBackground(new Color(0xf2f2f2));
            bttValorar9.addActionListener(e -> {
			bttValorar(e);
			bttValorar9(e);
		});

            //---- label2 ----
            label2.setText("Valorar canci\u00f3n");
            label2.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 12));

            //---- labelLike2 ----
            labelLike2.setText("Te gusta esta canci\u00f3n");
            labelLike2.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 12));

            //---- label7 ----
            label7.setText("Media valoraciones:");
            label7.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 12));

            //---- label1 ----
            label1.setText("0.0");
            label1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 12));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(label9)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)
                                        .addComponent(labelDuracion, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addGroup(panel1Layout.createParallelGroup()
                                                    .addComponent(labelCancion, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                                    .addComponent(labelArtistas, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                                                .addGap(38, 38, 38)
                                                .addGroup(panel1Layout.createParallelGroup()
                                                    .addComponent(labelLike)
                                                    .addGroup(panel1Layout.createSequentialGroup()
                                                        .addGap(11, 11, 11)
                                                        .addComponent(bttLike)))
                                                .addGap(34, 34, 34))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(label3)
                                                .addGap(29, 29, 29)
                                                .addComponent(label4)
                                                .addGap(18, 18, 18)
                                                .addComponent(label5)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                                .addComponent(labelLike2))))))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label7)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(label2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bttValorar5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bttValorar6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bttValorar7)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bttValorar8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bttValorar9)))
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(bttLike, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCancion, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(labelLike)
                            .addComponent(labelArtistas, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(label3)
                                            .addComponent(label4)
                                            .addComponent(label5))
                                        .addGap(18, 18, 18)
                                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(label9)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelLike2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelDuracion)))
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(bttValorar9)
                                    .addComponent(bttValorar8)
                                    .addComponent(bttValorar7)
                                    .addComponent(bttValorar6)
                                    .addComponent(bttValorar5)))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label2)
                                    .addComponent(label7)
                                    .addComponent(label1))
                                .addContainerGap())))
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
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JPanel panel2;
    private JLabel label6;
    private JLabel labelCancion;
    private JLabel labelArtistas;
    private JButton button1;
    private JLabel label9;
    private JLabel labelDuracion;
    private JButton bttLike;
    private JLabel labelLike;
    private JButton bttValorar5;
    private JButton bttValorar6;
    private JButton bttValorar7;
    private JButton bttValorar8;
    private JButton bttValorar9;
    private JLabel label2;
    private JLabel labelLike2;
    private JLabel label7;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
