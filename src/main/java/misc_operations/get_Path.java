package misc_operations;

public class get_Path {

        public static String GetFile(String filename) {
            String absoluteFilePath = "";
            try {

                String your_os = System.getProperty("os.name").toLowerCase();
                String workingDir;

                workingDir = System.getProperty("user.dir");
                String directoryName;
                if (your_os.contains("win")) {
                    directoryName = "src\\main\\resources\\";
                    absoluteFilePath = workingDir + "\\" + directoryName + "\\" + filename;
                } else if (your_os.contains("nix") ||
                        your_os.contains("nux") ||
                        your_os.contains("mac")) {
                    directoryName = "src/main/resources/";
                    absoluteFilePath = workingDir + "/" + directoryName + "/" + filename;
                } else {
                    directoryName = "src/main/resources/";
                    absoluteFilePath = workingDir + "/" + directoryName + "/" + filename;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return absoluteFilePath;

        }

}



