import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class Extent {
    private static final String ExtentsFile = "extents.xml";

    public static void saveExtents() throws FileNotFoundException {
        try(XMLEncoder encoder = new XMLEncoder(
                new BufferedOutputStream(new FileOutputStream(ExtentsFile))
        )){
            Driver.writeExtent(encoder);
            Customer.writeExtent(encoder);
            encoder.flush();
        }
    }

    public static void loadExtents() throws FileNotFoundException {
        try(XMLDecoder decoder = new XMLDecoder(
                new BufferedInputStream(new FileInputStream(ExtentsFile))
        )){
            Driver.readExtent(decoder);
            Customer.readExtent(decoder);
        }
    }
}
