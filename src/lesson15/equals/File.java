package lesson15.equals;

public class File {
    private int siae;
    private String path;
    private String extension;

    public File(int siae, String path, String extension) {
        this.siae = siae;
        this.path = path;
        this.extension = extension;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        File file = (File) o;
//
//        if (siae != file.siae) return false;
//        if (!path.equals(file.path)) return false;
//        if(!extension.equals(file.extension)) return false;
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = siae;
//        result = 31*result + path.hashCode();
//        result = 31*result + extension.hashCode();
//        return result;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        File file = (File) o;

        return path != null ? path.equals(file.path) : file.path == null;
    }

    @Override
    public int hashCode() {
        return path != null ? path.hashCode() : 0;
    }
}
