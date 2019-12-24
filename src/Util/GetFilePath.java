package Util;
public class GetFilePath {
    public String getFilePath(String str) {
        String currentPath1 = getClass().getResource(str).getFile().toString();
        return currentPath1;
    }


}

