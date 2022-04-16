package cz.bakterio.discord.Tux;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private File file;
    private BufferedWriter writer;

    public Logger(String filePath) {
        try {
            file = new File(filePath);
            writer = new BufferedWriter(new FileWriter(file, true));

            if (file.exists()) file.delete();

            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(String log) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            String dateString = formatter.format(date);
            writer.append(dateString + " | "  + log + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void simpleLog(String log) {
        try {
            writer.append(log + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}