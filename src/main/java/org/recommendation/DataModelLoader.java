package org.recommendation;

import org.apache.log4j.Level;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class DataModelLoader {

    public static DataModel ModelFromFile(String path) throws IOException {
        Logger.getRootLogger().setLevel(Level.OFF);
        File file = new File(path);
        return new FileDataModel(file);
    }

}
