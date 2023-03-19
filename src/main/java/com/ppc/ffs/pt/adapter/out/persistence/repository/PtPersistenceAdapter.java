package com.ppc.ffs.pt.adapter.out.persistence.repository;

import com.ppc.ffs.pt.adapter.out.persistence.entity.Pt;
import com.ppc.ffs.pt.application.port.out.SelectPtQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PtPersistenceAdapter implements SelectPtQuery {

    private final PtRepository ptRepository;

    @Override
    public Pt selectAblePtByMemberIdOrderByRegisterDate(Long memberId) {
        Optional<Pt> ptOptional = ptRepository.findByMemberIdOrderByRegisterDate(memberId);
        return ptOptional.orElseThrow(EntityNotFoundException :: new);
    }
}
