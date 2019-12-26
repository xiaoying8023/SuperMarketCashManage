package Util;
public class GetFilePath {
    /**
     * 获取文件路径
     * @param str
     * @return
     */
    public String getFilePath(String str) {
        String currentPath1 = getClass().getResource(str).getFile();
        return currentPath1;
    }


}

