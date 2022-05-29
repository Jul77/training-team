package trainingLibrary.dto;

import lombok.Value;

@Value
public class SearchTrainingRequest {

    String trainer;
    String trainingChoice;
    Integer userId;
}
