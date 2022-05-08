package otros;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesBBDD {
    private String tblLogin;
    private String tblExposicion;
    private String tblSala;
    private String tblReserva;

    public PropertiesBBDD() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("config.bbdd.properties"));


        tblLogin = properties.getProperty("tblLogin");
        tblExposicion = properties.getProperty("tblExposicion");
        tblSala = properties.getProperty("tblSala");
        tblReserva = properties.getProperty("tblReserva");

    }

    public String getTblLogin() {
        return tblLogin;
    }

    public String getTblExposicion() {
        return tblExposicion;
    }

    public String getTblSala() {
        return tblSala;
    }

    public String getTblReserva() {
        return tblReserva;
    }
}
