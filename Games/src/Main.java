import test.GameProgress;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        GameProgress gameProgress1 = new GameProgress(20, 50, 2, 105);
        GameProgress gameProgress2 = new GameProgress(50, 70, 10, 1105);
        GameProgress gameProgress3 = new GameProgress(80, 40, 7, 505);

    }

    public static void saveGame(String path, GameProgress gameProgress) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(gameProgress);
            objectOutputStream.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void zipFiles(String pathArchive, String pathFile) {
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(pathArchive));
            FileInputStream fileInputStream = new FileInputStream(pathFile);
            ZipEntry zipEntry = new ZipEntry("packed.txt");
            zipOutputStream.putNextEntry(zipEntry);
            byte[] buffer = new byte[fileInputStream.available()];

            int byteRead = fileInputStream.read();

            while (byteRead != -1) {
                System.out.println((char) byteRead);
                byteRead = fileInputStream.read();
            }

            zipOutputStream.write(byteRead);
            zipOutputStream.closeEntry();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void newDi() throws IOException {
        StringBuilder builder = new StringBuilder();

        String currentDir = System.getProperty("user.dir");
        System.out.println(currentDir);

        File dir1 = new File(currentDir, "src");
        if (dir1.mkdir()) {
            builder.append("Дирректория src создана по пути - ").append(dir1).append("\n");
        }

        File dir11 = new File(dir1, "main");

        if (dir11.mkdir()) {
            builder.append("Дирректория main создана по пути - ").append(dir1).append("\n");
        }

        try {
            File file121 = new File(dir11, "Main.java");
            if (file121.createNewFile()) {
                builder.append("Файл Main.java создан по пути - ").append(file121).append("\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            File file122 = new File(dir11, "Utils.java");
            if (file122.createNewFile()) {
                builder.append("Файл src создан по пути - ").append(file122).append("\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        File dir12 = new File(dir1, "test");
        if (dir12.mkdir()) {
            builder.append("Дирректория test создана по пути - ").append(dir12).append("\n");
        }

        File dir2 = new File(currentDir, "res");
        if (dir2.mkdir()) {
            builder.append("Дирректория res создана по пути - ").append(dir2).append("\n");
        }

        File dir21 = new File(dir2, "drawables");
        if (dir21.mkdir()) {
            builder.append("Дирректория drawables создана по пути - ").append(dir21).append("\n");
        }

        File dir22 = new File(dir2, "vectors");
        if (dir22.mkdir()) {
            builder.append("Дирректория vectors создана по пути - ").append(dir22).append("\n");
        }

        File dir23 = new File(dir2, "icons");
        if (dir23.mkdir()) {
            builder.append("Дирректория icons создана по пути - ").append(dir23).append("\n");
        }

        File dir3 = new File(currentDir, "savegames");
        if (dir3.mkdir()) {
            builder.append("Дирректория savegames создана по пути - ").append(dir3).append("\n");
        }

        File dir4 = new File(currentDir, "temp");
        if (dir4.mkdir()) {
            builder.append("Дирректория temp создана по пути - ").append(dir4).append("\n");
        }

        try {
            File file41 = new File(dir4, "temp.txt");
            if (file41.createNewFile()) {
                builder.append("Файл temp.txt создан по пути - ").append(file41).append("\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        String w = builder.toString();
        System.out.println(builder.toString());
        FileWriter fileWriter = new FileWriter("temp/temp.txt");
        fileWriter.write(w);
        fileWriter.close();
    }

}