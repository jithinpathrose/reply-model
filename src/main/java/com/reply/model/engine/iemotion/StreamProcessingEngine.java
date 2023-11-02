package com.reply.model.engine.iemotion;

import java.util.stream.Stream;

public class StreamProcessingEngine<T> {

    public void processStreamInOrder(Stream<String> stream){
        /*anyMatch()
noneMatch()
mapToLong()
findAny()
forEachOrdered()
forEach()
allMatch()
filter()
findFirst()
flatMapToInt()
mapToInt()
map()
peek()
counting()
Iterator()
Generate()
Skip()
SummaryStatistics()
Builder()
Empty()
Stream toArray()
Sum of list with stream filter
        * */

        boolean hasMatch = stream.anyMatch(n -> n.equals("yes")); // returns a boolean
        boolean noneMatching = stream.noneMatch(n -> n.endsWith("//")); // returns a boolean

        double doubleAverage = stream.mapToLong(n -> Long.valueOf(n)).average().getAsDouble();

    }
}
