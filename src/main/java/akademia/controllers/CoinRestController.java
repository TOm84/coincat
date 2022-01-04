package akademia.controllers;

import akademia.model.Coin;
import akademia.services.CoinService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static akademia.commons.Variables.DB_PASSWORD;
import static akademia.commons.Variables.DB_URL;
import static akademia.commons.Variables.DB_USER;

@RestController
@RequestMapping("/")
public class CoinRestController {
  private final CoinService coinService;

  private final MetalController metalController;

  public CoinRestController(CoinService coinService, MetalController metalController) {
    this.coinService = coinService;
    this.metalController = metalController;
  }

  public HashMap<String, List<String>> loadCoinParameter() {
    HashMap<String, List<String>> hashMap = new HashMap<>();
    hashMap.put("getseries", coinService.getSeries());
    hashMap.put("getvalue", coinService.getValue());
    hashMap.put("getcountry", coinService.getCountry());
    hashMap.put("gethallmark", coinService.getHallmark());
    hashMap.put("getstamp", coinService.getStamp());

    return hashMap;
  }

  public String addCoin(Coin coin) {
    try (
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        PreparedStatement statement =
            connection.prepareStatement("INSERT INTO coin values ((select max(t.id)+1 from (select id from coin) t),?,?,?,?,?,?,?,?,?,?,?,?,?,?);")
    ) {
      statement.setString(1, String.valueOf(coin.getName()));
      statement.setString(2, String.valueOf(coin.getSeries()));
      statement.setString(3, String.valueOf(coin.getValue()));
      statement.setString(4, String.valueOf(coin.getCountry()));
      statement.setString(5, String.valueOf(coin.getHallmark()));
      statement.setString(6, String.valueOf(coin.getStamp()));
      statement.setString(7, String.valueOf(coin.getDimansion()));
      statement.setString(8, String.valueOf(coin.getMass()));
      statement.setString(9, String.valueOf(coin.getEmission()));
      statement.setString(10, String.valueOf(coin.getEmissiondate()));
      statement.setString(11, String.valueOf(coin.getEmissionprise()));
      statement.setString(12, String.valueOf(coin.getAwers()));
      statement.setString(13, String.valueOf(coin.getRewers()));
      statement.setString(14, String.valueOf(coin.getNote()));
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return null;
  }

  public String updateCoin (Coin coin, int id) {
    try (
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        PreparedStatement statement =
            connection.prepareStatement("UPDATE Coin SET name = ?, series = ?, value = ?, country = ?, hallmark = ?, stamp = ?, dimansion = ?, mass = ?, emission = ?, emissiondate = ?, emissionprise = ?, awers = ?, rewers = ?, note = ? WHERE ID = ?;")
    ){
      statement.setString(1, String.valueOf(coin.getName()));
      statement.setString(2, String.valueOf(coin.getSeries()));
      statement.setString(3, String.valueOf(coin.getValue()));
      statement.setString(4, String.valueOf(coin.getCountry()));
      statement.setString(5, String.valueOf(coin.getHallmark()));
      statement.setString(6, String.valueOf(coin.getStamp()));
      statement.setString(7, String.valueOf(coin.getDimansion()));
      statement.setString(8, String.valueOf(coin.getMass()));
      statement.setString(9, String.valueOf(coin.getEmission()));
      statement.setString(10, String.valueOf(coin.getEmissiondate()));
      statement.setString(11, String.valueOf(coin.getEmissionprise()));
      statement.setString(12, String.valueOf(coin.getAwers()));
      statement.setString(13, String.valueOf(coin.getRewers()));
      statement.setString(14, String.valueOf(coin.getNote()));
      statement.setInt(15, id);
      statement.executeUpdate();
    } catch (SQLException e){
      e.printStackTrace();
      return null;
    }
    return null;
  }

  public List<Coin> searchingCoin(String string) {
    try (
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        PreparedStatement statement = connection.prepareStatement("select * from coin;")
    ) {
      List<Coin> listCoin = new ArrayList<>();
      List<Coin> newListCoin = new ArrayList<>();
      listCoin.addAll(coinService.getAllCoins());
      string.toLowerCase();

      for (Coin lc : listCoin) {
        if (lc.getName().toLowerCase().contains(string) ||
            lc.getSeries().toLowerCase().contains(string) ||
            lc.getValue().toString().toLowerCase().contains(string) ||
            lc.getCountry().toLowerCase().contains(string) ||
            lc.getHallmark().toLowerCase().contains(string) ||
            lc.getStamp().toLowerCase().contains(string) ||
            lc.getDimansion().toLowerCase().contains(string) ||
            lc.getMass().toLowerCase().contains(string) ||
            lc.getEmission().toString().toLowerCase().contains(string) ||
            lc.getEmissiondate().toLowerCase().contains(string) ||
            lc.getEmissionprise().toLowerCase().contains(string) ||
            lc.getNote().toLowerCase().contains(string)
        ) {
          newListCoin.add(lc);
        }
      }
      return newListCoin;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  public String convertMassCoinToMetal(int id) {
    DecimalFormat df = new DecimalFormat("####.###");
    String output;
    String alloy = coinService.takeAlloyFromCoin(id);
    float getMass = (float) (coinService.getMassFromCoin(id));
    float getUsd = metalController.getUSD();
    float getGoldGram = (float) (metalController.getGold() / 31.1034768);
    float getSilverGram = (float) (metalController.getSilver() / 31.1034768);

    if (alloy.equalsIgnoreCase("Au")) {
      return output = df.format(getMass * getGoldGram * getUsd);
    } else if (alloy.equalsIgnoreCase("Ag")) {
      return output = df.format(getMass * getSilverGram * getUsd);
    } else if (alloy.equalsIgnoreCase("MN") || alloy.equalsIgnoreCase("Cu") ||alloy.equalsIgnoreCase("Al") ) {
      return "Stop nieinwestycyjny";
    } else {
      output = "Błąd stopu";
      return output;
    }
  }

  public String takeMassFromCoin (int id) {
    Coin coin = coinService.getCoinFromBase(id);
    return coin.getMass();
  }
}
