package lambdas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessing {

    public String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("/n");
            }
            return br.readLine();
        }
    }

    public String processFileWithLambda(FileProcessor processor) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return processor.process(br);
        }
    }

    interface FileProcessor {
        String process(BufferedReader br) throws IOException;
    }

    public static void main(String[] args) {
        FileProcessing fileProcessor = new FileProcessing();

        try {
            String line = fileProcessor.processFile();
            System.out.println("First line: " + line);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
