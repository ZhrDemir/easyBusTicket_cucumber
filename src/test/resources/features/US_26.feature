Feature: US_26 Admin Booking History girer.
@wip
  Scenario: TC_01 Admin Booking History 'e girebilmeli

Given kullanici "eBTAdminUrl" anasayfaya gider
Then  Admin olarak giris yapar
And  Booking_History linkinin görünürlügü test edilir
And  Booking_History linkine tiklanir
And 2 saniye bekle
Then sayfayi kapatir