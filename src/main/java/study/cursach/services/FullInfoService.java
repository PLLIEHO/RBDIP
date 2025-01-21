package study.cursach.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(FullInfoService.class);

    private final ObjectMapper mapper = new ObjectMapper();

    
    public ArrayNode getJob() {
        ArrayNode output = mapper.createArrayNode();
        for (JobEntity job : jobEntityRepository.findAll()) {
            output.add(mapper.valueToTree(parser.jobToDTO(job)));
        }
        logger.info("Find all jobs: {}", output);
        return output;
    }

    public ArrayNode getCriminal() {
        ArrayNode output = mapper.createArrayNode();
        for (CriminalEntity criminal : criminalEntityRepository.findAll()) {
            output.add(mapper.valueToTree(parser.criminalToDTO(criminal)));
        }
        logger.info("Find all criminals: {}", output);
        return output;
    }

    public ArrayNode getCustomsParam() {
        ArrayNode output = mapper.createArrayNode();
        for (CustomsParamEntity customs : customsParamEntityRepository.findAll()) {
            output.add(mapper.valueToTree(parser.customToDTO(customs)));
        }
        logger.info("Find all custom params: {}", output);
        return output;
    }

    public ArrayNode getInstruction() {
        ArrayNode output = mapper.createArrayNode();
        for (InstructionEntity instruction : instructionEntityRepository.findAll()) {
            output.add(mapper.valueToTree(parser.instructionToDTO(instruction)));
        }
        logger.info("Find all instructions: {}", output);
        return output;
    }

    public JsonNode getNext() {
        var next = nextGeneratedEntityRepository.findAllByOrderById().get(0);
        logger.info("Find next one: {}", next);
        return mapper.valueToTree(parser.nextToDTO(next));
    }

}
