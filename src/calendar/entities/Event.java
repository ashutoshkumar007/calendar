package calendar.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
public class Event implements Comparable{
    private String title;
    private String description;
    private String meetingUrl;
    private Date date;
    private User createdBy;
    private List<User> invited;
    private List<User> accepted;
    private List<User> rejected;

    public Event(){
        invited = new ArrayList<>();
        accepted = new ArrayList<>();
        rejected = new ArrayList<>();
    }


    @Override
    public int compareTo(Object o) {
        if( o == this)
            return 0;
        Event e = (Event)o;
        return this.date.compareTo(e.date);
    }
}
