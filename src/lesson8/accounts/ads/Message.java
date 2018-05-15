package lesson8.accounts.ads;

import java.util.Date;

public class Message extends BaseEntity {
    long id;
    User userFrom;
    User userTo;
    Date dateSent;
    Date dateRead;
    String message;


    public Message(int id, User userFrom, User userTo, Date dateSent, Date dateRead, String message) {
        super(id);
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.dateSent = new Date();
        this.message = message;
    }

    void setDateRead(){
        dateRead = new Date();
    }

    boolean isRead(){
     return dateRead == null;
    }
}
