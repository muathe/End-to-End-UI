package automation.Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public List<HashMap<String, String>> getJsonData(String myPath) throws IOException {

		String textData = FileUtils.readFileToString(new File(myPath),StandardCharsets.UTF_8);

		ObjectMapper map = new ObjectMapper();

		List<HashMap<String, String>> data = map.readValue(textData, new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;

	}

}


