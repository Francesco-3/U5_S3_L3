package francescodicecca.DesignPatterns.entities;

import francescodicecca.DesignPatterns.repositories.DataSource;

public class UserData {
    private String nomeCompleto;
    private int eta;

    public void getData(DataSource ds) { nomeCompleto = ds.getNomeCompleto(); eta = ds.getEta(); }
}
