package trainingLibrary.repository;

import trainingLibrary.dto.AddTrainingRequest;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTrainingRepository implements TrainingRepository {

    private List<AddTrainingRequest> database = new ArrayList<>();
    private long idSequence = 0;

    @Override
    public AddTrainingRequest save(AddTrainingRequest request) {
       request.setId(idSequence);
        idSequence++;
        database.add(request);
        return request;
    }

    @Override
    public List<AddTrainingRequest> findAll() {
        return database;
    }
}
