package com.app;

import java.util.List;

/**
 * Created by Администратор on 09.07.2017.
 */
public class RemoteDataServiceImpl implements RemoteDataService {

    private DAO dao;
    private Transformer xmlTransformer = new XMLTransformerImpl();
    private Transformer jsonTransformer = new JSONTransformerImpl();

   /* {
        dao = new DAOImpl();
    }*/

    public String getDataAsJSON(int age) {
        List<Person> persons = dao.getByAge(age);
        return jsonTransformer.from(persons);
    }

    public String getDataAsXML(int age) {
        List<Person> persons = dao.getByAge(age);
        return xmlTransformer.from(persons);
    }

    public void putDataFromJSON(String json) {
        List<Person> persons = jsonTransformer.to(json);
        dao.save(persons);
    }

    public void putDataFromXML(String xml) {
        List<Person> persons = xmlTransformer.to(xml);
        dao.save(persons);
    }
}
