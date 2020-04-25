import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Cipher Cesar under test")
class Rot13CipherTest {

    @DisplayName("When no arg constructor then empty encode string and empty decode string")
    @Test
    public void emptyArgConstructorReturnEmptyString() {
        //given
        final Rot13CipherTest cipher = new Rot13CipherTest();
        //when
        //then
        assertEquals("", cipher.getBase());
        assertEquals("", cipher.getEncode());
        assertEquals("", cipher.getDecoded());
    }

    @DisplayName("Check encode function")
    @ParameterizedTest(name = "Test case {index} : input {0} gives result {1}")
    @CsvSource({"abc,nop", "xyz,klm", "xYz,kLm", "x Y z,nOp","'',''"})
    public void getEncodeStringWhenGivenParamInput(
            String entry, String result
    ) {
        //given
        final Rot13CipherTest cipher = new Rot13CipherTest(entry);
        //when
        cipher.encode();
        String encode = cipher.getEncode();
        //then
        assertEquals(result, encode);

    }

    @DisplayName("Check decode function")
    @ParameterizedTest(name = "Test case {index} : input {0} gives result {1}")
    @CsvSource({"def,abc", "abc,xyz", "aBc,xYz"})
    public void getDecodeStringWhenGivenParamInput(
            String entry, String result
    ) {
        //given
        final Rot13CipherTest cipher = new Rot13CipherTest(entry);
        //when
        cipher.decode();
        String decoded = cipher.getDecoded();
        //then
        assertEquals(result, decoded);

    }
}
