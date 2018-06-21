package lesson28;

import java.util.Date;

public class Capability implements Comparable<Capability> {
    //1001, 1005, 900
    //900, 1001, 1005
    private long id;
    private String channelName;
    private String fingerprint;
    private boolean isActive;
    private Date dateCreated;

    public Capability(long id, String channelName, String finerpring, boolean isActive, Date dateCreated) {
        this.id = id;
        this.channelName = channelName;
        this.fingerprint = finerpring;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
    }

    public long getId() {
        return id;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public boolean isActive() {
        return isActive;
    }

    public Date getDateCreated() {
        return dateCreated;
    }


    @Override
    public String toString() {
        return "Capability{" +
                "id=" + id +
                ", channelName='" + channelName + '\'' +
                ", fingerprint='" + fingerprint + '\'' +
                ", isActive=" + isActive +
                ", dateCreated=" + dateCreated +
                '}';
    }

    @Override
    //-1 OR 0 OR 1
    //true OR false
    public int compareTo(Capability capability) {
        System.out.println("compareTo is used");
        return (int)(this.id - capability.getId());

        //before: 1001, 1005, 1004
        //step1: 1001  - 1005 = -4;
    }




}
