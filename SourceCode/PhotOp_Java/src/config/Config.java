package config;

/**
 *
 * @author Señor C.
 */
public class Config {

    private String[] options;
    private String lg;
    private String webbroserpath;
    private String userpath;
    private String[] df;
    private int port;
    private boolean webapp;
    private boolean open;
    private boolean laf;

    public boolean getLaf() {
        return laf;
    }

    public void setLaf(boolean laf) {
        this.laf = laf;
    }

    public boolean getOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getLg() {
        return lg;
    }

    public void setLg(String lg) {
        this.lg = lg;
    }

    public String getWebbroserpath() {
        return webbroserpath;
    }

    public void setWebbroserpath(String webbroserpath) {
        this.webbroserpath = webbroserpath;
    }

    public String getUserpath() {
        return userpath;
    }

    public void setUserpath(String userpath) {
        this.userpath = userpath;
    }

    public String[] getDf() {
        return df;
    }

    public void setDf(String[] df) {
        this.df = df;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean getWebapp() {
        return webapp;
    }

    public void setWebapp(boolean webapp) {
        this.webapp = webapp;
    }

}
