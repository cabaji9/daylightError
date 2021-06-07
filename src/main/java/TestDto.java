import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * hson
 * 4/6/21
 */
@AllArgsConstructor
@Data
public class TestDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TimeConstants.DATE_PATTERN_TIME,timezone = TimeConstants.TIMEZONE)
    private Date fechaTimeZoneGmt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TimeConstants.DATE_PATTERN_TIME)
    private Date fechaNoTimeZone;
}
