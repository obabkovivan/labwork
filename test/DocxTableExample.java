package org.example.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.docx4j.XmlUtils;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.*;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBElement;
import java.io.File;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DocxTableExample {

    public static void main(String[] args) throws Exception {
        List<ShipmentDto> shipmentDtos = getShipmentData("5741");
        Map<String, String> vedField = new HashMap<>();
        vedField.put("Пункт назначения", "UF_CRM_1738518243043");
        vedField.put("Отгружаемый вес, тонн", "UF_CRM_1728907452867");
        vedField.put("Отгружаемый вес с БАЗЫ, тонн", "UF_CRM_1731344091649");
        vedField.put("Вес контейнера, КГ", "UF_CRM_1738255902758");
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new File("упаковочный_таблица.docx"));

        Map<String, String> globalPlaceholders = new HashMap<>(Map.of(
                "packingListNumber", "PL-2025-001",
                "invoiceDate", "19.05.2025",
                "contractNumber", "CN-304",
                "contractDate", "01.05.2025",
                "specNumber", "SP-221",
                "nameGruz", "ООО «Агро-Трейд»",
                "adressGruz", "г. Воронеж, ул. Ленина, д. 10",
                "nameAgentGruz", "ООО «ИмпортГруз»",
                "adressAgentGruz", "г. Санкт-Петербург, ул. Морская, д. 22",
                "nameAgent", "ООО «МаслоПродукт»"
        ));
        globalPlaceholders.put("adressAgent", "г. Москва, пр-т Мира, д. 101");

        replacePlaceholdersInDocument(wordMLPackage.getMainDocumentPart(), globalPlaceholders);

        List<Map<String, String>> containers = new ArrayList<>();
        for (var dto : shipmentDtos) {
            containers.add(Map.of("number", dto.getContainerNumber(),
                    "type", dto.getSeal(),
                    "prodDate", dto.getDate(),
                    "weight", dto.getOilWeight(),
                    "grossweight", String.valueOf(
                            Integer.parseInt(dto.getOilWeight()) +
                                    Integer.parseInt(dto.getContainerWeight()))));
        }

        List<Object> tables = wordMLPackage.getMainDocumentPart().getJAXBNodesViaXPath("//w:tbl", true);
        if (tables.isEmpty()) {
            System.err.println("Таблица не найдена!");
            return;
        }

        Tbl table = (Tbl) ((JAXBElement<?>) tables.get(1)).getValue();
        List<Object> rows = table.getContent();
        Tr templateRow = (Tr) rows.get(rows.size() - 1);

        for (Map<String, String> data : containers) {
            Tr newRow = XmlUtils.deepCopy(templateRow);
            smartReplacePlaceholders(newRow, data);
            table.getContent().add(newRow);
        }

        table.getContent().remove(templateRow); // Удаляем шаблонную строку
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        wordMLPackage.save(new File("Упаковочный от " + LocalDate.now().format(formatter) + ".docx"));
    }

    private static void replacePlaceholdersInDocument(ContentAccessor parent, Map<String, String> data) {
        for (Object obj : parent.getContent()) {
            if (obj instanceof JAXBElement) obj = ((JAXBElement<?>) obj).getValue();
            if (obj instanceof Text) {
                Text text = (Text) obj;
                String val = text.getValue();
                System.out.println(val);
                for (Map.Entry<String, String> entry : data.entrySet()) {
                    val = val.replace("{" + entry.getKey() + "}", entry.getValue());
                }
                text.setValue(val);
            } else if (obj instanceof ContentAccessor) {
                replacePlaceholdersInDocument((ContentAccessor) obj, data);
            }
        }
    }

    private static void smartReplacePlaceholders(Object obj, Map<String, String> data) {
        if (!(obj instanceof ContentAccessor)) return;

        List<Object> contents = ((ContentAccessor) obj).getContent();
        for (int i = 0; i < contents.size(); i++) {
            Object item = contents.get(i);
            if (item instanceof JAXBElement) item = ((JAXBElement<?>) item).getValue();

            if (item instanceof ContentAccessor) {
                smartReplacePlaceholders(item, data);
            } else if (item instanceof Text) {
                Text text = (Text) item;
                String val = text.getValue();
                System.out.println(val);
                for (Map.Entry<String, String> entry : data.entrySet()) {
                    if (val.contains("{" + entry.getKey() + "}")) {
                        text.setValue(val.replace("{" + entry.getKey() + "}", entry.getValue()));
                    }
                }
            }
        }
    }

    public static List<ContractDto> getAllContracts() {
        List<JsonNode> contracts = getDealsByCategory("7", List.of("ID", "UF_CRM_1728301107", "STAGE_ID"));

        List<ContractDto> result = new ArrayList<>();
        for (JsonNode contract : contracts) {
            if (!contract.path("STAGE_ID").asText().equals("C7:WON")) {
                ContractDto dto = new ContractDto();
                dto.setId(contract.path("ID").asText());
                dto.setTitle(contract.path("UF_CRM_1728301107").asText());
                result.add(dto);
            }

        }
        return result;
    }


    public static List<JsonNode> getDealsByCategory(String categoryId, List<String> fields) {
        Map<String, String> filters = Map.of("CATEGORY_ID", categoryId);
        return getDealsByFilter(filters, fields);
    }


    public static List<JsonNode> getDealsByFilter(Map<String, String> filter, List<String> selectFields) {
        ObjectMapper objectMapper = new ObjectMapper();
        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate restTemplate = builder.build();

        try {
            StringBuilder urlBuilder = new StringBuilder("https://apkvega.bitrix24.ru/rest/9/wm54m2ay8obzyzyi/crm.deal.list.json");
            urlBuilder.append("?");

            for (Map.Entry<String, String> entry : filter.entrySet()) {
                if (entry.getKey().equals("STAGE_ID"))
                    urlBuilder.append("filter[").append(entry.getKey()).append("]=")
                            .append(entry.getValue())
                            .append("&");
                else
                    urlBuilder.append("filter[").append(entry.getKey()).append("]=")
                            .append(URLEncoder.encode(String.valueOf(entry.getValue()), StandardCharsets.UTF_8))
                            .append("&");
            }

            for (String field : selectFields) {
                urlBuilder.append("select[]=").append(field).append("&");
            }

            String url = urlBuilder.substring(0, urlBuilder.length() - 1);

            System.out.println(url);

            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                JsonNode resultNode = objectMapper.readTree(response.getBody()).path("result");
                if (resultNode.isArray()) {
                    List<JsonNode> deals = new ArrayList<>();
                    for (JsonNode deal : resultNode) {
                        deals.add(deal);
                    }
                    return deals;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    public static List<ShipmentDto> getShipmentData(String contractId) {
        List<JsonNode> shipments = getDealsByParentIdAndCategory(contractId, "21", List.of(
                "UF_CRM_1728052920136",
                "UF_CRM_1728128389251",
                "UF_CRM_1731572033529",
                "UF_CRM_1734364159952",
                "UF_CRM_1734364013259",
                "UF_CRM_1729449886727",
                "ID"
        ));

        List<ShipmentDto> result = new ArrayList<>();
        for (JsonNode shipment : shipments) {
            ShipmentDto dto = new ShipmentDto();
            dto.setId(shipment.path("ID").asText());
            dto.setDate(parseDate(shipment.path("UF_CRM_1728052920136").asText()));
            dto.setCarNumber(shipment.path("UF_CRM_1728128389251").asText());
            dto.setContainerNumber(shipment.path("UF_CRM_1731572033529").asText());
            dto.setContainerWeight(shipment.path("UF_CRM_1734364159952").asText());
            dto.setSeal(shipment.path("UF_CRM_1734364013259").asText());
            dto.setOilWeight(shipment.path("UF_CRM_1729449886727").asText());
            result.add(dto);
        }
        return result;
    }

    public static List<JsonNode> getDealsByParentIdAndCategory(String parentId, String categoryId, List<String> fields) {
        Map<String, String> filters = Map.of(
                "CATEGORY_ID", categoryId,
                "UF_CRM_1733323527", parentId
        );
        return getDealsByFilter(filters, fields);
    }

    private static String parseDate(String raw) {
        if (raw == null || raw.isEmpty()) return "-";
        return raw.substring(8, 10) + "." + raw.substring(5, 7) + "." + raw.substring(0, 4);
    }
}
