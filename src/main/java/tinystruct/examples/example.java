package tinystruct.examples;


import org.tinystruct.AbstractApplication;
import org.tinystruct.ApplicationException;
import org.tinystruct.system.annotation.Action;

public class example extends AbstractApplication {

    @Override
    public void init() {
        // TODO Auto-generated method stub
    }

    @Action("praise")
    public String praise() {
        return "Praise to the Lord!";
    }

    @Action("say")
    public String say() throws ApplicationException {
        if (null != this.context.getAttribute("--words"))
            return this.context.getAttribute("--words").toString();

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