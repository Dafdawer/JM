import java.io.*;
import java.nio.charset.Charset;

public class Test3 {

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {

        Reader reader = new InputStreamReader(inputStream, charset);
        int charRead;
        StringBuilder sb = new StringBuilder();
        while ((charRead = reader.read()) != -1) {
            sb.append((char) charRead);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {

        int charRead;

        while ((charRead = inputStream.read()) != -1) {
            if (charRead % 2 == 0) {
                outputStream.write((byte) charRead);
            }
        }

        inputStream.close();
        outputStream.flush();
        outputStream.close();
    }

    public static void main(String[] args) throws IOException {

        readAsString(new ByteArrayInputStream(new byte[] {49, 50, 51, 52}), Charset.forName("ASCII"));
        }
}



