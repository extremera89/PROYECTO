package otros;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesBBDD {
    private String tblLogin;
    private String tblExposicion;
    private String tblCliente;
    private String tblPersona;
    private String tblMonitor;
    private String tblVisita;
    private String tblSala;
    private String tblReserva;
    private String tblCentro;
    public PropertiesBBDD() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("config.bbdd.properties"));


        tblLogin = properties.getProperty("tblLogin");
        tblExposicion = properties.getProperty("tblExposicion");
        tblCliente=properties.getProperty("tblCliente");
        tblPersona=properties.getProperty("tblPersona");
        tblMonitor=properties.getProperty("tblMonitor");
        tblSala = properties.getProperty("tblSala");
        tblReserva = properties.getProperty("tblReserva");
        tblVisita = properties.getProperty("tblVisita");
        tblCentro=properties.getProperty("tblCentro");
    }

    public String getTblLogin() {
        return tblLogin;
    }

    public String getTblExposicion() {
        return tblExposicion;
    }

    public String getTblCliente() {
        return tblCliente;
    }

    public String getTblPersona() {return tblPersona;}

    public String getTblMonitor() {
        return tblMonitor;
    }

    public String getTblSala() {
        return tblSala;
    }

    public String getTblReserva() {
        return tblReserva;
    }

    public String getTblVisita() {
        return tblVisita;
    }

    public String getTblCentro() {
        return tblCentro;
    }
}
