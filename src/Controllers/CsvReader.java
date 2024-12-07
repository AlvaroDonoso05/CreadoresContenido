package Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import Models.Metrica;

public class CsvReader {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private List<Metrica> archivoCsv;
    private final String url;

    public CsvReader(String url) {
        this.url = url;
        this.archivoCsv = abrirCSV();
    }

    public List<Metrica> abrirCSV() {
        List<Metrica> metricas = null;
        try {
            FileReader reader = new FileReader(this.url);

            CsvToBeanBuilder<Metrica> csvBuilder = new CsvToBeanBuilder<>(reader);
            CsvToBean<Metrica> csv = csvBuilder.withType(Metrica.class).withIgnoreLeadingWhiteSpace(true).build();

            metricas = csv.parse();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return metricas;
    }

    public List<Metrica> obtenerPorId(int id) {
        List<Metrica> metricaCreador = new ArrayList<>();

        for (Metrica metrica : this.archivoCsv) {
            if (metrica.getIdCreador() == id) {
                metricaCreador.add(metrica);
            }
        }

        return metricaCreador;
    }

    public List<Metrica> obtenerPorRedSocial(int id, String redSocial) {
        List<Metrica> metricaCreador = new ArrayList<>();

        for (Metrica metrica : this.archivoCsv) {
            if (metrica.getIdCreador() == id && metrica.getPlataforma().equalsIgnoreCase(redSocial)) {
                metricaCreador.add(metrica);
            }
        }

        return metricaCreador;
    }

    public ObjectNode obtenerContenidosPlataforma(int id, String plataforma) {
        ObjectNode rootNode = objectMapper.createObjectNode();

        for (Metrica metrica : archivoCsv) {
            if (metrica.getIdCreador() == id && metrica.getPlataforma().equalsIgnoreCase(plataforma)) {
                ObjectNode contenido = objectMapper.createObjectNode();
                contenido.put("vistas", metrica.getVistas());
                contenido.put("me_gusta", metrica.getMeGusta());

                rootNode.set(metrica.getContenido(), contenido);
            }
        }

        return rootNode;

    }

    public List<Metrica> getArchivoCsv() {
        return archivoCsv;
    }

    public void setArchivoCsv(List<Metrica> archivoCsv) {
        this.archivoCsv = archivoCsv;
    }
}
