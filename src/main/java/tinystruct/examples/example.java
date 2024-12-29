package tinystruct.examples;


import org.tinystruct.AbstractApplication;
import org.tinystruct.ApplicationException;
import org.tinystruct.system.Event;
import org.tinystruct.system.EventDispatcher;
import org.tinystruct.system.annotation.Action;

import java.text.SimpleDateFormat;
import java.util.Date;

public class example extends AbstractApplication {

    private static final EventDispatcher dispatcher = EventDispatcher.getInstance();

    static {
        dispatcher.registerHandler(InitEvent.class, handler -> System.out.println(handler.getPayload()));
    }

    @Override
    public void init() {
        // TODO Auto-generated method stub
        dispatcher.dispatch(new InitEvent());
    }

    @Action("praise")
    public String praise() {
        return "Praise to the Lord!";
    }

    @Action("say")
    public String say() throws ApplicationException {
        if (null != getContext().getAttribute("--words"))
            return getContext().getAttribute("--words").toString();

        throw new ApplicationException("Could not find the parameter <i>--words</i>.");
    }

    @Action("say")
    public String say(String words) {
        return words;
    }

    @Override
    public String version() {
        return "1.0";
    }
}

class InitEvent implements Event<String> {

    @Override
    public String getName() {
        return "Initialize";
    }

    @Override
    public String getPayload() {
        return "The app started at " + new SimpleDateFormat().format(new Date());
    }
}