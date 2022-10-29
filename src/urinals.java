import java.util.ArrayList;
import java.util.*;
import java.io.*;


public class urinals {
    public static int getUrinals(String string){
        //Have fun :)
        int[] urinal = new int[string.length()];
        String[] strings = string.split("");
        int count = 0;
        for (int i = 0; i < urinal.length; i++) urinal[i] = Integer.parseInt(strings[i]);


        for (int j = 0; j < urinal.length; j++) {
            if (j - 1 >= 0 && urinal[j - 1] == 1 && urinal[j] == 1) return -1;
            if (j + 1 < urinal.length && urinal[j + 1] == 1 && urinal[j] == 1) return -1;
            if (urinal[j] == 1) continue;
            if (j - 1 >= 0 && urinal[j - 1] == 1) continue;
            if (j + 1 < urinal.length && urinal[j + 1] == 1) continue;

            urinal[j] = 1;
            count++;
        }
        return count;
    }


    public static boolean validate(String string){
        if (string.length()>20) return false;
        if (string.length()<1) return false;
        if (string.contains("11")) return false;
        char[] valid = string.toCharArray();
        for (int i = 0; i < valid.length - 1; i++){
            if(valid[i]!='0'&& valid[i]!='1') {
                return false;
            }
        }
        return true;
    }


    public static String getInput(String string) throws Exception {
        if(string.equals("1")){
            return keyboard();
        }
        else if(string.equals("2")){
            return File("src/urinal.dat");
        }
        return "Choose 1 or 2";
    }


    public static String keyboard(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Input: ");
        String str = scan.next();
        boolean n = validate(str);
        int result = 0;
        if(n)
            result = getUrinals(str);
        String val = String.valueOf(result);
        return val;
    }


    public static String File(String path) throws Exception {
        try{
            File file = new File(path);
            if(file.length()==0)
                throw new Exception("Empty File");
            else{

                ArrayList<Integer> counter =new ArrayList<Integer>();
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String string;

                while((string = reader.readLine())!=null){
                    counter.add(getUrinals(string));
                }
                for (Integer value : counter) {
                    System.out.println(value);
                }
                StringBuilder str = new StringBuilder();
                for (Integer value : counter) {
                    str.append(" ").append(value);
                }
                reader.close();
                File rule = new File("src/rule.txt");
                int buff=1;
                while(rule.exists()){
                    rule = new File("src/rule"+buff+".txt");
                    buff++;
                }
                FileWriter writer = new FileWriter(rule);
                for (Integer integer : counter) {
                    writer.write(integer + "\n");
                }
                writer.close();
                return str.toString();
            }

        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }


    public static void main(String[] args) throws Exception {
        System.out.println("Enter 1 to input from Keyboard and 2 to input from file");
        Scanner scan = new Scanner(System.in);
        String string = scan.next();
        String str= getInput(string);
        System.out.println(str);
    }


}

