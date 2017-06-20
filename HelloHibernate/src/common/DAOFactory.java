package common;

/**
 * Created by denys on 6/20/2017.
 */
public class DAOFactory {

    public static DAO getDAO(DAOType daoType){
        switch (daoType){
            case HIBERNATE:
                return new HibernateImpl();
            case JPA:
                return new JPADAO();
            case JDBC:
                return new JDBCDAO();
            default: throw new IllegalArgumentException("Incorrect type:"+daoType);
        }
    }
}
