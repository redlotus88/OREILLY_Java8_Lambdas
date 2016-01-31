package cn.stsniper.ch08.command;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MockEditor implements Editor {

    private final List<String> actions = new ArrayList<>();

    @Override
    public void save() {
    	System.out.println("Save");
        actions.add("save");
    }

    @Override
    public void open() {
    	System.out.println("open");
        actions.add("open");
    }

    @Override
    public void close() {
    	System.out.println("close");
        actions.add("close");
    }

    public void check() {
        assertEquals("open", actions.get(0));
        assertEquals("save", actions.get(1));
        assertEquals("close", actions.get(2));
    }

}
