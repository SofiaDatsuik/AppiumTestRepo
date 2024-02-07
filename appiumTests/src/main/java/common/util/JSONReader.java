package common.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class JSONReader {
    public Object[] getData() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/main/resources/user-data.json"));
        JsonElement userSet = jsonData.getAsJsonObject().get("UserData");
        List<UserData> testData = new Gson().fromJson(userSet, new TypeToken<List<UserData>>(){}.getType());
        return testData.toArray();
    }
}
