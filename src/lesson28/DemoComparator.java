package lesson28;

import java.util.ArrayList;
import java.util.Date;

public class DemoComparator {
    public static void main(String[] args) {
        Date date1 = new Date(2018, 8, 01);
        Date date2 = new Date(2018, 1, 01);
        Date date3 = new Date(2018, 11, 01);
        Date date4 = new Date(2018, 3, 01);



        Capability capability1 = new Capability(1001, "test", "rrr", false, date1);
        Capability capability2 = new Capability(1005, "test", "bbb", false, date2);
        Capability capability3 = new Capability(1000, "test", "sss", true, date3);
        Capability capability4 = new Capability(900, "test", "aaa", false, date4);



        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);
        capabilities.add(capability4);

        System.out.println(capabilities);

        capabilities.sort(new IsActivecomparator());

        System.out.println(capabilities);

        capabilities.sort(new DateComparator());

        System.out.println(capabilities);

        capabilities.sort(new FullComparator());

        System.out.println("FullComparator " + capabilities);



//        Comparator<Capability> comparator = new Comparator<Capability>(){
//            @Override
//            public int compare(Capability o1, Capability o2) {
//
//                //если channelName  не равно - сравниваю по нему
//                //если равно - переходим к fingerprint
//                //если fingerprint не равно - сравниваю по нему
//                //если равно - переходим к dataCreated
//                //если dateCreated не равно - сравниваю по нему
//                //если равно  - объекты равны
//
//                if(!o1.getChannelName().equals(o2))
//                    return o1.getChannelName().compareTo(o2.getChannelName());
//
//
//                //finish the task
//                return 0;
//
//            }
//        };

    }
}
