package common.connector;

import org.apache.log4j.Logger;

import java.util.ArrayList;

public class ADB {
    private static Logger LOG = Logger.getLogger(ADB.class);

    public static ArrayList getConnectionDevices() {
        ArrayList devices = new ArrayList();
        LOG.info("Command line command adb devices");
        String output = "adb devices";
        for (String line : output.split("\n")) {
            line = line.trim();
            if (line.endsWith("devices")) devices.add(line.replace("device", "").trim());
        }
        return devices;
    }
}
