import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("cod.txt"));
            BufferedWriter fl = new BufferedWriter(new FileWriter("fixcod.txt"))){

            int s;
            StringBuffer cods = new StringBuffer();
            while((s = br.read())!=-1){
                cods.append((char) s);
            }

            Pattern pattern = Pattern.compile("(/\\*.*?\\*/)|(//[^\n]*)", Pattern.DOTALL);
            Matcher matcher = pattern.matcher(cods.toString());
            StringBuffer fixcods=new StringBuffer(matcher.replaceAll(""));
            fl.write(fixcods.toString());
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}