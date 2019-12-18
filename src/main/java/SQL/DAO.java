package SQL;

import java.util.List;

public interface DAO {

    void add(String[] data);
    void remove(String name);
    void edit(String login, String columnName, String data);
    List<String> getNames(String type);
}
