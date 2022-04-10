package photop;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Señor C.
 */
public class Receptor {

    private static String validate(String dir) {
        return dir.replace(System.getProperty("user.home"),
                "http://localhost:8000").replace("\\", "/");
    }

    private static Scanner getScanner(String query) throws IOException {
        Process process = Runtime.getRuntime().exec(query);
        return new Scanner(process.getInputStream());
    }

    private static String getProdId(String query) throws IOException {
        Scanner sc = getScanner(query);
        query = sc.nextLine().trim();
        query = sc.nextLine().trim();
        query = sc.nextLine().trim();
        sc.close();
        String[] vec = query.replace(" ", ",").split(",");
        return vec[vec.length - 1];
    }

    private static String findPath(Scanner sc, String aux) {
        while (sc.hasNextLine()) {
            aux = sc.nextLine();
            Matcher matcher = Pattern.compile("[\"](.+?)[\"]").matcher(aux);
            if (matcher.find()) {
                sc.close();
                aux = matcher.group(1);
                return aux;
            }
        }
        sc.close();
        return "Error: browser path missed";
    }

    public static String getDefaultBrowser() {
        try {
            String prodId = getProdId("REG QUERY HKEY_CURRENT_USER\\SOFTWARE\\"
                    + "Microsoft\\Windows\\Shell\\Associations\\UrlAssociations"
                    + "\\http\\UserChoice");
            Scanner kb = getScanner("REG QUERY HKEY_CLASSES_ROOT\\" + prodId
                    + "\\shell\\open\\command");
            return findPath(kb, prodId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Error: Unable to get default browser";
    }

    public static void open(String link, String browser, boolean df, boolean solo) {
        try {
            if (solo) {
                link = "--app=" + link;
            }
            if (df) {
                Process p = Runtime.getRuntime().exec(getDefaultBrowser() + " " + link);
            } else {
                String aux = getrealPath(browser);
                Process process = new ProcessBuilder(aux, link).start();
            }
        } catch (Exception e) {

        }
    }

    public static String getrealPath(String path) throws IOException, ParseException {
        if (path.endsWith(".lnk")) {
            final WindowsShortcut sc = new WindowsShortcut(new File(path));
            return sc.getRealFilename();
        }
        return path;
    }

    public static void ini(String[] ruta, String browser, boolean df, boolean solo) {
        if (ruta.length > 0) {
            String files = "";
            for (int i = 0; i < ruta.length; i++) {
                System.out.println(ruta[i]);
                if (i > 0) {
                    files += ",";
                }
                files += "\\\"" + validate(ruta[i]) + "\\\"";
            }
            final String path = "https://www.photopea.com/#{\\\"files\\\":[" + files + "]}";
            open(path, browser, df, solo);
        } else {
            open("https://www.photopea.com", browser, df, solo);
        }

    }

}
