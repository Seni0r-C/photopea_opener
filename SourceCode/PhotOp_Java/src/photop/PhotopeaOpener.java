package photop;

import Ui.PhotOpTrayIcon;
import Ui.SplashScreen;
import config.*;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;

/**
 *
 * @author Señor C.
 */
public class PhotopeaOpener {

    private static final int PORT = 9999;
    private static ServerSocket socket;

    public static void main(String[] args) {

        try {
            socket = new ServerSocket(PORT, 0, InetAddress.getByAddress(new byte[]{127, 0, 0, 1}));
            {
                SplashScreen sc = new SplashScreen();
                sc.setVisible(true);
                new Utilites().initServer();
                Config conf = Utilites.getConf();
                new PhotOpTrayIcon().init();
                sleep(1900);
                sc.dispose();
                if (conf.getOpen() || args.length > 0) {
                    Receptor.ini(args, conf.getWebbroserpath(), Utilites.isdefault(conf.getWebbroserpath(), conf), conf.getWebapp());
                }
            }
        } catch (BindException e) {
            Config conf = new Utilites().getConf();
            Receptor.ini(args, conf.getWebbroserpath(), Utilites.isdefault(conf.getWebbroserpath(), conf), conf.getWebapp());
            System.exit(1);
        } catch (IOException e) {
            System.err.println("************************************Unexpected error.");
            e.printStackTrace();
            System.exit(2);
        } catch (Exception e) {
            System.err.println("************************************ Error");
            System.exit(3);
        }

    }
}
