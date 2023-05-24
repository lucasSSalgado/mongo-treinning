package treining.mongo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class StandartError {

    private String msg;
    private Integer status;
    private Instant timeStant;
    private String stackTrace;
    private String path;
}
