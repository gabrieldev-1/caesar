import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
    private static final String mark = """
    /$$$$$$                                                   
    /$$__  $$                                                  
    | $$  \\__/  /$$$$$$   /$$$$$$   /$$$$$$$  /$$$$$$   /$$$$$$ 
    | $$       |____  $$ /$$__  $$ /$$_____/ |____  $$ /$$__  $$
    | $$        /$$$$$$$| $$$$$$$$|  $$$$$$   /$$$$$$$| $$  \\__/
    | $$    $$ /$$__  $$| $$_____/ \\____  $$ /$$__  $$| $$      
    |  $$$$$$/|  $$$$$$$|  $$$$$$$ /$$$$$$$/|  $$$$$$$| $$      
    \\______/  \\_______/ \\_______/|_______/  \\_______/|__/
                                             Caesar v1.1
                                             Author: gabrieldev-1
        """;

    public static void help() {
        System.out.println(mark + "\n");
        System.out.println("Commands");
        System.out.println("help: caesar -h");
        System.out.println("encrypt     -e <input_file.txt> <key> <output_file.txt>");
        System.out.println("decrypt     -d <input_file.txt> <key> <output_file.txt>");


    }
    
    public static void main(String[] args) {
        if(args.length < 4) {
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
        final String OUTPUT_FILE = args[3];

        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE)); 
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
                String line;
                String encryptedLine;
                Encryptor encryptor = new Encryptor();

                while((line = reader.readLine()) != null) {
                    encryptedLine = encryptor.encrypt(line, key);

                    writer.write(encryptedLine);
                    writer.newLine();

                }


        } catch(IOException e) {
            System.err.println("ERROR: Something went wrong while trying to read the file.");
        }
    }
}