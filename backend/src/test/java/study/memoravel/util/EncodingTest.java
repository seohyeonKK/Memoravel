package study.memoravel.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EncodingTest {
    @Test
    void BCrypt_인코딩_확인() {
        String input = "asdfasdfasdf";
        String bcrypt1 = Encoding.getBCrypt(input, Encoding.getSalt());
        String bcrypt2 = Encoding.getBCrypt(input, Encoding.getSalt());

        assertThat(bcrypt1).isNotEqualTo(bcrypt2);
    }

    @Test
    void BCrypt_디코딩_확인() {
        String input1 = "asdfasdf";
        String input2 = "ddddddD";
        String bcrypt1 = Encoding.getBCrypt(input1, Encoding.getSalt());
        String bcrypt2 = Encoding.getBCrypt(input2, Encoding.getSalt());

        assertThat(Encoding.checkBCrypt(input1, bcrypt1)).isEqualTo(true);
        assertThat(Encoding.checkBCrypt(input2, bcrypt1)).isEqualTo(false);


    }

}