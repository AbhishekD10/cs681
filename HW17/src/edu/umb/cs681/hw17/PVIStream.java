package edu.umb.cs681.hw17;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class PVIStream {

    public static void main(String[] args) {

        Path path = Path.of("PVIData.csv");

        try( Stream<String> lines = Files.lines(path) ){
            List<List<String>> matrix = lines.map(line -> {
                        return Stream.of( line.split(",") )
                                .map(value->value.substring(0, value.length()))
                                .collect( Collectors.toList() ); })
                    .collect( Collectors.toList() );
            
            List santaClara = matrix.stream().parallel().filter((i) -> i.get(5).contains("Santa Clara")).collect(Collectors.toList()).get(0);

            List miami = matrix.stream().parallel().filter((i) -> i.get(5).contains("Miami-Dade")).collect(Collectors.toList()).get(0);
            
            String totaldeath = matrix.stream().parallel().filter((i) -> i.get(5).contains("New York"))
                    .map((i) -> i.get(7)).reduce("0", (subtotal, element) -> String.valueOf(Integer.parseInt(subtotal) + Integer.parseInt(element)));
            
            System.out.println("Testing in Santa Clara: " + santaClara.get(15));
            System.out.println("\nTotal no. of deaths in New York: " + totaldeath);
            System.out.println("\nTotal no. of cases in HartFord: " + miami.get(6));
            
        }

        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}