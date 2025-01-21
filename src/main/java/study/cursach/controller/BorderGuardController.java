package study.cursach.controller;

import jakarta.inject.Inject;
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
    GetByIdService getByIdService;
    @Inject
    BdFunctionsService bdFunctionsService;

    @GetMapping("/info")
    public ResponseEntity<?> getInfo() {
        try {
            return ResponseEntity.ok(fullInfoService.getNext());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Внутреняя ошибка сервера");
        }
    }

    @GetMapping("/countries")
    public ResponseEntity<?> getCountries() {
        try {
            return ResponseEntity.ok(countryService.getCountries());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Внутреняя ошибка сервера");
        }
    }

    @GetMapping("/job")
    public ResponseEntity<?> getJob() {
        try {
            return ResponseEntity.ok(fullInfoService.getJob());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Внутреняя ошибка сервера");
        }
    }

    @GetMapping("/criminal")
    public ResponseEntity<?> getCriminal() {
        try {
            return ResponseEntity.ok(fullInfoService.getCriminal());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Внутреняя ошибка сервера");
        }
    }

    @GetMapping("/instruction")
    public ResponseEntity<?> getInstruction() {
        try {
            System.out.println(fullInfoService.getInstruction());
            return ResponseEntity.ok(fullInfoService.getInstruction());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Внутреняя ошибка сервера");
        }
    }

    @GetMapping("/customs_param")
    public ResponseEntity<?> getCustomsParam() {
        try {
            return ResponseEntity.ok(fullInfoService.getCustomsParam());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Внутреняя ошибка сервера");
        }
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validate() {
        try {
            return ResponseEntity.ok(bdFunctionsService.validate());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Внутреняя ошибка сервера");
        }
    }

    @GetMapping("/allow")
    public ResponseEntity<?> getAllow() {
        try {
            bdFunctionsService.nextOne(true);
            return ResponseEntity.ok("Success");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Внутреняя ошибка сервера");
        }
    }


    @GetMapping("/decline")
    public ResponseEntity<?> getDecline() {
        try {
            bdFunctionsService.nextOne(false);
            return ResponseEntity.ok("Success");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Внутреняя ошибка сервера");
        }
    }

}
