package com.yck12.dicom;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

@Slf4j
@Data
public class TagTitleUtils {

    private static final Properties PROP = new Properties();
    public static final String FILE_NAME = "tags.properties";

    public static String getTitle(String key) {
        return PROP.getProperty(key, key);
    }

    static {
        URL url = TagTitleUtils.class.getClassLoader().getResource("tags.properties");
        InputStream fis = null;
        try {
            fis = url.openStream();
            PROP.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
