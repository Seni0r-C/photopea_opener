package config;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Señor C.
 */
public class Utilites {

    private static String config = "srcs/config.json";
    private String server = "srcs/server/PhotOp_Server.exe";
    public static Process p;

    public static String getJson(String path) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(path);
        } catch (FileNotFoundException fe) {
            System.out.println("File not found");
        }
        try {
            br = new BufferedReader(fr);
            String tmp_c = "";
            String linea = null;
            while ((linea = br.readLine()) != null) {
                tmp_c = tmp_c + linea;
            }
            fr.close();
            return tmp_c;

        } catch (IOException e) {
            return null;
        }
    }

    public static Config getConf() {
        final Gson gson = new Gson();
        Config config = gson.fromJson(getJson(Utilites.config), Config.class);
        return config;
    }

    public static boolean isdefault(String text, Config conf) {
        return text.equals(conf.getDf()[0]) || text.equals(conf.getDf()[1]);
    }

    public void initServer() {
        Config conf = getConf();
        try {
            if (isdefault(conf.getUserpath(), conf)) {
                if (conf.getPort() == 8000) {
                    p = Runtime.getRuntime().exec(this.server);
                } else {
                    p = Runtime.getRuntime().exec(this.server + " "
                            + System.getProperty("user.home") + " "
                            + conf.getPort());
                }
            } else {
                p = Runtime.getRuntime().exec(this.server + " "
                        + conf.getUserpath() + " " + conf.getPort());
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static LinkedTreeMap<String, String> getLenguage(String lang) {
        final String path;
        if (lang.equals("English")) {

            path = "srcs/idiom/en.json";

        } else {
            path = "srcs/idiom/es.json";
        }
        return getJsonMap(path);
    }

    private static LinkedTreeMap<String, String> getJsonMap(String path) {
        final Gson gson = new Gson();
        LinkedTreeMap<String, String> map = gson.fromJson(getJson(path), new LinkedTreeMap<>().getClass());
        return map;
    }

    public static void saveConf(Config conf) {
        String json = new Gson().toJson(conf);
        writeJson(json);
    }

    private static void writeJson(String json) {
        try {
            FileWriter file = new FileWriter(config);
            file.write(json);
            file.close();
        } catch (Exception e) {
        }
    }
}
