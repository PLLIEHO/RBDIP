package study.cursach.services;

import org.springframework.stereotype.Service;
import study.cursach.dto.Validation;
import study.cursach.entity.DocumentPack;
import study.cursach.entity.NextGeneratedEntity;
import study.cursach.repo.DocumentPackRepository;
import study.cursach.repo.NextGeneratedEntityRepository;
import study.cursach.repo.PassportRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class BdFunctionsService {

    private final NextGeneratedEntityRepository nextGeneratedEntityRepository;
    private final PassportRepository passportRepository;

    private final DocumentPackRepository documentPackRepository;

    public BdFunctionsService(NextGeneratedEntityRepository nextGeneratedEntityRepository,
                              PassportRepository passportRepository,
                              DocumentPackRepository documentPackRepository){
        this.nextGeneratedEntityRepository = nextGeneratedEntityRepository;
        this.passportRepository = passportRepository;
        this.documentPackRepository = documentPackRepository;
    }

    public void nextOne(boolean accepted){
        NextGeneratedEntity now = nextGeneratedEntityRepository.findAllByOrderById().getFirst();

        if (accepted){
            nextGeneratedEntityRepository.allow(passportRepository.findAll().getLast().getId());
        }

//        nextGeneratedEntityRepository.next_one(now.getName(), now.getSurname(), now.getLastname(), now.getNationality(),
//                now.getEyeColor(), now.getFingerprint(), now.getPsname(), now.getPssurname(), now.getPslastname(),
//                now.getPseyeColor(), now.getPsnationality(), now.getEnname(), now.getEnsurname(), now.getEnlastname(),
//                now.getEndateGaned(), now.getEndateExpired(), now.getEnpurpose(), now.getWorkname(), now.getWorksurname(),
//                now.getWorklastname(), now.getWorkcompany(), now.getLugsize(), now.getLugweight(), now.getLugcategory(),
//                now.getDecname(), now.getDecsurname(), now.getDeclastname(), now.getDecsize(), now.getDecweight(),
//                now.getDeccat());

        nextGeneratedEntityRepository.deleteById(now.getId());
        // Удаляем прибывшиго гостя, так как он уже не следующий
    }

    public Validation validate() throws InterruptedException {
        NextGeneratedEntity now = nextGeneratedEntityRepository.findAllByOrderById().getFirst();

        nextGeneratedEntityRepository.next_one(now.getName(), now.getSurname(), now.getLastname(), now.getNationality(),
                now.getEyeColor(), now.getFingerprint(), now.getPsname(), now.getPssurname(), now.getPslastname(),
                now.getPseyeColor(), now.getPsnationality(), now.getEnname(), now.getEnsurname(), now.getEnlastname(),
                now.getEndateGaned(), now.getEndateExpired(), now.getEnpurpose(), now.getWorkname(), now.getWorksurname(),
                now.getWorklastname(), now.getWorkcompany(), now.getLugsize(), now.getLugweight(), now.getLugcategory(),
                now.getDecname(), now.getDecsurname(), now.getDeclastname(), now.getDecsize(), now.getDecweight(),
                now.getDeccat());

        Validation output = new Validation();
        output.setPassport(nextGeneratedEntityRepository.passport_check());
        System.out.println(output.getPassport());
        Thread.sleep(100);
        output.setEntry(nextGeneratedEntityRepository.entry_check());
        System.out.println(output.getEntry());
        Thread.sleep(100);
        DocumentPack documentPack = documentPackRepository.findAll().getFirst();
        System.out.println(documentPack.getWorkPermissionId());
        if (documentPack.getWorkPermissionId() != null){
            output.setWork(nextGeneratedEntityRepository.work_check());
        }
        Thread.sleep(100);
        if (documentPack.getDeclarationId() != null){
            output.setDeclaration(nextGeneratedEntityRepository.declaration_check());
        }
        Thread.sleep(100);
        output.setCriminal(nextGeneratedEntityRepository.criminal_check());
        System.out.println(output.toString());
        Thread.sleep(100);
        return output;
    }
}
