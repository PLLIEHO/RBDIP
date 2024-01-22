package study.cursach.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.cursach.dto.Form;
import study.cursach.dto.Id;
import study.cursach.services.*;

@CrossOrigin
@RestController
@RequestMapping("")
public class BorderGuardController {

    CountryService countryService;
    FullInfoService fullInfoService;
    GetByIdService getByIdService;
    BdFunctionsService bdFunctionsService;
    AuthService authService;

    public BorderGuardController(CountryService countryService,
                                 FullInfoService fullInfoService,
                                 GetByIdService getByIdService,
                                 BdFunctionsService bdFunctionsService,
                                 AuthService authService){
        this.getByIdService = getByIdService;
        this.countryService = countryService;
        this.fullInfoService = fullInfoService;
        this.bdFunctionsService = bdFunctionsService;
        this.authService = authService;
    }

    @GetMapping("/info")
    public ResponseEntity<?> getInfo(){
        try{
            System.out.println("abeeba");
            return ResponseEntity.ok(fullInfoService.getNext());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("База данных умерла :((((");
        }
    }

    @GetMapping("/countries")
    public ResponseEntity<?> getCountries(){
        try{
            return ResponseEntity.ok(countryService.getCountries());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("База данных умерла :((((");
        }
    }

    @GetMapping("/job")
    public ResponseEntity<?> getJob(){
        try{
            return ResponseEntity.ok(fullInfoService.getJobs());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("База данных умерла :((((");
        }
    }

    @GetMapping("/criminal")
    public ResponseEntity<?> getCriminal(){
        try{
            return ResponseEntity.ok(fullInfoService.getCriminal());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("База данных умерла :((((");
        }
    }

    @GetMapping("/instruction")
    public ResponseEntity<?> getInstruction(){
        try{
            System.out.println(fullInfoService.getInstruction());
            return ResponseEntity.ok(fullInfoService.getInstruction());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("База данных умерла :((((");
        }
    }

    @GetMapping("/customs_param")
    public ResponseEntity<?> getCustomsParam(){
        try{
            return ResponseEntity.ok(fullInfoService.getCustomsParam());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("База данных умерла :((((");
        }
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validate(){
        try{
            return ResponseEntity.ok(bdFunctionsService.validate());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("База данных умерла :((((");
        }
    }

    @GetMapping("/allow")
    public ResponseEntity<?> getAllow(){
        try{
            bdFunctionsService.nextOne(true);
            return ResponseEntity.ok("Success");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Fail");
        }
    }
    //Функция это просто манипуляции в БД, поэтому возвращает успешно/неуспешно


    @GetMapping("/decline")
    public ResponseEntity<?> getDecline(){
        try{
            bdFunctionsService.nextOne(false);
            return ResponseEntity.ok("Success");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Fail");
        }
    }
    //Функция это просто манипуляции в БД, поэтому возвращает успешно/неуспешно


    @PostMapping("/purpose")
    public ResponseEntity<?> getPurpose(@RequestBody Id id){
        try{
            System.out.println(id.getId());
            return ResponseEntity.ok(getByIdService.getEntryPurpose(id.getId()));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("База данных умерла :((((");
        }
    }

    @PostMapping("/category")
    public ResponseEntity<?> getCategory(@RequestBody Id id){
        try{
            return ResponseEntity.ok(getByIdService.getCustomsInfo(id.getId()));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("База данных умерла :((((");
        }
    }

    @PostMapping("/company")
    public ResponseEntity<?> getCompany(@RequestBody Id id){
        try{
            return ResponseEntity.ok(getByIdService.getCompanyName(id.getId()));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("База данных умерла :((((");
        }
    }

    @PostMapping("/job")
    public ResponseEntity<?> getJob(@RequestBody Id id){
        try{
            return ResponseEntity.ok(getByIdService.getJobTypeName(id.getId()));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("База данных умерла :((((");
        }
    }

    @PostMapping("/entry")
    public ResponseEntity<?> getEntry(@RequestBody Id id){
        try{
            return ResponseEntity.ok(getByIdService.isInEntryList(id.getId()));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("База данных умерла :((((");
        }
    }

    @PostMapping("/auth")
    public ResponseEntity<?> postAuth(@RequestBody Form form){
        try{
            return ResponseEntity.ok(authService.auth(form.getLogin(), form.getPass()));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(false);
        }
    }
}
