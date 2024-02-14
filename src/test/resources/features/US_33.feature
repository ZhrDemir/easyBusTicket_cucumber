Feature:US_33 Admnin olarak giriş admin sayfasında header bölümünde
  site içinde arama yapıp istediğim sayfaya ulaşabilmeli,
  bildirimleri görüntüleyebilmeli ve bildirimler sayfasına ulaşıp tümünü okuyup işaretleyebilmeliyim


  @P2
  Scenario: TC02 Admin dashboard sayfasında header bölümündeki
  arama butonua tıklayarak sayfa araması yapıp aradığım sayfaya ulaşabilmeliyim


    Given kullanici "eBTAdminUrl" anasayfaya gider
    Then  Admin olarak giris yapar
    And  Search Butonu linkinin görünürlügü test edilir
    And  Search Butonu linkinin aktif olduğu test edilir
    And  Search Butonu linkine tiklanir
    And  Search Placeholder görünürlügü test edilir
    And  Search Placeholder ına yazılan sayfaya gittigi dogrulanir
    And 2 saniye bekle
    Then sayfayi kapatir