package akademia.services;

import akademia.model.Coin;
import akademia.repository.CoinRepository;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static akademia.commons.Variables.DB_PASSWORD;
import static akademia.commons.Variables.DB_URL;
import static akademia.commons.Variables.DB_USER;

@Service
public class CoinService {
  private final CoinRepository coinRepository;

  public CoinService(CoinRepository coinRepository) {
    this.coinRepository = coinRepository;
  }

  public List<Coin> getAllCoins() {
    return coinRepository.findAll();
  }

  public List<String> getSeries() {
    return  coinRepository.getSeries();
  }

  public List<Coin> getCoinBySeries(String series) {
    return coinRepository.getCoinBySeries(series);
  }

  public List<String> getValue() {
    return coinRepository.getCoinValue();
  }
  public List<Coin> getCoinByValues(String values) {
    return coinRepository.getCoinByValues(values);
  }

  public List<String> getHallmark() {
    return coinRepository.getCoinHallmark();
  }

  public List<Coin> getCoinByHallmark(String hallmark) {
    return coinRepository.getCoinByHallmark(hallmark);
  }

  public List<String> getStamp() {
    return coinRepository.getCoinStamp();
  }

  public List<Coin> getCoinByStamp(String stamp) {
    return coinRepository.getCoinByStamp(stamp);
  }

  public List<String> getCountry() {
    return coinRepository.getCountry();
  }

  public List<Coin> getCoinByCountry(String country) {
    return coinRepository.getCoinByCountry(country);
  }

  public String getNote(int id) {
    return coinRepository.getNoteFromCoin(id);
  }

  public Coin getCoinFromBase(int id) {
    return coinRepository.getCoinFromBase(id);
  }

  public String deleteCoin(int id) {
    try (
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        PreparedStatement statement =
            connection.prepareStatement("delete from coin where id = ?");
    ) {
      statement.setInt(1, id);
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return null;
  }

  public String takeAlloyFromCoin(int id) {
    String stringToTrim = coinRepository.getHallmarkFromCoin(id);
    String trimmed = stringToTrim.substring(0,2);
    return trimmed;
  }

  public float getMassFromCoin(int id) {
    return coinRepository.getMassFromCoin(id);
  }

  public String getHallmarkFromCoin (int id) {
    return coinRepository.getHallmarkFromCoin(id);
  }

  @Override
  public String toString() {
    return "CoinService{" +
        "coinRepository=" + coinRepository +
        '}';
  }
}
