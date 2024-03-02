package other_programs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlatMapTest {

    public static void calDate() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.UK);
        Date dateBefore = dateFormat.parse("2023-03-30T00:10:00Z");
        Date dateAfter = dateFormat.parse("2023-04-01T00:00:00Z");
        // Approach 1
        System.out.println(dateBefore.toInstant().atZone(ZoneId.of("Europe/London")).toLocalDate());
        long daysDiff = ChronoUnit.DAYS.between(dateBefore.toInstant().atZone(ZoneId.of("Europe/London")).toLocalDate(), dateAfter.toInstant().atZone(ZoneId.of("Europe/London")).toLocalDate());
        System.out.println("The number of days between dates: " + daysDiff);
    }

    public static void decodeJWTToken() {
        String regex = "(?<=\"exp\":)\\d+";
        System.out.println(new Date(System.currentTimeMillis() - 60 * 1000));
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Im4xZHN4ajI4NW1iY2I4dWtudnFxd3FmdDRxa3NwbWoifQ.eyJpc3MiOiJodHRwczovL2FwaTAubzIuY28udWsiLCJhdWQiOiJuYy1lY2FyZSIsImlhdCI6MTY4MDUxNjQ0MywiZXhwIjoxNjgwNTE3MDQzLCJzdWIiOiIyMDAwMDAwMDAwMDAwMDIyMjM3NSIsImF1dGhfdGltZSI6MTY4MDUxNjQxMCwibm9uY2UiOiIzODk1NGQ3Mi1kYmZiLTRhMWEtOGJkZi1hZmExMjM1NmZhM2UiLCJhdXRob3JpemF0aW9uX2lkIjoiZTMxZWMwZGItOGMyYS00MGE0LWJiYjItN2VlY2M4MWNmNGU4IiwiYWNyIjoiMiIsImFtciI6WyJTSUdOX0lOIl0sImlkZW50aXR5X2NhdGVnb3J5IjoibmNfYnNzIiwiZW50aXRsZW1lbnRzIjpbXSwiYmlydGhkYXRlIjoiMTk2Mi0wMy0yOSIsImVtYWlsX3ZlcmlmaWVkIjoidHJ1ZSIsInByb21wdF9wcm9maWxlX3VwZCI6ImZhbHNlIiwicHJlZmVycmVkX3VzZXJuYW1lIjoibGF1cmVuY2xhcmVodWdoQGdtYWlsLmNvbSIsImdpdmVuX25hbWUiOiJLYXJlbiIsImNvbnRhY3RfaWQiOiIzMTY0NDIwNjU0NjE0MjkxODc3IiwiY3VzdG9tZXJfY29udGFjdF9pZCI6IjMxNjQ0MjA2NTQ2MTQyOTE4NzciLCJwaG9uZV92ZXJpZmllZCI6InRydWUiLCJuYW1lIjoiS2FyZW4gQ0xBUkVIVUdIIiwicGhvbmVfbnVtYmVyIjoiKzQ0Nzg1MDI0NDExOCIsImZhbWlseV9uYW1lIjoiQ0xBUkVIVUdIIiwiZW1haWwiOiJsYXVyZW5jbGFyZWh1Z2hAZ21haWwuY29tIn0.gHcVImPWZSyfGApAKcgWg0frwH8bZDBvgmchZoiumM2uvaIfyPAiUZeLRw89-vj9E1lR5XpafduAJR1fcx99uOjgJPSZ0ei7P_s0bGFTQd14ok5VIqaTYVtsJhgDEL2eP6V2KVkCMkzpk_TkQt6TUepWYH8aacddzr6IudibWk9iAxnyozkfFwD1awiZEYkqN6Lp-_68t8q0l7IZ_mbXEnbbUhfxahDd-dEGaMl1L3-tzjjAu8IhAFtGoBekpEXnbMwaC3hQLLMsMJMMpLOhzjbPf-PkzGmbcXXQ9R0gFxcJAbqCBUZkCuT8bojIgF3aBaHNa0UxAi6-6XRYV9LrHw";
        String[] chunks = token.split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();

        String header = new String(decoder.decode(chunks[0]));
        String payload = new String(decoder.decode(chunks[1]));

        System.out.println(payload.contains("exp"));

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(payload);

        if(matcher.find()) {
            System.out.println( matcher.group() );
        }
        System.out.println(payload.matches(regex));

        System.out.println(decoder.decode(chunks[1])[4]);

        System.out.println(header);
        System.out.println(payload);
    }

    public static void checkDate() {
        System.out.println(new Date().getTime());
        System.out.println(new Date());
        System.out.println(new Date().getTime() + 600 * 1000);
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date().getTime() < new Date().getTime());
    }
    public static void main(String[] args) throws ParseException {
          //calDate();
        //checkDate();
        decodeJWTToken();
/*        List<other_programs.Developer> team = new ArrayList<>(Arrays.asList(
                new other_programs.Developer(
                        "id":"00000001-001",
                "device":"Huawei P20 128GB Orange",
                "ccaDurationMonths":"36",
                "ccaCharge":"30000",
                "ccaAmount":"400",
                "totalPaid":"200",
                "numberOfInstallments":"5"),
        {
            "id":"00000002-002",
                "device":"Huawei P20 64GB Green",
                "ccaDurationMonths":"36",
                "ccaCharge":"20000",
                "ccaAmount":"400",
                "totalPaid":"200",
                "numberOfInstallments":"5"
        },
        {
                "id":"00000003-003",
                "device":"Huawei P20 32GB Red",
                "ccaDurationMonths":"36",
                "ccaCharge":"15000",
                "ccaAmount":"400",
                "totalPaid":"200",
                "numberOfInstallments":"5"
        }
    );
        other_programs.Developer polyglot = new other_programs.Developer("esoteric");
        polyglot.add("clojure");
        polyglot.add("scala");
        polyglot.add("groovy");
        polyglot.add("go");

        other_programs.Developer busy = new other_programs.Developer("pragmatic");
        busy.add("java");
        busy.add(null);

        team.add(polyglot);
        team.add(busy);
        team.add(null);
        team = null;

        List<String> teamLanguages = team.stream().
                filter(Objects::nonNull).
                map(other_programs.Developer::getLanguages).
                filter(Objects::nonNull).
                flatMap(Collection::stream).
                collect(Collectors.toList());

        System.out.println(Arrays.toString(teamLanguages.toArray()));
        System.out.println(teamLanguages.containsAll(polyglot.getLanguages()));
        System.out.println((teamLanguages.containsAll(busy.getLanguages())));*/
    }
}