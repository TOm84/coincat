package akademia.controllers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import static akademia.commons.Variables.GOLD_ELE;
import static akademia.commons.Variables.GOLD_URL;
import static akademia.commons.Variables.SILVER_ELE;
import static akademia.commons.Variables.SILVER_URL;
import static akademia.commons.Variables.USD_ELE;
import static akademia.commons.Variables.USD_URL;

@Controller
public class MetalController {
  public static float usd;
  public static String gold;
  public static String silver;

  public MetalController() {
  }

  public static float getUSD() {
    Document document = null;
    try {
      document = Jsoup.connect(USD_URL).get();
      String input = document.getElementsByClass(USD_ELE).first().text();
      StringBuffer sb = new StringBuffer();
      input = input.replace("," , ".");
      for (int i = 0; i < input.length() ; i++) {
        if (Character.isDigit(input.charAt(i)) || input.charAt(i) == '.') {
          sb.append(input.charAt(i));
        }
      }
      float output = Float.parseFloat(sb.toString());
      return output;
    } catch (IOException e) {
      e.printStackTrace();
      return 0;
    }
  }

  public static float getGold() {
    Document document = null;
    try {
      document = Jsoup.connect(GOLD_URL).get();
      String input = document.getElementsByClass(GOLD_ELE).first().text();
      float output = convertString(input);
      return output;
    } catch (IOException e) {
      e.printStackTrace();
      return 0;
    }

  }

  public static String getGoldPrice() {
    DecimalFormat df = new DecimalFormat("####.##");
    float gold = getGold();
    float usd = getUSD();
    float price = gold * usd;
    df.setRoundingMode(RoundingMode.HALF_DOWN);
    String priceRound = df.format(price);
    return priceRound;
  }

  public static float getSilver() {
    Document document = null;
    try {
      document = Jsoup.connect(SILVER_URL).get();
    } catch (IOException e) {
      e.printStackTrace();
    }
    String input = document.getElementsByClass(SILVER_ELE).first().text();
    float output = convertString(input);
    return output;
  }

  public static String getSilverPrice() {
    DecimalFormat df = new DecimalFormat("####.##");
    float silver = getSilver();
    float usd = getUSD();
    float price = silver * usd;
    df.setRoundingMode(RoundingMode.HALF_DOWN);
    String priceRound = df.format(price);
    return priceRound;
  }

  public static float convertString (String input) {
    StringBuffer sb = new StringBuffer();
    input = input.replace("," , ".");
    for (int i = 0; i < input.length() ; i++) {
      if (Character.isDigit(input.charAt(i)) || input.charAt(i) == '.') {
        sb.append(input.charAt(i));
      }
    }
    return Float.parseFloat(sb.toString());
  }
}
