package calendar;

import calendar.entities.Event;
import calendar.entities.User;

import java.util.Iterator;
import java.util.List;

public class EventManager {

    public static void createEvent(User user,Event event){
            User invitedUser;
            user.getCreatedEvent().add(event);
            System.out.println("User "+user.getEmailId()+" has created an event for timing "+event.getDate());
            if(event.getInvited().size() > 0){
                for(int i=0;i<event.getInvited().size();i++ ){
                    invitedUser = event.getInvited().get(i);
                    invitedUser.getInvitedEvent().add(event);
                }
            }
    }
    public static void sendInvite(User user,Event event){
        event.getInvited().add(user);
        user.getInvitedEvent().add(event);
        System.out.println("User "+user.getEmailId()+" has been invited");
    }

    public static void sendInvite(List<User> userList,Event event){
        User user;
        if(userList.size() > 0){
            for(int i=0;i<userList.size();i++ ){
                user = userList.get(i);
                event.getInvited().add(user);
                user.getInvitedEvent().add(event);
            }
        }
    }
    
    public static void acceptInvite(User user, Event event){
        if(event.getInvited().contains(user)){
            user.getAcceptedEvent().add(event);
            event.getAccepted().add(user);
            user.getRejectedEvent().remove(event);
            event.getRejected().remove(event);
            System.out.println("User "+user.getEmailId()+" has accepted invitation");
        }else{
            System.out.println("This user is not invited");
        }
    }

    public static void rejectInvite(User user, Event event){
        if(event.getInvited().contains(user)){
            user.getRejectedEvent().add(event);
            event.getRejected().add(user);
            user.getAcceptedEvent().remove(event);
            event.getAccepted().remove(event);

            System.out.println("User "+user.getEmailId()+" has rejected invitation");
        }else{
            System.out.println("This user is not invited");
        }
    }

    public static void  showEventGuest(Event event){
        if(event == null){
            return;
        }
        System.out.println("User invited for the event : "+ event.getTitle());
        for(int i=0;i < event.getInvited().size();i++){
            System.out.println("User : "+event.getInvited().get(i).getEmailId());
        }
        System.out.println("User accepted for the event : "+ event.getTitle());
        for(int i=0;i < event.getAccepted().size();i++){
            System.out.println("User : "+event.getAccepted().get(i).getEmailId());
        }
        System.out.println("User rejected for the event : "+ event.getTitle());
        for(int i=0;i < event.getRejected().size();i++){
            System.out.println("User : "+event.getRejected().get(i).getEmailId());
        }

    }

    public static void showCalender(User user){
        if(user == null){
            return;
        }
        Iterator<Event> iterator = user.getInvitedEvent().iterator();
        System.out.println("Invited for the event : ");
        while(iterator.hasNext()){
            System.out.println("User : "+iterator.next().getTitle());
        }
        iterator = user.getAcceptedEvent().iterator();
        System.out.println("Accepted for the event :");
        while(iterator.hasNext()){
            System.out.println("User : "+iterator.next().getTitle());
        }
        iterator = user.getRejectedEvent().iterator();
        System.out.println("Rejected for the event : ");
        while(iterator.hasNext()){
            System.out.println("User : "+iterator.next().getTitle());
        }

    }
}
