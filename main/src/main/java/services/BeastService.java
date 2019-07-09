package services;

import beans.Beast;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeastService {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public List<Beast> getAllBeasts() throws IOException {
        List<Beast> beasts = new ArrayList<>();
        File folder = new File("src/main/resources/beasts");
        File[] listOfFiles = folder.listFiles();
        for(File file : listOfFiles){
            beasts.add(objectMapper.readValue(file, Beast.class));
        }
        return beasts;
    }
}
