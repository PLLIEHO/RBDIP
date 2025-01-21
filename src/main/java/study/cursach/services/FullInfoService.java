package study.cursach.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;
import study.cursach.entity.*;
import study.cursach.repo.*;
import study.cursach.util.Parser;

@Service
public class FullInfoService {

    @Inject
    CriminalEntityRepository criminalEntityRepository;
    @Inject
    CustomsParamEntityRepository customsParamEntityRepository;
    @Inject
    InstructionEntityRepository instructionEntityRepository;
    @Inject
    NextGeneratedEntityRepository nextGeneratedEntityRepository;
    @Inject
    JobEntityRepository jobEntityRepository;
    
    @Inject
    Parser parser;

    private final ObjectMapper mapper = new ObjectMapper();

    
    public ArrayNode getJob() {
        ArrayNode output = mapper.createArrayNode();
        for (JobEntity job : jobEntityRepository.findAll()) {
            output.add(mapper.valueToTree(parser.jobToDTO(job)));
        }
        return output;
    }

    public ArrayNode getCriminal() {
        ArrayNode output = mapper.createArrayNode();
        for (CriminalEntity criminal : criminalEntityRepository.findAll()) {
            output.add(mapper.valueToTree(parser.criminalToDTO(criminal)));
        }
        return output;
    }

    public ArrayNode getCustomsParam() {
        ArrayNode output = mapper.createArrayNode();
        for (CustomsParamEntity customs : customsParamEntityRepository.findAll()) {
            output.add(mapper.valueToTree(parser.customToDTO(customs)));
        }
        return output;
    }

    public ArrayNode getInstruction() {
        ArrayNode output = mapper.createArrayNode();
        for (InstructionEntity instruction : instructionEntityRepository.findAll()) {
            output.add(mapper.valueToTree(parser.instructionToDTO(instruction)));
        }
        return output;
    }

    public JsonNode getNext() {
        var next = nextGeneratedEntityRepository.findAllByOrderById().get(0);
        return mapper.valueToTree(parser.nextToDTO(next));
    }

}
