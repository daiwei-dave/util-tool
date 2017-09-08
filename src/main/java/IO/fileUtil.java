package IO;


import java.io.File;
import java.io.IOException;

/**
 * Created by daiwei on 2017/8/29.
 */
public class fileUtil {
    public static void main(String[] args) {
        File f=new File("F:\\gome\\IM_ModelStore\\gome-store\\竞争力模型-标准值-201733.xlsx");
        try {
            System.out.println(f.getCanonicalPath());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Sorry,can't get canonical path");
        }
        boolean delete = f.delete();

        //      recurDelete(f);
    }

    public static void recurDelete(File f){
        try{
            for(File fi:f.listFiles()){
                if(fi.isDirectory()){
                    recurDelete(fi);
                }
                else{
                    fi.delete();
                }
            }
            f.delete();
        }
        catch(NullPointerException n){
            System.out.println("Sorry,No such file");
        }
    }

}
