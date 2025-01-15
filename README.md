
# System Bankowy

Prosty system bankowy implementujący podstawowe funkcje bankowości internetowej i obsługi bankomatu.

## Struktura Systemu

```plantuml
@startuml
package "Struktura Systemu" {
    class SystemBankowy {
        - {static} Scanner skaner
        - {static} List<Konto> konta
        - {static} List<Transakcja> transakcje
        - {static} Konto zalogowanyUzytkownik
        - {static} String aktualnyNumerKarty
    }

    class Konto {
        + String login
        + String haslo
        + String imie
        + String nazwisko
        + float saldo
        + String numerKonta
        + String numerKarty
        + String pin
        + Konto(login: String, haslo: String, imie: String, nazwisko: String)
        - generujNumerKonta(): String
        - generujNumerKarty(): String
        - generujPin(): String
    }

    class Transakcja {
        + String nadawca
        + String odbiorca
        + float kwota
        + boolean zatwierdzona
        + Transakcja(nadawca: String, odbiorca: String, kwota: float)
    }
}
@enduml
```

## Dane Początkowe

```plantuml
@startuml
package "Dane Początkowe" {
    note "Przykładowe konta:\n\nKonto 1:\n- Login: user1\n- Hasło: pass1\n- Imię: Jan\n- Nazwisko: Kowalski\n- Nr konta: 0001\n- Nr karty: 01\n- PIN: 1234\n- Saldo: 1000 PLN\n\nKonto 2:\n- Login: user2\n- Hasło: pass2\n- Imię: Anna\n- Nazwisko: Nowak\n- Nr konta: 0002\n- Nr karty: 02\n- PIN: 1234\n- Saldo: 1000 PLN\n\nAdmin:\n- Hasło: admin" as DanePoczatkowe
}
@enduml
```

## Struktura Menu

```plantuml
@startuml
package "Struktura Menu" {
    rectangle "Menu Główne" as MenuGlowne {
        note "=== SYSTEM BANKOWY ===\n1. Bankowość internetowa\n2. Bankomat\n3. Panel administratora\n0. Wyjście" as OpcjeMenuGlownego
    }

    rectangle "Bankowość Internetowa" as BankowoscInternetowa {
        note "=== BANKOWOŚĆ INTERNETOWA ===\nBez logowania:\n1. Logowanie\n2. Rejestracja\n0. Powrót" as BankInternetBezLogowania

        note "=== PANEL KLIENTA ===\nPo zalogowaniu:\n1. Sprawdź saldo\n2. Wykonaj przelew\n3. Historia transakcji\n4. Zmień dane\n0. Wyloguj" as BankInternetPoLogowaniu
    }

    rectangle "Bankomat" as Bankomat {
        note "=== BANKOMAT ===\nBez karty:\nPodaj numer karty (0 aby wyjść)\nPodaj PIN" as BankomatBezKarty

        note "=== OPERACJE BANKOMATOWE ===\nZ kartą:\n1. Wypłata\n2. Wpłata\n3. Sprawdź saldo\n4. Zmień PIN\n0. Wysuń kartę" as BankomatZKarta
    }

    rectangle "Panel Administratora" as PanelAdmina {
        note "=== PANEL ADMINISTRATORA ===\nLogowanie:\nPodaj hasło administratora" as LoginAdmina

        note "=== PANEL ADMINISTRATORA ===\nPo zalogowaniu:\n1. Lista klientów\n2. Lista transakcji\n0. Wyloguj" as OpcjeAdmina
    }
}
@enduml
```

## Przykładowe Scenariusze Użycia

```plantuml
@startuml
package "Przykładowe Scenariusze" {
    rectangle "Bankowość Internetowa - Scenariusz" as ScenariuszBI {
        note "1. Wybierz 'Bankowość internetowa'\n2. Zaloguj się (user1/pass1)\n3. Sprawdź saldo\n4. Wykonaj przelew na konto 0002\n5. Sprawdź historię transakcji\n6. Wyloguj" as PrzykladBI
    }

    rectangle "Bankomat - Scenariusz" as ScenariuszBankomat {
        note "1. Wybierz 'Bankomat'\n2. Wprowadź kartę (01)\n3. Wprowadź PIN (1234)\n4. Wpłać pieniądze\n5. Sprawdź saldo\n6. Wysuń kartę" as PrzykladBankomat
    }

    rectangle "Panel Admina - Scenariusz" as ScenariuszAdmin {
        note "1. Wybierz 'Panel administratora'\n2. Wprowadź hasło (admin)\n3. Wyświetl listę klientów\n4. Wyświetl listę transakcji\n5. Wyloguj" as PrzykladAdmin
    }
}
@enduml
```

## Jak uruchomić

1. Skompiluj plik `Bank.java`:
```bash
javac Bank.java
```

2. Uruchom program:
```bash
java Bank
```

## Funkcjonalności

- Bankowość internetowa (przelewy, sprawdzanie salda, historia transakcji)
- Obsługa bankomatu (wpłaty, wypłaty, zmiana PIN)
- Panel administratora (podgląd klientów i transakcji)

## Dane testowe

- Konto 1: login: user1, hasło: pass1
- Konto 2: login: user2, hasło: pass2
- Admin: hasło: admin
