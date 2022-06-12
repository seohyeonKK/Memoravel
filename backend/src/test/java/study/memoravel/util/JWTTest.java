package study.memoravel.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JWTTest {
    @Test
    void JWT_생성_확인() {
        int id1 = 555;
        String nickname1 = "asdfasdfsadf";
        String jwt1 = JWT.create(id1, nickname1);

        int id2 = 555;
        String nickname2 = "asdfasdfsadf";
        String jwt2 = JWT.create(id2, nickname2);

        int id3 = 565;
        String nickname3 = "asdfasdfsaddf";
        String jwt3 = JWT.create(id3, nickname3);

        assertThat(jwt1).isNotEqualTo(jwt2);
        assertThat(jwt1).isNotEqualTo(jwt3);
    }

    @Test
    void JWT_id_파싱_확인() {
        int id = 1234;
        String nickname = "asffddss";
        String jwt = JWT.create(id, nickname);

        int parsedId = JWT.getIdFromJWT(jwt);

        assertThat(id).isEqualTo(parsedId);

    }
}