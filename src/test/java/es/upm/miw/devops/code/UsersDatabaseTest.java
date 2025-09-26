package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsersDatabaseTest {

    @Test
    void testFindUserFamilyNameInitialBySomeProperFraction() {
        UsersDatabase db = new UsersDatabase();

        List<String> initials = db
                .findUserFamilyNameInitialBySomeProperFraction()
                .collect(Collectors.toList());


        assertEquals(List.of("F", "B", "L"), initials);
    }
}