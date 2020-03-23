package ua.lviv.iot.ExtremeSportEquipment.writer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.ExtremeSportEquipment.manager.BaseExtremeSportEquipmentManagerTest;
import ua.lviv.iot.ExtremeSportEquipment.model.AbstractExtremeSportEquipment;

public class EquipmentWriterTest extends BaseExtremeSportEquipmentManagerTest {

    @Test
    public void testWriteToFile() throws IOException {
        try (Writer fileWriter = new FileWriter("Equipment.csv")) {
            EquipmentWriter writer = new EquipmentWriter();
            writer.setWriter(fileWriter);
            writer.writeToFile(equipmentList);
        }
    }

    @Test
    public void testStringWriteToFile() throws IOException {
        try (Writer csvWriter = new StringWriter()) {
            EquipmentWriter writer = new EquipmentWriter();
            writer.setWriter(csvWriter);
            writer.writeToFile(equipmentList);
            String expectedString = "";
            for (AbstractExtremeSportEquipment equip : equipmentList) {
                expectedString += equip.getHeaders() + ", " + equip.toCSV() + "\r\n";
            }
            assertEquals(expectedString, writer.toString());
        }
    }

}