package com.docker;

import org.testng.Assert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import static java.util.Calendar.SECOND;

public class StopDocker {

    public void stopHubAndNodes() throws IOException, InterruptedException {
        boolean flag = false;
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("cmd /c start dockerDown.bat");

        String file = "output.txt";

        Calendar calendar = Calendar.getInstance();
        calendar.add(SECOND, 45);
        long stopNow = calendar.getTimeInMillis();

        Thread.sleep(3000); //to check if a output.txt file created

        while (System.currentTimeMillis() < stopNow) {

            if (flag) {
                break;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String currentLine = reader.readLine();
            while (currentLine != null) {
                if (currentLine.contains("Shutdown complete")) {
                    System.out.println("Shutdown complete!!!!!");
                    flag = true;
                    break;
                }
                currentLine = reader.readLine();
            }
            reader.close();
        }

        Assert.assertTrue(flag);
    }


}
