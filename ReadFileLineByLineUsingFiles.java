import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class ReadFileLineByLineUsingFiles {

        public static Map<String,List<BigDecimal>> createMapFromInputFile(List<String> allLines ){
            Map<String, List<BigDecimal>> map=new LinkedHashMap<>();
            List<BigDecimal>  priceLists=new ArrayList<>();

            for (String line : allLines) {
                if(!line.chars().allMatch(y -> (Character.isDigit(y))|| y=='.')) {
                    priceLists=new ArrayList<>();
                    map.put(line, priceLists);
                }
                else{
                    priceLists.add(new BigDecimal(line));
                }

            }
            System.out.println(" ****** This is original Map ******");
            System.out.println(map);
            return map;
        }
        public static Map<String,BigDecimal> getThelatestPriceForEachElement(Map<String, List<BigDecimal>> map){
             Map<String,BigDecimal> elementToMap=new HashMap<>();
             map.entrySet().stream().forEach(x->
             {
                 int positionOFLastElement=x.getValue().size()-1;
                 BigDecimal price=x.getValue().get(positionOFLastElement);
                 elementToMap.put(x.getKey(),price);
             });
            System.out.println(" ****** This is final Map ******");
            System.out.println(elementToMap);
            return elementToMap;

        }
        public static void main(String[] args) {
            /**
             * read the file and put all of the content in List of String
             */
            List<String> allLines=new ArrayList<>();
            try {
                allLines = Files.readAllLines(Paths.get("/Users/mpourhoma/IdeaProjects/untitled1/src/inputFile.txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Map<String,BigDecimal>  MapElementToLatestPrice=getThelatestPriceForEachElement(createMapFromInputFile(allLines));
        }

    }

