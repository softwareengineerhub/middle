package ch3.sample3;

/**
 * Created by denys on 7/25/2017.
 */
public class MessageData3 {

    public String makeAction() {
        System.out.println("\t\tmakeAction()");
        return "SUCCESS";
    }

    public String makeAction(int param) {
        System.out.println("\t\tmakeAction(param)");
        return "PARAM_ACTION";
    }

}
