package es.upm.miw.devops.code;

import java.util.List;
import java.util.stream.Stream;

public class UsersDatabase {

    public Stream<User> findAll() {

        List<Fraction> fractions1 = List.of(
                new Fraction(0, 1),
                new Fraction(1, 1),
                new Fraction(2, 1)
        );
        List<Fraction> fractions2 = List.of(
                new Fraction(2, 1),
                new Fraction(-1, 5),
                new Fraction(2, 4),
                new Fraction(4, 3)
        );
        List<Fraction> fractions3 = List.of(
                new Fraction(1, 5),
                new Fraction(3, -6),
                new Fraction(1, 2),
                new Fraction(4, 4)
        );
        List<Fraction> fractions4 = List.of(
                new Fraction(2, 2),
                new Fraction(4, 4)
        );
        List<Fraction> fractions5 = List.of(
                new Fraction(0, 1),
                new Fraction(0, -2),
                new Fraction(0, 3)
        );

        List<Fraction> fractions6 = List.of(
                new Fraction(0, 0),
                new Fraction(1, 0),
                new Fraction(1, 1)
        );

        return Stream.of(
                new User("1", "Oscar", "Fernandez", fractions1),
                new User("2", "Ana", "Blanco", fractions2),
                new User("3", "Oscar", "López", fractions3),
                new User("4", "Paula", "Torres", fractions4),
                new User("5", "Antonio", "Blanco", fractions5),
                new User("6", "Paula", "Torres", fractions6)
        );

    }
    public Stream<String> findUserFamilyNameInitialBySomeProperFraction() {
        return this.findAll()
                .filter(user -> user.getFractions().stream().anyMatch(Fraction::isProper))
                .map(user -> user.getFamilyName().substring(0, 1))
                .distinct();
    }
    public Fraction findHighestFraction() {
        return this.findAll()
                .flatMap(user -> user.getFractions().stream())
                // 过滤掉分母为 0 的非法分数，避免 NaN/异常
                .filter(f -> f.getDenominator() != 0)
                .max(java.util.Comparator.comparingDouble(
                        f -> (double) f.getNumerator() / f.getDenominator()))
                .orElse(null);
    }
    public Fraction findFractionDivisionByUserId(String id) {
        return this.findAll()
                .filter(user -> user.getId().equals(id))
                .flatMap(user -> user.getFractions().stream())
                .reduce((a, b) -> new Fraction(
                        a.getNumerator() * b.getDenominator(),
                        a.getDenominator() * b.getNumerator()
                ))
                .orElse(null);
    }
    public Stream<String> findUserFamilyNameBySomeImproperFraction() {
        return this.findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(f -> f.getNumerator() >= f.getDenominator()))
                .map(User::getFamilyName);
    }

}
//1