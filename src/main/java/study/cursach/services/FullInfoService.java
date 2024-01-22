package study.cursach.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Service;
import study.cursach.entity.*;
import study.cursach.repo.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FullInfoService {

    private final ObjectMapper mapper = new ObjectMapper();
    private final CriminalEntityRepository criminalEntityRepository;
    private final CustomsParamEntityRepository customsParamEntityRepository;
    private final InstructionEntityRepository instructionEntityRepository;

    private final NextGeneratedEntityRepository nextGeneratedEntityRepository;
    private final JobEntityRepository jobEntityRepository;
    public FullInfoService(CriminalEntityRepository criminalEntityRepository,
                           CustomsParamEntityRepository customsParamEntityRepository,
                           InstructionEntityRepository instructionEntityRepository,
                           JobEntityRepository jobEntityRepository,
                           NextGeneratedEntityRepository nextGeneratedEntityRepository){
        this.criminalEntityRepository = criminalEntityRepository;
        this.customsParamEntityRepository = customsParamEntityRepository;
        this.instructionEntityRepository = instructionEntityRepository;
        this.jobEntityRepository = jobEntityRepository;
        this.nextGeneratedEntityRepository = nextGeneratedEntityRepository;
    }

    public ArrayNode getJobs() {
        ArrayNode output = mapper.createArrayNode();
        for (JobEntity job : jobEntityRepository.findAll()) {
            output.add(mapper.valueToTree(job));
        }
        return output;
    }

    public ArrayNode getCriminal() {
        ArrayNode output = mapper.createArrayNode();
        for (CriminalEntity criminal : criminalEntityRepository.findAll()) {
            output.add(mapper.valueToTree(criminal));
        }
        return output;
    }

    public ArrayNode getCustomsParam() {
        ArrayNode output = mapper.createArrayNode();
        for (CustomsParamEntity customs : customsParamEntityRepository.findAll()) {
            output.add(mapper.valueToTree(customs));
        }
        return output;
    }

    public ArrayNode getInstruction() {
        ArrayNode output = mapper.createArrayNode();
        for (InstructionEntity instruction : instructionEntityRepository.findAll()) {
            output.add(mapper.valueToTree(instruction));
        }
        return output;
    }

    public JsonNode getNext() {
        JsonNode output = mapper.valueToTree(nextGeneratedEntityRepository.findAllByOrderById().getFirst());
        return output;
    }

}
