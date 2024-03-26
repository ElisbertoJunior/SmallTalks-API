package com.tahto.smallTalks.service;

import com.tahto.smallTalks.entity.Salutation;
import com.tahto.smallTalks.entity.Swearing;
import com.tahto.smallTalks.entity.ToThank;
import com.tahto.smallTalks.repository.SalutationRepository;
import com.tahto.smallTalks.repository.SwearingRepository;
import com.tahto.smallTalks.repository.ToThankRepository;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.List;

@Service
public class VerificationService {
    private SalutationRepository salutationRepository;

    private SwearingRepository swearingRepository;

    private ToThankRepository toThankRepository;

    public VerificationService(
            SalutationRepository salutationRepository,
            SwearingRepository swearingRepository,
            ToThankRepository toThankRepository
    ) {
        this.salutationRepository = salutationRepository;
        this.swearingRepository = swearingRepository;
        this.toThankRepository = toThankRepository;
    }



    public String verificationSmallTalks(String entry) {
        List<Salutation> salutationList = salutationRepository.findAll();
        List<Swearing> swearingLIst = swearingRepository.findAll();
        List<ToThank> toThankList = toThankRepository.findAll();

        String normalizedString = normalizeString(entry);


        for(Salutation salutation : salutationList) {
            String salutationName = normalizeString(salutation.getName());

            if(salutationName.equals(normalizedString)) {
                return "Saudação";
            }

        }

        for(Swearing swearing : swearingLIst) {
            String swearingName = normalizeString(swearing.getName());

            if(swearingName.equals(normalizedString)) {
                return "Xingamento";
            }

        }

        for(ToThank toThank : toThankList) {
            String toThankName = normalizeString(toThank.getName());

            if(toThankName.equals(normalizedString)) {
                return "Agradecimento";
            }

        }

        return "Nao e SmallTalks";
    }

    private static String normalizeString(String str) {
        return Normalizer.normalize(str.toLowerCase(), Normalizer.Form.NFD)
                .replaceAll("[^a-zA-Z0-9\\s]", "");
    }
}
