
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

![](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/sm-idk/SystemBankowy/master/struktura_systemu.puml)


## Struktura Menu

![](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/sm-idk/SystemBankowy/master/struktura_menu.puml)


## Przykładowe Scenariusze Użycia

![](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/sm-idk/SystemBankowy/master/przyklady_uzycia.puml)


## Jak uruchomić

Uruchom program:
```bash
java Bank.java
```


## Funkcjonalności

- Bankowość internetowa (przelewy, sprawdzanie salda, historia transakcji)
- Obsługa bankomatu (wpłaty, wypłaty, zmiana PIN)
- Panel administratora (podgląd klientów i transakcji)


## Dane testowe / początkowe

![](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/sm-idk/SystemBankowy/master/dane_poczatkowe.puml)