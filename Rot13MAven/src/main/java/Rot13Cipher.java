public class Rot13Cipher {
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private String base;
    private String encoded;
    private String decoded;

    public Rot13Cipher(String toEncode) {
        this();
        base = toEncode;
    }

    public Rot13Cipher() {
        base = "";
        encoded = "";
        decoded = "";
    }

    public String getBase() {
        return base;
    }

    public void encode() {
        //a -> d
        StringBuilder tempEncode = new StringBuilder();
        for (int i = 0; i < base.length(); i++) {
            char letter = base.charAt(i);

            if (!Character.isLetter(letter)) continue;

            final boolean isLower = Character.isLowerCase(letter);
            if (!isLower) {
                letter = Character.toLowerCase(letter);
            }
            final int position = alphabet.indexOf(letter);
            final char c = alphabet.charAt(getEncodedPosition(position));

            tempEncode.append(isLower ? c : Character.toUpperCase(c));
        }


        encoded = tempEncode.toString();
    }

    private int getEncodedPosition(int position) {
        return (position + 13) % 26;
    }

    public String getEncode() {
        return encoded;
    }

    public void decode() {
        //d -> a
        StringBuilder tempEncode = new StringBuilder();
        for (int i = 0; i < base.length(); i++) {
            char letter = base.charAt(i);
            final boolean isLower = Character.isLowerCase(letter);
            if (!isLower) {
                letter = Character.toLowerCase(letter);
            }
            final int position = alphabet.indexOf(letter);
            final char c = alphabet.charAt(getDecodedPosition(position));

            tempEncode.append(isLower ? c : Character.toUpperCase(c));
        }


        decoded = tempEncode.toString();
    }

    private int getDecodedPosition(int position) {
        return (position + 13) % 26;
    }

    public String getDecoded() {
        return decoded;
    }
}

