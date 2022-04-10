package Ui;

import static Ui.ConfigWin.setlookandfeel;
import com.google.gson.internal.LinkedTreeMap;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import photop.*;
import config.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFrame;

public class PhotOpTrayIcon {

    private String version = "PhotopeaOpener V1.3";
    private String icon = "srcs/img/logo.png";
    private String photOpsSvr = "PhotOp_Server.exe";
    private Receptor rec = new Receptor();
    Config conf = new Utilites().getConf();
    LinkedTreeMap<String, String> lg = Utilites.getLenguage(conf.getLg());
    ConfigWin configwin;
    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getClickCount() >= 2) {
                rec.open("https://www.photopea.com", conf.getWebbroserpath(),
                        Utilites.isdefault(conf.getWebbroserpath(), conf),
                        conf.getWebapp());
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    };

    public void init() {
        if (!SystemTray.isSupported()) {
            System.out.println("System tray is not supported !!! ");
            return;
        }
        ConfigWin.setlookandfeel(conf.getLaf());

        SystemTray systemTray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().getImage(icon);
        PopupMenu trayPopupMenu = new PopupMenu();
        addOptions(trayPopupMenu);
        TrayIcon trayIcon = new TrayIcon(image, version, trayPopupMenu);
        trayIcon.setImageAutoSize(true);
        trayIcon.addMouseListener(ml);
        try {
            systemTray.add(trayIcon);
        } catch (Exception e) {
//            awtException.printStackTrace();
        }

    }

    private void addOptions(PopupMenu menu) {
        MenuItem openPhotOp = new MenuItem(lg.get("openPho"));
        openPhotOp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conf = new Utilites().getConf();
                rec.open("https://www.photopea.com", conf.getWebbroserpath(),
                        Utilites.isdefault(conf.getWebbroserpath(), conf),
                        conf.getWebapp());
            }
        });

        MenuItem close = new MenuItem(lg.get("exitTray"));
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (serverIsOn()) {
                    Utilites.p.destroy();
                }
                System.exit(0);
            }
        });

        MenuItem server = new MenuItem("On/Off Local Server");
        server.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (serverIsOn()) {
                    Utilites.p.destroy();
                    JOptionPane.showMessageDialog(null, lg.get("desser"),
                            lg.get("dessertit"), 1);
                } else {
                    new Utilites().initServer();
                    JOptionPane.showMessageDialog(null, lg.get("actser"),
                            lg.get("actsertit"), 1);
                }
            }
        });

        MenuItem config = new MenuItem(lg.get("configTray"));
        config.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!configwin.open) {
                    configwin = new ConfigWin();
                    setlookandfeel(new Utilites().getConf().getLaf());
                    configwin.setVisible(true);
                } else {
                    configwin.requestFocus();
                    configwin.setExtendedState(JFrame.NORMAL);
                }
            }
        });

        menu.add(openPhotOp);
        menu.add(server);
        menu.add(config);
        menu.add(close);
    }

    private boolean serverIsOn() {
        try {
            String line;
            String pidInfo = "";

            Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");

            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while ((line = input.readLine()) != null) {
                pidInfo += line;
            }

            input.close();

            if (pidInfo.contains(photOpsSvr)) {
                return true;

            } else {
                return false;

            }
        } catch (IOException er) {
            return false;
        }
    }

}
