import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Konto> konta = new ArrayList<>();
    private static List<Transakcja> transakcje = new ArrayList<>();
    private static Konto zalogowanyUzytkownik = null;
    private static String aktualnyNumerKarty = null;

    public static void main(String[] args) {
        inicjalizujPrzykladoweDane();
        menuGlowne();
    }

    private static void menuGlowne() {
        while (true) {
            System.out.println("\n=== SYSTEM BANKOWY ===");
            System.out.println("1. Bankowość internetowa");
            System.out.println("2. Bankomat");
            System.out.println("3. Panel administratora");
            System.out.println("0. Wyjście");
            System.out.print("Wybierz opcję: ");

            int wybor = scanner.nextInt();
            scanner.nextLine();

            switch (wybor) {
                case 1:
                    menuBankowosciInternetowej();
                    break;
                case 2:
                    menuBankomatu();
                    break;
                case 3:
                    menuAdministratora();
                    break;
                case 0:
                    System.out.println("Do widzenia!");
                    return;
                default:
                    System.out.println("Nieprawidłowy wybór!");
            }
        }
    }

    private static void menuBankowosciInternetowej() {
        while (true) {
            if (zalogowanyUzytkownik == null) {
                System.out.println("\n=== BANKOWOŚĆ INTERNETOWA ===");
                System.out.println("1. Logowanie");
                System.out.println("2. Rejestracja");
                System.out.println("0. Powrót");
                System.out.print("Wybierz opcję: ");

                int wybor = scanner.nextInt();
                scanner.nextLine();

                switch (wybor) {
                    case 1:
                        logowanie();
                        break;
                    case 2:
                        rejestracja();
                        break;
                    case 0:
                        return;
                }
            } else {
                menuZalogowanegoUzytkownika();
            }
        }
    }

    private static void menuZalogowanegoUzytkownika() {
        while (true) {
            System.out.println("\n=== PANEL KLIENTA ===");
            System.out.println("1. Sprawdź saldo");
            System.out.println("2. Wykonaj przelew");
            System.out.println("3. Historia transakcji");
            System.out.println("4. Zmień dane");
            System.out.println("0. Wyloguj");
            System.out.print("Wybierz opcję: ");

            int wybor = scanner.nextInt();
            scanner.nextLine();

            switch (wybor) {
                case 1:
                    System.out.println(
                        "Twoje saldo: " + zalogowanyUzytkownik.saldo + " PLN"
                    );
                    break;
                case 2:
                    wykonajPrzelew();
                    break;
                case 3:
                    wyswietlHistorieTransakcji();
                    break;
                case 4:
                    zmienDane();
                    break;
                case 0:
                    zalogowanyUzytkownik = null;
                    System.out.println("Wylogowano pomyślnie");
                    return;
            }
        }
    }

    private static void menuBankomatu() {
        while (true) {
            if (aktualnyNumerKarty == null) {
                System.out.println("\n=== BANKOMAT ===");
                System.out.print("Podaj numer karty (0 aby wyjść): ");
                String numerKarty = scanner.nextLine();

                if (numerKarty.equals("0")) return;

                System.out.print("Podaj PIN: ");
                String pin = scanner.nextLine();

                for (Konto konto : konta) {
                    if (
                        konto.numerKarty.equals(numerKarty) &&
                        konto.pin.equals(pin)
                    ) {
                        aktualnyNumerKarty = numerKarty;
                        zalogowanyUzytkownik = konto;
                        menuOperacjiBankomatowych();
                        return;
                    }
                }
                System.out.println("Nieprawidłowy numer karty lub PIN!");
            }
        }
    }

    private static void menuOperacjiBankomatowych() {
        while (true) {
            System.out.println("\n=== OPERACJE BANKOMATOWE ===");
            System.out.println("1. Wypłata");
            System.out.println("2. Wpłata");
            System.out.println("3. Sprawdź saldo");
            System.out.println("4. Zmień PIN");
            System.out.println("0. Wysuń kartę");
            System.out.print("Wybierz opcję: ");

            int wybor = scanner.nextInt();
            scanner.nextLine();

            switch (wybor) {
                case 1:
                    System.out.print("Podaj kwotę do wypłaty: ");
                    float kwotaWyplaty = scanner.nextFloat();
                    if (kwotaWyplaty <= zalogowanyUzytkownik.saldo) {
                        zalogowanyUzytkownik.saldo -= kwotaWyplaty;
                        System.out.println(
                            "Wypłacono: " + kwotaWyplaty + " PLN"
                        );
                    } else {
                        System.out.println("Brak wystarczających środków!");
                    }
                    break;
                case 2:
                    System.out.print("Podaj kwotę do wpłaty: ");
                    float kwotaWplaty = scanner.nextFloat();
                    zalogowanyUzytkownik.saldo += kwotaWplaty;
                    System.out.println("Wpłacono: " + kwotaWplaty + " PLN");
                    break;
                case 3:
                    System.out.println(
                        "Saldo: " + zalogowanyUzytkownik.saldo + " PLN"
                    );
                    break;
                case 4:
                    zmienPin();
                    break;
                case 0:
                    System.out.println("Karta została wysunięta");
                    aktualnyNumerKarty = null;
                    zalogowanyUzytkownik = null;
                    return;
            }
        }
    }

    private static void menuAdministratora() {
        System.out.print("Podaj hasło administratora: ");
        String haslo = scanner.nextLine();
        if (haslo.equals("admin")) {
            while (true) {
                System.out.println("\n=== PANEL ADMINISTRATORA ===");
                System.out.println("1. Lista klientów");
                System.out.println("2. Lista transakcji");
                System.out.println("0. Wyloguj");
                System.out.print("Wybierz opcję: ");

                int wybor = scanner.nextInt();
                scanner.nextLine();

                switch (wybor) {
                    case 1:
                        wyswietlListeKlientow();
                        break;
                    case 2:
                        wyswietlListeTransakcji();
                        break;
                    case 0:
                        return;
                }
            }
        } else {
            System.out.println("Nieprawidłowe hasło!");
        }
    }

    private static void logowanie() {
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Hasło: ");
        String haslo = scanner.nextLine();

        for (Konto konto : konta) {
            if (konto.login.equals(login) && konto.haslo.equals(haslo)) {
                zalogowanyUzytkownik = konto;
                System.out.println("Zalogowano pomyślnie!");
                return;
            }
        }
        System.out.println("Nieprawidłowe dane logowania!");
    }

    private static void rejestracja() {
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Hasło: ");
        String haslo = scanner.nextLine();
        System.out.print("Imię: ");
        String imie = scanner.nextLine();
        System.out.print("Nazwisko: ");
        String nazwisko = scanner.nextLine();

        Konto noweKonto = new Konto(login, haslo, imie, nazwisko);
        konta.add(noweKonto);
        System.out.println("Konto zostało utworzone!");
        System.out.println("Twój numer konta: " + noweKonto.numerKonta);
        System.out.println("Twój numer karty: " + noweKonto.numerKarty);
        System.out.println("Twój PIN: " + noweKonto.pin);
    }

    private static void inicjalizujPrzykladoweDane() {
        konta.add(new Konto("user1", "pass1", "Jan", "Kowalski"));
        konta.add(new Konto("user2", "pass2", "Anna", "Nowak"));
    }

    private static void wykonajPrzelew() {
        System.out.print("Podaj numer konta odbiorcy: ");
        String numerKontaOdbiorcy = scanner.nextLine();
        System.out.print("Podaj kwotę: ");
        float kwota = scanner.nextFloat();
        scanner.nextLine();

        if (kwota > zalogowanyUzytkownik.saldo) {
            System.out.println("Brak wystarczających środków!");
            return;
        }

        for (Konto konto : konta) {
            if (konto.numerKonta.equals(numerKontaOdbiorcy)) {
                zalogowanyUzytkownik.saldo -= kwota;
                konto.saldo += kwota;
                transakcje.add(
                    new Transakcja(
                        zalogowanyUzytkownik.numerKonta,
                        numerKontaOdbiorcy,
                        kwota
                    )
                );
                System.out.println("Przelew wykonany pomyślnie!");
                return;
            }
        }
        System.out.println("Nie znaleziono konta odbiorcy!");
    }

    private static void wyswietlHistorieTransakcji() {
        System.out.println("\n=== HISTORIA TRANSAKCJI ===");
        for (Transakcja transakcja : transakcje) {
            if (
                transakcja.nadawca.equals(zalogowanyUzytkownik.numerKonta) ||
                transakcja.odbiorca.equals(zalogowanyUzytkownik.numerKonta)
            ) {
                System.out.println(
                    "Z: " +
                    transakcja.nadawca +
                    " Do: " +
                    transakcja.odbiorca +
                    " Kwota: " +
                    transakcja.kwota +
                    " PLN" +
                    " Status: " +
                    (transakcja.zatwierdzona ? "zatwierdzona" : "oczekuje")
                );
            }
        }
    }

    private static void zmienDane() {
        System.out.println("1. Zmień hasło");
        System.out.println("2. Zmień login");
        System.out.print("Wybierz opcję: ");
        int wybor = scanner.nextInt();
        scanner.nextLine();

        switch (wybor) {
            case 1:
                System.out.print("Podaj nowe hasło: ");
                zalogowanyUzytkownik.haslo = scanner.nextLine();
                System.out.println("Hasło zostało zmienione!");
                break;
            case 2:
                System.out.print("Podaj nowy login: ");
                zalogowanyUzytkownik.login = scanner.nextLine();
                System.out.println("Login został zmieniony!");
                break;
        }
    }

    private static void zmienPin() {
        System.out.print("Podaj stary PIN: ");
        String staryPin = scanner.nextLine();
        if (staryPin.equals(zalogowanyUzytkownik.pin)) {
            System.out.print("Podaj nowy PIN: ");
            zalogowanyUzytkownik.pin = scanner.nextLine();
            System.out.println("PIN został zmieniony!");
        } else {
            System.out.println("Nieprawidłowy PIN!");
        }
    }

    private static void wyswietlListeKlientow() {
        System.out.println("\n=== LISTA KLIENTÓW ===");
        for (Konto konto : konta) {
            System.out.println(
                "Klient: " +
                konto.imie +
                " " +
                konto.nazwisko +
                "\nLogin: " +
                konto.login +
                "\nHasło: " +
                konto.haslo +
                "\nNumer konta: " +
                konto.numerKonta +
                "\nNumer karty: " +
                konto.numerKarty +
                "\nPIN: " +
                konto.pin +
                "\nSaldo: " +
                konto.saldo +
                " PLN" +
                "\n-------------------"
            );
        }
    }

    private static void wyswietlListeTransakcji() {
        System.out.println("\n=== LISTA TRANSAKCJI ===");
        for (Transakcja transakcja : transakcje) {
            System.out.println(
                "Z: " +
                transakcja.nadawca +
                " Do: " +
                transakcja.odbiorca +
                " Kwota: " +
                transakcja.kwota +
                " PLN" +
                " Status: " +
                (transakcja.zatwierdzona ? "zatwierdzona" : "oczekuje")
            );
        }
    }

    static class Konto {

        String login;
        String haslo;
        String imie;
        String nazwisko;
        float saldo;
        String numerKonta;
        String numerKarty;
        String pin;

        public Konto(String login, String haslo, String imie, String nazwisko) {
            this.login = login;
            this.haslo = haslo;
            this.imie = imie;
            this.nazwisko = nazwisko;
            this.saldo = 1000.0f;
            this.numerKonta = generujNumerKonta();
            this.numerKarty = generujNumerKarty();
            this.pin = generujPin();
        }

        private String generujNumerKonta() {
            return String.format("%04d", konta.size() + 1);
        }

        private String generujNumerKarty() {
            return String.format("%02d", konta.size() + 1);
        }

        private String generujPin() {
            return "1234";
        }
    }

    static class Transakcja {

        String nadawca;
        String odbiorca;
        float kwota;
        boolean zatwierdzona;

        public Transakcja(String nadawca, String odbiorca, float kwota) {
            this.nadawca = nadawca;
            this.odbiorca = odbiorca;
            this.kwota = kwota;
            this.zatwierdzona = false;
        }
    }
}
