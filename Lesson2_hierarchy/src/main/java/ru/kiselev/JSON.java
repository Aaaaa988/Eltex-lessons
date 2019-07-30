package ru.kiselev;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface JSON {
    String writeToJSON() throws IOException;
    void readFromJSON(String filename) throws IOException;
}
