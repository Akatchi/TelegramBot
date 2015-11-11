package controllers;

import java.io.*;
import java.util.Properties;

/**
 * Created by Vasco on 11/11/2015.
 * Singleton Controller to handle the usage of the property file
 */
public class PropertiesController
{
    private static PropertiesController ourInstance = new PropertiesController();
    private OutputStream output;
    private InputStream input;
    private Properties properties;

    public static PropertiesController getInstance()
    {
        return ourInstance;
    }

    private PropertiesController()
    {
        // Initialize the controller
        // By loading the porperty file
        properties = new Properties();

        try
        {
            // Set the input and output to the property file
            File propertyFile = new File("src/app.properties");

            input = new FileInputStream(propertyFile);
            output = new FileOutputStream(propertyFile, true);

            properties.load(input);
        }
        catch( IOException e )
        {
            e.printStackTrace();
        }
    }

    public String getProperty(String key)
    {
        if( properties != null )
        {
            return properties.getProperty(key);
        }

        return null;
    }

    // Method to return the default value if the property doesnt exist
    public String getProperty(String key, String defaultValue)
    {
        if( properties != null )
        {
            return properties.getProperty(key, defaultValue);
        }

        return defaultValue;
    }

    // Method to set a property (we enable the override falg in this method by default)
    public void setProperty(String key, String value)
    {
        setProperty(key, value, true);
    }

    public void setProperty(String key, String value, boolean override)
    {
        if( properties != null)
        {
            // If we need to override the property by default
            // We dont need to check if the property exists
            if( override )
            {
                properties.setProperty(key, value);
            }
            else
            {
                // We need to check if the key exists
                // If this is teh case we shouldnt do anything
                // Otherwise create the key
                if( properties.getProperty(key) == null )
                {
                    properties.setProperty(key, value);
                }
            }

            try
            {
                // Save the changes
                properties.store(output, null);
            }
            catch( IOException e )
            {
                e.printStackTrace();
            }
        }
    }


}
