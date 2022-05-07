package otros;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesBBDD {
    private String tblLogin;
    private String tblExposicion;

    public PropertiesBBDD() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("config.bbdd.properties"));


        tblLogin = properties.getProperty("tblLogin");
        tblExposicion = properties.getProperty("tblExposicion");

    }

    public String getTblLogin() {
        return tblLogin;
    }

    public String getTblExposicion() {
        return tblExposicion;
    }
}
