Feature:

  @login
  Scenario: Kullanıcı giriş ve çıkış yapar
    Given   Kullanıcı Ana sayfaya gider
    When    Kullanıcı sayfanın yüklendiğini görür
    And     Kullanıcı giriş yap butonuna tıklar
    And     Kullanıcı mail ve şifre girer
    Then    Kullanıcı Log out olur

  @wronglogin
  Scenario: Kullanıcı yanlış password ile giriş yapar hata mesajı alır
    Given Kullanıcı Ana sayfaya gider
    When  Kullanıcı sayfanın yüklendiğini görür
    And   Kullanıcı giriş yap butonuna tıklar
    And   Kullanıcı mail ve yanlıs sifre girer
    Then  Kullanıcı hatalı giriş uyarısını görür

    @searchPage
    Scenario: Kullanıcı ürün arar ve listlenen ürünler results dodyasına kaydedilir
      Given Kullanıcı Ana sayfaya gider
      When  Kullanıcı sayfanın yüklendiğini görür
      And   Kullanıcı giriş yap butonuna tıklar
      And   Kullanıcı mail ve şifre girer
      And   Arama çubuğuna ürün girer
      And   Arama butonuna tıklar
      Then  Arama sonuçları results.txtye kaydedilir

  @searchPage
  Scenario: Kullanıcı olmayan ürün arar
    Given Kullanıcı Ana sayfaya gider
    When  Kullanıcı sayfanın yüklendiğini görür
    And   Kullanıcı giriş yap butonuna tıklar
    And   Kullanıcı mail ve şifre girer
    And   Arama çubuğuna olmayan ürün girer
    And   Olmayan ürün için Arama butonuna tıklar

  @loginwithParameter
  Scenario: Config dosyasından parametre ile login olunur
    Given Kullanıcı Ana sayfaya gider
    When  Kullanıcı sayfanın yüklendiğini görür
    And   Kullanıcı giriş yap butonuna tıklar
    And   Config.txtden mail ve şifre girilir
    Then  Kullanıcı Log out olur



