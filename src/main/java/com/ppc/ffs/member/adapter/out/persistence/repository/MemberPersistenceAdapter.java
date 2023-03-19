package com.ppc.ffs.member.adapter.out.persistence.repository;

import com.ppc.ffs.member.adapter.out.persistence.entity.Member;
import com.ppc.ffs.member.application.port.out.MemberPort;
import com.ppc.ffs.member.application.service.MemberUtil;
import com.ppc.ffs.member.domain.MemberInfo;
import com.ppc.ffs.util.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class MemberPersistenceAdapter implements MemberPort {

    private final MemberRepository memberRepository;

    private final MemberInfoMapper memberInfoMapper;

    @Override
    public Long saveMember(MemberInfo memberInfo) {
        String passwordType = "";//todo 설정파일에서 가져오기 ffs.yaml
        String passwordSalt = CommonService.makeKey(24);

        //todo 패스워드 암호화 처리 필요
        //String encrypt_password = memberInfo.getLoginPassword() + passwordSalt;

        Member member  = Member.builder()
                .name(memberInfo.getName())
                .loginId(memberInfo.getLoginId())
                .loginPassword(memberInfo.getLoginPassword())
                .passwordType(passwordType)
                .passwordSalt(passwordSalt)
                .status(memberInfo.getStatus())
                .regDate(new Date())
                .build();
        return memberRepository.save(member).getMemberId();
    }

    @Override
    public MemberInfo findByMemberIdAndLoginIdAndLoginPassword(Long memberId, String loginId, String loginPassword) {
        Member member = memberRepository.findByMemberIdAndLoginIdAndLoginPassword(memberId,loginId,loginPassword);
        return memberInfoMapper.mapMemberToMemberInfo(member);
    }

    public MemberInfo findById(Long memberId) {
        Optional<Member> memberOptional =  memberRepository.findById(memberId);
        if(memberOptional.isEmpty()){
            return null;
        }
        return memberInfoMapper.mapMemberToMemberInfo(memberOptional.get());
    }

    @Override
    public List<MemberInfo> findAll() {
        List<Member> memberList = memberRepository.findAll();
        return memberInfoMapper.mapMemberListToMemberInfoList(memberList);
    }

    @Override
    public List<MemberInfo> findByNameOrLoginId(String name, String loginId) {
        List<Member> memberInfoList = memberRepository.findByNameOrLoginId(name,loginId);
        return memberInfoMapper.mapMemberListToMemberInfoList(memberInfoList);
    }

    @Override
    public List<MemberInfo> findByNameOrLoginId(String name, String loginId, Pageable pageable) {
        List<Member> memberList = memberRepository.findByNameOrLoginId(name,loginId,pageable);
        return memberInfoMapper.mapMemberListToMemberInfoList(memberList);
    }

    @Override
    public MemberInfo findByLoginId(String loginId) {

        return memberInfoMapper.mapMemberToMemberInfo(memberRepository.findByLoginId(loginId));
    }
}
