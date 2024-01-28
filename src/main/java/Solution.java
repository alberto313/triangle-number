import java.io.*;
import java.util.*;

public class Solution {

    public static String decode(String fileName) {
        List<String> content = new ArrayList<>();
        String decodedMessage = "";
        InputStream inputStream = Solution.class.getClassLoader().getResourceAsStream(fileName);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
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
            int n = 1;
            boolean lastPyramidFloor = false;
            while (!lastPyramidFloor) {
                lastIndex = n * (n + 1) /2;
                if (lastIndex > sortedNumbers.size()) {
                    lastPyramidFloor = true;
                } else {
                    pyramid.add(new ArrayList<>(sortedNumbers.subList(initIndex, lastIndex)));
                    initIndex = lastIndex;
                    n++;
                }
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
        String filePath = "coding_qual_input.txt";

        String decodedMessage = decode(filePath);
        System.out.println(decodedMessage);
        //down dont nine lot work silver east duck done tone bit stop sun deal huge moment poem hold make like possible clock of bought
    }
}