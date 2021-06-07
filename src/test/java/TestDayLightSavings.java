import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

/**
 * hson
 * 4/6/21
 */
public class TestDayLightSavings {

    private ObjectMapper objectMapper= new ObjectMapper();;



    @Test
    public void testDayLight() throws IOException {
        System.out.println("CAMBIO ---> A AMERICA/GUAYAQUIL");
        TimeZone.setDefault(TimeZone.getTimeZone("America/Guayaquil"));
        Date fechaAhora = getDate();
        System.out.println(fechaAhora);

        assertEquals("Mon Feb 01 00:00:00 ECST 1993",fechaAhora.toString()); //ECST --> Ecuadorian summer time
        String fechaString = objectMapper.writeValueAsString(new TestDto(fechaAhora,fechaAhora));
        System.out.println(fechaString);

        assertEquals("{\"fechaTimeZoneGmt\":\"1993-01-31 11:00:00\",\"fechaNoTimeZone\":\"1993-02-01 04:00:00\"}",fechaString);


        System.out.println("\n\nCAMBIO A GMT-5 -->");
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-5"));
        fechaAhora = getDate();
        System.out.println(fechaAhora);
         fechaString = objectMapper.writeValueAsString(new TestDto(fechaAhora,fechaAhora));
        System.out.println(fechaString);



        assertEquals("Mon Feb 01 00:00:00 GMT-05:00 1993",fechaAhora.toString());




        //
    }


    private static Date getDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1993, 1, 1, 0, 0, 0);
        return calendar.getTime();
    }
}
