
# System Bankowy

Prosty system bankowy implementujący podstawowe funkcje bankowości internetowej i obsługi bankomatu.
Napisany przez Bruna Popławskiego, nr albumu: 167884

Program napisany w linuxie pod javą 21
```shell
$ java --version
openjdk 21.0.6 2025-01-21
OpenJDK Runtime Environment (build 21.0.6+1-void-r1)
OpenJDK 64-Bit Server VM (build 21.0.6+1-void-r1, mixed mode, sharing)
```

## Struktura Systemu

![](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/sm-idk/SystemBankowy/master/PlantUML/struktura_systemu.puml)


## Struktura Menu

![](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/sm-idk/SystemBankowy/master/PlantUML/struktura_menu.puml)


## Przykładowe Scenariusze Użycia

![](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/sm-idk/SystemBankowy/master/PlantUML/przyklady_uzycia.puml)


## Dane testowe / początkowe

![](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/sm-idk/SystemBankowy/master/PlantUML/dane_poczatkowe.puml)


## Jak uruchomić

Uruchom program:
```shell
$ java Bank.java
```


## Funkcjonalności

- Bankowość internetowa (przelewy, sprawdzanie salda, historia transakcji)
- Obsługa bankomatu (wpłaty, wypłaty, zmiana PIN)
- Panel administratora (podgląd klientów i transakcji)

# Limitacje implementacji systemu bankowego

## Oryginalne zadanie znajduje się w repozytorium [Magistra Artura Petrusiewicza](https://github.com/pecix/), pod nazwą [Bank.pdf](https://github.com/pecix/exercises-java/blob/main/Tasks/Bank.pdf)

## Główne uproszczenia
- Numery kont 4-cyfrowe (zamiast 26)
- Numery kart 2-cyfrowe (zamiast 6)
- Brak persystencji danych
- PIN zawsze "1234"

## Pominięte wymagania
- Walidacja danych (email, hasło, PESEL)
- Dodatkowe dane klienta (adres, data urodzenia)
- Obsługa walut (tylko PLN)
- System weryfikacji przelewów przez admina
- Blokowanie środków podczas przelewu