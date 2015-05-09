/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface_Sub;

import DB.ComandosSQL;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author 30-90042
 */
public class Add_Universitario extends javax.swing.JFrame {

    ComandosSQL sql = new ComandosSQL();

    ResultSet rs;
    String foto = null;
    private int id;
    private String dia;
    private String nome;
    private String nasc;
    private String rua;
    private int numero;
    private String complemento;
    private String bairro;
    private int idcidade;
    private int idfaculdade;
    private int idescola;
    private String estado;
    private String pais;
    private String fone;

    private String formatData(String data) throws SQLException {
        //18/19/2000
        System.out.println("O dia é: " + data);
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6, 10);
        String dt = ano + "-" + mes + "-" + dia;
        System.out.println("Dia:" + dia + "/Mes:" + mes + "/ano:" + ano);
        System.out.println(dt);
        return dt;
    }

    public void listar() throws SQLException {
        rs = sql.listar_estados();
        while (rs.next()) {
            combo_estado.addItem(rs.getString("NOME"));
        }

        rs = sql.listar_cidades();
        while (rs.next()) {
            combo_cidades.addItem(rs.getString("NOME"));
        }

        rs = sql.listar_faculdades();
        while (rs.next()) {
            combo_faculdade.addItem(rs.getString("NOME"));
        }
        
        rs = sql.listar_escolas();
        while (rs.next()) {
            combo_escola.addItem(rs.getString("NOME"));
        }
        
    }

    /**
     * Creates new form Add_Universitario
     */
    public Add_Universitario() throws ParseException, ClassNotFoundException, SQLException {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        MaskFormatter maskData = new MaskFormatter("##/##/####");
        MaskFormatter maskFone = new MaskFormatter("(##)####-####");

        maskData.install(text_nascimento);
        maskFone.install(text_telefone);

        
        int num = Integer.parseInt(sql.getMaxUniversitario());
        num++;
        String numero = String.valueOf(num);

        text_id.setText(numero);
        text_id.setEditable(false);
        
        listar();

    }

    public Add_Universitario(String id) throws SQLException, ClassNotFoundException, ParseException {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        MaskFormatter maskData = new MaskFormatter("##/##/####");
        MaskFormatter maskFone = new MaskFormatter("(##)####-####");

        maskData.install(text_nascimento);
        maskFone.install(text_telefone);
        
        listar();
        
        ResultSet rs;
        rs = sql.search_id_uni(id);

        while (rs.next()) {
            text_id.setText(rs.getString(1));
            text_nome.setText(rs.getString(2));
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            //System.out.println(dateFormat.format(rs.getDate(3)));
            text_nascimento.setText(dateFormat.format(rs.getDate(3)));
            text_telefone.setText(rs.getString(4));
            combo_dia.setSelectedItem(rs.getString(5));
            text_rua.setText(rs.getString(6));
            text_numero.setText(rs.getString(7));
            text_complemento.setText(rs.getString(8));
            text_bairro.setText(rs.getString(9));
            String cidade = sql.busca_nomecidade(rs.getInt(10));
            combo_cidades.setSelectedItem(cidade);
            combo_estado.setSelectedItem(rs.getString(11));
            text_pais.setText(rs.getString(12));
            String faculdade = sql.busca_nomecidade(rs.getInt(15));
            combo_faculdade.setSelectedItem(faculdade);
            combo_curso.setSelectedItem(rs.getString(16));
            String escola = sql.busca_nomeescola(rs.getInt(17));
            combo_escola.setSelectedItem(escola);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        text_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        text_nome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        label_dia = new javax.swing.JLabel();
        combo_dia = new javax.swing.JComboBox();
        botao_Confirmar = new javax.swing.JButton();
        botao_Cancelar = new javax.swing.JButton();
        text_nascimento = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        text_telefone = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        text_rua = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        text_numero = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        text_complemento = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        text_bairro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        text_pais = new javax.swing.JTextField();
        label_foto = new javax.swing.JLabel();
        botao_limpar = new javax.swing.JButton();
        combo_estado = new javax.swing.JComboBox();
        combo_cidades = new javax.swing.JComboBox();
        botao_escolherfoto = new javax.swing.JButton();
        label_faculdade = new javax.swing.JLabel();
        combo_faculdade = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        combo_curso = new javax.swing.JComboBox();
        combo_escola = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID");

        jLabel2.setText("Nome");

        jLabel4.setText("Nascimento");

        label_dia.setText("Dia");

        combo_dia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sábado", "Domingo" }));

        botao_Confirmar.setText("Confirmar");
        botao_Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_ConfirmarActionPerformed(evt);
            }
        });

        botao_Cancelar.setText("Cancelar");
        botao_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_CancelarActionPerformed(evt);
            }
        });

        text_nascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_nascimentoActionPerformed(evt);
            }
        });

        jLabel3.setText("Telefone");

        jLabel6.setText("Endereço");

        jLabel7.setText("Número");

        jLabel8.setText("Complemento");

        jLabel9.setText("Bairro");

        jLabel10.setText("Cidade");

        jLabel11.setText("Estado");

        jLabel12.setText("País");

        text_pais.setEditable(false);
        text_pais.setText("BR");

        label_foto.setText("foto");

        botao_limpar.setText("Limpar");

        combo_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_estadoActionPerformed(evt);
            }
        });

        botao_escolherfoto.setText("Escolher foto..");
        botao_escolherfoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_escolherfotoActionPerformed(evt);
            }
        });

        label_faculdade.setText("Faculdade");

        jLabel5.setText("Curso");

        jLabel13.setText("Escola");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(text_complemento, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(text_bairro))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(combo_cidades, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(combo_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(text_id, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_dia)
                                    .addComponent(combo_dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(text_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(text_nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(text_rua, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(text_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(131, 131, 131)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(86, 86, 86)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(text_pais, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(botao_escolherfoto)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_foto, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo_curso, 0, 177, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(label_faculdade))
                            .addComponent(combo_faculdade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_escola, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(text_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(botao_Confirmar)
                .addGap(18, 18, 18)
                .addComponent(botao_limpar)
                .addGap(18, 18, 18)
                .addComponent(botao_Cancelar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(label_dia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(text_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(text_nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)))
                    .addComponent(label_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_complemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_escolherfoto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_pais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_cidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_escola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_faculdade)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_faculdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_Confirmar)
                    .addComponent(botao_limpar)
                    .addComponent(botao_Cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_ConfirmarActionPerformed
        
        id          = Integer.parseInt(text_id.getText());
        rua         = text_rua.getText();
        numero      = Integer.parseInt(text_numero.getText());
        complemento = text_complemento.getText();
        bairro      = text_bairro.getText();
        estado      = (String) combo_estado.getSelectedItem();
        pais        = text_pais.getText();
        fone        = text_telefone.getText();
        dia         = (String) combo_dia.getSelectedItem();
        nome        = text_nome.getText();
        
        String city = (String) combo_cidades.getSelectedItem();
        try {
            idcidade = sql.busca_idcidade(city);
        } catch (SQLException ex) {
            Logger.getLogger(Add_Universitario.class.getName()).log(Level.SEVERE, null, ex);
        }

        String faculdade = (String) combo_faculdade.getSelectedItem();
        try {
            idfaculdade = sql.busca_idfaculdade(faculdade);
        } catch (SQLException ex) {
            Logger.getLogger(Add_Universitario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String escola = (String) combo_escola.getSelectedItem();
        try {
            idescola = sql.busca_idescola(escola);
        } catch (SQLException ex) {
            Logger.getLogger(Add_Universitario.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            nasc = formatData(text_nascimento.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Add_Universitario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if (foto == null) {
            //System.out.println(query);
            System.out.println("foto está nula");
            sql.update_universitario(id, nome, nasc, fone, dia, rua, numero, complemento, bairro, idcidade, idfaculdade, idescola);
            JOptionPane.showMessageDialog(null, "Universitário incluido com sucesso !", "Sucesso !", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
            //System.out.println(query);
            System.out.println("foto NÃO esta nula");
            sql.update_universitario_foto(id, nome, nasc, fone, dia, rua, numero, complemento, bairro, idcidade, foto, idfaculdade, idescola);
            JOptionPane.showMessageDialog(null, "Universitário incluido com sucesso !", "Sucesso !", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }

    }//GEN-LAST:event_botao_ConfirmarActionPerformed

    private void botao_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_CancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botao_CancelarActionPerformed

    private void text_nascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_nascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_nascimentoActionPerformed

    private void combo_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_estadoActionPerformed

    }//GEN-LAST:event_combo_estadoActionPerformed

    private void botao_escolherfotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_escolherfotoActionPerformed
        //Criação do FileChooser    
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Importar imagem");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        // int a = fileChooser.showOpenDialog(null);    

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File arquivo = fileChooser.getSelectedFile();//arquivo    
            BufferedImage bi = null;
            try {
                bi = ImageIO.read(arquivo); //carrega a imagem real num buffer  
            } catch (IOException ex) {
                Logger.getLogger(Add_Universitario.class.getName()).log(Level.SEVERE, null, ex);
            }
            //cria um buffer auxiliar com o tamanho desejado
            BufferedImage aux = new BufferedImage(123, 159, bi.getType());
            //pega a classe graphics do aux para edicao
            Graphics2D g = aux.createGraphics();
            //cria a transformacao
            AffineTransform at = AffineTransform.getScaleInstance((double) 123 / bi.getWidth(), (double) 159 / bi.getHeight());
            //pinta e transforma a imagem real no auxiliar
            g.drawRenderedImage(bi, at);
            //seta no jlabel
            label_foto.setIcon(new ImageIcon(aux));
            label_foto.setText(null);
            //Imagem da foto !!
            foto = fileChooser.getSelectedFile().getPath();
            //return;    
            //LB_Foto.setIcon(new ImageIcon(fileChooser.getSelectedFile().getPath()));

        }
    }//GEN-LAST:event_botao_escolherfotoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Add_Universitario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Universitario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Universitario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Universitario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Add_Universitario().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(Add_Universitario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Add_Universitario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Add_Universitario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_Cancelar;
    private javax.swing.JButton botao_Confirmar;
    private javax.swing.JButton botao_escolherfoto;
    private javax.swing.JButton botao_limpar;
    private javax.swing.JComboBox combo_cidades;
    private javax.swing.JComboBox combo_curso;
    private javax.swing.JComboBox combo_dia;
    private javax.swing.JComboBox combo_escola;
    private javax.swing.JComboBox combo_estado;
    private javax.swing.JComboBox combo_faculdade;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel label_dia;
    private javax.swing.JLabel label_faculdade;
    private javax.swing.JLabel label_foto;
    private javax.swing.JTextField text_bairro;
    private javax.swing.JTextField text_complemento;
    private javax.swing.JTextField text_id;
    private javax.swing.JFormattedTextField text_nascimento;
    private javax.swing.JTextField text_nome;
    private javax.swing.JTextField text_numero;
    private javax.swing.JTextField text_pais;
    private javax.swing.JTextField text_rua;
    private javax.swing.JFormattedTextField text_telefone;
    // End of variables declaration//GEN-END:variables
}
