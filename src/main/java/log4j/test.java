package log4j;

import org.apache.log4j.PropertyConfigurator;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.*;

public class test {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String nameFile = "src/main/resources/log4j.properties";
        PropertyConfigurator.configure(nameFile);


        Logger LOG = Logger.getRootLogger();

        Logger localLog2 = Logger.getLogger("logfile");

        Enumeration append = LOG.getAllAppenders();

        while (append.hasMoreElements()) {


            LOG.info("Available appender " + append.nextElement());

        }

        LOG.info("Hi Logger info!");
        localLog2.warn("logfile write!");
        System.out.println("LOG.equals(localLog) is " + LOG.equals(localLog2));
    }
}

