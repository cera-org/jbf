import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileReaderForJBF {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner i = new Scanner(new FileReader(args[0]));
        try {
            StringBuilder sb = new StringBuilder();

            while (i.hasNext()) {
                sb.append(i.next());
            }

            String stdin = "";
            if (args.length > 1) {
                stdin = args[1];
            }

            System.out.println(JBF.interpretBrainfuck(sb.toString(), stdin));
        } finally {
            i.close();
        }
    }
}