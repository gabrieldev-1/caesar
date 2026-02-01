import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.StringBuilder;

public class Main {
    private static final String mark = """
    /$$$$$$                                                   
    /$$__  $$                                                  
    | $$  \\__/  /$$$$$$   /$$$$$$   /$$$$$$$  /$$$$$$   /$$$$$$ 
    | $$       |____  $$ /2$$__  $$ /$$_____/ |____  $$ /$$__  $$
    | $$        /$$$$$$$| $$$$$$$$|  $$$$$$   /$$$$$$$| $$  \\__/
    | $$    $$ /$$__  $$| $$_____/ \\____  $$ /$$__  $$| $$      
    |  $$$$$$/|  $$$$$$$|  $$$$$$$ /$$$$$$$/|  $$$$$$$| $$      
    \\______/  \\_______/ \\_______/|_______/  \\_______/|__/
                                             Caesar v1.2
                                             Author: gabrieldev-1
        """;

    public static void help() {
        System.out.println(mark + "\n");
        System.out.println("Usage:");
        System.out.println("  caesar <flag> <input_file> [key] [output_file]");
        System.out.println("\nFlags:");
        System.out.println("  -e    Encrypt the input file.");
        System.out.println("  -d    Decrypt the input file.");
        System.out.println("  -h    Show this help message.");
        System.out.println("\nArguments:");
        System.out.println("  <input_file>   Path to the file to be processed.");
        System.out.println("  <key>          Integer value for the cipher shift (Required for -e and -d).");
        System.out.println("  [output_file]  Optional. If omitted, the input file will be modified (In-place).");
        System.out.println("\nExamples:");
        System.out.println("  caesar -e secret.txt 12             # Encrypts in-place");
        System.out.println("  caesar -d secret.txt 12 plain.txt   # Decrypts to a new file");

    }
    
    public static void main(String[] args) {
        if(args.length <= 0) {
            help();
            return;
        }

        String mode = args[0];
        if (mode.equals("-h") || mode.equals("--help")) {
            help();
            return;
        }

        int key;
        try {
            key = Integer.parseInt(args[2]);

        } catch(NumberFormatException e) {
            System.err.println("ERRO: The key must be a number.");
            return;

        }

        if(mode.equals("-d")) {
            key = 26 - (key % 26);
        
        } else if (!mode.equals("-e")) {
            System.err.println("ERRO: Enter a valid parameter.");
            help();
            return;
        }

        final String INPUT_FILE = args[1];
        final String OUTPUT_FILE;

        if(args.length > 3) {
            OUTPUT_FILE = args[3];

        } else {
            OUTPUT_FILE = INPUT_FILE; 
        
        }
        
        StringBuilder sb = new StringBuilder();

        try {
            try(BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE))) {
                String line;
                while((line = reader.readLine()) != null ) {
                    sb.append(line).append(System.lineSeparator());
                }
            }

            Encryptor encryptor = new Encryptor();
            String finalContent = encryptor.encrypt(sb.toString(), key);
        
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(INPUT_FILE))) {
                writer.write(finalContent);
            }

            System.out.println("File processed successfully.");
        
        } catch (IOException e) {
            System.out.println("[ERROR] " + e.getMessage());
        
        } catch (NumberFormatException e ) {
            System.out.println("[ERROR] " + e.getLocalizedMessage());
        }

    }
}