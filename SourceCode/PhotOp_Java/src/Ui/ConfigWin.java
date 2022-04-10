package Ui;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.google.gson.internal.LinkedTreeMap;
import config.Config;
import config.Utilites;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import photop.Receptor;

/**
 *
 * @author Señor C.
 */
public class ConfigWin extends javax.swing.JFrame {

    Config conf;
    JDialog dialog;
    LinkedTreeMap<String, String> lg;
    public static boolean open = false;
    Image icon = Toolkit.getDefaultToolkit().getImage(getClass().
            getResource("/img/PhotOpIcon.png"));

    public ConfigWin() {
        initComponents();
        winParameters();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBackground = new javax.swing.JPanel();
        jLabelLenguage = new javax.swing.JLabel();
        jComboBoxLenguage = new javax.swing.JComboBox<>();
        jLabelWebBrow = new javax.swing.JLabel();
        jTextFieldWebBrow = new javax.swing.JTextField();
        jButtonChang1 = new javax.swing.JButton();
        jCheckBoxOpenPho = new javax.swing.JCheckBox();
        jCheckBoxWebApp = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabelServerPath = new javax.swing.JLabel();
        jTextFieldServerPath = new javax.swing.JTextField();
        jButtonChang2 = new javax.swing.JButton();
        jLabelServerPort = new javax.swing.JLabel();
        jTextFieldServerPort = new javax.swing.JTextField();
        jButtonCancel = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jLabelTip = new javax.swing.JLabel();
        jLabelDarkMode = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelBackground.setBackground(new java.awt.Color(51, 51, 51));
        jPanelBackground.setMaximumSize(new java.awt.Dimension(596, 411));

        jLabelLenguage.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelLenguage.setText("Lenguaje:");

        jComboBoxLenguage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Español", "English" }));
        jComboBoxLenguage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelWebBrow.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelWebBrow.setText("Navegador Web:");

        jTextFieldWebBrow.setText("Por Defecto");
        jTextFieldWebBrow.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jButtonChang1.setText("Cambiar");
        jButtonChang1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonChang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChang1ActionPerformed(evt);
            }
        });

        jCheckBoxOpenPho.setBackground(new java.awt.Color(51, 51, 51));
        jCheckBoxOpenPho.setSelected(true);
        jCheckBoxOpenPho.setText("Abrir Photopea al Iniciar");
        jCheckBoxOpenPho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jCheckBoxWebApp.setBackground(new java.awt.Color(51, 51, 51));
        jCheckBoxWebApp.setText("Abrir como WebApp");
        jCheckBoxWebApp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Opciones Avanzadas");

        jLabelServerPath.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelServerPath.setText("Local Server (Directorio):");

        jTextFieldServerPath.setText("Por Defecto");

        jButtonChang2.setText("Cambiar");
        jButtonChang2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonChang2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChang2ActionPerformed(evt);
            }
        });

        jLabelServerPort.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelServerPort.setText("Puerto del Servidor:");

        jTextFieldServerPort.setText("8000");

        jButtonCancel.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancel.setText("Cancelar");
        jButtonCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonSave.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSave.setText("Guardar");
        jButtonSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jLabelTip.setForeground(new java.awt.Color(255, 255, 102));
        jLabelTip.setText("(Guarde y reinicia la aplicacion para aplicar los cambios)");

        jLabelDarkMode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDarkMode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/moon_dark_mode_.png"))); // NOI18N
        jLabelDarkMode.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDarkMode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDarkModeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelBackgroundLayout = new javax.swing.GroupLayout(jPanelBackground);
        jPanelBackground.setLayout(jPanelBackgroundLayout);
        jPanelBackgroundLayout.setHorizontalGroup(
            jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTip)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancel)
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBackgroundLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(218, 218, 218))
            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelWebBrow, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jLabelLenguage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxLenguage, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldWebBrow, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonChang1))
                            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jCheckBoxOpenPho))))
                    .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxWebApp, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabelServerPort, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelServerPath, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                                        .addComponent(jTextFieldServerPath, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonChang2))
                                    .addComponent(jTextFieldServerPort, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelDarkMode, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanelBackgroundLayout.setVerticalGroup(
            jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDarkMode, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLenguage)
                    .addComponent(jComboBoxLenguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelWebBrow)
                    .addComponent(jTextFieldWebBrow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonChang1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jCheckBoxOpenPho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(24, 24, 24)
                .addComponent(jCheckBoxWebApp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelServerPath)
                    .addComponent(jTextFieldServerPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonChang2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelServerPort)
                    .addComponent(jTextFieldServerPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonSave)
                    .addComponent(jLabelTip))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        exit();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonChang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChang1ActionPerformed
        // TODO add your handling code here:
        if (!inCaseDefault(jTextFieldWebBrow, lg.get("dfWBMsg"), lg.get("dfWBTitle"))) {
            chooseExe();
        }

    }//GEN-LAST:event_jButtonChang1ActionPerformed

    private void jButtonChang2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChang2ActionPerformed
        // TODO add your handling code here:
        if (!inCaseDefault(jTextFieldServerPath, lg.get("dfPthMsg"), lg.get("dfPthTitle"))) {
            chooseDir();
        }
    }//GEN-LAST:event_jButtonChang2ActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
        if (verifychgs()) {
            save();
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jLabelDarkModeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDarkModeMouseClicked
        // TODO add your handling code here:
        chgtheme();
    }//GEN-LAST:event_jLabelDarkModeMouseClicked

    public static void main(String args[]) {
        setlookandfeel(Utilites.getConf().getLaf());
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfigWin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonChang1;
    private javax.swing.JButton jButtonChang2;
    private static javax.swing.JButton jButtonSave;
    private static javax.swing.JCheckBox jCheckBoxOpenPho;
    private static javax.swing.JCheckBox jCheckBoxWebApp;
    private javax.swing.JComboBox<String> jComboBoxLenguage;
    private javax.swing.JLabel jLabel3;
    private static javax.swing.JLabel jLabelDarkMode;
    private javax.swing.JLabel jLabelLenguage;
    private javax.swing.JLabel jLabelServerPath;
    private javax.swing.JLabel jLabelServerPort;
    private static javax.swing.JLabel jLabelTip;
    private javax.swing.JLabel jLabelWebBrow;
    private static javax.swing.JPanel jPanelBackground;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldServerPath;
    private javax.swing.JTextField jTextFieldServerPort;
    private javax.swing.JTextField jTextFieldWebBrow;
    // End of variables declaration//GEN-END:variables

    public static void setlookandfeel(boolean op) {
        try {
            if (op) {
                UIManager.setLookAndFeel(new FlatLightLaf());
                jButtonSave.setForeground(Color.BLACK);
                jButtonCancel.setForeground(Color.BLACK);
                jPanelBackground.setBackground(new Color(224, 224, 224));
                jCheckBoxOpenPho.setBackground(new Color(224, 224, 224));
                jCheckBoxWebApp.setBackground(new Color(224, 224, 224));
                jLabelTip.setForeground(new Color(187, 0, 0));

                ImageIcon imageIcon = new ImageIcon("srcs/img/cw/sun.png");
                Image newimg = imageIcon.getImage().getScaledInstance(30, 30,
                        java.awt.Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(newimg);

                jLabelDarkMode.setIcon(imageIcon);

            } else {
                UIManager.setLookAndFeel(new FlatDarkLaf());
                jButtonSave.setForeground(Color.WHITE);
                jButtonCancel.setForeground(Color.WHITE);
                jPanelBackground.setBackground(new Color(51, 51, 51));
                jCheckBoxOpenPho.setBackground(new Color(51, 51, 51));
                jCheckBoxWebApp.setBackground(new Color(51, 51, 51));
                jLabelTip.setForeground(new Color(255, 255, 102));

                ImageIcon imageIcon = new ImageIcon("srcs/img/cw/moon.png");
                Image newimg = imageIcon.getImage().getScaledInstance(30, 30,
                        java.awt.Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(newimg);

                jLabelDarkMode.setIcon(imageIcon);
            }
        } catch (Exception e) {

        }
    }

    public void winParameters() {
        open = true;
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        onCloseEvent();
        this.setLocationRelativeTo(null);
        jLabelTip.setVisible(false);
        paintWords();
        this.setResizable(false);
        this.setIconImage(icon);
        this.setTitle(lg.get("title"));
    }

    private void paintWords() {
        conf = Utilites.getConf();
        lg = Utilites.getLenguage(conf.getLg());
        ImageIcon imageIcon;
        if (conf.getLaf()) {
            imageIcon = new ImageIcon("srcs/img/cw/sun.png");
        } else {
            imageIcon = new ImageIcon("srcs/img/cw/moon.png");
        }
        Image newimg = imageIcon.getImage().getScaledInstance(30, 30,
                java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);

        jLabelDarkMode.setIcon(imageIcon);

        //normal ops
        jLabelLenguage.setText(lg.get("idiomLabel"));
        jComboBoxLenguage.removeAllItems();
        addOp(jComboBoxLenguage, conf);
        jComboBoxLenguage.setSelectedIndex(getindexlg(conf));

        jLabelWebBrow.setText(lg.get("webBrowserlabel"));
        setJtextFields(jTextFieldWebBrow, conf.getWebbroserpath(), conf);
        jButtonChang1.setText(lg.get("changebotton"));
        jLabelWebBrow.setToolTipText(lg.get("tooltip1"));
        jTextFieldWebBrow.setToolTipText(lg.get("tooltip1"));

        jCheckBoxOpenPho.setText(lg.get("open"));
        jCheckBoxOpenPho.setSelected(conf.getOpen());
        jCheckBoxOpenPho.setToolTipText(lg.get("tooltip4"));

        //adv ops
        jLabel3.setText(lg.get("advncOption"));
        jCheckBoxWebApp.setText(lg.get("webApplabel"));
        jCheckBoxWebApp.setSelected(conf.getWebapp());
        jCheckBoxWebApp.setToolTipText(lg.get("tooltip2"));

        jLabelServerPath.setText(lg.get("localservlabel"));
        setJtextFields(jTextFieldServerPath, conf.getUserpath(), conf);
        jButtonChang2.setText(lg.get("changebotton"));
        jLabelServerPath.setToolTipText(lg.get("tooltip3"));
        jTextFieldServerPath.setToolTipText(lg.get("tooltip3"));

        jLabelServerPort.setText(lg.get("portlabel"));
        jTextFieldServerPort.setText("" + conf.getPort());
        jButtonCancel.setText(lg.get("cancellabel"));
        jButtonSave.setText(lg.get("savelabel"));
        jLabelTip.setText(lg.get("tip"));
    }

    private void addOp(JComboBox combo, Config conf) {
        for (int i = 0; i < conf.getOptions().length; i++) {
            combo.addItem(conf.getOptions()[i]);
        }
    }

    private int getindexlg(Config conf) {
        for (int i = 0; i < conf.getOptions().length; i++) {
            if (conf.getOptions()[i].equals(conf.getLg())) {
                return i;
            }
        }
        return 0;
    }

    private void setJtextFields(JTextField field, String current, Config conf) {
        if (Utilites.isdefault(current, conf)) {
            setDef(field);
        } else {
            field.setText(current);
        }
    }

    private boolean verifychgs() {
        return !(jComboBoxLenguage.getSelectedItem().equals(conf.getLg())
                && jTextFieldWebBrow.getText().equals(conf.getWebbroserpath())
                && jCheckBoxOpenPho.isSelected() == conf.getOpen()
                && jCheckBoxWebApp.isSelected() == conf.getWebapp()
                && jTextFieldServerPath.getText().equals(conf.getUserpath())
                && jTextFieldServerPort.getText().equals(
                        String.valueOf(conf.getPort())));
    }

    private void exit() {
        open = false;
        this.dispose();
    }

    private void onCloseEvent() {
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (verifychgs()) {
                    final int op = JOptionPane.showConfirmDialog(null,
                            lg.get("quitMsg"), lg.get("quittitle"),
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    switch (op) {
                        case 0:
                            save();
                            exit();
                            break;
                        case 1:
                            exit();
                            break;
                        default:
                            return;
                    }
                }
                exit();
            }
        });
    }

    private boolean validateThings() {
        String text = jTextFieldServerPort.getText();
        try {
            new Integer(text);
        } catch (NumberFormatException ne) {
            jTextFieldServerPort.setText("" + conf.getPort());
            JOptionPane.showMessageDialog(this, lg.get("alert"), "Error", 1);
            return true;
        }
        return false;
    }

    private void save() {
        if (validateThings()) {
            return;
        }
        Thread t = new Thread(() -> {
            showTip();
            savingaLL();
            try {
                Thread.sleep(900);
                dialog.dispose();
                Thread.sleep(900);
                dialog.dispose();
            } catch (Exception e) {
            }
        });
        t.start();
        dialog = setDialog("srcs/img/cw/load.gif", lg.get("wait"),
                lg.get("saving"));
        dialog.setVisible(true);
        dialog = setDialog("srcs/img/cw/check.png", lg.get("xd"),
                lg.get("saved"));
        dialog.setVisible(true);
    }

    private void showTip() {
        if (!(jComboBoxLenguage.getSelectedItem().equals(conf.getLg())
                && jTextFieldServerPath.getText().equals(conf.getUserpath())
                && jTextFieldServerPort.getText().equals(String.valueOf(
                        conf.getPort())))) {
            jLabelTip.setVisible(true);
        }
    }

    private void savingaLL() {
        conf.setLg(String.valueOf(jComboBoxLenguage.getSelectedItem()));
        conf.setWebbroserpath(jTextFieldWebBrow.getText());
        conf.setOpen(jCheckBoxOpenPho.isSelected());
        conf.setWebapp(jCheckBoxWebApp.isSelected());
        conf.setUserpath(jTextFieldServerPath.getText());
        conf.setPort(Integer.parseInt(jTextFieldServerPort.getText()));

        Utilites.saveConf(conf);
    }

    private void chooseExe() {
        JFileChooser fc = new JFileChooser() {
            @Override
            protected JDialog createDialog(Component parent) throws HeadlessException {
                JDialog dialog = super.createDialog(parent);
                dialog.setIconImage(icon);
                return dialog;
            }
        };

        if (Utilites.isdefault(conf.getWebbroserpath(), conf)) {
            fc.setCurrentDirectory(new File(
                    "C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs"));
        } else {
            fc.setCurrentDirectory(new File(jTextFieldWebBrow.getText()));
        }
        fc.setDialogTitle(lg.get("selectWB"));
        fc.setFileFilter(new FileNameExtensionFilter(lg.get("exe"), "exe", "lnk"));

        if (fc.showOpenDialog(null) == 0) {
            try {
                String path = Receptor.getrealPath(fc.getSelectedFile().
                        getAbsolutePath());
                if (!path.equals(Receptor.getDefaultBrowser())) {
                    jTextFieldWebBrow.setText(fc.getSelectedFile().
                            getAbsolutePath());
                } else {
                    setDef(jTextFieldWebBrow);
                }
            } catch (Exception e) {

            }
        }
    }

    private void chooseDir() {
        JFileChooser fc = new JFileChooser() {
            @Override
            protected JDialog createDialog(Component parent) throws HeadlessException {
                JDialog dialog = super.createDialog(parent);
                dialog.setIconImage(icon);
                return dialog;
            }

        };
        if (Utilites.isdefault(jTextFieldServerPath.getText(), conf)) {
            fc.setCurrentDirectory(new File(System.getProperty("user.home")));
        } else {
            fc.setCurrentDirectory(new File(jTextFieldServerPath.getText()));
        }
        fc.setDialogTitle(lg.get("dir"));
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (fc.showOpenDialog(null) == 0) {
            try {
                if (!fc.getSelectedFile().getAbsolutePath().equals(
                        System.getProperty("user.home"))) {
                    jTextFieldServerPath.setText(fc.getSelectedFile().
                            getAbsolutePath());
                } else {
                    setDef(jTextFieldServerPath);
                }
            } catch (Exception e) {

            }
        }
    }

    private boolean inCaseDefault(JTextField text, String msg, String title) {
        if (!Utilites.isdefault(text.getText(), conf)) {
            int op = JOptionPane.showConfirmDialog(null, msg, title,
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (op == 0) {
                setDef(text);
                return true;
            }
        }
        return false;
    }

    private void setDef(JTextField text) {
        for (int i = 0; i < conf.getOptions().length; i++) {
            if (conf.getOptions()[i].equals(conf.getLg())) {
                text.setText(conf.getDf()[i]);
            }
        }
    }

    private JDialog setDialog(String path, String tit, String msg) {
        ImageIcon img = new ImageIcon(path);
        final JOptionPane optionPane = new JOptionPane(msg,
                JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION,
                img, new Object[]{}, null);
        optionPane.setFont(new Font("Arial", Font.CENTER_BASELINE, 50));
        dialog = new JDialog();
        dialog.setIconImage(icon);
        dialog.setTitle(tit);
        dialog.setModal(true);
        dialog.setContentPane(optionPane);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        return dialog;
    }

    private void chgtheme() {
        conf.setLaf(!conf.getLaf());
        changeLaf(this, conf.getLaf());
        Utilites.saveConf(conf);
    }

    public static void changeLaf(JFrame frame, boolean laf) {
        setlookandfeel(laf);
        SwingUtilities.updateComponentTreeUI(frame);
    }

}
