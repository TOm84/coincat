package akademia.repository;

import akademia.model.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoinRepository extends JpaRepository<Coin, String>  {
  @Query(value = "select c from Coin c where c.name = :name")
  List<Coin> getCoinByName(String name);

  @Query(value = "select * from coin where series = ?", nativeQuery = true) //SQL
  List<Coin> getCoinBySeries(String series);

  @Query(value="select distinct series from Coin ORDER BY series")
  List<String> getSeries();

  @Query(value = "select distinct value from Coin ORDER BY value")
  List<String> getCoinValue();

  @Query(value = "select * from coin where value = ?", nativeQuery = true)
  List<Coin> getCoinByValues(String values);

  @Query(value = "select distinct country from Coin ORDER BY country")
  List<String> getCountry();

  @Query(value = "select * from coin where country = ?", nativeQuery = true)
  List<Coin> getCoinByCountry(String country);

  @Query(value = "select distinct hallmark from Coin ORDER BY hallmark")
  List<String> getCoinHallmark();

  @Query(value = "select * from coin where hallmark = ?", nativeQuery = true)
  List<Coin> getCoinByHallmark(String hallmark);

  @Query(value= "select distinct stamp from Coin ORDER BY stamp")
  List<String> getCoinStamp();

  @Query(value = "select * from coin where stamp = ?", nativeQuery = true)
  List<Coin> getCoinByStamp(String stamp);

  @Query(value = "select note from coin where id = ?", nativeQuery = true)
  String getNoteFromCoin(int id);

  @Query(value = "select hallmark from coin where id = ?", nativeQuery = true)
  String getHallmarkFromCoin(int id);

  @Query(value = "select mass from coin where id = ?", nativeQuery = true)
  float getMassFromCoin(int id);

  @Query(value = "delete from Coin where id = ?", nativeQuery = true)
  String deleteCoinById(int id);

  @Query(value = "select * from Coin where id = ?", nativeQuery = true)
  Coin getCoinFromBase (int id);
}
