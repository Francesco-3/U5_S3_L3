package francescodicecca.DesignPatterns.adapters;

import francescodicecca.DesignPatterns.entities.Info;
import francescodicecca.DesignPatterns.repositories.DataSource;

import java.util.Calendar;
import java.util.Date;

public class InfoAdapter implements DataSource {
    private Info info;

    public InfoAdapter(Info info) {
        this.info = info;
    }

    @Override
    public String getNomeCompleto() {
        return info.getNome() + " " + info.getCognome();
    }

    @Override
    public int getEta() {
        Date dataNascita = info.getDataDiNascita();
        if (dataNascita == null) return 0;

        Calendar oggi = Calendar.getInstance();
        Calendar nascita = Calendar.getInstance();
        nascita.setTime(dataNascita);

        int eta = oggi.get(Calendar.YEAR) - nascita.get(Calendar.YEAR);

        if (oggi.get(Calendar.DAY_OF_YEAR) < nascita.get(Calendar.DAY_OF_YEAR)) {
            eta--;
        }

        return eta;
    }
}
