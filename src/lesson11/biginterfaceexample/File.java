package lesson11.biginterfaceexample;

public class File {
    private String name;
    private String path;
    private String extension;
    private int sze;

    public File(String name, String path, String extension, int sze) {
        this.name = name;
        this.path = path;
        this.extension = extension;
        this.sze = sze;
    }


    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getExtension() {
        return extension;
    }

    public int getSize() {
        return sze;
    }

}
