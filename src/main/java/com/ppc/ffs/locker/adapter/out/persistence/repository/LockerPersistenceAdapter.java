package com.ppc.ffs.locker.adapter.out.persistence.repository;

import com.ppc.ffs.locker.adapter.out.persistence.entity.Locker;
import com.ppc.ffs.locker.application.port.out.LockerPort;
import com.ppc.ffs.locker.domain.LockerInfo;
import com.ppc.ffs.member.adapter.out.persistence.entity.Member;
import com.ppc.ffs.member.adapter.out.persistence.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class LockerPersistenceAdapter implements LockerPort {

    private final LockerRepository lockerRepository;

    private final MemberRepository memberRepository;

    private final LockerInfoMapper lockerInfoMapper;

    @Override
    public LockerInfo findById(Long lockerId) {
        Optional<Locker> lockerOptional =  lockerRepository.findById(lockerId);
        if(lockerOptional.isEmpty()){
            return null;
        }
        return lockerInfoMapper.mapLockerToLockerInfo(lockerOptional.get());
    }

    @Override
    public Long saveLocker(LockerInfo lockerInfo) {
        Optional<Member> memberOptional =  memberRepository.findById(lockerInfo.getMemberId());
        Locker locker  = Locker.builder()
                .lockerId(lockerInfo.getLockerId())
                .member(memberOptional.get())
                .startDate(lockerInfo.getStartDate())
                .endDate(lockerInfo.getEndDate())
                .build();
        return lockerRepository.save(locker).getLockerId();
    }

    @Override
    public List<LockerInfo> findAllLocker() {
        List<Locker> lockerList = lockerRepository.findAll();
        return lockerInfoMapper.mapLockerListToLockerInfoList(lockerList);
    }

    @Override
    public LockerInfo findByMemberId(Long memberId) {
        Locker locker = lockerRepository.findByMemberId(memberId);
        return lockerInfoMapper.mapLockerToLockerInfo(locker);
    }

    @Override
    public void deleteById(Long lockerId) {
        lockerRepository.deleteById(lockerId);
    }
}
