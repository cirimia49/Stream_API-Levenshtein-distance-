# Stream JAVA API

The following project reads the content of a file and turns it into a stream and calculate the Levenshtein distance
between the possible combinations of strings. 

This distance is a measure of how many changes need to be made to the
first string to convert it to the second string. 

For more info on this: https://en.wikipedia.org/wiki/Levenshtein_distance

It uses a parallel stream and a regular stream to calculate the Levenshtein distance between all
pairs of words in a random generation of words from words_alpha.txt for: 
10 words, 20 words, 50 words, 100 words, 500 words, 1000 words, and 5000 words(the content of number.txt file).

Then it calculates the time in milliseconds to do the calculations and outputs each different scenario. 
