import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        Collections.sort(a);
        System.out.println(a);
        int M = a.size();
        ArrayList<Integer> count = new ArrayList<>();
        for(int i=0;i<M;i++){
            //int count = 0;
            ArrayList<Integer> diff = new ArrayList<>();
            diff.clear();
            for(int j=0;j<M;j++){
                if((a.get(i) - a.get(j))<=1 && a.get(i) - a.get(j)>= -1){
                   diff.add(a.get(i) - a.get(j));
                   //System.out.println(a.get(i) - a.get(j)+" <--diff element");
                }
            }
            int minusCount = 0;
            int plusCount = 0;
            int zeroCount = 0;
            for(int j=0;j<diff.size();j++){
                if(diff.get(j)== -1){
                    minusCount++;
                }
                else if(diff.get(j) == 1){
                    plusCount++;
                }
                else{
                    zeroCount++;
                }
            }
            count.add(plusCount+zeroCount);
            count.add(minusCount+zeroCount);
            
            //System.out.println(diff);
        }
        //System.out.println(count);
        return Collections.max(count);
    // Write your code here

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
