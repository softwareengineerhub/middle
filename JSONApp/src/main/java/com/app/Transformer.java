package com.app;

import java.util.List;

/**
 * Created by Администратор on 09.07.2017.
 */
public interface Transformer {

    public String from(List<Person> prsons);

    public List<Person> to(String str);

}
