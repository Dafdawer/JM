import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

public class Test {
    public static void main(String[] args) {
    }

    class Animal implements Serializable {
        private final String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Animal) {
                return Objects.equals(name, ((Animal) obj).name);
            }
            return false;
        }
    }

    public static Animal[] deserializeAnimalArray(byte[] data) throws IOException {

        Animal[] deserialized;

        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {

            deserialized = new Animal[ois.readInt()];
            for (int i = 0; i < deserialized.length; i++) {
                deserialized[i] = (Animal) ois.readObject();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return deserialized;
    }
}
