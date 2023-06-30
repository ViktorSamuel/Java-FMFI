import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReverseFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // BufferedReader in = null;
        while (scanner.hasNext()){
            String file = scanner.next();
            try(BufferedReader in = new BufferedReader(new FileReader(file))){
                // in = new BufferedReader(new FileReader(file));
                StringBuilder builder = new StringBuilder();
                int c;
                while ((c = in.read()) != -1) builder.append((char) c);
                System.out.print(builder.reverse().toString());
            }
            catch (IOException e){
                System.out.println("Chyba pri nacitani suboru.");
            }
//            finally {
//                if(in != null){
//                    try{
//                        in.close();
//                    }
//                    catch (IOException e) {
//                        System.err.println("Chyba pri zatvarani suboru.");
//                    }
//                }
//            }
        }
    }
}
