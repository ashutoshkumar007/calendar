package calendar.test;

import calendar.EventManager;
import calendar.entities.Event;
import calendar.entities.User;

import java.util.ArrayList;
import java.util.Date;

public class Driver {

    public static void main(String args[]){
        Date date = new Date();
        date.setYear(2001);
        date.setMonth(3);
        User user1 = new User();
        user1.setEmailId("aman@gmail.com");
        User user2 = new User();
        user2.setEmailId("ajay@gmail.com");
        User user3 = new User();
        user3.setEmailId("ashu@gmail.com");
        User user4 = new User();
        user4.setEmailId("anant@gmail.com");

        Event event1 = new Event();
        event1.setCreatedBy(user1);
        event1.setTitle("Testing event 1");
        event1.setDate(new Date());

        Event event2 = new Event();
        event2.setCreatedBy(user1);
        event2.setTitle("Testing event 2");
        event2.setDate(date);

        EventManager.createEvent(user1,event1);
        EventManager.sendInvite(user2,event1);
        EventManager.sendInvite(user2,event2);
        EventManager.sendInvite(user3,event1);
        EventManager.acceptInvite(user2,event1);
        EventManager.rejectInvite(user3,event1);
        EventManager.showEventGuest(event1);

        EventManager.showCalender(user2);


    }
}
