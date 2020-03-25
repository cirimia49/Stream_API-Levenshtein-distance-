package package1;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStream {

    public static void operationsParallelStream(String numberOfTimes)throws IOException {

        int n = Integer.parseInt(numberOfTimes);

        List<String> wordsFromStream = (Streams.readStream(n));

        Instant start = Instant.now();
        List<Integer> words = //Save them just in case i want to print all distances
                wordsFromStream.parallelStream()
                        .flatMap(str1 -> wordsFromStream.parallelStream().map(str2 -> Levenshtein.calculateEditDistance(str1, str2)))
                        .collect(Collectors.toList());
        Instant stop = Instant.now();
        Long time = Duration.between(start, stop).toMillis();

        //words.forEach(s -> System.out.println(s));
        System.out.println("TIME is: " + time + " milliseconds");

    }

}
