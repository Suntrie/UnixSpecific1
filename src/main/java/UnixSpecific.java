import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// Sample Java program to print highest CPU process in a linux system
// Note that this program itself may be reported as the top process!
public class UnixSpecific {

    static final Logger rootLogger = LoggerFactory.getLogger(UnixSpecific.class);

    public static void main(String[] args) throws Exception {

        printAllProcesses();
    }
    // Java example program to display the names of all running linux processes
    public static List<String> printAllProcesses() throws Exception{

        System.out.println(rootLogger.isInfoEnabled());

        Process process = Runtime.getRuntime().exec("ps -Ao pid=,pcpu=");
        BufferedReader r =  new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = null;

        List <String> result = new ArrayList<String>();

        while((line=r.readLine())!=null) {
            System.out.println(line);
            rootLogger.info(line);
            result.add(line);
        }

        return result;
    }
}