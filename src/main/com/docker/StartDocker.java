package com.docker;

import org.testng.Assert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import static java.util.Calendar.SECOND;

public class StartDocker {

    public void startHubAndScaleDockerNodes() throws IOException, InterruptedException {
        boolean flag = false;
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("cmd /c start dockerUp.bat");

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
                if (currentLine.contains("Node has been added")) {
                    System.out.println("Node has been added!!!!!");
                    flag = true;
                    break;
                }
                currentLine = reader.readLine();
            }
            reader.close();
        }

        Assert.assertTrue(flag);

        runtime.exec("cmd /c start dockerScale.bat");
        Thread.sleep(10000);
    }
}
