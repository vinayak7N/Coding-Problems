import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       int stringSize=Integer.parseInt(br.readLine());
       String[] strArray=new String[stringSize];
       HashMap<String,Integer> strMap=new HashMap<>();

       for(int index=0;index<stringSize;index++){
           String s=br.readLine();
           if(strMap.get(s)!=null){
               strMap.put(s,strMap.get(s)+1);
           }else{
               strMap.put(s,1);
           }
       }
        int querySize=Integer.parseInt(br.readLine());
        for(int index=0;index<querySize;index++){
             String s=br.readLine();
             Integer count=strMap.get(s);
             if(count!=null)
                System.out.println(count);
             else
                System.out.println(0);
        }
    }
}
