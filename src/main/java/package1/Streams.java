package package1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) throws IOException {

        List<String> num = numberOfOperations();

       // Since the results if running both streams at the same time will be skewed I suggest in running the streams separately

//        // Operations performed while using regular stream
//        System.out.println("Operations performed while using regular stream" + "\n");
//            for (String i : num) {
//                System.out.println("When noWords is: " + i);
//                RegularStream.operationsRegularStream(i);
//
//                System.out.println("--------------------------------");
//            }


        // Operations performed while using parallel stream
        System.out.println("Operations performed while using parallel stream");
        for (String i : num) {
            System.out.println("When noWords is: " + i);
            ParallelStream.operationsParallelStream(i);
            System.out.println("--------------------------------");
        }

    }

    public static List<String> numberOfOperations() throws IOException{

        Path path  = Path.of(ClassLoader.getSystemClassLoader().getResource("number.txt").getFile());

        Stream<String> repetitions = Files.lines(path);

        List<String> numberOfChoices = repetitions.collect(Collectors.toList());
        return numberOfChoices;
    }


    public static List<String> readStream(int number) throws IOException{
        Path path  = Path.of(ClassLoader.getSystemClassLoader().getResource("words_alpha.txt").getFile());

        Stream<String> words = Files.lines(path);

        List<String>  list = words.collect(Collectors.toList());

        return generateRandomWords(list, number);
    }

    public static List<String> generateRandomWords(List<String> myWords, int numberWords){
        List <String> list = myWords.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), collected ->{
                    Collections.shuffle(collected);
                    return collected.stream();
                }))
                .limit(numberWords)
                .collect(Collectors.toList());

        return list;
    }

}
