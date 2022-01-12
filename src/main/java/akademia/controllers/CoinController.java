package akademia.controllers;

import akademia.authorize.RegisterUser;
import akademia.model.Coin;
import akademia.model.UserApp;
import akademia.services.CoinService;
import akademia.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

@Controller
public class CoinController {

  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  private final CoinService coinService;

  @Autowired
  private final CoinRestController coinRestController;

  @Autowired
  private final UserService userService;

  private final RegisterUser registerUser;
  private final MetalController metalController;

  public CoinController(CoinService coinService, CoinRestController coinRestController, UserService userService, MetalController metalController, RegisterUser registerUser) {
    this.coinService = coinService;
    this.coinRestController = coinRestController;
    this.userService = userService;
    this.metalController = metalController;
    this.registerUser = registerUser;
  }

  @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
  @GetMapping("/")
  public String homePage(
      @RequestParam(value = "ser", required = false) String seri,
      @RequestParam(value = "nom", required = false) String nom,
      @RequestParam(value = "coun", required = false) String coun,
      @RequestParam(value = "hall", required = false) String hall,
      @RequestParam(value = "stam", required = false) String stam,
      @RequestParam(value = "search", required = false, defaultValue = "") String search,
      HttpServletRequest request,
      Model model
  ) {
    model.addAttribute("user",request.getRemoteUser());
    model.addAttribute("usd", metalController.getUSD());
    model.addAttribute("silver", metalController.getSilverPrice());
    model.addAttribute("gold", metalController.getGoldPrice());

    model.addAllAttributes(coinRestController.loadCoinParameter());
    if (seri != null) {
      model.addAttribute("viewtable", coinService.getCoinBySeries(seri));
    } else if (nom != null) {
      model.addAttribute("viewtable", coinService.getCoinByValues(nom));
    } else if (coun != null) {
      model.addAttribute("viewtable", coinService.getCoinByCountry(coun));
    } else if (hall != null) {
      model.addAttribute("viewtable", coinService.getCoinByHallmark(hall));
    } else if (stam != null) {
      model.addAttribute("viewtable", coinService.getCoinByStamp(stam));
    } else if (search != null){
      model.addAttribute("viewtable", coinRestController.searchingCoin(search.toLowerCase()));
    } else {
      model.addAttribute("viewtable", coinService.getAllCoins());
    }
    return "index";
  }

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping("/addcoin")
  public String getAddCoinPage(Model model) {
    model.addAllAttributes(coinRestController.loadCoinParameter());
    return "addcoin";
  }

  @PostMapping("new-coin")
  public String addNewCoin(
      @RequestParam(value = "nameField", required = false, defaultValue = "nn") String nameField,
      @RequestParam(value = "seriesField", required = false, defaultValue = "nn") String seriesField,
      @RequestParam(value = "valueField", required = false, defaultValue = "0") Integer valueField,
      @RequestParam(value = "countryField", required = false, defaultValue = "nn") String countryField,
      @RequestParam(value = "halmarkField", required = false, defaultValue = "nn") String halmarkField,
      @RequestParam(value = "stampField", required = false, defaultValue = "nn") String stampField,
      @RequestParam(value = "dimansionField", required = false, defaultValue = "nn") String dimansionField,
      @RequestParam(value = "massField", required = false, defaultValue = "nn") String massField,
      @RequestParam(value = "emissionField", required = false, defaultValue = "0") Integer emissionField,
      @RequestParam(value = "emissionDateField", required = false, defaultValue = "nn") String emissionDateField,
      @RequestParam(value = "emissionPriseField", required = false, defaultValue = "nn") String emissionPriseField,
      @RequestParam(value = "buyPrise", required = false, defaultValue = "nn") String buyPrise,
      @RequestParam(value = "awersField", required = false, defaultValue = "nn") String awersField,
      @RequestParam(value = "rewersField", required = false, defaultValue = "nn") String rewersField,
      @RequestParam(value = "noteField", required = false, defaultValue = "nn") String noteField,
      Model model) {
    Coin coin = new Coin(nameField, seriesField, valueField, countryField, halmarkField,
        stampField, dimansionField, massField, emissionField, emissionDateField,
        emissionPriseField, buyPrise,awersField, rewersField, noteField);
    coinRestController.addCoin(coin);
    return "redirect:/";
  }

  @PostMapping("updateCoin")
  public String updateCoin (
      @RequestParam(value = "nameFieldUpdate", required = false, defaultValue = "nn") String nameField,
      @RequestParam(value = "seriesFieldUpdate", required = false, defaultValue = "nn") String seriesField,
      @RequestParam(value = "valueFieldUpdate", required = false, defaultValue = "0") Integer valueField,
      @RequestParam(value = "countryFieldUpdate", required = false, defaultValue = "nn") String countryField,
      @RequestParam(value = "halmarkFieldUpdate", required = false, defaultValue = "nn") String halmarkField,
      @RequestParam(value = "stampFieldUpdate", required = false, defaultValue = "nn") String stampField,
      @RequestParam(value = "dimansionFieldUpdate", required = false, defaultValue = "nn") String dimansionField,
      @RequestParam(value = "massFieldUpdate", required = false, defaultValue = "nn") String massField,
      @RequestParam(value = "emissionFieldUpdate", required = false, defaultValue = "0") Integer emissionField,
      @RequestParam(value = "emissionDateFieldUpdate", required = false, defaultValue = "nn") String emissionDateField,
      @RequestParam(value = "emissionPriseFieldUpdate", required = false, defaultValue = "nn") String emissionPriseField,
      @RequestParam(value = "buyPriseUpdate", required = false, defaultValue = "nn") String buyPriseField,
      @RequestParam(value = "awersFieldUpdate", required = false, defaultValue = "nn") String awersField,
      @RequestParam(value = "rewersFieldUpdate", required = false, defaultValue = "nn") String rewersField,
      @RequestParam(value = "noteFieldUpdate", required = false, defaultValue = "nn") String noteField,
      @RequestParam("id") int id) {

    Coin coin = new Coin(nameField, seriesField, valueField, countryField, halmarkField,
        stampField, dimansionField, massField, emissionField, emissionDateField,
        emissionPriseField, buyPriseField, awersField, rewersField, noteField);
    coinRestController.updateCoin(coin, id);
    return "redirect:/admin";

  }

  @PostMapping("/delete")
  public String deleteRecord(@RequestParam("id") int id) {
    coinService.deleteCoin(id);
    return "redirect:/admin";
  }

  @PostMapping("/deleteUser")
  public String deleteUserAccount(@RequestParam("id") int id) {
    userService.deleteUserAccount(id);
    return "redirect:/tableuser";
  }

  @GetMapping("/register")
  public String getRegisterPage() {
    return "register";
  }

  @PostMapping("/registerUser")
  public String registerNewUser(
      @RequestParam(value = "loginField", required = true) String loginField,
      @RequestParam(value = "nameField", required = true) String nameField,
      @RequestParam(value = "lastNameField", required = true) String lastNameField,
      @RequestParam(value = "emailField", required = true) String emailField,
      @RequestParam(value = "passwordField1", required = true) String passwordField1,
//      @RequestParam(value = "passwordField2", required = true) String passwordField2,
      Model model) {

    UserApp usApp = new UserApp();
    usApp.setActive(2);
    usApp.setLogin(loginField);
    usApp.setName(nameField);
    usApp.setLastname(lastNameField);
    usApp.setEmail(emailField);
    usApp.setPassword(passwordField1);
    registerUser.regUser(usApp);
    return "redirect:/";
  }

  @GetMapping("/login")
  public String getLoginPage () {
    return "login";
  }

  @PreAuthorize("hasAnyRole('ADMIN')")
  @GetMapping("/admin")
  public String getAdminPage (
      @RequestParam(value = "ser", required = false) String seri,
      @RequestParam(value = "nom", required = false) String nom,
      @RequestParam(value = "coun", required = false) String coun,
      @RequestParam(value = "hall", required = false) String hall,
      @RequestParam(value = "stam", required = false) String stam,
      @RequestParam(value = "search", required = false, defaultValue = "") String search,
      HttpServletRequest request,
      Model model
  ) {
    model.addAttribute("user",request.getRemoteUser());
    model.addAllAttributes(coinRestController.loadCoinParameter());
    model.addAttribute("usd", metalController.getUSD());
    model.addAttribute("silver", metalController.getSilverPrice());
    model.addAttribute("gold", metalController.getGoldPrice());

    if (seri != null) {
      model.addAttribute("viewtable", coinService.getCoinBySeries(seri));
    } else if (nom != null) {
      model.addAttribute("viewtable", coinService.getCoinByValues(nom));
    } else if (coun != null) {
      model.addAttribute("viewtable", coinService.getCoinByCountry(coun));
    } else if (hall != null) {
      model.addAttribute("viewtable", coinService.getCoinByHallmark(hall));
    } else if (stam != null) {
      model.addAttribute("viewtable", coinService.getCoinByStamp(stam));
    } else if (search != null){
      model.addAttribute("viewtable", coinRestController.searchingCoin(search.toLowerCase()));
    } else {
      model.addAttribute("viewtable", coinService.getAllCoins());
    }
    return "admin_secured";
  }

  @GetMapping("/tableuser")
  public String userPage(
      Model model
  ) {
    model.addAttribute("viewtable", userService.getAllNormalUser());
    return "table_user";
  }

  @ExceptionHandler(AccessDeniedException.class)
  public String accessDenied () {
    return "acces denied idiot";
  }

}
