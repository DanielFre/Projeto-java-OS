/*
 * The MIT License
 *
 * Copyright 2022 Daniel Frey.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.com.infox.view;

import br.com.infox.controller.TelaOSController;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Daniel Frey
 * @version 1.0.0
 */
public class TelaOS extends javax.swing.JInternalFrame {

    private final TelaOSController controller;

    /**
     * Creates new form TelaOS
     */
    public TelaOS() {
        initComponents();
        controller = new TelaOSController(this);
        this.controller.limparTela();

        try {
            setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaOS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void exibeMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public JTextField getJtfOSClienteCliente() {
        return jtfOSClienteCliente;
    }

    public void setJtfOSClienteCliente(JTextField jtfOSClienteCliente) {
        this.jtfOSClienteCliente = jtfOSClienteCliente;
    }

    public JComboBox<String> getCbcOS_Situacao() {
        return cbcOS_Situacao;
    }

    public void setCbcOS_Situacao(JComboBox<String> cbcOS_Situacao) {
        this.cbcOS_Situacao = cbcOS_Situacao;
    }

    public JComboBox<String> getCbcOS_Tecnico() {
        return cbcOS_Tecnico;
    }

    public void setCbcOS_Tecnico(JComboBox<String> cbcOS_Tecnico) {
        this.cbcOS_Tecnico = cbcOS_Tecnico;
    }

    public JTextField getJtfOSClienteID() {
        return jtfOSClienteID;
    }

    public void setJtfOSClienteID(JTextField jtfOSClienteID) {
        this.jtfOSClienteID = jtfOSClienteID;
    }

    public JLabel getJtfOSData() {
        return jtfOSData;
    }

    public void setJtfOSData(JLabel jtfOSData) {
        this.jtfOSData = jtfOSData;
    }

    public JTextField getJtfOSDefeito() {
        return jtfOSDefeito;
    }

    public void setJtfOSDefeito(JTextField jtfOSDefeito) {
        this.jtfOSDefeito = jtfOSDefeito;
    }

    public JTextField getJtfOSEquipamento() {
        return jtfOSEquipamento;
    }

    public void setJtfOSEquipamento(JTextField jtfOSEquipamento) {
        this.jtfOSEquipamento = jtfOSEquipamento;
    }

    public JTextField getJtfOSPesquisaCliente() {
        return jtfOSPesquisaCliente;
    }

    public void setJtfOSPesquisaCliente(JTextField jtfOSPesquisaCliente) {
        this.jtfOSPesquisaCliente = jtfOSPesquisaCliente;
    }

    public JTextField getJtfOSServico() {
        return jtfOSServico;
    }

    public void setJtfOSServico(JTextField jtfOSServico) {
        this.jtfOSServico = jtfOSServico;
    }

    public JTextField getJtfOSValor() {
        return jtfOSValor;
    }

    public void setJtfOSValor(JTextField jtfOSValor) {
        this.jtfOSValor = jtfOSValor;
    }

    public JLabel getJtfOSid() {
        return jtfOSid;
    }

    public void setJtfOSid(JLabel jtfOSid) {
        this.jtfOSid = jtfOSid;
    }

    public JRadioButton getRdbOSOrcamento() {
        return rdbOSOrcamento;
    }

    public void setRdbOSOrcamento(JRadioButton rdbOSOrcamento) {
        this.rdbOSOrcamento = rdbOSOrcamento;
    }

    public JRadioButton getRdbOS_OrdemDeServico() {
        return rdbOS_OrdemDeServico;
    }

    public void setRdbOS_OrdemDeServico(JRadioButton rdbOS_OrdemDeServico) {
        this.rdbOS_OrdemDeServico = rdbOS_OrdemDeServico;
    }

    public JTable getTblOSClientes() {
        return tblOSClientes;
    }

    public void setTblOSClientes(JTable tblOSClientes) {
        this.tblOSClientes = tblOSClientes;
    }

    public JLabel getJtfOSTecnicoID() {
        return jtfOSTecnicoID;
    }

    public void setJtfOSTecnicoID(JLabel jtfOSTecnicoID) {
        this.jtfOSTecnicoID = jtfOSTecnicoID;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rdbOSOrcamento = new javax.swing.JRadioButton();
        rdbOS_OrdemDeServico = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfOSid = new javax.swing.JLabel();
        jtfOSData = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbcOS_Situacao = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jtfOSPesquisaCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOSClientes = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jtfOSEquipamento = new javax.swing.JTextField();
        jtfOSDefeito = new javax.swing.JTextField();
        jtfOSServico = new javax.swing.JTextField();
        jtfOSValor = new javax.swing.JTextField();
        cbcOS_Tecnico = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnOS_Alterar = new javax.swing.JButton();
        btnOS_Adicionar = new javax.swing.JButton();
        btnOS_Pesquisar = new javax.swing.JButton();
        btnOS_Imprimir = new javax.swing.JButton();
        btnOS_Deletar = new javax.swing.JButton();
        jtfOSClienteCliente = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfOSClienteID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfOSTecnicoID = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("OS - Ordem de Servi??o");
        setMaximumSize(new java.awt.Dimension(640, 540));
        setMinimumSize(new java.awt.Dimension(640, 540));
        setPreferredSize(new java.awt.Dimension(640, 540));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup1.add(rdbOSOrcamento);
        rdbOSOrcamento.setText("Or??amento");
        rdbOSOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbOSOrcamentoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbOS_OrdemDeServico);
        rdbOS_OrdemDeServico.setSelected(true);
        rdbOS_OrdemDeServico.setText("Ordem de Servi??o");
        rdbOS_OrdemDeServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbOS_OrdemDeServicoActionPerformed(evt);
            }
        });

        jLabel1.setText("N?? OS:");

        jLabel2.setText("Data:");

        jtfOSid.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtfOSid.setText("00");

        jtfOSData.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtfOSData.setText("00/00/0000");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/clear_icon.png"))); // NOI18N
        jButton1.setFocusPainted(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMaximumSize(new java.awt.Dimension(20, 20));
        jButton1.setMinimumSize(new java.awt.Dimension(20, 20));
        jButton1.setPreferredSize(new java.awt.Dimension(40, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rdbOS_OrdemDeServico)
                        .addGap(99, 105, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfOSid)
                            .addComponent(jtfOSData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rdbOSOrcamento)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfOSid))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtfOSData)))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(rdbOSOrcamento)
                .addGap(5, 5, 5)
                .addComponent(rdbOS_OrdemDeServico)
                .addGap(11, 11, 11))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 17, -1, -1));

        jLabel5.setText("* Situa????o:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 154, -1, -1));

        cbcOS_Situacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Na Bancada", "Entrega OK", "Aguardando Entrega", "Aguardando Aprova????o", "Aguardando Pe??as", "Abandonado Pelo Cliente", "Or??amento Reprovado", "Or??amento Aprovado", "Retornou", "Irrepar??vel" }));
        getContentPane().add(cbcOS_Situacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 151, 160, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cliente"));
        jPanel2.setMaximumSize(new java.awt.Dimension(370, 164));
        jPanel2.setMinimumSize(new java.awt.Dimension(370, 164));

        jtfOSPesquisaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfOSPesquisaClienteKeyReleased(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/find_search_icon.png"))); // NOI18N

        tblOSClientes = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblOSClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nome", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOSClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblOSClientes.setFocusable(false);
        tblOSClientes.setMaximumSize(new java.awt.Dimension(225, 64));
        tblOSClientes.setMinimumSize(new java.awt.Dimension(225, 64));
        tblOSClientes.getTableHeader().setReorderingAllowed(false);
        tblOSClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOSClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblOSClientes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jtfOSPesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(jtfOSPesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 10, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 184, 604, 10));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("* Equipamento:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 233, -1, -1));
        getContentPane().add(jtfOSEquipamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 230, 519, -1));
        getContentPane().add(jtfOSDefeito, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 265, 519, -1));
        getContentPane().add(jtfOSServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 300, 519, -1));

        jtfOSValor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtfOSValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        getContentPane().add(jtfOSValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 336, 160, -1));

        cbcOS_Tecnico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cbcOS_Tecnico.setToolTipText("Usu??rio");
        cbcOS_Tecnico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbcOS_TecnicoItemStateChanged(evt);
            }
        });
        getContentPane().add(cbcOS_Tecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 335, 200, -1));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("* Defeito:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 268, -1, -1));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Servi??o:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 303, -1, -1));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("* T??cnico:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 339, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Valor R$:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 339, -1, -1));

        btnOS_Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/os_update_icon.png"))); // NOI18N
        btnOS_Alterar.setToolTipText("Alterar OS");
        btnOS_Alterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOS_Alterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOS_Alterar.setMaximumSize(new java.awt.Dimension(80, 80));
        btnOS_Alterar.setMinimumSize(new java.awt.Dimension(80, 80));
        btnOS_Alterar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnOS_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOS_AlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnOS_Alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 389, -1, -1));

        btnOS_Adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/os_add_icon.png"))); // NOI18N
        btnOS_Adicionar.setToolTipText("Emitir OS");
        btnOS_Adicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOS_Adicionar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOS_Adicionar.setMaximumSize(new java.awt.Dimension(80, 80));
        btnOS_Adicionar.setMinimumSize(new java.awt.Dimension(80, 80));
        btnOS_Adicionar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnOS_Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOS_AdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnOS_Adicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 389, -1, -1));

        btnOS_Pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/os_search_icon.png"))); // NOI18N
        btnOS_Pesquisar.setToolTipText("Pesquisar OS");
        btnOS_Pesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOS_Pesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOS_Pesquisar.setMaximumSize(new java.awt.Dimension(80, 80));
        btnOS_Pesquisar.setMinimumSize(new java.awt.Dimension(80, 80));
        btnOS_Pesquisar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnOS_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOS_PesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnOS_Pesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 389, -1, -1));

        btnOS_Imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/os_printer_icon.png"))); // NOI18N
        btnOS_Imprimir.setToolTipText("Imprimir OS");
        btnOS_Imprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOS_Imprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOS_Imprimir.setMaximumSize(new java.awt.Dimension(80, 80));
        btnOS_Imprimir.setMinimumSize(new java.awt.Dimension(80, 80));
        btnOS_Imprimir.setPreferredSize(new java.awt.Dimension(80, 80));
        btnOS_Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOS_ImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(btnOS_Imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 389, -1, -1));

        btnOS_Deletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/os_delete_icon.png"))); // NOI18N
        btnOS_Deletar.setToolTipText("Deletar OS");
        btnOS_Deletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOS_Deletar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOS_Deletar.setMaximumSize(new java.awt.Dimension(80, 80));
        btnOS_Deletar.setMinimumSize(new java.awt.Dimension(80, 80));
        btnOS_Deletar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnOS_Deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOS_DeletarActionPerformed(evt);
            }
        });
        getContentPane().add(btnOS_Deletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 389, -1, -1));

        jtfOSClienteCliente.setEditable(false);
        jtfOSClienteCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtfOSClienteCliente.setEnabled(false);
        getContentPane().add(jtfOSClienteCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 199, 339, -1));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("* Cliente:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 202, -1, -1));

        jLabel7.setText("* Id:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 202, -1, -1));

        jtfOSClienteID.setEditable(false);
        jtfOSClienteID.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtfOSClienteID.setEnabled(false);
        getContentPane().add(jtfOSClienteID, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 199, 80, -1));

        jLabel3.setText("* Campos obrigat??rios!");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 365, -1, -1));

        jLabel4.setText("Id_T:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 339, -1, -1));

        jtfOSTecnicoID.setText("0");
        getContentPane().add(jtfOSTecnicoID, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 339, -1, -1));

        setBounds(0, 0, 640, 540);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfOSPesquisaClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfOSPesquisaClienteKeyReleased
        try {
            this.controller.pesquisarCliente();
        } catch (SQLException ex) {
            Logger.getLogger(TelaOS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jtfOSPesquisaClienteKeyReleased

    private void tblOSClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOSClientesMouseClicked
        this.controller.setarLinhaTabelaNosCampos();
    }//GEN-LAST:event_tblOSClientesMouseClicked

    private void rdbOSOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbOSOrcamentoActionPerformed
        this.controller.setarTipodeOS();
    }//GEN-LAST:event_rdbOSOrcamentoActionPerformed

    private void rdbOS_OrdemDeServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbOS_OrdemDeServicoActionPerformed
        this.controller.setarTipodeOS();
    }//GEN-LAST:event_rdbOS_OrdemDeServicoActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        this.controller.setarTipodeOS();
        try {
            this.controller.atualizaUsuariosTecnicos();
        } catch (SQLException ex) {
            Logger.getLogger(TelaOS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnOS_AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOS_AdicionarActionPerformed
        try {
            this.controller.emitirOS();
        } catch (SQLException ex) {
            Logger.getLogger(TelaOS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOS_AdicionarActionPerformed

    private void cbcOS_TecnicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbcOS_TecnicoItemStateChanged
        this.controller.tecnicoSelecionado();
    }//GEN-LAST:event_cbcOS_TecnicoItemStateChanged

    private void btnOS_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOS_PesquisarActionPerformed
        try {
            this.controller.pesquisarOS();
        } catch (SQLException ex) {
            Logger.getLogger(TelaOS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOS_PesquisarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.controller.limparTela();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnOS_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOS_AlterarActionPerformed
        try {
            this.controller.alterarOS();
        } catch (SQLException ex) {
            Logger.getLogger(TelaOS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOS_AlterarActionPerformed

    private void btnOS_DeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOS_DeletarActionPerformed
        try {
            this.controller.deletarOS();
        } catch (SQLException ex) {
            Logger.getLogger(TelaOS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOS_DeletarActionPerformed

    private void btnOS_ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOS_ImprimirActionPerformed
        this.controller.imprimirOS();
    }//GEN-LAST:event_btnOS_ImprimirActionPerformed

    public JButton getBtnOS_Adicionar() {
        return btnOS_Adicionar;
    }

    public void setBtnOS_Adicionar(JButton btnOS_Adicionar) {
        this.btnOS_Adicionar = btnOS_Adicionar;
    }

    public JButton getBtnOS_Alterar() {
        return btnOS_Alterar;
    }

    public void setBtnOS_Alterar(JButton btnOS_Alterar) {
        this.btnOS_Alterar = btnOS_Alterar;
    }

    public JButton getBtnOS_Deletar() {
        return btnOS_Deletar;
    }

    public void setBtnOS_Deletar(JButton btnOS_Deletar) {
        this.btnOS_Deletar = btnOS_Deletar;
    }

    public JButton getBtnOS_Imprimir() {
        return btnOS_Imprimir;
    }

    public void setBtnOS_Imprimir(JButton btnOS_Imprimir) {
        this.btnOS_Imprimir = btnOS_Imprimir;
    }

    public JButton getBtnOS_Pesquisar() {
        return btnOS_Pesquisar;
    }

    public void setBtnOS_Pesquisar(JButton btnOS_Pesquisar) {
        this.btnOS_Pesquisar = btnOS_Pesquisar;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOS_Adicionar;
    private javax.swing.JButton btnOS_Alterar;
    private javax.swing.JButton btnOS_Deletar;
    private javax.swing.JButton btnOS_Imprimir;
    private javax.swing.JButton btnOS_Pesquisar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbcOS_Situacao;
    private javax.swing.JComboBox<String> cbcOS_Tecnico;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jtfOSClienteCliente;
    private javax.swing.JTextField jtfOSClienteID;
    private javax.swing.JLabel jtfOSData;
    private javax.swing.JTextField jtfOSDefeito;
    private javax.swing.JTextField jtfOSEquipamento;
    private javax.swing.JTextField jtfOSPesquisaCliente;
    private javax.swing.JTextField jtfOSServico;
    private javax.swing.JLabel jtfOSTecnicoID;
    private javax.swing.JTextField jtfOSValor;
    private javax.swing.JLabel jtfOSid;
    public javax.swing.JRadioButton rdbOSOrcamento;
    public javax.swing.JRadioButton rdbOS_OrdemDeServico;
    private javax.swing.JTable tblOSClientes;
    // End of variables declaration//GEN-END:variables
}
