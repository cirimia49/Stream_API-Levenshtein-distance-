package package1;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class RegularStream {

    public static void operationsRegularStream(String numberOfTimes)throws IOException {

        int n = Integer.parseInt(numberOfTimes);

        List<String> wordsFromStream = (Streams.readStream(n));

        Instant start = Instant.now();
        List<Integer> words = //Save them just in case i want to print all distances
                wordsFromStream.stream()
                        .flatMap(str1 -> wordsFromStream.stream().map(str2 -> Levenshtein.calculateEditDistance(str1, str2)))
                        .collect(Collectors.toList());

        //words.forEach(s -> System.out.println(s));
        Instant stop = Instant.now();
        Long time = Duration.between(start, stop).toMillis();
        System.out.println("TIME is: "  + time + " milliseconds");
    }

}
