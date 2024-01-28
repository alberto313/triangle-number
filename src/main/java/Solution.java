import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {

    public static String decode(String filePath) {
        List<String> content = new ArrayList<>();
        String decodedMessage = "";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.add(line);
            }

            Map<Integer, String> map = new HashMap<>();
            for (String listLine : content) {
                String[] parts = listLine.split("\\s");
                int number = Integer.parseInt(parts[0]);
                String word = parts[1];
                map.put(number, word);
            }

            List<Integer> sortedNumbers = new ArrayList<>(map.keySet());
            Collections.sort(sortedNumbers);
            List<List<Integer>> pyramid = new ArrayList<>();
            int initIndex = 0;
            int lastIndex = 1;
            for (int i = 1; i < sortedNumbers.size(); i++) {
                lastIndex = i * (i + 1) /2;
                if (lastIndex > sortedNumbers.size())
                    break;
                pyramid.add(new ArrayList<>(sortedNumbers.subList(initIndex, lastIndex)));
                initIndex = lastIndex;
            }

            List<String> messageWords = new ArrayList<>();
            pyramid.forEach(x -> messageWords.add(map.get(x.get(x.size() - 1))));

            decodedMessage = String.join(" ", messageWords);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return decodedMessage;
    }

    public static void main(String[] args) throws IOException {
        String filePath = "/Users/albertorodriguez/Downloads/pyramid/src/main/resources/coding_qual_input.txt";

        String decodedMessage = decode(filePath);
        System.out.println(decodedMessage);
    }
}