package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class Ex183 {
    public static void main(String[] args) {
        PriorityQueue<Message> tasks = new PriorityQueue<>(new MessageComparator());
        tasks.add( new Message( "Treasure Hunt" ) );
        System.out.println( "= " + tasks );

        tasks.add( new Message( "Little Canon, Family Movie Night!" ) );
        System.out.println( "= " + tasks );

        tasks.add( new Message( "Build a pirate ship" ) );
        System.out.println( "= " + tasks );

        System.out.println( tasks.remove() + "\n" + "= " + tasks );
        System.out.println( tasks.remove() + "\n" + "= " + tasks );

        tasks.add( new Message( "Capture the Flag" ) );
        System.out.println( "= " + tasks );

        tasks.add( new Message( "Bury the treasure, Little Canon" ) );
        System.out.println( "= " + tasks );

        tasks.add( new Message( "Little Canon, make a treasure map" ) );
        System.out.println( "= " + tasks );

        for ( int i = 0; i < 4; i++ )
            System.out.println( tasks.remove() + "\n" + "= " + tasks );
    }
}

record Message(String message, LocalDateTime timestamp) {
    Message(String message) {
        this(Objects.requireNonNull(message), LocalDateTime.now());
    }

    @Override
    public String toString() {
        return "'%s', %s".formatted(
                message, timestamp.format(DateTimeFormatter.ofPattern("mm:ss.SSSSSSS"))
        );
    }
}

class MessageComparator implements Comparator<Message> {
    @Override
    public int compare(Message o1, Message o2) {
        String kleiner = "Little";
        if (o1.message().contains(kleiner)) {
            if(o2.message().contains(kleiner)){
                return o1.timestamp().compareTo(o2.timestamp());
            } else {
                return -1;
            }
        } else if (o2.message().contains(kleiner)) {
            return 1;
        } else {
            return o1.timestamp().compareTo(o2.timestamp());
        }
    }
}
