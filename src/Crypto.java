import java.util.*;

public class Crypto implements Map {

    private String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
            "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "0", ",", ".", "(", ")", "\"", "-", "_", ";", ":", "/", "\'", "<", ">", "\\", "|", "!", "?",
            "$", "£", "*", "[", "]", "{", "}", "+", "=", "&"};
    private int encryptionKey;
    private Map<String, String> encryption = new HashMap<>();
    private Map<String, String> decryption = new HashMap<>();

    public Crypto(int encryptionKey) {
        this.encryptionKey = encryptionKey;
        encryptionMap();
        decryptionMap();
    }

    public void encryptLines() {
        ArrayList<String> lines = new ArrayList<>();
        FileReader.read(lines);
        for (int i = 0; i < lines.size(); i++) {
            lines.set(i, encryptWords(lines.get(i)));
        }
        FileReader.print(lines);
    }

    private String encryptWords(String text) {
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("")) {
                words[i] = "";
            } else {
                words[i] = encryptLetters(words[i]);
            }
        }
        text = String.join(" ", words);
        return text;
    }

    private String encryptLetters(String text) {
        String[] letters = text.split("");
        for (int i = 0; i < letters.length; i++) {
            if (letters[i].equals("")) {
                letters[i] = "";
            } else {
                letters[i] = encryption.get(letters[i]);
            }
        }

        text = String.join("", letters);
        return text;
    }

    public void decryptLines() {
        ArrayList<String> lines = new ArrayList<>();
        FileReader.read(lines);
        for (int i = 0; i < lines.size(); i++) {
            lines.set(i, decryptWords(lines.get(i)));
        }
        FileReader.print(lines);
    }

    private String decryptWords(String text) {
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("")) {
                words[i] = "";
            } else {
                words[i] = decryptLetters(words[i]);
            }
        }
        text = String.join(" ", words);

        return text;
    }

    private String decryptLetters(String text) {
        String[] letters = text.split("");
        for (int i = 0; i < letters.length; i++) {
            if (letters[i].equals("")) {
                letters[i] = "";
            } else {
                letters[i] = decryption.get(letters[i]);
            }
        }

        text = String.join("", letters);

        return text;
    }

    private void encryptionMap() throws NullPointerException{
        for (int i = 0; i < letters.length; i++) {
            if ((i + encryptionKey) >= letters.length) {
                encryption.put(letters[i], letters[(i + encryptionKey) - letters.length]);
            } else if ((i + encryptionKey) <= letters.length){
                encryption.put(letters[i], letters[i + encryptionKey]);
            }
        }
    }

    private void decryptionMap() {
        for (int i = 0; i < letters.length; i++) {
            if ((i + encryptionKey) >= letters.length) {
                decryption.put(letters[(i + encryptionKey) - letters.length], letters[i]);
            } else if ((i + encryptionKey) <= letters.length){
                decryption.put(letters[i + encryptionKey], letters[i]);
            }
        }
    }

    private String[] getLetters() {
        return letters;
    }

    private void setLetters(String[] letters) {
        this.letters = letters;
    }

    private int getKey() {
        return encryptionKey;
    }

    private void setKey(int encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    private Map<String, String> getEncryption() {
        return encryption;
    }

    private void setEncryption(Map<String, String> encryption) {
        this.encryption = encryption;
    }

    private Map<String, String> getDecryption() {
        return decryption;
    }

    private void setDecryption(Map<String, String> decryption) {
        this.decryption = decryption;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}
