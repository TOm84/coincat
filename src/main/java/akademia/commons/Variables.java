package akademia.commons;

public class Variables {
  public static final String DB_URL = "jdbc:mysql://localhost:3306/coinbase?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
  public static final String DB_USER = "root";
  public static final String DB_PASSWORD = "root";

  public static final String USD_URL = "https://www.bankier.pl/waluty/kursy-walut/nbp/USD";
  public static final String USD_ELE = "profilLast";

  public static final String GOLD_URL = "https://www.bankier.pl/inwestowanie/profile/quote.html?symbol=ZLOTO";
  public static final String GOLD_ELE = "profilLast";

  public static final String SILVER_URL = "https://www.bankier.pl/inwestowanie/profile/quote.html?symbol=SREBRO";
  public static final String SILVER_ELE = "profilLast";
}
