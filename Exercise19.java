package Chapter11;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;

public class Exercise19
{
    /*
    Write a method called rarest that accepts a map whose keys are strings and
    whose values are integers as a parameter and returns the integer value that
     occurs the fewest times in the map. If there is a tie, return the smaller
     integer value. If the map is empty, throw an exception.
     */

    public static void main(String[] args)
    {
        Map<String,Integer> map = new HashMap<>();
        map.put("Jack",5);
        map.put("Anna",1);
        map.put("Yuri",2);
        map.put("James",1);
        map.put("Name",2);
        map.put("cake",1);
        map.put("Hans",2);
        map.put("Ida",3);
        map.put("Lars",5);
        map.put("Dennis",3);
        map.put("Mads",3);
        map.put("Steen",3);
        map.put("Frida",3);
        map.put("Marie",3);

        System.out.println(rarest(map));
    }

    public static Integer rarest(Map<String, Integer> map)
    {
        Integer rarest = 100;
        Integer limit = 50;
        Integer occurrence = 0;

        if(map.isEmpty() == true)
        {
            throw new EmptyStackException();

        }

        for (Map.Entry<String, Integer> m1: map.entrySet())
        {
            for (Map.Entry<String, Integer> m2: map.entrySet())
            {
                if(m1.getValue() == m2.getValue())
                {
                    occurrence++;
                }
            }
            if(occurrence <= limit && m1.getValue() < rarest)
            {
                limit = occurrence;
                rarest = m1.getValue();
            }
            occurrence = 0;
        }

        return rarest;

    }
}
