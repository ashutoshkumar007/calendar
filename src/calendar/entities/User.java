package calendar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String emailId;
    private Set<Event> createdEvent = new TreeSet<>();
    private Set<Event> invitedEvent = new TreeSet<>();
    private Set<Event> acceptedEvent= new TreeSet<>();
    private Set<Event> rejectedEvent= new TreeSet<>();

}
