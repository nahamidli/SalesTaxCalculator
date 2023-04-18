package com.interview.salestaxcalculator.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ItemPropertiesReader {

    public static String[] getExemptItemTypes() {

        Properties props = new Properties();
        try {
            // Load the properties file
            InputStream inputStream = ItemPropertiesReader.class.getClassLoader().getResourceAsStream("item-types.properties");
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }

        // Get the property value and split it by comma
        String propertyValue = props.getProperty("exempt.item.types");
        if (propertyValue != null) {
            return propertyValue.split(",");
        } else {
            return new String[0];
        }
    }
}
