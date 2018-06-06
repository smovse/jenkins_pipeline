package dk.thj.jenkins.action;

import com.opensymphony.xwork2.Action;
import org.junit.Test;

import static org.junit.Assert.*;

public class IndexActionTest {

    @Test
    public void execute() {
        IndexAction action = new IndexAction();
        String result = action.execute();
        assertEquals(Action.SUCCESS, result);
    }
}