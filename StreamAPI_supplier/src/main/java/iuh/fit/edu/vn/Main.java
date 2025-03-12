package iuh.fit.edu.vn;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import iuh.fit.edu.vn.entity.Supplier;

import java.io.InputStream;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {
    public static void main(String[] args) {
        String targetId = "1";

        try {

            InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("suppliers.json");
            if (inputStream == null) {
                throw new RuntimeException("File suppliers.json khong ton tai trong resources!");
            }

            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(inputStream);


            Stream<JsonNode> supplierStream = StreamSupport.stream(rootNode.spliterator(), false);

            // Tìm supplier theo ID
            Optional<Supplier> foundSupplier = supplierStream
                    .map(node -> new Supplier(
                            node.get("id").asText(),
                            node.get("name").asText(),
                            node.get("address").asText()))
                    .filter(supplier -> Objects.equals(supplier.getId(), targetId))
                    .findFirst();

            // Hiển thị kết quả
            foundSupplier.ifPresentOrElse(
                    supplier -> System.out.println("Tim thay: " + supplier),
                    () -> System.out.println("Khong tim thay supplier voi ID: " + targetId)
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
