import org.cryptacular.util.CodecUtil;
import org.cryptacular.util.HashUtil;
import org.json.JSONObject;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Yaml yaml = new Yaml();
        String currentDirectory = System.getProperty("user.dir");
        String pathName = currentDirectory+"\\src\\main\\resources\\userDetails.yml";
        String jsonStr = yaml.dump(yaml.load(new FileInputStream(new File(pathName))));
        String pathHash = CodecUtil.hex(HashUtil.sha256(pathName));

        JSONObject jsonObj = new JSONObject(jsonStr);
        String extractedHash = jsonObj.getString("hashValue");
        String extractedComment = jsonObj.getString("comment");


        if (!pathHash.equals(extractedHash)){
            System.out.println("Not running in Shrek's PC. Big sad.");
        }
        else {
            System.out.println("Yay! Running in Shrek's PC. He says "+extractedComment+".");
        }
    }
}

