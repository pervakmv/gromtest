package lesson18;

public class Defenition {

    private void notifyUsers(String[] userEmails) {

        for (String email : userEmails) {
            try{

                //send email to user - error
                System.out.println("Email" + email + " was sent");
                //
                //
                //
                //updateStatus
            }catch(Exception e){
                //how should I handle exception
                System.err.println("Email" + email + " was not sent");
            }finally{
                //update status
            }
//            catch(type2 e){
//
//            }

            //1
            //2
            //3
        }

    }
}
