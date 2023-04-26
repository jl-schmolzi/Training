package org.example;

import java.io.*;
import java.math.BigInteger;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;

class HeroYearComparator2 implements Comparator<Heroes.Hero> {

    @Override
    public int compare(Heroes.Hero o1, Heroes.Hero o2) {
        return Integer.compare(o1.yearFirstAppearance, o2.yearFirstAppearance);
    }
}

public class Application {

    static int[] parseInts(String... numbers) {
        int[] ret = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            int nr = 0;
            try {
                nr = Integer.parseInt(numbers[i]);
            } catch (NumberFormatException ignored) {
            }
            ret[i] = nr;
        }
        return ret;
    }

    private static boolean isValidNote(String line) {
        return line.matches(
                "C,|D,|E,|F,|G,|A,|B,|C|D|E|F|G|A|B|c|d|e|f|g|a|b|c'|d'|e'|f'|g'|a'|b'");
    }

    public static void main(String[] args) throws IOException {
        Radio bedroomRadio = new Radio();
        bedroomRadio.volumeUp();
        Radio cabooseRadio = new Radio();
        cabooseRadio.volumeUp();
        TV mainTv = new TV();
        Radio crRadio = new Radio();
        Feuermelder alarm = new Feuermelder();
        Ship ship = new Ship();
        ship.load(bedroomRadio);
        ship.load(cabooseRadio);
        ship.load(mainTv);
        ship.load(crRadio);
        ship.load(alarm);
        ship.holiday();

        Gerät ea1 = new Radio();
        ea1.setWatt(200);
        Gerät ea2 = new Radio();
        ea2.setWatt(20);
        Comparator<Gerät> c = new GerätWattVergleich();
        System.out.println(c.compare(ea1, ea2));
        System.out.println(c.compare(ea2, ea1));

        Radio grannysRadio = new Radio();
        grannysRadio.volumeUp();
        grannysRadio.setWatt(12_000);

        TV grandpasTv = new TV();
        grandpasTv.setWatt(1000);

        Ship ship2 = new Ship();
        ship2.load(grannysRadio);
        ship2.load(grandpasTv);

        String[] strings = {"1", "234", "333"};
        int[] ints1 = parseInts(strings);                                // [1, 234, 333]
        int[] ints2 = parseInts("1", "234", "333");                      // [1, 234, 333]
        int[] ints3 = parseInts("1", "ll234", "3", null, "99");          // [1, 0, 3, 0, 99]
        int[] ints4 = parseInts("Person", "Woman", "Man", "Camera, TV"); // [0, 0, 0, 0, 0]
        System.out.println(Arrays.toString(ints1));
        System.out.println(Arrays.toString(ints2));
        System.out.println(Arrays.toString(ints3));
        System.out.println(Arrays.toString(ints4));
        try (PrintWriter writer = new PrintWriter("src/main/java/org/example/writer.txt")) {
            String time = String.valueOf(LocalDateTime.now());
            writer.println(time);
        } catch (FileNotFoundException e) {
            System.out.println("NO SUCH FILE");
        }

        try (Scanner scanner = new Scanner(Paths.get("src/main/java/org/example/notes.txt"))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (isValidNote(line)) {
                    System.out.print(line);
                    System.out.print(" ");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println();

        try {
            Gerät g = new Gerät();
            g.setWatt(-3);
        } catch (IllegalWattException e) {
            System.out.println(e);
            System.out.println("Watt 0 Sinn");
        }
        class HeroYearAndNameComparator implements Comparator<Heroes.Hero> {

            @Override
            public int compare(Heroes.Hero o1, Heroes.Hero o2) {
                int re1 = Integer.compare(o1.yearFirstAppearance, o2.yearFirstAppearance);
                return (!(re1 == 0)) ? re1 : CharSequence.compare(o1.name, o2.name);
            }
        }

        class HeroNameComparator implements Comparator<Heroes.Hero> {

            @Override
            public int compare(Heroes.Hero o1, Heroes.Hero o2) {
                return CharSequence.compare(o1.name, o2.name);
            }
        }

        List<Heroes.Hero> allHeroes = new ArrayList<>(Heroes.ALL);
        System.out.println(allHeroes);
//        allHeroes.sort(new HeroYearComparator2());
        allHeroes.sort(new HeroYearAndNameComparator());
//        allHeroes.sort(new HeroYearComparator2().thenComparing(new HeroNameComparator()));
//        allHeroes.sort(
//                (Heroes.Hero o1, Heroes.Hero o2) -> Integer.compare(o1.yearFirstAppearance, o2.yearFirstAppearance)
//        );
        System.out.println(allHeroes);

        System.out.println(OS.current());

//        double d = 33333.245;
//        for (Locale locale : Locale.getAvailableLocales())
//            System.out.printf(locale, "%s: %,.2f%n", locale, d);
        LocalDate now = LocalDate.of(Year.now().getValue(), Month.SEPTEMBER, 19);
        System.out.println(now);
        System.out.println(now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        System.out.println(now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.ENGLISH)));
        System.out.println(now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.US)));
        System.out.println(now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN)));
        System.out.println(now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.KOREA)));
        System.out.println(now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println(now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
        System.out.println(now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));

        LocalDate beaufortBday = LocalDate.of(1774, Month.MAY, 27);
        LocalDate beaufortBday2 = LocalDate.of(Year.now().getValue(), Month.MAY, 27);
        DayOfWeek dayOfWeek = beaufortBday2.getDayOfWeek();
        System.out.println(dayOfWeek);
        System.out.println(dayOfWeek.getValue());
        System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.GERMANY));
        frOfYear(2024);
        frOfYear(2024);
        String times = "2022-03-12, 20:20 - 2022-03-12, 23:50\n" +
                "2022-04-01, 21:30 - 2022-04-02, 01:20";
        calcAverageTime(times);
//        Scanner scanner = new Scanner(System.in);
//        int tst = scanner.nextInt();
//        String tst2 = scanner.nextLine();
//        System.out.println(tst);
//        System.out.println(tst2);
        System.out.println(LocalDate.now());
        System.out.println(testTimeStrings("2020-10-10"));
        System.out.println(testTimeStrings("2020-12-2"));
        System.out.println(testTimeStrings("1/3/1976"));
        System.out.println(testTimeStrings("1/3/20"));
        System.out.println(testTimeStrings("tomorrow"));
        System.out.println(testTimeStrings("today"));
        System.out.println(testTimeStrings("yesterday"));
        System.out.println(testTimeStrings("1 day ago"));
        System.out.println(testTimeStrings("2234 days ago"));
        double[] numbers = {-199.99};
        System.out.println(detectRoundingMode(numbers, -200));
        System.out.println(completeNumber(123, 22, 989, 77, 9));
        System.out.println();

        String baseName = "Hi";
        try {
            ResourceBundle bundle = ResourceBundle.getBundle(baseName);
            System.out.println(bundle.getString("Hello"));
        } catch (MissingResourceException e) {
            System.err.println(e);
        }
//        Collection<String> strings1 = readWords();
//        System.out.println(wordList( "wristwatches" , strings1));
//        System.out.println(wordList( "abibliophobia" , strings1));
        Receipt receipt = new Receipt();
        receipt.addItem(new Receipt.Item("Peanuts", 222));
        receipt.addItem(new Receipt.Item("Lightsaber", 19999));
        receipt.addItem(new Receipt.Item("Peanuts", 222));
        receipt.addItem(new Receipt.Item("Log book", 1000));
        receipt.addItem(new Receipt.Item("Peanuts", 222));
        System.out.println(receipt);

        String[] words = {
                "Baby Shark", "Corona", "Baby Yoda", "Corona", "Baby Yoda", "Tiger King",
                "David Bowie", "Kylie Jenner", "Kardashian", "Love Island", "Bachelorette",
                "Baby Yoda", "Tiger King", "Billie Eilish", "Corona"
        };
        System.out.println(importantGossip(words));

        NavigableMap<LocalDate, String> dates = new TreeMap<>();
        dates.put(LocalDate.of(2023, 12, 26), "2. Weihnachtsfeiertag");
        dates.put(LocalDate.of(2023, 5, 1), "Tag der Arbeit");
        dates.put(LocalDate.of(2023, 12, 24), "Heiligabend");
        dates.put(LocalDate.of(2023, 12, 25), "1. Weihnachtsfeiertag");
        dates.put(LocalDate.of(2023, 1, 1), "Neujahr");
        dates.put(LocalDate.of(2022, 12, 31), "Silvester");
        System.out.println(dates);
        System.out.println(dates.firstEntry());
        System.out.println(dates.lastEntry());
        System.out.println(dates.higherEntry(LocalDate.of(2023, 1, 6)));
        SortedMap<LocalDate, String> x = dates.subMap(LocalDate.of(2022, 12, 25), LocalDate.of(2023, 1, 7));
        System.out.println(x);
        System.out.println(dates);
//        dates.remove(LocalDate.of(2022, 12, 31));
//        System.out.println(dates);
//        Set<LocalDate> localDates = x.keySet();
//        System.out.println(localDates);
//        for (LocalDate value : localDates) {
//            dates.remove(value);
//        }
//        System.out.println(dates);
//        System.out.println(dates.keySet().removeAll(x.keySet()));
        List<String> names = new ArrayList<>();
        Collections.addAll(names, "", "", "Sonny", "Crockett", "Burnett",
                "Ricardo", "", "Rico", "Tubbs", "Ricardo", "Cooper", "");

//        for ( String name : names )
//            if ( "".equals( name ) )
//                names.remove( name );
//        for(int i = 0; i < names.size(); i++){
//            if ( "".equals( names.get(i) ) )
//                names.remove( i );
//        }
//        System.out.println(names);
        Heroes.ALL.stream().forEach(h -> System.out.println(h.toString()));
        System.out.println(Heroes.ALL.stream().allMatch(h -> h.yearFirstAppearance > 1900));
        System.out.println(Heroes.ALL.stream().anyMatch(h -> h.sex == Heroes.Hero.Sex.FEMALE && h.yearFirstAppearance >= 1950));
        System.out.println(Heroes.ALL.stream().min(Comparator.comparingInt(h -> h.yearFirstAppearance)));
        System.out.println(Heroes.ALL.stream().min(Comparator.comparingInt(h -> Math.abs(h.yearFirstAppearance - 1960))));
        StringBuilder years = new StringBuilder();
        Heroes.ALL.stream().forEach(h -> years.append(String.format("%d, ", h.yearFirstAppearance)));
        System.out.println(years);
        System.out.println(Heroes.ALL.stream().collect(StringBuilder::new, (sb, h) -> sb.append(h.yearFirstAppearance + ", "),
                StringBuilder::append).toString());
        Map<Heroes.Hero.Sex, List<Heroes.Hero>> heroSet = new HashMap<>();
        heroSet = Heroes.ALL.stream().collect(Collectors.groupingBy(h -> h.sex));
        System.out.println(heroSet);
        Map<Boolean, List<Heroes.Hero>> heroSet2 = new HashMap<>();
        heroSet2 = Heroes.ALL.stream().collect(Collectors.groupingBy(h -> h.yearFirstAppearance >= 1970));
        System.out.println(heroSet2);
        System.out.println(Heroes.ALL.stream().filter(h -> h.sex == Heroes.Hero.Sex.FEMALE).count());
        Heroes.ALL.stream().sorted(Comparator.comparingInt(h -> h.yearFirstAppearance)).forEach(System.out::println);
        StringBuilder femHeroes = Heroes.ALL.stream().filter(h -> h.sex == Heroes.Hero.Sex.FEMALE).collect(
                StringBuilder::new,
                ( sb, hero ) -> sb.append( sb.isEmpty() ? "" : "," )
                        .append( hero.name ),
                ( sb1, sb2 ) -> sb1.append( sb2.isEmpty() ? "" : "," + sb2 ).toString()) ;
        System.out.println(femHeroes);
        Heroes.ALL.stream().map( h -> new Heroes.Hero(h.name.replaceAll("\\(.*\\)", "") , h.sex, h.yearFirstAppearance)).forEach(System.out::println);
        System.out.println(Arrays.toString(Heroes.ALL.stream().map(h -> h.yearFirstAppearance).distinct().toArray()));
        Heroes.UNIVERSES.stream().flatMap(Heroes.Universe::heroes).forEach(h -> System.out.println(h.name));
        String[] chosenNames = { "Anne", "Captain CiaoCiao", "Balico", "Charles", "Anne", "CiaoCiao", "CiaoCiao", "Drake", "Anne", "Balico", "CiaoCiao" };
        System.out.println(names.stream().map(h -> (h.equals("Captain CiaoCiao") ? "CiaoCiao".toLowerCase() : h.toLowerCase()))
                .collect(Collectors.groupingBy(h -> h, Collectors.counting())));
    }

    static List<String> importantGossip(String... words) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
//            wordMap.computeIfPresent(word, (k, v) -> v + 1);
//            wordMap.putIfAbsent(word, 1);
//            wordMap.merge(word, 1, (ov, v) -> ov + v );
            wordMap.merge(word, 1, Integer::sum);
        }
        System.out.println(wordMap);
        List<String> ret = new ArrayList<>(wordMap.keySet());
        ret.sort((s1, s2) -> wordMap.get(s2).compareTo(wordMap.get(s1)));
        System.out.println(ret);
        return ret.subList(0, 5);
    }

    static Collection<String> wordList(String string, Collection<String> words) throws IOException {
        Collection<String> ret = new HashSet<>(words);
        String testString = string.toLowerCase();
        ret.removeIf(s -> s.length() < 3);
        ret.removeIf(s -> !testString.contains(s));
        return ret;
    }

    private static Collection<String> readWords() throws IOException {
        String WORD_LIST_URL =
                // "https://raw.githubusercontent.com/creativecouple/all-the-german-words/master/corpus/de.txt";
                "https://raw.githubusercontent.com/dwyl/english-words/master/words_alpha.txt";
        URL url = new URL(WORD_LIST_URL); //    370.000 words
        Collection<String> words = new HashSet<>(500_000);
        try (InputStream is = url.openStream()) {
            new Scanner(is).forEachRemaining(s -> words.add(s.toLowerCase()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return words;
    }

    private static BigInteger completeNumber(int... parts) {
        BigInteger ret = BigInteger.valueOf(0);
        for (int part : parts) {
            if (part >= 100) {
                ret = ret.multiply(BigInteger.valueOf(10));
                ret = ret.add(BigInteger.valueOf(part / 100));
                part = part % 100;
                ret = ret.multiply(BigInteger.valueOf(10));
                ret = ret.add(BigInteger.valueOf(part / 10));
                ret = ret.multiply(BigInteger.valueOf(10));
                part = part % 10;
                ret = ret.add(BigInteger.valueOf(part));
            } else if (part >= 10) {
                ret = ret.multiply(BigInteger.valueOf(10));
                ret = ret.add(BigInteger.valueOf(part / 10));
                ret = ret.multiply(BigInteger.valueOf(10));
                part = part % 10;
                ret = ret.add(BigInteger.valueOf(part));
            } else {
                ret = ret.multiply(BigInteger.valueOf(10));
                ret = ret.add(BigInteger.valueOf(part));
            }
        }
        return ret;
    }

    private static RoundingMode detectRoundingMode(double[] numbers, int i) {
        double sum = 0.0;
        for (double number : numbers) {
            sum += number;
        }
        int ret1 = (int) sum;
        if (ret1 == i)
            return RoundingMode.CAST;
        int ret2 = (int) Math.floor(sum);
        if (ret2 == i)
            return RoundingMode.FLOOR;
        int ret3 = (int) Math.ceil(sum);
        if (ret3 == i)
            return RoundingMode.CEIL;
        int ret4 = (int) Math.rint(sum);
        if (ret4 == i)
            return RoundingMode.RINT;
        int ret5 = (int) Math.round(sum);
        if (ret5 == i)
            return RoundingMode.ROUND;

        return null;
    }

    private static LocalDate testTimeStrings(String s) {
        if (s.contains("-")) {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-d");
            return LocalDate.parse(s, format);
        } else if (s.contains("/")) {
            try {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("d/M/yyyy");
                return LocalDate.parse(s, format);
            } catch (Exception e) {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("d/M/yy");
                return LocalDate.parse(s, format);
            }
        } else if (s.equals("tomorrow")) {
            LocalDate date = LocalDate.now();
            date = date.plusDays(1);
            return date;
        } else if (s.equals("today")) {
            LocalDate date = LocalDate.now();
            return date;
        } else if (s.equals("yesterday")) {
            LocalDate date = LocalDate.now();
            date = date.minusDays(1);
            return date;
        } else if (s.contains("ago")) {
            int days = Integer.valueOf(s.split(" ")[0]);
            LocalDate date = LocalDate.now();
            date = date.minusDays(days);
            return date;
        } else {
            System.out.println("illegal pattern");
            return null;
        }
    }

    enum RoundingMode {
        CAST, ROUND, FLOOR, CEIL, RINT, UNKNOWN;
    }

    private static void calcAverageTime(String times) {
        String[] timesArr = times.split("\n");
        int nrOfDay = timesArr.length;
        Duration sum = Duration.ofMinutes(0L);
        for (String time : timesArr) {
            String[] startAndEnd = time.split(" - ");
            String start = startAndEnd[0];
            String end = startAndEnd[1];
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
            LocalDateTime startD = LocalDateTime.from(LocalDateTime.parse(start, format));
            LocalDateTime endD = LocalDateTime.from(LocalDateTime.parse(end, format));
            Duration duration = Duration.between(startD, endD);
            sum = sum.plus(duration);
            System.out.printf("%dH:%dM%n", duration.toHours(), duration.toMinutesPart());
        }
        System.out.printf("%dH:%dM%n", sum.toHours(), sum.toMinutesPart());
    }

    private static void frOfYear(int i) {
        LocalDate current = LocalDate.of(i, 1, 1);
        while (current.getYear() == i) {
            DayOfWeek dayOfWeek = current.getDayOfWeek();
            int dayOfMonth = current.getDayOfMonth();
            if (dayOfWeek == DayOfWeek.FRIDAY && dayOfMonth == 13) {
                System.out.println(current);
            }
            current = current.plusDays(1);
        }
    }

    private static void frOfYear2(int i) {
        LocalDate current = LocalDate.of(i, 1, 13);
        while (current.getYear() == i) {
            DayOfWeek dayOfWeek = current.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.FRIDAY) {
                System.out.println(current);
            }
            current = current.plusMonths(1);
        }
    }


}
