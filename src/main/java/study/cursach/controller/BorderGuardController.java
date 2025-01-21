package study.cursach.controller;

import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.cursach.services.*;


@CrossOrigin
@RestController
@RequestMapping("")
public class BorderGuardController {

    @Inject
    CountryService countryService;
    @Inject
    FullInfoService fullInfoService;
    @Inject
    BdFunctionsService bdFunctionsService;

    Logger logger = LoggerFactory.getLogger(BorderGuardController.class);


    @GetMapping("/info")
    public ResponseEntity<?> getInfo() {
        try {
            logger.info("Get info request");
            return ResponseEntity.ok(fullInfoService.getNext());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Внутреняя ошибка сервера");
        }
    }

    @GetMapping("/countries")
    public ResponseEntity<?> getCountries() {
        try {
            logger.info("Get countries request");
            return ResponseEntity.ok(countryService.getCountries());
        } catch (Exception e) {
            logger.error("500 sent to client from countries");
            return ResponseEntity.status(500).body("Внутреняя ошибка сервера");
        }
    }

    @GetMapping("/job")
    public ResponseEntity<?> getJob() {
        try {
            logger.info("Get job request");
            return ResponseEntity.ok(fullInfoService.getJob());
        } catch (Exception e) {
            logger.error("500 sent to client from job");
            return ResponseEntity.status(500).body("Внутреняя ошибка сервера");
        }
    }

    @GetMapping("/criminal")
    public ResponseEntity<?> getCriminal() {
        try {
            logger.info("Get criminal request");
            return ResponseEntity.ok(fullInfoService.getCriminal());
        } catch (Exception e) {
            logger.error("500 sent to client from criminal");
            return ResponseEntity.status(500).body("Внутреняя ошибка сервера");
        }
    }

    @GetMapping("/instruction")
    public ResponseEntity<?> getInstruction() {
        try {
            logger.info("Get instruction request");
            return ResponseEntity.ok(fullInfoService.getInstruction());
        } catch (Exception e) {
            logger.error("500 sent to client from instruction");
            return ResponseEntity.status(500).body("Внутреняя ошибка сервера");
        }
    }

    @GetMapping("/customs_param")
    public ResponseEntity<?> getCustomsParam() {
        try {
            logger.info("Get customs_param request");
            return ResponseEntity.ok(fullInfoService.getCustomsParam());
        } catch (Exception e) {
            logger.error("500 sent to client from customs_param");
            return ResponseEntity.status(500).body("Внутреняя ошибка сервера");
        }
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validate() {
        try {
            logger.info("Get validate request");
            return ResponseEntity.ok(bdFunctionsService.validate());
        } catch (Exception e) {
            logger.error("500 sent to client from validate");
            return ResponseEntity.status(500).body("Внутреняя ошибка сервера");
        }
    }

    @GetMapping("/allow")
    public ResponseEntity<?> getAllow() {
        try {
            logger.info("Get allow request");
            bdFunctionsService.nextOne(true);
            return ResponseEntity.ok("Success");
        } catch (Exception e) {
            logger.error("500 sent to client from allow");
            return ResponseEntity.status(500).body("Внутреняя ошибка сервера");
        }
    }


    @GetMapping("/decline")
    public ResponseEntity<?> getDecline() {
        try {
            logger.info("Get decline request");
            bdFunctionsService.nextOne(false);
            return ResponseEntity.ok("Success");
        } catch (Exception e) {
            logger.error("500 sent to client from decline");
            return ResponseEntity.status(500).body("Внутреняя ошибка сервера");
        }
    }

}
