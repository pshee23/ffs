package com.ppc.ffs.locker.adapter.out.persistence.repository;

import com.ppc.ffs.locker.adapter.out.persistence.entity.Locker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LockerRepository extends JpaRepository<Locker,Long> {

    Locker findByMemberId(Long memberId);

}
